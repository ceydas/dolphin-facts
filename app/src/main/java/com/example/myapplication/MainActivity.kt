package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CreateFactBinding
import com.example.myapplication.databinding.FragmentFactsScreenBinding
import com.example.myapplication.screens.FactsScreen
import com.example.myapplication.view_models.FactsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: FactsViewModel by viewModels()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setTheme(R.style.Theme_MyApplication)
        supportActionBar?.hide()
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    // Remember that you should never show the action bar if the
    // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.miFacts, R.id.miAbout))
        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        val fab = binding.fabAdd
        fab.setOnClickListener{
            Log.i("fab click", "You clicked on FAB!")
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.create_new_fact -> {
                        val fact = ""
                        val name = ""
                        Log.i("create click", "You clicked on Create New Fact")
                        val builder = AlertDialog.Builder(this)
                        val dialogLayout = CreateFactBinding.inflate(layoutInflater)

                        with (builder){
                            setTitle("Create Custom Fact")
                            setPositiveButton("Done"){ dialog, which ->

                                // TODO : Must update the arraylist expansions.
                                //val currentFragment = supportFragmentManager.findFragmentById(R.id.)
                                val binding_facts_screen = FragmentFactsScreenBinding.inflate(layoutInflater)
                                binding_facts_screen.tvFact.text = dialogLayout.textInputFact.editText.toString()
                                binding_facts_screen.tvDolphinName.text = dialogLayout.textInputName.editText.toString()
                            }

                            setNegativeButton("Cancel"){ dialog, which ->
                                Log.i("cancel", "Create new fact cancelled.")
                            }

                            setView(dialogLayout.root)
                            show()
                        }
                        true
                    }

                    else -> false
                }
            }
            popupMenu.inflate(R.menu.create_menu)
            /*
            try {
                val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("")
            }
            */
            popupMenu.show()

        }


        /*
        val fab = binding.fabAdd
        fab.setOnClickListener{
            val action =
                it.findNavController()
            navController.navigate()
        }

        */


    }



}