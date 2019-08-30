package com.tomlettuces.base

import java.lang.StringBuilder

fun String.lastChar(): Char = get(length - 1)

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {

    val result = StringBuilder(prefix)

//    for ((index, element) in this.withIndex()) {
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//
//    result.append(postfix)
//    return result.toString()

    // 使用with优化写法
    return with(result) {
        for ((index, element) in this.withIndex()) {
            if (index > 0) append(separator)
            append(element)
        }

        append(postfix)
        this.toString()
    }
}

/**
 * #joinToString的另一种写法，使用了表达式函数体语法，在lambda中不需要显式的this就可以引用到这个实例
 */
fun <T> Collection<T>.joinToString1(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = with(StringBuilder()) {
    for ((index, element) in this.withIndex()) {
        if (index > 0) append(separator)
        append(element)
    }

    append(postfix)
    toString()
}

/**
 * buildString会负责创建StringBuilder并调用toString()
 */
fun <T> Collection<T>.joinToString2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = buildString {
    for ((index, element) in this.withIndex()) {
        if (index > 0) append(separator)
        append(element)
    }

    append(postfix)
}