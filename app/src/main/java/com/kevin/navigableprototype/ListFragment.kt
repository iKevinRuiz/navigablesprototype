package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Acciones de la fila inferior
        view.findViewById<MaterialButton>(R.id.btnGoDetailDemo)?.setOnClickListener {
            // Navega al detalle de demostración
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<MaterialButton>(R.id.btnGoForm)?.setOnClickListener {
            // Navega al formulario
            findNavController().navigate(R.id.action_list_to_form)
        }

        // Botones "Ver detalle" de cada tarjeta
        val btnSeeUsuarios   = view.findViewById<MaterialButton>(R.id.btnSeeUsuarios)
        val btnSeePedidos    = view.findViewById<MaterialButton>(R.id.btnSeePedidos)
        val btnSeeReportes   = view.findViewById<MaterialButton>(R.id.btnSeeReportes)

        // Tarjetas completas también permiten tocar para ir a detalle
        val cardUsuarios     = view.findViewById<MaterialCardView>(R.id.cardUsuarios)
        val cardPedidos      = view.findViewById<MaterialCardView>(R.id.cardPedidos)
        val cardReportes     = view.findViewById<MaterialCardView>(R.id.cardReportes)

        // Acción común: ir al detalle
        val goDetail: (View) -> Unit = {
            findNavController().navigate(R.id.action_list_to_detail)
        }

        // Conectar listeners (si alguna vista no existe, el safe-call evita crash en preview)
        listOf(btnSeeUsuarios, btnSeePedidos, btnSeeReportes).forEach { it?.setOnClickListener(goDetail) }
        listOf(cardUsuarios, cardPedidos, cardReportes).forEach { it?.setOnClickListener(goDetail) }
    }
}
