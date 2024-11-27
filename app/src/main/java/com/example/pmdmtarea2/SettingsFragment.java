package com.example.pmdmtarea2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pmdmtarea2.databinding.SettingsFragmentBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

/**
 * Fragmento que gestiona la configuración de la aplicación. *
 * Este fragmento permite al usuario cambiar el idioma de la aplicación y actualiza dinámicamente
 * los textos y elementos de la interfaz para reflejar el cambio.
 */
public class SettingsFragment extends Fragment {

    private SettingsFragmentBinding binding; // Objeto de binding para acceder a la vista.


    /**
     * Método llamado al crear la vista del fragmento.
     * Inicializa el binding y configura los eventos para manejar la selección de idioma.
     *
     * @param inflater           Inflador para crear la vista del fragmento.
     * @param container          Contenedor padre al que se añadirá la vista del fragmento.
     * @param savedInstanceState Estado guardado previamente del fragmento, si existe.
     * @return Vista raíz del fragmento.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        binding.languageRadioGroup.setOnCheckedChangeListener(this::onLenguageSelected);
        updateLanguageSelection(); // Actualiza los botones de idioma según las preferencias guardadas.
        return binding.getRoot();

    }

    /**
     * Actualiza los textos y elementos de la interfaz para reflejar el idioma seleccionado.     *
     * Este método actualiza los textos de la pantalla actual, el título de la barra de herramientas
     * y los elementos del menú del NavigationView.
     */
    public void updateLanguageView() {
        binding.languageTextView.setText(R.string.language_textView);
        binding.radioButtonEnglish.setText(R.string.english_radioButton);
        binding.radioButtonSpanish.setText(R.string.spanish_radioButton);


        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(getString(R.string.title_actionbar_list_fragment));

            }
        }

        //Configura los items del NavigationDrawer para el cambio de idioma
        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_home).setTitle(getString(R.string.home_drawer));
        menu.findItem(R.id.nav_settings).setTitle(getString(R.string.settings_drawer));

        //Configura el textView del NavigationDrawer para el cambio de idioma
        View headerViewSubTitle = navigationView.getHeaderView(0); // Obtiene la vista del header
        TextView headerSubtitle = headerViewSubTitle.findViewById(R.id.header_subtitle); //Encontramos el textView
        headerSubtitle.setText(getString(R.string.subtitle_navheader));//Actualiza el texto
/*
        //Configura el menú de la toolbar para el cambio de idioma
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        Menu menu1 = toolbar.getMenu();
        menu.findItem(R.id.acerca_de).setTitle(getString(R.string.about_main_menu));

*/


    }

    /**
     * Método llamado cuando se selecciona un idioma en el grupo de botones de radio.
     * Cambia el idioma de la aplicación y guarda la preferencia.
     *
     * @param radioGroup Grupo de botones de radio que contiene las opciones de idioma.
     * @param checkedId  ID del botón seleccionado.
     */
    private void onLenguageSelected(RadioGroup radioGroup, int checkedId) {
        if (checkedId == R.id.radioButtonSpanish) {
            changeLenguage("es");
        } else {
            changeLenguage("en");
        }
    }

    /**
     * Actualiza la selección de idioma en los botones de radio según las preferencias guardadas.
     */
    private void updateLanguageSelection() {
        PreferencesHelper preferencesManager = new PreferencesHelper(requireContext());
        String currentLanguage = preferencesManager.getLanguage(); // Obtener el idioma guardado.

        if ("es".equals(currentLanguage)) {
            binding.radioButtonSpanish.setChecked(true);
        } else if ("en".equals(currentLanguage)) {
            binding.radioButtonEnglish.setChecked(true);
        }
    }

    /**
     * Cambia el idioma de la aplicación.     *
     * Este método actualiza la configuración regional de la aplicación, guarda la preferencia
     * de idioma en las preferencias compartidas y recarga la interfaz para reflejar el cambio.
     *
     * @param languageCode Código del idioma a establecer (por ejemplo, "es" o "en").
     */
    private void changeLenguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        PreferencesHelper preferencesManager = new PreferencesHelper(requireContext());
        preferencesManager.setLanguage(languageCode);

        updateLanguageView();

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).updateMenuTitles(); // Notifica a la actividad principal para actualizar los títulos del menú.

        }
    }
}
