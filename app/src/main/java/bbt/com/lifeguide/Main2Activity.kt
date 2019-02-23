package bbt.com.lifeguide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow

import com.facebook.drawee.view.SimpleDraweeView

class Main2Activity : AppCompatActivity() {

    private var imgOption1: com.facebook.drawee.view.SimpleDraweeView? = null
    private var imgOption2: com.facebook.drawee.view.SimpleDraweeView? = null
    private var imgOpenPopUp: SimpleDraweeView? = null
    private var popupWindow: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val view = LayoutInflater.from(this).inflate(R.layout.popup_options, null)
        this.imgOption2 = view.findViewById<View>(R.id.imgOption2) as SimpleDraweeView
        this.imgOption1 = view.findViewById<View>(R.id.imgOption1) as SimpleDraweeView
        this.imgOpenPopUp = findViewById<View>(R.id.imgOpenPopUp) as SimpleDraweeView

        popupWindow = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)



        imgOpenPopUp!!.setOnClickListener {
            if (popupWindow!!.isShowing) {
                popupWindow!!.dismiss()
            } else {
                popupWindow!!.showAsDropDown(imgOpenPopUp)

            }
        }

    }
}
