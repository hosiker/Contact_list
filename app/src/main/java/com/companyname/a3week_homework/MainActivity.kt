package com.companyname.a3week_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.companyname.a3week_homework.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))

        val dataList = mutableListOf<Contact>()
        dataList.add(Contact(R.drawable.sample_0, "Bella", "010-0000-0000", true))
        dataList.add(Contact(R.drawable.sample_1, "Charlie", "010-1111-1111", false))
        dataList.add(Contact(R.drawable.sample_2, "Daisy", "010-2222-2222", true))
        dataList.add(Contact(R.drawable.sample_3, "Duke", "010-3333-3333", true))
        dataList.add(Contact(R.drawable.sample_4, "Max", "010-4444-4444", false))
        dataList.add(Contact(R.drawable.sample_5, "Happy", "010-5555-5555", false))
        dataList.add(Contact(R.drawable.sample_6, "Luna", "010-6666-6666", true))
        dataList.add(Contact(R.drawable.sample_7, "Bob", "010-7777-7777", false))
        dataList.add(Contact(R.drawable.sample_8, "Bobo", "010-8888-8888", true))
        dataList.add(Contact(R.drawable.sample_9, "Bobonom", "010-9999-9999", false))

        adapter = ContactAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}