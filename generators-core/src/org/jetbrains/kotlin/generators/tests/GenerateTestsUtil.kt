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

package org.jetbrains.kotlin.generators.tests

import junit.framework.TestCase
import org.jetbrains.kotlin.generators.tests.generator.*
import java.io.File
import java.util.*
import java.util.regex.Pattern

class TestGroup(val testsRoot: String, val testDataRoot: String) {
    inline fun <reified T: TestCase> testClass(
            suiteTestClass: String = getDefaultSuiteTestClass(T::class.java),
            noinline init: TestClass.() -> Unit
    ) {
        testClass(T::class.java, suiteTestClass, init)
    }

    fun testClass(
            baseTestClass: Class<out TestCase>,
            suiteTestClass: String = getDefaultSuiteTestClass(baseTestClass),
            init: TestClass.() -> Unit
    ) {
        val testClass = TestClass()
        testClass.init()

        val lastDot = suiteTestClass.lastIndexOf('.')
        val suiteTestClassName = if (lastDot == -1) suiteTestClass else suiteTestClass.substring(lastDot+1)
        val suiteTestClassPackage = if (lastDot == -1) baseTestClass.`package`.name else suiteTestClass.substring(0, lastDot)

        TestGenerator(
                testsRoot,
                suiteTestClassPackage,
                suiteTestClassName,
                baseTestClass,
                testClass.testModels
        ).generateAndSave()
    }

    inner class TestClass {
        val testModels = ArrayList<TestClassModel>()

        fun model(
                relativeRootPath: String,
                recursive: Boolean = true,
                excludeParentDirs: Boolean = false,
                extension: String? = "kt", // null string means dir (name without dot)
                pattern: String = if (extension == null) """^([^\.]+)$""" else "^(.+)\\.$extension\$",
                testMethod: String = "doTest",
                singleClass: Boolean = false,
                testClassName: String? = null,
                targetBackend: TestGenerator.TargetBackend = TestGenerator.TargetBackend.ANY,
                excludeDirs: List<String> = listOf(),
                filenameStartsLowerCase: Boolean? = null
        ) {
            val rootFile = File(testDataRoot + "/" + relativeRootPath)
            val compiledPattern = Pattern.compile(pattern)
            val className = testClassName ?: TestGeneratorUtil.fileNameToJavaIdentifier(rootFile)
            testModels.add(
                    if (singleClass) {
                        if (excludeDirs.isNotEmpty()) error("excludeDirs is unsupported for SingleClassTestModel yet")
                        SingleClassTestModel(rootFile, compiledPattern, filenameStartsLowerCase, testMethod, className, targetBackend)
                    }
                    else {
                        SimpleTestClassModel(rootFile, recursive, excludeParentDirs,
                                             compiledPattern, filenameStartsLowerCase, testMethod, className,
                                             targetBackend, excludeDirs)
                    }
            )
        }
    }

}

fun testGroup(testsRoot: String, testDataRoot: String, init: TestGroup.() -> Unit) {
    TestGroup(testsRoot, testDataRoot).init()
}

fun getDefaultSuiteTestClass(baseTestClass:Class<*>): String {
    val baseName = baseTestClass.simpleName
    if (!baseName.startsWith("Abstract")) {
        throw IllegalArgumentException("Doesn't start with \"Abstract\": $baseName")
    }
    return baseName.substring("Abstract".length) + "Generated"
}
