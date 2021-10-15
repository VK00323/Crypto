package com.example.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.adapters.CoinInfoAdapter
import com.example.crypto.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var rvCoinPriceList: RecyclerView



    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        rvCoinPriceList = findViewById(R.id.rvCoinPriceList)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromsymbol
                )
                startActivity(intent)

            }
        }
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, {
            adapter.coinInfoList = it
        })

    }
}

