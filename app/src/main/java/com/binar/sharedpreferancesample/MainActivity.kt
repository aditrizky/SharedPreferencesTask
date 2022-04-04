package com.binar.sharedpreferancesample

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.sharedpreferancesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences : SharedPreferences = this.getSharedPreferences(
            this.toString(),
            Context.MODE_PRIVATE)

        binding.btnSave.setOnClickListener {
            val id : Int = binding.etInputId.text.toString().toInt()
            val name: String = binding.etInputName.text.toString()
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("id_key", id)
            editor.putString("name_key", name)
            editor.apply()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()

        }
        binding.btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(this,"Data Clear", Toast.LENGTH_LONG).show()
        }
        binding.btnView.setOnClickListener {
            val sharedIdValue = sharedPreferences.getInt("id_key", 0)
            val sharedNameValue = sharedPreferences.getString("name_key","defaultname")
            if (sharedIdValue == 0 || sharedNameValue == "defaultname"){
                binding.tvShowName.text="default name: ${sharedNameValue.toString()}"
                binding.tvShowId.text= "default id : ${sharedIdValue.toString()}"
                Toast.makeText(this,"Data View Kosong", Toast.LENGTH_LONG).show()
            }else{
                binding.tvShowName.text= sharedNameValue.toString()
                binding.tvShowId.text= sharedIdValue.toString()
                Toast.makeText(this,"data VIew Ditampilkan",Toast.LENGTH_LONG).show()
            }

        }
    }

}