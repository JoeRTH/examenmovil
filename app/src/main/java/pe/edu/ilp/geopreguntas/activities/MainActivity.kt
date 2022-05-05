package pe.edu.ilp.geopreguntas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.geopreguntas.R
import pe.edu.ilp.geopreguntas.model.Pregunta
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0
    var contador = 0

    //Pregunta 2
    val n = 5
    var factorial: Long = 1
    //Pregunta 3
    var base=5
    var altura:Int=6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //E01()
        //EO2()
        //E03()

        //Este metodo añade preguntas a la lista
        cargarPreguntas()

        //Este metodo muestra las preguntas
        mostrarPreguntas()

        val btnVerdod = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdod.setOnClickListener {
            if (preguntas[posicionActual].respuesta)
                Toast.makeText(this, "Respuesta Correcta Prrin xD", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Respuesta Incorrecta :v", Toast.LENGTH_SHORT).show()

        }

        val btnFalsu = findViewById<android.view.View>(R.id.btnFalso)
        btnFalsu.setOnClickListener {
            //Si la respuesta es falsa entonces:
            if (!preguntas[posicionActual].respuesta)
                Toast.makeText(this, "Respuesta Correcta prrin :V", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Respuesta incorrecta Xd", Toast.LENGTH_SHORT).show()
        }

        val btnNext = findViewById<Button>(R.id.btnSiguiente)
        btnNext.setOnClickListener {
            try {
                posicionActual++
                mostrarPreguntas()
            } catch (e:Exception){
                Toast.makeText(this, "No hay mas preguntas Xd", Toast.LENGTH_SHORT).show()
            }
        }

        val btnAnterior = findViewById<Button>(R.id.btnAtras)
        btnAnterior.setOnClickListener {
            posicionActual--
            mostrarPreguntas()
        }

    }


    fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.tvPregunta)
        //Para no mostrar la respuesta solo se pone el enunciado.
        textoPregunta.text = preguntas[posicionActual].enunciado
    }

    fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas es la capital de Venezuela", true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador", false))
        preguntas.add(Pregunta("Uruguay es un pais Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de chile", false))
    }

    fun E01() {
        for (i in 50 downTo 1 step 2) {
            println("Numero: $i")
        }
    }

    fun EO2() {
        for (i in 1..n) {
            factorial *= i.toLong()
        }
        println("factorial de: $n=$factorial")
    }
    fun E03(){
        var area=(base*altura)/2
        println("Area del Triangualo =: $area")
    }
}//Line 7