package com.example.exer5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.exer5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.nameEdit.setOnClickListener {
            updateName(it)
        }

    }

    private fun updateName(view: View) {
        //binding versions
        binding.apply {
            nameLabel.text = nameEdit.text.toString()
            nameLabel.visibility = View.INVISIBLE
            nameEdit.visibility = View.VISIBLE
            nameEdit.requestFocus()
        }


        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nameEdit, 0)
    }

}

