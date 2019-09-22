package com.playground.caca.view.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.playground.caca.R
import com.playground.caca.model.MessageActivityFragmentEvent
import com.playground.caca.model.MessageFragmentActivityEvent
import kotlinx.android.synthetic.main.activity_eventbus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class EventBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventbus)

        btnSend.setOnClickListener {
            EventBus.getDefault().post(MessageActivityFragmentEvent(etMessage.text.toString()))
        }

        supportFragmentManager.beginTransaction().add(R.id.container, EventBusFragment()).commit()
    }

    @Subscribe
    fun onMessageEvent(event: MessageFragmentActivityEvent) {
        tvMessage.text = event.message
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}