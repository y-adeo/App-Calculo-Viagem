package com.yasminadeo.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }

    }

    private fun calculate() {

        if (validationOk()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAuto.text.toString().toFloat()

                val resultadoTotal = (distancia * preco) / autonomia
                editResult.text = "R$ ${"%.2f".format(resultadoTotal)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.insira_numero_valido), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campo), Toast.LENGTH_LONG).show()

        }

    }

    private fun validationOk(): Boolean {
        return (editDistancia.text.toString() != ""
            && editPreco.text.toString() != ""
            && editAuto.text.toString() != ""
        )

    }


}


