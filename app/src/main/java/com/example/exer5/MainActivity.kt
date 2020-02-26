package com.example.exer5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.exer5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.nameEdit.setOnClickListener {
            updateName(it)
        }
        binding.doneButton.setOnClickListener {
            addDetails(it)
        }
    }

    private fun addDetails(view: View) {
        // binding versions
        binding.apply {
            myName?.name = nameEdit.text.toString()
            nameLabel.text = myName?.name
            nameLabel.visibility = View.VISIBLE
            nameEdit.visibility = View.INVISIBLE
            view.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateName(view: View) {
        // binding versions
        binding.apply {
            doneButton.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
            view.requestFocus()
        }
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

}

