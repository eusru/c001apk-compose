package com.example.c001apk.compose.ui.component

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import coil.drawable.CrossfadeDrawable
import coil.load
import com.example.c001apk.compose.logic.providable.LocalUserPreferences
import com.example.c001apk.compose.util.ImageShowUtil.startBigImgViewSimple
import com.example.c001apk.compose.util.dp
import com.example.c001apk.compose.util.http2https
import com.example.c001apk.compose.view.RoundedImageView
import jp.wasabeef.transformers.coil.ColorFilterTransformation

/**
 * Created by bggRGjQaUbCoE on 2024/6/10
 */
@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    url: String,
    isRound: Boolean = false,
    borderWidth: Float? = null,
    borderColor: Int? = null,
    isCover: Boolean = false,
) {

    val isDarkMode = LocalUserPreferences.current.isDarkMode()

    AndroidView(
        modifier = modifier,
        factory = { context ->
            RoundedImageView(context).apply {
                scaleType = android.widget.ImageView.ScaleType.CENTER_CROP
                if (isRound) {
                    setCornerRadius(1000)
                }
                borderWidth?.let {
                    setBorderWidth(it.dp)
                }
                borderColor?.let {
                    setBorderColor(it)
                }
                setOnClickListener {
                    startBigImgViewSimple(this, url.http2https)
                }
            }
        },
        update = { imageView ->
            imageView.load(url.http2https) {
                crossfade(CrossfadeDrawable.DEFAULT_DURATION)
                if (isCover) {
                    transformations(
                        ColorFilterTransformation(
                            Color.parseColor(
                                if (isDarkMode)
                                    "#8D000000"
                                else
                                    "#5DFFFFFF"
                            )
                        )
                    )
                }
            }
        }
    )

}