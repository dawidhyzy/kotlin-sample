package com.github.dawidhyzy.kotlinsample

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 *
 * <p/>
 * @author Maciej Madetko <maciej.madetko@seedlabs.io>
 * @since 12.02.2016.
 */
fun ImageView.load(url : String) {
    Picasso.with(this.context).load(url).into(this)
}
