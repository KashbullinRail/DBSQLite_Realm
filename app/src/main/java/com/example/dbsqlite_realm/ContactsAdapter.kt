package com.example.dbsqlite_realm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dbsqlite_realm.databinding.ItemContactsBinding

class ContactsAdapter() : ListAdapter<Contacts, ContactsAdapter.MyViewHolder>(MyDiffUtil) {

    object MyDiffUtil: DiffUtil.ItemCallback<Contacts>(){
        override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class MyViewHolder(private val binding: ItemContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contacts: Contacts?) {
            binding.tvNameAddSurname.text = "${ contacts?.name } ${contacts?.surname}"
            binding.tvNumber.text = contacts?.number
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemContactsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(allContacts: List<Contacts>){
        this.submitList(allContacts)
        notifyDataSetChanged()
    }


}