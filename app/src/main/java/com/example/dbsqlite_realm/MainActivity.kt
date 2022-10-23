package com.example.dbsqlite_realm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dbsqlite_realm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ContactsAdapter()

        viewModel.allContacts.observe(this){
            adapter.setData(it)
        }
        binding.rvContacts.adapter = adapter

        binding.fabAddContacts.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
    }
}