package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

object TestObject {
    fun foo(`true`: String) {
    assertEquals("123", `true`)
    testRenamed("true", { `true` })
}

    fun test() {
        foo("123")
    }
}

fun box(): String {
    TestObject.test()

    return "OK"
}