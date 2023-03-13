package mx.edu.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {

    var adapter: DetalleAdapter? = null
    var detalles=ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        val gridview: GridView = findViewById(R.id.gridview)

        cargarDetalles()
        adapter=DetalleAdapter(this,detalles)
        gridview.adapter = adapter
    }

    fun cargarDetalles(){
        detalles.add(Detalles(R.drawable.globoamor,"Globo amor","250"))
        detalles.add(Detalles(R.drawable.globocumple,"Globo cumple","250"))
        detalles.add(Detalles(R.drawable.globofestejo,"Globo festejo","250"))
        detalles.add(Detalles(R.drawable.globonum,"Globo num","250"))
        detalles.add(Detalles(R.drawable.globoregalo,"Globo regalo","250"))
    }

    class DetalleAdapter: BaseAdapter {

        var productos = ArrayList<Detalles>()
        var contexto: Context? =null

        constructor(contexto: Context, pelicula: ArrayList<Detalles>){
            this.productos = pelicula
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflator=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            var vista=inflator.inflate(R.layout.activity_detalle_regalos,null)

            var imagen = vista.findViewById(R.id.iv_imagenDetalle) as ImageView
            var nombre = vista.findViewById(R.id.tv_titulo) as TextView
            var precio = vista.findViewById(R.id.tv_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.titulo)
            precio.setText(prod.precio)

            imagen.setOnClickListener(){
                val intento = Intent(contexto,DetalleRegalos::class.java)
                intento.putExtra("titulo",prod.titulo)
                intento.putExtra("imagen",prod.image)
                intento.putExtra("precio",prod.precio)
                contexto!!.startActivity(intento)
            }
            return vista
        }

    }
}