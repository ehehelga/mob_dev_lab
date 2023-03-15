package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.text.InputType
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.lab1.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private var email: EditText? = null
    private var password: EditText? = null
    private var isPasswordVisible = false
    private lateinit var binding: ActivitySignupBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.editTextTextEmailAddress
        password = binding.editTextTextPassword
        var localPassword = password
        localPassword?.setOnTouchListener(OnTouchListener { _, event ->
            val right = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= localPassword.right - localPassword.compoundDrawables[right].bounds.width() - 50) {
                    val selection = localPassword.selectionEnd
                    if (isPasswordVisible) {
                        localPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_password_visibility_off,
                            0
                        )
                        localPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        isPasswordVisible = false
                    } else {
                        localPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_password_visibillity_on,
                            0
                        )
                        localPassword.inputType = 1
                        isPasswordVisible = true
                    }
                    localPassword.setSelection(selection)
                    this.password = localPassword
                    return@OnTouchListener true
                }
            }
            false
        })

        binding.buttonSignUp.setOnClickListener{
            if(email!!.text.toString().isEmpty()) {
                email!!.hint = "Enter your e-mail"
            } else if(password!!.text.toString().isEmpty()) {
                password!!.hint = "Enter your password"

            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.imageView3.setOnClickListener {
            val intent = Intent(this, Onboarding::class.java)
            startActivity(intent)
        }
    }
}