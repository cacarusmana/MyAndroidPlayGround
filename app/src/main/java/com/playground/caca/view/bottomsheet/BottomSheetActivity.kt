package com.playground.caca.view.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import com.playground.caca.R
import com.playground.caca.view.BaseActivity
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheetActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        initComponent()
        initListener()
    }

    override fun initComponent() {


    }

    override fun initListener() {
        btnBottomSheetDialog.setOnClickListener {
            BottomSheetDialog(this@BottomSheetActivity).apply {
                setContentView(R.layout.bottom_sheet_dialog)
                show()
            }
        }

        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        btnBottomSheet.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        btnBottomSheetDialogFragment.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
    }
}