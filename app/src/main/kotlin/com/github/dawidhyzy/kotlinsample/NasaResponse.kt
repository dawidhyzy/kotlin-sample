package com.github.dawidhyzy.kotlinsample

import com.google.gson.annotations.SerializedName

/**
 *
 * <p/>
 * @author Maciej Madetko <maciej.madetko@seedlabs.io>
 * @since 12.02.2016.
 */
data class NasaResponse(val date:String, val url:String, @SerializedName("cloud_score")val cloudScore:Double, val id:String)