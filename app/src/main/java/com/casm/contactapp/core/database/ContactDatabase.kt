package com.casm.contactapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.casm.contactapp.core.domain.models.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}