package com.example.pmdmtarea2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pmdmtarea2.databinding.GameDetailFragmentBinding;

/**
 * Fragmento que muestra los detalles de un personaje del juego.
 *
 * Este fragmento se utiliza para visualizar información detallada de un personaje seleccionado
 * desde la lista principal, incluyendo su imagen, nombre, descripción y habilidades.
 */
public class GameDetailFragment extends Fragment {
    private GameDetailFragmentBinding binding;

    /**
     * Infla el diseño del fragmento y configura el binding para acceder a los elementos de la interfaz de usuario.
     *
     * @param inflater  El inflador de layouts utilizado para inflar las vistas.
     * @param container El contenedor padre donde se agregará este fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si está disponible.
     * @return La vista raíz inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = GameDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se llama después de que la vista del fragmento haya sido creada.
     * Configura los elementos de la interfaz de usuario con los datos recibidos como argumentos.
     *
     * @param view               La vista creada del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si está disponible.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener los datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes de la interfaz de usuario
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);

            // Mostrar un mensaje (Toast) con información del personaje seleccionado
            Toast.makeText(requireContext(), getString(R.string.toast_detailFragment) + " " + name, Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Se llama cuando el fragmento pasa al estado "iniciado".
     * Cambia el título de la barra de herramientas para reflejar el contenido actual.
     */
    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_actionbar_detail_fragment);

        }

    }
}
