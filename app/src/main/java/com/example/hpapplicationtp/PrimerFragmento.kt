package com.example.hpapplicationtp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class PrimerFragmento: Fragment() {

    var listener: PrimerFragmentoInterfaz? = null
    lateinit var btnSobreNosotros : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.primer_fragment, container, false)
        btnMostrarContenido = view.findViewById(R.id.btnFragmento)
        btnMostrarContenido.setOnClickListener {
            listener?.mostrarContenido()
        }
        return view
    }

}
