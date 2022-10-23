package com.example.dbsqlite_realm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dbsqlite_realm.databinding.ActivityAddContactsBinding

class AddContactActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAddContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveContact.setOnClickListener {
            with(binding) {
                viewModel.addContact(
                    name = etName.text.toString(),
                    surname = etSurname.text.toString(),
                    number = etNumber.text.toString()
                )
                startActivity(Intent(this@AddContactActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}