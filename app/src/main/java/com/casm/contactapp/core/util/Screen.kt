package com.casm.contactapp.core.util

sealed class Screen(val route: String) {
    data object AddContactScreen: Screen("addContact")
    data object ContactDetailScreen: Screen("contactDetail")
    data object ContactListScreen: Screen("contactList")
    data object EditContactScreen: Screen("editContact")
}