package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Acciones de la fila inferior
        view.findViewById<MaterialButton>(R.id.btnGoDetail)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<MaterialButton>(R.id.btnGoForm)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_form)
        }

        // 2) Acciones de cada tarjeta (mismo destino de ejemplo)
        view.findViewById<MaterialButton>(R.id.btnSee1)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<MaterialButton>(R.id.btnSee2)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<MaterialButton>(R.id.btnSee3)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }

        // (Opcional) Si quieres que toda la tarjeta sea “clickable”:
        view.findViewById<View>(R.id.cardItem1)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<View>(R.id.cardItem2)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
        view.findViewById<View>(R.id.cardItem3)?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
    }
}
