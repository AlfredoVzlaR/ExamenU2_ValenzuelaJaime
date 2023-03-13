package mx.edu.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val button: Button = findViewById(R.id.btnDetalles)

        button.setOnClickListener {
            var intent: Intent = Intent( this, Regalos::class.java)
            startActivity(intent)
        }
    }


}