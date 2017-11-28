package mchehab.com.activityfragmentcallback

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), FragmentListener {

    val callbackFragment = CallbackFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonAttach).setOnClickListener { attachFragment() }
        findViewById<Button>(R.id.buttonDetach).setOnClickListener { detachFragment() }
    }

    private fun attachFragment(){
        fragmentManager.beginTransaction().add(R.id.frameLayout, callbackFragment).commit()
    }

    private fun detachFragment(){
        fragmentManager.beginTransaction().remove(callbackFragment).commit()
    }

    override fun answerFragment(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
