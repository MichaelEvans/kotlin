package inlineOnlyBreakpointInsideInlineArgument

fun main(args: Array<String>) {
    //Breakpoint! (lambdaOrdinal = 1)
    foo { val a = 1 }
}

@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
@kotlin.internal.InlineOnly
inline fun foo(s: () -> Unit) {
    val x = 1
    s()
    val y = 1
}