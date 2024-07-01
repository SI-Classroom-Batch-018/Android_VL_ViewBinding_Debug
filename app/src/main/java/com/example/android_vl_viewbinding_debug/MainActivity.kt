package com.example.android_vl_viewbinding_debug

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_vl_viewbinding_debug.databinding.ActivityMainBinding
import com.example.android_vl_viewbinding_debug.databinding.SecondScreenBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var secondvb: SecondScreenBinding

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
            counter ++
            viewBinding.tvCounter.text = counter.toString()
        }
    }
}