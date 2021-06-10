package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DiaryContent : AppCompatActivity() {
    lateinit var title : TextView
    lateinit var content: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_content)
        title = findViewById(R.id.title)
        content = findViewById(R.id.content)
        var thediary = intent.getStringExtra("thediary")
        var i = intent.getLongExtra("id", 0)
        var alldiarycontent = intent.getStringArrayListExtra("alldiarycontent")
        title.text = thediary
        content.text = alldiarycontent?.get(i.toInt())
        val back : Button = findViewById(R.id.back)
        back.setOnClickListener{ back() }
    }
    private fun back()
    {
        var alldiary = intent.getStringArrayListExtra("alldiary")
        var alldiarycontent = intent.getStringArrayListExtra("alldiarycontent")
        val intent : Intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        intent.putExtra("bool", true)
        intent.putStringArrayListExtra("alldiary", alldiary)
        intent.putStringArrayListExtra("alldiarycontent", alldiarycontent)
        startActivity(intent)
    }
}