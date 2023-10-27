package com.example.hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hackathon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding // 바인딩뷰 생성

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Notification())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.calendar -> replaceFragment(Calendar())
                R.id.user -> replaceFragment(User())
                R.id.notification -> replaceFragment(Notification())

                else -> {

                }
            }
            true
        }
    }

    // bottomnavigationbar 페이지 전환
    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}