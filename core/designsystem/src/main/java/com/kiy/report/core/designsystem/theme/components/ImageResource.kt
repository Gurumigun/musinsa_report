package com.knowmerce.report.designsystem.common

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap

class ImageResource {
    private var resId: Int? = null
    private var imageVector: ImageVector? = null
    private var drawable: Drawable? = null
    private var url: String? = null
    private var painter: Painter? = null

    constructor(@DrawableRes resId: Int) {
        this.resId = resId
    }

    constructor(imageVector: ImageVector) {
        this.imageVector = imageVector
    }

    constructor(drawable: Drawable) {
        this.drawable = drawable
    }

    constructor(url: String) {
        this.url = url
    }

    constructor(painter: Painter) {
        this.painter = painter
    }


    fun isUrl(): Boolean = url != null
    fun getUrl(): String = url ?: ""
    fun isVector(): Boolean = imageVector != null
    fun isDrawableRes(): Boolean = resId != null

    @Composable
    operator fun invoke(): Painter? {
        val context = LocalContext.current
        return when {
            painter != null -> painter
            imageVector != null -> rememberVectorPainter(imageVector!!)
            resId != null -> painterResource(resId!!)
            drawable != null -> rememberDrawablePainter(drawable!!)
            url != null -> null // Coil 등의 이미지 로딩 라이브러리로 처리 필요
            else -> null
        }
    }

    /**
     * Android View 시스템에서 사용할 Drawable을 반환
     */
    operator fun invoke(context: Context): Drawable? {
        return when {
            drawable != null -> drawable
            resId != null -> ContextCompat.getDrawable(context, resId!!)
            url != null -> null // URL에서 Drawable을 로드하는 로직 필요
            else -> null
        }
    }
}

@Composable
fun rememberDrawablePainter(
    drawable: Drawable,
    targetSize: Size? = null
): BitmapPainter {
    val density = LocalDensity.current
    return remember(drawable, targetSize) {
        val bitmap = if (targetSize != null) {
            drawable.toBitmap(
                width = targetSize.width.toInt(),
                height = targetSize.height.toInt()
            )
        } else {
            drawable.toBitmap()
        }
        BitmapPainter(bitmap.asImageBitmap())
    }
}
