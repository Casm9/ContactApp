package com.casm.contactapp.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.casm.contactapp.core.presentation.ui.contacts.ContactViewModel
import com.casm.contactapp.core.util.Screen
import com.casm.contactapp.screens.presentation.AddContactScreen
import com.casm.contactapp.screens.presentation.ContactDetailScreen
import com.casm.contactapp.screens.presentation.ContactListScreen
import com.casm.contactapp.screens.presentation.EditContactScreen

@Composable
fun Navigation(viewModel: ContactViewModel, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ContactListScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.ContactListScreen.route) {
            ContactListScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.AddContactScreen.route) {
            AddContactScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.ContactDetailScreen.route + "/{contactId}") { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("contactId")?.toInt()
            val contact = viewModel.allContacts.observeAsState(
                initial = emptyList()
            ).value.find { it.id == contactId }
            contact?.let {
                ContactDetailScreen(
                    contact = it,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
        composable(Screen.EditContactScreen.route + "/{contactId}") { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("contactId")?.toInt()
            val contact = viewModel.allContacts.observeAsState(
                initial = emptyList()
            ).value.find { it.id == contactId }
            contact?.let {
                EditContactScreen(
                    contact = it,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}