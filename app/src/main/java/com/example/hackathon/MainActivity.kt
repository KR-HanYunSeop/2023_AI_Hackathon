package com.example.hackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddAlarmActivity::class.java)
            startActivity(intent)




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