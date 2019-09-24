package com.playground.caca.view.eventbus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.playground.caca.R
import com.playground.caca.model.MessageActivityFragmentEvent
import com.playground.caca.model.MessageFragmentActivityEvent
import kotlinx.android.synthetic.main.fragment_eventbus.btnSend
import kotlinx.android.synthetic.main.fragment_eventbus.etMessage
import kotlinx.android.synthetic.main.fragment_eventbus.tvMessage
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class EventBusFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_eventbus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSend.setOnClickListener {
            EventBus.getDefault().post(MessageFragmentActivityEvent(etMessage.text.toString()))
        }
    }

    @Subscribe
    fun onMessageEvent(event:MessageActivityFragmentEvent) {
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