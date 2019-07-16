package com.playground.caca.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.playground.caca.R
import com.playground.caca.util.toast
import com.playground.caca.view.adapter.MainMenuAdapter
import com.playground.caca.view.bottomsheet.BottomSheetActivity
import com.playground.caca.view.recyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : BaseActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    private lateinit var rvAdapter: MainMenuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    override fun initComponent() {
        setSupportActionBar(toolbar)

        rvAdapter = MainMenuAdapter(this, resources.getStringArray(R.array.home_menu_array).toMutableList())

        rvMenu.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvAdapter
        }

        initListener()
    }

    override fun initListener() {
        rvAdapter.addListener { menuName, _ ->

            with(menuName.toLowerCase()) {

                when {
                    contains("recycler") -> startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
                    contains("bottom sheet") -> startActivity(
                        Intent(
                            this@MainActivity,
                            BottomSheetActivity::class.java
                        )
                    )
                    else -> toast(this)
                }

            }

        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
