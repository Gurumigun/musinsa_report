package com.kiy.report.core.designsystem.theme.components

import android.content.Context
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 3. 30.
 */

class TextResource {
    private val text: AnnotatedString?
    private var resId: Int? = null

    constructor(text: String) {
        this.text = buildAnnotatedString {
            append(text)
        }
    }

    constructor(resId: Int) {
        text = null
        this.resId = resId
    }

    constructor(string: AnnotatedString) {
        this.text = string
    }

    operator fun invoke(): AnnotatedString {
        return text ?: throw IllegalArgumentException("TextResource is not initialized")
    }

    operator fun invoke(context: Context): AnnotatedString {
        return resId?.let {
            context.getString(it).let {
                buildAnnotatedString {
                    append(it)
                }
            }
        } ?: throw IllegalArgumentException("TextResource is not initialized")

    }
}
