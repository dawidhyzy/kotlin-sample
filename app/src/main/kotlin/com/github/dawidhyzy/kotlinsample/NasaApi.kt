package com.github.dawidhyzy.kotlinsample

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.RxJavaCallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 *
 * <p/>
 * @author Maciej Madetko <maciej.madetko@seedlabs.io>
 * @since 12.02.2016.
 */
interface NasaApi {

    @GET("planetary/earth/imagery")
    fun getNasaJson(@Query("lat") lat:Float, @Query("lon") lon:Float, @Query("api_key") api_key:String = "DEMO_KEY", @Query("date") date : String = "2016-02-01"):Observable<NasaResponse>

    companion object {
        val baseAddress:String = "https://api.nasa.gov/"

        fun create() : NasaApi {
            val client = OkHttpClient.Builder();
            client.addInterceptor{
                chain ->
                Log.d(this.javaClass.simpleName,"Chain: ${chain.request().url().toString()}")
                chain.proceed(chain.request())
            }

            val retrofit = Retrofit.Builder().baseUrl(baseAddress)
            return retrofit
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build().create(NasaApi::class.java)
        }
    }
}