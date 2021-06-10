package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewDiary : AppCompatActivity() {

    lateinit var topic : EditText
    lateinit var time: EditText
    lateinit var article: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_diary)
        topic = findViewById(R.id.topic)
        time = findViewById(R.id.time)
        article = findViewById(R.id.article)
        val add : Button = findViewById(R.id.add)
        add.setOnClickListener{ addNew() }
    }
    private fun addNew()
    {
        var alldiary = intent.getStringArrayListExtra("alldiary")
        alldiary?.add("標題 : " + topic.getText().toString() + "\n時間 : " + time.getText().toString())
        var alldiarycontent = intent.getStringArrayListExtra("alldiarycontent")
        alldiarycontent?.add(article.getText().toString() + "\n")
        val intent : Intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        intent.putExtra("bool", true)
        intent.putStringArrayListExtra("alldiary", alldiary)
        intent.putStringArrayListExtra("alldiarycontent", alldiarycontent)
        startActivity(intent)
    }
}