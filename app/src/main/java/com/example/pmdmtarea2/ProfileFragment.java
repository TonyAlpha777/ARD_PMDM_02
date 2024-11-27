package com.example.pmdmtarea2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pmdmtarea2.databinding.ProfileFragmentBinding;

/**
 * Fragmento que representa la pantalla de perfil.
 *
 * Este fragmento utiliza View Binding para inflar su vista y mostrar el contenido relacionado con el perfil del usuario.
 */
public class ProfileFragment extends Fragment {

    private @NonNull ProfileFragmentBinding binding; // View Binding para acceder a las vistas del layout.

    /**
     * Inflar el diseño del fragmento y configurar el binding.
     *
     * @param inflater           Objeto LayoutInflater para inflar el diseño del fragmento.
     * @param container          Contenedor padre en el que se insertará el fragmento (si corresponde).
     * @param savedInstanceState Estado guardado previo del fragmento, si existe.
     * @return La vista raíz del fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inicializar binding para acceder a los elementos del layout.
        binding = ProfileFragmentBinding.inflate(inflater, container, false);

        // Retornar la vista raíz para que se muestre en la interfaz.
        return binding.getRoot();
    }
}
