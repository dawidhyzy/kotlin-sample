package com.github.dawidhyzy.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val nasaApi = NasaApi.create()

        val observable = nasaApi.getNasaJson(50.0968457f, 19.8891281f)
        observable
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                { response : NasaResponse ->
                    nasaImageView.load(response.url) },
                { error : Throwable -> Log.e("XXX", error.message)})


    }
}
