package com.example.android_vl_viewbinding_debug

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_vl_viewbinding_debug.databinding.ActivityMainBinding
import com.example.android_vl_viewbinding_debug.databinding.SecondScreenBinding

const val TAG = "BTN_CLICK"

class MainActivity : AppCompatActivity() {
    private var counter = 10
    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)


        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewBinding.btCounter.setOnClickListener {
            counter --

            try {
                viewBinding.tvCounter.text = (100/counter).toString()
                Log.i(TAG, "CLICK CLICK counter == $counter")
            } catch (exeception: Exception) {
                Log.e(TAG, "NOT ALLOWED $counter")
                Log.wtf(TAG, "Exception ${exeception.localizedMessage}")
            }
        }
    }
}