@file:JvmName("UIUtils")
package com.tomlettuces.base

import com.tomlettuces.base.BaseApplication.Companion.mApplicationContext

fun dip2px(dip: Int): Int {
    val scale = mApplicationContext?.resources?.displayMetrics?.density ?: 0f
    return (dip * scale + 0.5f).toInt()
}