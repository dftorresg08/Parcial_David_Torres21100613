package com.example.parcial_dt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DivisasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_divisas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val etTipoDeCambio: TextView = findViewById(R.id.etTipoDeCambio)
        val etMonto: TextView = findViewById(R.id.etMonto)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtb1 = findViewById<TextView>(R.id.txtb1)
        val txtb2 = findViewById<TextView>(R.id.txtb2)
        val txtb3 = findViewById<TextView>(R.id.txtb3)


        btnCalcular.setOnClickListener{
            var Soles = etTipoDeCambio.text.toString().toDouble() * etMonto.text.toString().toDouble()
            txtResultado.text = Soles.toString()
            var result = billetes(Soles)
            for ((billete, cantidad) in result){
                if (billete== 100){
                    txtb1.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }else if(billete == 50){
                    txtb2.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }else if(billete == 20){
                    txtb3.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }
            }
        }
    }
    fun billetes(monto: Double): Map<Int, Int> {
        // Denominacion de los billetes
        val billetes = listOf(100,50,20)
        val resultado = mutableMapOf<Int, Int>()

        //Monto que resta
        var montoRestatnte = monto.toInt()

        for (billete in billetes) {
            val cantidadBilletes = montoRestatnte / billete
            if (cantidadBilletes > 0) {
                resultado[billete] = cantidadBilletes
                montoRestatnte %= billete
            }
        }

        return resultado
    }
}