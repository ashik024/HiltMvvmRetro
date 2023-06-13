package com.example.mvvmretrohilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmretrohilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
//        val navController = navHostFragment.navController

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController


//        navController.navigateTo(R.id.navigation_video)

//        val action =
//            SpecifyAmountFragmentDirections
//                .actionSpecifyAmountFragmentToConfirmationFragment()
//        view.findNavController().navigate(action)

        binding.liveMatchButton.setOnClickListener {

            Toast.makeText(this,"working",Toast.LENGTH_LONG).show()
        }
    }
}