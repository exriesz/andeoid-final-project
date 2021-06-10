package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var mainlistview : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mainact : LinearLayout = LinearLayout(this)
        mainact = findViewById((R.id.mainact))
        val plus : Button = findViewById(R.id.New)
        val getbool = intent.getBooleanExtra("bool", false)
        var getalldiary = intent.getStringArrayListExtra("alldiary")
        var getalldiarycontent = intent.getStringArrayListExtra("alldiarycontent")
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        mainlistview = findViewById(R.id.mainlistview)
        if(getbool)
        {
            if (getalldiary != null && getalldiarycontent!= null) {
                for(i in getalldiary) {
                    myAdapter.add(i)
                }
                plus.setOnClickListener{ newDiary(getalldiary, getalldiarycontent) }
            }
        }
        else
        {
            var alldiary : ArrayList<String> = ArrayList()
            var alldiarycontent : ArrayList<String> = ArrayList()
            plus.setOnClickListener{ newDiary(alldiary, alldiarycontent) }
        }
        mainlistview.setOnItemClickListener { adapterView, view, i, id ->
            val thediary = myAdapter.getItem(i)
            val intent = Intent(this, DiaryContent::class.java)
            intent.putStringArrayListExtra("alldiary", getalldiary)
            intent.putStringArrayListExtra("alldiarycontent", getalldiarycontent)
            intent.putExtra("thediary", thediary)
            intent.putExtra("id", id)
            startActivity(intent)
        }
        mainlistview.adapter = myAdapter
    }
    private fun newDiary(alldiary : ArrayList<String>, alldiarycontent: ArrayList<String>)
    {
        val Newdiary : Intent = Intent()
        Newdiary.setClass(this, NewDiary::class.java)
        Newdiary.putStringArrayListExtra("alldiary", alldiary)
        Newdiary.putStringArrayListExtra("alldiarycontent", alldiarycontent)
        startActivity(Newdiary)
    }
}