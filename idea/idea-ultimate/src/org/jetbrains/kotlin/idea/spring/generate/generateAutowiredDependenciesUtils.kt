/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.spring.generate

import com.intellij.codeInsight.template.TemplateBuilderImpl
import com.intellij.psi.PsiClass
import com.intellij.spring.CommonSpringModel
import com.intellij.spring.constants.SpringAnnotationsConstants
import com.intellij.spring.model.CommonSpringBean
import com.intellij.spring.model.SpringBeanPointer
import com.intellij.spring.model.SpringModelSearchParameters
import com.intellij.spring.model.actions.generate.GenerateSpringBeanDependenciesUtil
import com.intellij.spring.model.actions.generate.SpringGenerateTemplatesHolder
import com.intellij.spring.model.utils.SpringModelSearchers
import com.intellij.spring.model.utils.SpringModelUtils
import com.intellij.util.IncorrectOperationException
import org.jetbrains.kotlin.asJava.KtLightClass
import org.jetbrains.kotlin.idea.core.KotlinNameSuggester
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.psiUtil.containingClassOrObject
import org.jetbrains.kotlin.utils.ifEmpty

// TODO: GenerateAutowiredDependenciesUtil.getQualifierName() is not accessible here
private fun SpringBeanPointer<CommonSpringBean>.getQualifierName(): String? {
    val value = springBean.springQualifier?.qualifierValue
    return if (value.isNullOrBlank()) name else value
}

private fun createAutowiredProperty(
        currentBeanClass: KtLightClass,
        candidateBean: SpringBeanPointer<CommonSpringBean>,
        candidateBeanClasses: Array<out PsiClass>,
        model: CommonSpringModel
): KtProperty? {
    try {
        val ktBeanClass = currentBeanClass.getOrigin() ?: return null

        val qualifierName = candidateBean.getQualifierName()
        val candidateBeanClass = candidateBeanClasses.first()
        val beanName = candidateBean.name
        val name = if (beanName != null && KotlinNameSuggester.isIdentifier(beanName)) beanName else candidateBeanClass.name!!

        val psiFactory = KtPsiFactory(currentBeanClass.project)
        val prototype = psiFactory.createProperty("lateinit var ${name.decapitalize()}: ${candidateBeanClass.defaultTypeText}").apply {
            addAnnotationEntry(psiFactory.createAnnotationEntry("@${SpringAnnotationsConstants.AUTOWIRED}"))

            val searchParameters = SpringModelSearchParameters.byClass(candidateBeanClass).withInheritors().effectiveBeanTypes()
            if (SpringModelSearchers.findBeans(model, searchParameters).size > 1 && !qualifierName.isNullOrBlank()) {
                addAnnotationEntry(psiFactory.createAnnotationEntry("@${SpringAnnotationsConstants.QUALIFIER}(\"$qualifierName\")"))
            }
        }
        return ktBeanClass.addDeclaration(prototype).apply { reformat(this) }
    }
    catch (e: IncorrectOperationException) {
        throw RuntimeException(e)
    }
}

private fun addCreatePropertyTemplate(
        property: KtProperty,
        candidateBean: SpringBeanPointer<CommonSpringBean>,
        candidateBeanClasses: Array<out PsiClass>
): SpringGenerateTemplatesHolder {
    return SpringGenerateTemplatesHolder(property.project).apply {
        addTemplateFactory(property) {
            val builder = TemplateBuilderImpl(property)
            builder.appendVariableTemplate(property, candidateBeanClasses) {
                val existingNames = property.containingClassOrObject!!.declarations.mapNotNull { (it as? KtProperty)?.name }
                getSuggestedNames(candidateBean, property, existingNames) { returnType }
            }
            builder.buildInlineTemplate()
        }
    }
}

private fun createAutowiredDependency(
        klass: KtLightClass,
        candidateBean: SpringBeanPointer<CommonSpringBean>,
        model: CommonSpringModel
): SpringGenerateTemplatesHolder? {
    val candidateBeanClasses = candidateBean.effectiveBeanType.ifEmpty { return null }
    if (!GenerateSpringBeanDependenciesUtil.ensureFileWritable(klass)) return null
    val property = createAutowiredProperty(klass, candidateBean, candidateBeanClasses, model) ?: return null
    return addCreatePropertyTemplate(property, candidateBean, candidateBeanClasses)
}

fun generateAutowiredDependenciesFor(klass: KtLightClass): List<SpringGenerateTemplatesHolder> {
    val model = SpringModelUtils.getInstance().getPsiClassSpringModel(klass)
    val candidates = GenerateSpringBeanDependenciesUtil.getAutowiredBeanCandidates(model) { it.containingFile != klass.containingFile }
    val dependencies = GenerateSpringBeanDependenciesUtil.chooseDependentBeans(candidates, klass.project, true)
    return dependencies.mapNotNull { createAutowiredDependency(klass, it, model) }
}

