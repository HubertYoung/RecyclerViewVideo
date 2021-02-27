package com.hubertyoung.plugin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_video.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter: RVAdapter
    private var list: MutableList<ItemEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        for (index in 1..100) {
            list.add(ItemEntity("video", "https://test-hubert.oss-cn-beijing.aliyuncs.com/public/test.mp4"))
            list.add(ItemEntity("text", "textview ==> $index"))
            list.add(ItemEntity("text", "textview ==> $index 1"))
            list.add(ItemEntity("text", "textview ==> $index 2"))
            list.add(ItemEntity("text", "textview ==> $index 3"))
            list.add(ItemEntity("text", "textview ==> $index 4"))
            list.add(ItemEntity("text", "textview ==> $index 5"))
        }
        rvAdapter.setData(list)
        rvAdapter.notifyDataSetChanged()
    }

    private fun initView() {
        rvAdapter = RVAdapter(this)
        recyclerView.adapter = rvAdapter
    }
}