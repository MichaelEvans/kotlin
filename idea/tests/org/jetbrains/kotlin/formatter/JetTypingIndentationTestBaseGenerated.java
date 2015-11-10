/*
 * Copyright 2010-2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.formatter;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.JetTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class JetTypingIndentationTestBaseGenerated extends AbstractJetTypingIndentationTestBase {
    @TestMetadata("idea/testData/indentationOnNewline")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class DirectSettings extends AbstractJetTypingIndentationTestBase {
        @TestMetadata("AfterCatch.after.kt")
        public void testAfterCatch() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AfterCatch.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("AfterClassNameBeforeFun.after.kt")
        public void testAfterClassNameBeforeFun() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AfterClassNameBeforeFun.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("AfterFinally.after.kt")
        public void testAfterFinally() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AfterFinally.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("AfterImport.after.kt")
        public void testAfterImport() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AfterImport.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("AfterTry.after.kt")
        public void testAfterTry() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AfterTry.after.kt");
            doNewlineTest(fileName);
        }

        public void testAllFilesPresentInDirectSettings() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/indentationOnNewline"), Pattern.compile("^([^\\.]+)\\.after\\.kt.*$"), true);
        }

        @TestMetadata("AssignmentAfterEq.after.kt")
        public void testAssignmentAfterEq() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AssignmentAfterEq.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("BinaryWithTypeExpressions.after.kt")
        public void testBinaryWithTypeExpressions() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/BinaryWithTypeExpressions.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("ConsecutiveCallsAfterDot.after.kt")
        public void testConsecutiveCallsAfterDot() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/ConsecutiveCallsAfterDot.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("ConsecutiveCallsInSaeCallsMiddle.after.kt")
        public void testConsecutiveCallsInSaeCallsMiddle() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/ConsecutiveCallsInSaeCallsMiddle.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("ConsecutiveCallsInSafeCallsEnd.after.kt")
        public void testConsecutiveCallsInSafeCallsEnd() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/ConsecutiveCallsInSafeCallsEnd.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("DoInFun.after.kt")
        public void testDoInFun() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/DoInFun.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("EmptyParameters.after.kt")
        public void testEmptyParameters() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/EmptyParameters.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("For.after.kt")
        public void testFor() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/For.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("FunctionBlock.after.kt")
        public void testFunctionBlock() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/FunctionBlock.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("FunctionWithInference.after.kt")
        public void testFunctionWithInference() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/FunctionWithInference.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("If.after.kt")
        public void testIf() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/If.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InBinaryExpressionInMiddle.after.kt")
        public void testInBinaryExpressionInMiddle() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionInMiddle.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InBinaryExpressionUnfinished.after.kt")
        public void testInBinaryExpressionUnfinished() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionUnfinished.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InBinaryExpressionsBeforeCloseParenthesis.after.kt")
        public void testInBinaryExpressionsBeforeCloseParenthesis() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionsBeforeCloseParenthesis.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InDelegationListAfterColon.after.kt")
        public void testInDelegationListAfterColon() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListAfterColon.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InDelegationListAfterComma.after.kt")
        public void testInDelegationListAfterComma() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListAfterComma.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InDelegationListNotEmpty.after.kt")
        public void testInDelegationListNotEmpty() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListNotEmpty.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InEnumAfterSemicolon.after.kt")
        public void testInEnumAfterSemicolon() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumAfterSemicolon.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InEnumInitializerListAfterComma.after.kt")
        public void testInEnumInitializerListAfterComma() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumInitializerListAfterComma.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InEnumInitializerListNotEmpty.after.kt")
        public void testInEnumInitializerListNotEmpty() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumInitializerListNotEmpty.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InExpressionsParentheses.after.kt")
        public void testInExpressionsParentheses() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InExpressionsParentheses.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InExpressionsParenthesesBeforeOperand.after.kt")
        public void testInExpressionsParenthesesBeforeOperand() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InExpressionsParenthesesBeforeOperand.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLabmdaAfterArrow.after.kt")
        public void testInLabmdaAfterArrow() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLabmdaAfterArrow.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaAfterArrowWithSpaces.after.kt")
        public void testInLambdaAfterArrowWithSpaces() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaAfterArrowWithSpaces.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaBeforeParams.after.kt")
        public void testInLambdaBeforeParams() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaBeforeParams.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaInsideChainCallSameLine.after.kt")
        public void testInLambdaInsideChainCallSameLine() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaInsideChainCallSameLine.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaInsideChainCallSameLineWithSpaces.after.kt")
        public void testInLambdaInsideChainCallSameLineWithSpaces() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaInsideChainCallSameLineWithSpaces.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaInsideChainCallWithNewLine.after.kt")
        public void testInLambdaInsideChainCallWithNewLine() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaInsideChainCallWithNewLine.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InLambdaInsideChainCallWithNewLineWithSpaces.after.kt")
        public void testInLambdaInsideChainCallWithNewLineWithSpaces() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InLambdaInsideChainCallWithNewLineWithSpaces.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("InMultilineLambdaAfterArrow.after.kt")
        public void testInMultilineLambdaAfterArrow() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InMultilineLambdaAfterArrow.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("IsExpressionAfterIs.after.kt")
        public void testIsExpressionAfterIs() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/IsExpressionAfterIs.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("MultideclarationAfterEq.after.kt")
        public void testMultideclarationAfterEq() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/MultideclarationAfterEq.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("MultideclarationBeforeEq.after.kt")
        public void testMultideclarationBeforeEq() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/MultideclarationBeforeEq.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("NotFirstParameter.after.kt")
        public void testNotFirstParameter() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/NotFirstParameter.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("PropertyWithInference.after.kt")
        public void testPropertyWithInference() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/PropertyWithInference.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("ReturnContinue.after.kt")
        public void testReturnContinue() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/ReturnContinue.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("SettingAlignMultilineParametersInCalls.after.kt")
        public void testSettingAlignMultilineParametersInCalls() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/SettingAlignMultilineParametersInCalls.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("While.after.kt")
        public void testWhile() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/While.after.kt");
            doNewlineTest(fileName);
        }

        @TestMetadata("idea/testData/indentationOnNewline/script")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Script extends AbstractJetTypingIndentationTestBase {
            public void testAllFilesPresentInScript() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/indentationOnNewline/script"), Pattern.compile("^([^\\.]+)\\.after\\.kt.*$"), true);
            }

            @TestMetadata("ScriptAfterExpression.after.kts")
            public void testScriptAfterExpression() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/script/ScriptAfterExpression.after.kts");
                doNewlineTest(fileName);
            }

            @TestMetadata("ScriptAfterFun.after.kts")
            public void testScriptAfterFun() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/script/ScriptAfterFun.after.kts");
                doNewlineTest(fileName);
            }

            @TestMetadata("ScriptAfterImport.after.kts")
            public void testScriptAfterImport() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/script/ScriptAfterImport.after.kts");
                doNewlineTest(fileName);
            }

            @TestMetadata("ScriptInsideFun.after.kts")
            public void testScriptInsideFun() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/script/ScriptInsideFun.after.kts");
                doNewlineTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/indentationOnNewline")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class InvertedSettings extends AbstractJetTypingIndentationTestBase {
        public void testAllFilesPresentInInvertedSettings() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/indentationOnNewline"), Pattern.compile("^([^\\.]+)\\.after\\.inv\\.kt.*$"), true);
        }

        @TestMetadata("AssignmentAfterEq.after.inv.kt")
        public void testAssignmentAfterEq() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/AssignmentAfterEq.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("BinaryWithTypeExpressions.after.inv.kt")
        public void testBinaryWithTypeExpressions() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/BinaryWithTypeExpressions.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InBinaryExpressionInMiddle.after.inv.kt")
        public void testInBinaryExpressionInMiddle() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionInMiddle.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InBinaryExpressionUnfinished.after.inv.kt")
        public void testInBinaryExpressionUnfinished() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionUnfinished.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InBinaryExpressionsBeforeCloseParenthesis.after.inv.kt")
        public void testInBinaryExpressionsBeforeCloseParenthesis() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InBinaryExpressionsBeforeCloseParenthesis.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InDelegationListAfterColon.after.inv.kt")
        public void testInDelegationListAfterColon() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListAfterColon.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InDelegationListAfterComma.after.inv.kt")
        public void testInDelegationListAfterComma() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListAfterComma.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InDelegationListNotEmpty.after.inv.kt")
        public void testInDelegationListNotEmpty() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InDelegationListNotEmpty.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InEnumAfterSemicolon.after.inv.kt")
        public void testInEnumAfterSemicolon() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumAfterSemicolon.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InEnumInitializerListAfterComma.after.inv.kt")
        public void testInEnumInitializerListAfterComma() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumInitializerListAfterComma.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InEnumInitializerListNotEmpty.after.inv.kt")
        public void testInEnumInitializerListNotEmpty() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InEnumInitializerListNotEmpty.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InExpressionsParentheses.after.inv.kt")
        public void testInExpressionsParentheses() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InExpressionsParentheses.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("InExpressionsParenthesesBeforeOperand.after.inv.kt")
        public void testInExpressionsParenthesesBeforeOperand() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/InExpressionsParenthesesBeforeOperand.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("IsExpressionAfterIs.after.inv.kt")
        public void testIsExpressionAfterIs() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/IsExpressionAfterIs.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

        @TestMetadata("SettingAlignMultilineParametersInCalls.after.inv.kt")
        public void testSettingAlignMultilineParametersInCalls() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/indentationOnNewline/SettingAlignMultilineParametersInCalls.after.inv.kt");
            doNewlineTestWithInvert(fileName);
        }

    }
}