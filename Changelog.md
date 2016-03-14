# CHANGELOG

## 1.1

## 1.0.2
- Show only changed files in notification "Kotlin not configured"
- Configure Kotlin: restore all changed files in undo action

### JVM
- Remove the compiler option "Xmultifile-facades-open"

### JS
- Safe calls (`x?.let { it }`) are now inlined

### Tools. J2K
- Protected members used outside of inheritors are converted as public
- Support conversion for annotation constructor calls
- Place comments from the middle of the call to the end
- Drop line breaks between operator arguments (except '+', "-", "&&" and "||")
- Add non-null assertions on call site for non-null parameters

### IDE
- Debugger can distinguish nested inline arguments
- Add kotlinClassName() and kotlinFunctionName() macros for use in live templates

New features:

- [KT-11098](https://youtrack.jetbrains.com/issue/KT-11098) Inspection on final classes/functions annotated with Spring @Configuration/@Component/@Bean
- [KT-11405](https://youtrack.jetbrains.com/issue/KT-11405) Navigation and Find Usages for Spring beans referenced in annotation arguments and BeanFactory method calls
- [KT-3741](https://youtrack.jetbrains.com/issue/KT-3741) Show Spring-specific line markers on Kotlin classes