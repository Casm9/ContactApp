package com.casm.contactapp.core.presentation.ui.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.casm.contactapp.core.domain.repository.ContactRepository

@Suppress("UNCHECKED_CAST")
class ContactViewModelFactory(private val repository: ContactRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)){
            return ContactViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}