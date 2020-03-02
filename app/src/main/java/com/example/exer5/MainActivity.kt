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
    private val myGuides: MyGuides = MyGuides()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.myGuides = myGuides

        //hardcoded strings for the "guides"
        binding.apply {
            helloGuide.text = myGuides?.hello
            nameGuide.text = myGuides?.name
            nicknameGuide.text = myGuides?.nickname
            ageGuide.text = myGuides?.age
            birthdayGuide.text = myGuides?.birthday
            phoneGuide.text = myGuides?.phone
            colorGuide.text = myGuides?.color
            dreamGuide.text = myGuides?.dream
            courseGuide.text = myGuides?.course
            crushGuide.text = myGuides?.crush
            messageGuide.text = myGuides?.message
            doneButton.text = myGuides?.done
            endLabel.text = myGuides?.end
        }

        binding.nameEdit.setOnClickListener {
            updateName(it)
        }
        binding.doneButton.setOnClickListener {
            addDetails(it)
        }
    }

    private fun addDetails(view: View) {
        // binding versions, hide form and show only the result
        binding.apply {

            //edit text to the end labels
            myName?.name = nameEdit.text.toString()
            nameLabel.text = myName?.name
            nameLabel.visibility = View.VISIBLE

            myName?.nickname = nicknameEdit.text.toString()
            nicknameLabel.text = myName?.nickname
            nicknameLabel.visibility = View.VISIBLE

            myName?.age = ageEdit.text.toString()
            ageLabel.text = myName?.age
            ageLabel.visibility = View.VISIBLE

            //visibility
            helloGuide.visibility = View.GONE
            nameGuide.visibility = View.GONE
            nicknameGuide.visibility = View.GONE
            ageGuide.visibility = View.GONE
            birthdayGuide.visibility = View.GONE
            phoneGuide.visibility = View.GONE
            colorGuide.visibility = View.GONE
            dreamGuide.visibility = View.GONE
            courseGuide.visibility = View.GONE
            crushGuide.visibility = View.GONE
            messageGuide.visibility = View.GONE

            nameEdit.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            ageEdit.visibility = View.GONE
            birthdayEdit.visibility = View.GONE
            phoneEdit.visibility = View.GONE
            colorEdit.visibility = View.GONE
            dreamEdit.visibility = View.GONE
            courseEdit.visibility = View.GONE
            crushEdit.visibility = View.GONE
            messageEdit.visibility = View.GONE
            view.visibility = View.GONE
            endLabel.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    //focus phone to the text
    private fun updateName(view: View) {
        view.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

}

