# CHANGELOG

## 1.1

## 1.0.2

### JS
- Safe calls (`x?.let { it }`) are now inlined

### Tools. J2K
- Protected members used outside of inheritors are converted as public
- Support conversion for annotation constructor calls
- Place comments from the middle of the call to the end
- Drop line breaks between operator arguments (except '+', "-", "&&" and "||")
- Add non-null assertions on call site for non-null parameters

### IDE

New features:

- [KT-11098](https://youtrack.jetbrains.com/issue/KT-11098) Inspection on final classes/functions annotated with Spring @Configuration/@Component/@Bean
- [KT-11405](https://youtrack.jetbrains.com/issue/KT-11405) Navigation and Find Usages for Spring beans referenced in annotation arguments and BeanFactory method calls
- [KT-3741](https://youtrack.jetbrains.com/issue/KT-3741) Show Spring-specific line markers on Kotlin classes
- [KT-11406](https://youtrack.jetbrains.com/issue/KT-11406) Support Spring EL injections inside of Kotlin string literals
- [KT-11407](https://youtrack.jetbrains.com/issue/KT-11407) Implemented "Generate Spring Dependency..." actions
- [KT-11408](https://youtrack.jetbrains.com/issue/KT-11408) Implemented "Generate @Autowired Dependency..." action