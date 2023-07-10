package com.gc.utils

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.Gravity.CENTER
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.gc.utils.databinding.LayoutToastBinding


const val SUCCEED = 0
const val ERROR = 1
const val WARNING = 2

object ToastUtils {

    fun toast(context: Context, type: Int, msg: String) {
        var iconSource: Int = when (type) {
            SUCCEED -> R.mipmap.icon_toast_success
            ERROR -> R.mipmap.icon_toast_error
            WARNING -> R.mipmap.icon_toast_warning
            else -> 0
        }
        Builder(context)
            .setContentString(msg)
            .setIconSource(iconSource)
            .setDuration(LENGTH_LONG)
            .setGravity(CENTER)
            .setVerticalOffset(0)
            .build()
            .show()
    }

    class Builder(private val context: Context) {
        private var contentString: String? = null
        private var iconSource: Int = 0
        private var performDuration: Int = LENGTH_LONG
        private var toastGravity: Int = Gravity.CENTER
        private var verticalOffset: Int = 0

        fun setContentString(contentString: String): Builder {
            this.contentString = contentString
            return this
        }

        fun setContentString(stringSource: Int): Builder {
            this.contentString = Resources.getSystem().getString(stringSource)
            return this
        }

        fun setIconSource(iconSource: Int): Builder {
            this.iconSource = iconSource
            return this
        }

        fun setDuration(duration: Int): Builder {
            this.performDuration = duration
            return this
        }

        fun setGravity(gravity: Int): Builder {
            this.toastGravity = gravity
            return this
        }

        fun setVerticalOffset(verticalOffset: Int): Builder {
            this.verticalOffset = verticalOffset
            return this
        }

        fun build(): Toast {
            val binding = LayoutToastBinding.inflate(LayoutInflater.from(context))
            if (iconSource > 0) {
                binding.ivIcon.visibility = VISIBLE
                binding.ivIcon.setImageResource(iconSource)
            } else {
                binding.ivIcon.visibility = GONE
            }
            if (!contentString.isNullOrEmpty()) {
                binding.tvContent.text = contentString
            }
            return Toast(context).apply {
                view = binding.root
                duration = performDuration
                setGravity(toastGravity, 0, verticalOffset)
            }
        }
    }

}