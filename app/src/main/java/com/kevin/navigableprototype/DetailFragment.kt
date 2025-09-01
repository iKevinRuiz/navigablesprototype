package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón "Volver"
        view.findViewById<MaterialButton>(R.id.btnBack)?.setOnClickListener {
            findNavController().navigateUp()
        }

        // Si luego pasas argumentos desde la lista, puedes pintarlos aquí.
        // Si no hay args, quedan los valores por defecto de strings.xml
        val title = arguments?.getString("title")
        val subtitle = arguments?.getString("subtitle")
        val body = arguments?.getString("body")
        val status = arguments?.getString("status")
        val date = arguments?.getString("date")

        title?.let { view.findViewById<MaterialTextView>(R.id.tvDetailTitle).text = it }
        subtitle?.let { view.findViewById<MaterialTextView>(R.id.tvDetailSubtitle).text = it }
        body?.let { view.findViewById<MaterialTextView>(R.id.tvDetailBody).text = it }
        status?.let { view.findViewById<MaterialTextView>(R.id.tvStatus).text = it }
        date?.let { view.findViewById<MaterialTextView>(R.id.tvDate).text = it }
    }
}
