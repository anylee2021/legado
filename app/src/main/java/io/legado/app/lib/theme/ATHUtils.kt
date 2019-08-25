package io.legado.app.lib.theme

import android.content.Context
import androidx.annotation.AttrRes

/**
 * @author Aidan Follestad (afollestad)
 */
object ATHUtils {

    fun isWindowBackgroundDark(context: Context): Boolean {
        return !ColorUtils.isColorLight(resolveColor(context, android.R.attr.windowBackground))
    }

    @JvmOverloads
    fun resolveColor(context: Context, @AttrRes attr: Int, fallback: Int = 0): Int {
        val a = context.theme.obtainStyledAttributes(intArrayOf(attr))
        return try {
            a.getColor(0, fallback)
        } catch (e: Exception) {
            fallback
        } finally {
            a.recycle()
        }
    }
}