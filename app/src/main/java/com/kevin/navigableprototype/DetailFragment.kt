package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Acción Volver
        view.findViewById<MaterialButton>(R.id.btnBack)?.setOnClickListener {
            findNavController().navigateUp()
        }

        // Si en el futuro pasas argumentos desde la lista, aquí los lees y pintas:
        // val args = requireArguments()
        // val title = args.getString("title") ?: "Título del ítem"
        // view.findViewById<MaterialTextView>(R.id.tvDetailTitle)?.text = title
    }
}
