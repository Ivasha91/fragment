package com.ivan.graduationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var bottomNav: BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)
//      to make the first fragment to appear
        replaceFragment(MainFragment())

        bottomNav.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.main -> {
                    fragment = MainFragment()
                }
                R.id.catalog -> {
                    fragment = CatalogFragment()
                }
                R.id.cart -> {
                    fragment = CartFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }
}