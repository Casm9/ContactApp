package com.casm.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.casm.contactapp.core.database.ContactDatabase
import com.casm.contactapp.core.domain.repository.ContactRepository
import com.casm.contactapp.core.presentation.ui.contacts.ContactViewModel
import com.casm.contactapp.core.presentation.ui.contacts.ContactViewModelFactory
import com.casm.contactapp.core.presentation.components.Navigation
import com.casm.contactapp.core.presentation.ui.theme.ContactAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact_database"
        ).build()

        val repository = ContactRepository(database.contactDao())

        val viewModel: ContactViewModel by viewModels {
            ContactViewModelFactory(repository)
        }

        setContent {
            ContactAppTheme {
                val navController = rememberNavController()
                Navigation(viewModel = viewModel, navController = navController)
            }
        }
    }
}