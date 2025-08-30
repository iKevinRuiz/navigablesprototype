package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navegar a la Lista al tocar el botón
        view.findViewById<MaterialButton>(R.id.btnGoToList)?.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_list)
        }
    }
}
