package org.sopt.doSopkathon.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.data.mock.categoryList
import org.sopt.doSopkathon.databinding.ActivityMainBinding
import org.sopt.doSopkathon.presentation.list.ListActivity
import org.sopt.doSopkathon.presentation.write.WriteActivity
import org.sopt.doSopkathon.util.base.BindingActivity
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**  화면 이동 방법*
         *     binding.tvTest.setOnClickListener {
         *            navigateTo<WriteActivity>()
         *   }
         *   navigateTo<ListActivity>()
         *   navigateTo<WriteActivity>()
         *   navigateTo<DetailActivity>()
         * **/

        initRecyclerView()
        clickWriteWorryBtn()
        clickListWorryBtn()
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = binding.rvMainWorryCollectionBox
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainAdapter(categoryList)
    }

    private fun clickListWorryBtn() {
        binding.btnMainWatchWorry.setOnSingleClickListener {
            navigateTo<ListActivity>()
        }
    }

    private fun clickWriteWorryBtn() {
        binding.fabMainWriteWorry.setOnSingleClickListener {
            navigateTo<WriteActivity>()
        }
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@MainActivity, T::class.java).apply {
            startActivity(this)
        }
    }
}
