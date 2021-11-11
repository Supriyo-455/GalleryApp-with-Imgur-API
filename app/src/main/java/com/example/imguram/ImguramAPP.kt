package com.example.imguram

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class ImguramAPP : Application() {
    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(object : ImageLoaderFactory {
            val imageLoaderBuilder = ImageLoader.Builder(this@ImguramAPP)
                .componentRegistry {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder(context = this@ImguramAPP))
                    } else {
                        add(GifDecoder())
                    }
                }

            override fun newImageLoader() = imageLoaderBuilder.build()
        })

    }
}