package com.kevin.navigableprototype

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FormFragment : Fragment(R.layout.fragment_form) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tilName = view.findViewById<TextInputLayout>(R.id.tilName)
        val etName = view.findViewById<TextInputEditText>(R.id.etName)
        val tilEmail = view.findViewById<TextInputLayout>(R.id.tilEmail)
        val etEmail = view.findViewById<TextInputEditText>(R.id.etEmail)
        val tilDesc = view.findViewById<TextInputLayout>(R.id.tilDesc)
        val etDesc = view.findViewById<TextInputEditText>(R.id.etDesc)

        // Botón Cancelar → volver atrás
        view.findViewById<MaterialButton>(R.id.btnCancel)?.setOnClickListener {
            findNavController().navigateUp()
        }

        // Botón Guardar → validación simple + Toast
        view.findViewById<MaterialButton>(R.id.btnSave)?.setOnClickListener {
            clearErrors(tilName, tilEmail, tilDesc)

            val name = etName?.text?.toString()?.trim().orEmpty()
            val email = etEmail?.text?.toString()?.trim().orEmpty()
            val desc = etDesc?.text?.toString()?.trim().orEmpty()

            var valid = true
            if (name.isEmpty()) {
                tilName.error = "El nombre es obligatorio"
                valid = false
            }
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tilEmail.error = "Correo inválido"
                valid = false
            }
            if (desc.length < 5) {
                tilDesc.error = "Agrega una descripción (mín. 5 caracteres)"
                valid = false
            }

            if (valid) {
                Toast.makeText(requireContext(), "Guardado correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp() // vuelve a la pantalla anterior
            }
        }
    }

    private fun clearErrors(vararg til: TextInputLayout) {
        til.forEach { it.error = null }
    }
}
