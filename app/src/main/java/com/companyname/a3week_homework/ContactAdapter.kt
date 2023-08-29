package com.companyname.a3week_homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companyname.a3week_homework.databinding.AnotherItemBinding
import com.companyname.a3week_homework.databinding.ItemBinding

class ContactAdapter(val items: MutableList<Contact>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_DEFAULT = 0
        private const val VIEW_TYPE_ANOTHER = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_DEFAULT -> {
                val binding = ItemBinding.inflate(inflater, parent, false)
                DefaultViewHolder(binding)
            }
            VIEW_TYPE_ANOTHER -> {
                val anotherBinding = AnotherItemBinding.inflate(inflater, parent, false)
                AnotherViewHolder(anotherBinding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DefaultViewHolder -> {
                val contact = items[position]
                holder.bindDefault(contact)
            }
            is AnotherViewHolder -> {
                val contact = items[position]
                holder.bindAnother(contact)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].Favorites) {
            VIEW_TYPE_DEFAULT
        } else {
            VIEW_TYPE_ANOTHER
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class DefaultViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val iconImageView = binding.icon
        private val name = binding.name
        private val phoneNumber = binding.phonenumber

        fun bindDefault(contact: Contact) {
            iconImageView.setImageResource(contact.Icon)
            name.text = contact.Name
            phoneNumber.text = contact.PhoneNumber
        }
    }

    inner class AnotherViewHolder(private val binding: AnotherItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val iconImageView = binding.icon
        private val name = binding.name
        private val phoneNumber = binding.phonenumber

        fun bindAnother(contact: Contact) {
            iconImageView.setImageResource(contact.Icon)
            name.text = contact.Name
            phoneNumber.text = contact.PhoneNumber
        }
    }
}
