package practice.llc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var editTextDate : EditText
    private lateinit var  editTextMST: EditText
    private lateinit var editTextAST:EditText
    private lateinit var  editTextNotes: EditText
    private lateinit var buttonSave : Button
    private lateinit var buttonClear : Button
    private lateinit var buttonNext : Button
    private lateinit var tvMessage : TextView
    //add
    private val dateArray = mutableListOf<Float>()
    private val timeArrayMorning =  mutableListOf<Float>()
    private val timeArrayAfternoon = mutableListOf<Float>()
    private val notesArray = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        editTextDate = findViewById(R.id.editTextDate)
        editTextMST = findViewById(R.id.editTextMst)
        editTextAST = findViewById(R.id.editTextAST)
        editTextNotes = findViewById(R.id.editTextNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        buttonNext = findViewById(R.id.buttonNext)
        tvMessage = findViewById(R.id.tvMessage)



        buttonClear.setOnClickListener {
            editTextDate.setText("")
            editTextMST.setText("")
            editTextAST.setText("")
            editTextNotes.setText("")
        }

        buttonSave.setOnClickListener {
          val screenTimeDate = editTextDate.text.toString()
            val screenTimeMorning = editTextMST.text.toString()
           val screenTimeAfternoon = editTextAST.text.toString()
            val screenTimeNote = editTextNotes.text.toString()

            if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()){
                try {
                    dateArray.add(screenTimeDate.toFloat())
                    timeArrayMorning.add(screenTimeMorning.toFloat())
                    timeArrayAfternoon.add(screenTimeAfternoon.toFloat())
                    notesArray.add((screenTimeNote))
                    editTextDate.text.clear()
                    editTextMST.text.clear()
                    editTextAST.text.clear()
                    editTextNotes.text.clear()
                } catch (e:NumberFormatException){
                    tvMessage.text = "Please enter a valid number"
                }
                } else {
                tvMessage.text = "Input cannot be empty"
            }
        }

        buttonNext.setOnClickListener {
           val intent = Intent(this,MainActivity3::class.java)
           intent.putExtra("dateArray",dateArray.toFloatArray())
           intent.putExtra("timeArrayMorning",timeArrayMorning.toFloatArray())
           intent.putExtra("timeArrayAfternoon",timeArrayAfternoon.toFloatArray())
           intent.putExtra("notesArray",notesArray.toTypedArray())
           startActivity(intent)
        }

        }
    }
