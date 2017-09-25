package misiulia.alex.dev.detectfragmentsvisibility

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentContainer: ViewGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.fragment_container) as ViewGroup

        navigate(to = MasterFragment(), addToBackStack = false)

        supportFragmentManager.addOnBackStackChangedListener {
            val currentFragment = supportFragmentManager.findFragmentById(fragmentContainer.id)
            currentFragment.userVisibleHint = true
        }
    }

    public fun navigate(from: Fragment? = null, to: Fragment, addToBackStack: Boolean = true) {
        if(from != null) from.userVisibleHint = false

        val transaction = supportFragmentManager.beginTransaction()
                .add(fragmentContainer.id, to)
        if(addToBackStack) transaction.addToBackStack(null)
        transaction.commit()
    }
}
