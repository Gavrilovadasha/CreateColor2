package da.gavrilova.createcolor

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var createColorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createColorButton = findViewById(R.id.showDialogButton)
        createColorButton.setOnClickListener{
            showColorPickerDialog()
        }

    }

    @SuppressLint("MissingInflatedId")
    private fun showColorPickerDialog() {
        val builder = AlertDialog.Builder(this@MainActivity)
        val inflater = layoutInflater
        val dialogView: View = inflater.inflate(R.layout.colors_dialog, null)
        builder.setView(dialogView)
        val seekBarR = dialogView.findViewById<SeekBar>(R.id.seekBarR)
        val seekBarG = dialogView.findViewById<SeekBar>(R.id.seekBarG)
        val seekBarB = dialogView.findViewById<SeekBar>(R.id.seekBarB)
        val confirmButton = dialogView.findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            val red = seekBarR.progress
            val green = seekBarG.progress
            val blue = seekBarB.progress
            val color = Color.rgb(red, green, blue)
            dialogView.setBackgroundColor(color);
        }
        val dialog = builder.create()
        dialog.show()
    }
}




