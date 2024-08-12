package com.casm.contactapp.core.presentation.ui.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.casm.contactapp.core.domain.models.Contact
import com.casm.contactapp.core.domain.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel() {
    val allContacts: LiveData<List<Contact>> = repository.allContacts.asLiveData()

    fun addContact(image: String, name: String, phoneNumber: String, email: String) {
        viewModelScope.launch {
            val contact = Contact(
                0,
                image = image,
                name = name,
                phoneNumber = phoneNumber,
                email = email
            )
            repository.insert(contact)
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            repository.update(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repository.delete(contact)
        }
    }
}

