package misiulia.alex.dev.detectfragmentsvisibility

import android.support.v4.app.Fragment
import android.util.Log

open class AppFragment : Fragment() {
    private val TAG = "VisibilityTest"
    protected var isVisibleToUser: Boolean = true

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        logVisibility()
    }

    override fun onDetach() {
        super.onDetach()
        isVisibleToUser = false
        logVisibility()
    }

    private fun logVisibility() {
        val msg = "Fragment ${javaClass.simpleName} becomes visible = $isVisibleToUser"
        Log.d(TAG, msg)
    }


}