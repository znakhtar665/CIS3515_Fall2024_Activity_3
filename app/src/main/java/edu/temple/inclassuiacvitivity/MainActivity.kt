package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

// TODO Replace ArrayAdapter with your implementation of TextSizeAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = Array(50){i -> (i + 1) * 2}

        with (spinner) {
            /* Step 2: Create adapter to display items from array in Spinner */
            adapter = TextSizeAdapter(this@MainActivity, numberArray)


            // Step 3: Change TextView's text size to the number selected in the Spinner */
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    parent?.run {
                        displayTextView.textSize = getItemAtPosition(position).toString().toFloat()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }

    }
}