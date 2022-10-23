package com.example.dbsqlite_realm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.kotlin.createObject
import java.util.*

class MainViewModel : ViewModel() {
    private var realm: Realm = Realm.getDefaultInstance()

    val allContacts: LiveData<List<Contacts>>
        get() = getAllContacts()

    fun addContact(name: String, surname: String, number: String) {
        realm.executeTransaction {
            val model = it.createObject<Contacts>(UUID.randomUUID().toString()).apply {
                this.name = name
                this.surname = surname
                this.number = number
            }
            it.insertOrUpdate(model)
        }
    }

    private fun getAllContacts(): MutableLiveData<List<Contacts>> {
        val list = MutableLiveData<List<Contacts>>()
        val allContacts = realm.where(Contacts::class.java).findAll()
        list.value = allContacts.subList(0, allContacts.size)
        return list
    }
}