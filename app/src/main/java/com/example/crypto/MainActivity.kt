package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.crypto.api.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    //
    private val compositeDisposable = CompositeDisposable()//сущность в которую закидываются все запросы и уничтожаются чтоб не висели


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//6 вывод в лог json.toString
        val disposable = ApiFactory.apiService.getTopCoinsInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TEST_OF_LOADING_DATA1", it.toString())
            },
                {
                    Log.d("TEST_OF_LOADING_DATA", it.toString())
                })
        compositeDisposable.add(disposable)
    }

    //задиспоузили наш объект. Что это значит?
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    }