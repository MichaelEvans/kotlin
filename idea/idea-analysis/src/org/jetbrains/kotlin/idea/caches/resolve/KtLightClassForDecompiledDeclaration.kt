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

package org.jetbrains.kotlin.idea.caches.resolve

import com.intellij.psi.*
import com.intellij.psi.impl.compiled.ClsClassImpl
import com.intellij.psi.impl.light.LightMethod
import org.jetbrains.kotlin.asJava.KtLightMethodImpl
import org.jetbrains.kotlin.asJava.KtWrappingLightClass
import org.jetbrains.kotlin.idea.decompiler.classFile.KtClsFile
import org.jetbrains.kotlin.load.kotlin.MemberSignature
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.psi.KtFile

class KtLightClassForDecompiledDeclaration(
        private val clsClass: ClsClassImpl,
        private val origin: KtClassOrObject?,
        private val file: KtClsFile
) : KtWrappingLightClass(clsClass.manager) {
    private val fqName = origin?.fqName ?: FqName(clsClass.qualifiedName)

    override fun copy() = this

    override fun getOwnInnerClasses(): List<PsiClass> {
        val nestedClasses = origin?.declarations?.filterIsInstance<KtClassOrObject>() ?: emptyList()
        return clsClass.ownInnerClasses.map { innerClsClass ->
            KtLightClassForDecompiledDeclaration(innerClsClass as ClsClassImpl,
                                                 nestedClasses.firstOrNull { innerClsClass.name == it.name }, file)
        }
    }

    override fun getNavigationElement() = origin?.navigationElement ?: super.getNavigationElement()

    override fun getDelegate() = clsClass

    override fun getOrigin() = origin

    override fun getFqName() = fqName

    override fun getOwnMethods(): List<PsiMethod> {
        return delegate.ownMethods.map {
            object : LightMethod(myManager, it, this) {
                override fun getNavigationElement(): PsiElement {
                    val desc = descFromPsiMethod(it)
                    val signature = MemberSignature.fromMethodNameAndDesc(it.name, desc)
                    val declarationBySignature = file.getDeclarationBySignature(signature)
                    return declarationBySignature ?: delegate.navigationElement
                }
            }
        }
    }

    override fun getParent() = clsClass.parent

    override fun equals(other: Any?): Boolean =
            other is KtLightClassForDecompiledDeclaration &&
            getFqName() == other.getFqName()

    override fun hashCode(): Int =
            getFqName().hashCode()
}

private fun descFromPsiMethod(psiMethod: PsiMethod): String = buildString {

    fun descForClass(psiClass: PsiClass): String {
        return "L" + psiClass.qualifiedName!!.replace(".", "/") + ";"
    }


    fun descForType(type: PsiType): String = when (type) {
        PsiType.BOOLEAN -> "b" //TODO_R: other primitives
        PsiType.CHAR -> "C"
        is PsiClassType -> {
            val resolved = type.resolve()
            when (resolved) {
                is PsiTypeParameter -> {
                    val superType = resolved.superTypes.firstOrNull()?.let { return descForType(it) }
                    "Ljava/lang/Object;"
                }
                is PsiClass -> {
                    descForClass(resolved)
                }
                else -> error("TODO")
            }

        }
        else -> error("TODO")
    }

    append("(")
    psiMethod.parameterList.parameters.forEach {
        append(descForType(it.type))
    }
    append(")")

    //TODO_R:
    append(descForType(psiMethod.returnType ?: return ""))
}
