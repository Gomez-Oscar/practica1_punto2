package com.example.practica1_punto2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_convertir.setOnClickListener {

            val monto = etn_dinero.text.toString()
            val moneda_ini = sp1.selectedItem.toString()
            val moneda_fin = sp2.selectedItem.toString()

            var monto1 = 0.0
            var monto2 = 0.0

            if (monto.isEmpty()) {
                tv_resultado.text = "Porfavor ingrese un valor"
            } else {
                monto1 = monto.toDouble()

                if (moneda_ini == "Pesos Colombianos") {
                    when (moneda_fin) {
                        "Dólares Estadounidenses" -> monto2 = monto1 * 0.00027
                        "Pesos Argentinos" -> monto2 = monto1 * 0.019
                        "Pesos Chilenos" -> monto2 = monto1 * 0.22
                        "Pesos Colombianos" -> monto2 = monto1
                    }
                } else if (moneda_ini == "Dólares Estadounidenses") {
                    when (moneda_fin) {
                        "Pesos Colombianos" -> monto2 = monto1 * 3748
                        "Pesos Argentinos" -> monto2 = monto1 * 69.74
                        "Pesos Chilenos" -> monto2 = monto1 * 817.30
                        "Dólares Estadounidenses" -> monto2 = monto1
                    }
                } else if (moneda_ini == "Pesos Argentinos") {
                    when (moneda_fin) {
                        "Pesos Colombianos" -> monto2 = monto1 * 53.74
                        "Dólares Estadounidenses" -> monto2 = monto1 * 0.014
                        "Pesos Chilenos" -> monto2 = monto1 * 11.72
                        "Pesos Argentinos" -> monto2 = monto1
                    }
                } else if (moneda_ini == "Pesos Chilenos") {
                    when (moneda_fin) {
                        "Pesos Colombianos" -> monto2 = monto1 * 4.59
                        "Pesos Argentinos" -> monto2 = monto1 * 0.085
                        "Dólares Estadounidenses" -> monto2 = monto1 * 0.0012
                        "Pesos Chilenos" -> monto2 = monto1
                    }
                }

                tv_resultado.text = "${monto1.toBigDecimal().toPlainString()} $moneda_ini" +
                        "\nequivalen a " +
                        "\n${monto2.toBigDecimal().setScale(4, RoundingMode.HALF_EVEN).toPlainString()} " +
                        "$moneda_fin"
            }

        }
    }
}
