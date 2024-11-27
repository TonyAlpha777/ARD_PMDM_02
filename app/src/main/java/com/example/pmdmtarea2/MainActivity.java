package com.example.pmdmtarea2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.pmdmtarea2.databinding.ActivityMainBinding;

import java.util.Locale;

/**
 * Clase principal de la aplicación que actúa como controlador para gestionar la navegación
 * y el ciclo de vida principal de la app.
 * <p>
 * La clase implementa la funcionalidad de un Drawer Layout, Navigation Component,
 * un menú contextual y configuración de idioma. También maneja eventos de clics en los elementos de la interfaz.
 */
public class MainActivity extends AppCompatActivity {

    private NavController navController; // Controlador de navegación
    private ActionBarDrawerToggle toggle; // Botón de alternancia para el menú lateral
    private ActivityMainBinding binding; // Objeto de binding para acceder al layout

    /**
     * Método llamado al crear la actividad. Configura la navegación, el menú lateral y el idioma.
     *
     * @param savedInstanceState Objeto que contiene el estado anterior de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        // Configuración del View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración del NavController
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();


        configureToggleMenu(); // Configura el menú lateral
        configureNavigation(); // Configura la navegación

        // Configuración del icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * Configura el menú lateral y su interacción con la ActionBar.
     */
    private void configureToggleMenu() {
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.home_drawer,
                R.string.settings_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Configura la navegación utilizando Navigation Component.
     * También maneja la interacción con el menú lateral y el header de navegación.
     */
    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar selección en el menú lateral
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.gameListFragment); // Navega al fragmento de inicio
            } else if (menuItem.getItemId() == R.id.nav_settings) {
                navController.navigate(R.id.settingsFragment); // Navega al fragmento de configuración
            }
            binding.drawerLayout.closeDrawers();
            return true;
        });

        // Configurar clic en la imagen del header
        View headerView = binding.navView.getHeaderView(0); // Obtiene la vista del header
        ImageView profileImage = headerView.findViewById(R.id.header_image); // Obtiene la referencia de la imagen
        profileImage.setOnClickListener(v -> {
            navController.navigate(R.id.profileFragment); // Navega al fragmento de perfil
            binding.drawerLayout.closeDrawers(); // Cierra el Drawer después del clic
        });


    }

    /**
     * Método llamado al hacer clic en un elemento de la lista de juegos.
     * Navega al detalle del juego y pasa los datos correspondientes al siguiente fragmento.
     *
     * @param game Objeto GameData que contiene la información del personaje seleccionado.
     * @param view Vista desde la cual se inició la navegación.
     */
    public void gameClicked(GameData game, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", game.getImage());
        bundle.putString("name", game.getName());
        bundle.putString("description", game.getDescription());
        bundle.putString("skills", game.getSkills());

        // Navega al fragmento de detalle con los datos del juego
        Navigation.findNavController(view).navigate(R.id.gameDetailFragment, bundle);
    }

    /**
     * Infla el menú contextual en la ActionBar.
     *
     * @param menu Objeto del menú donde se inflará el menú definido en XML.
     * @return True si el menú se infló correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.acerca_de).setTitle(getString(R.string.title_context_menu));
        return true;
    }

    /**
     * Maneja la selección de opciones del menú contextual.
     *
     * @param item Elemento del menú seleccionado.
     * @return True si se maneja la acción, False en caso contrario.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.acerca_de) {
            StartGameDialogFragment dialog = new StartGameDialogFragment();
            dialog.show(getSupportFragmentManager(), "StartGameDialogFragment");
        } else if (item.getItemId() == R.id.gameListFragment) {
            navController.navigate(R.id.gameDetailFragment);
        } else {
            navController.navigate(R.id.gameListFragment);
        }

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Devuelve el controlador de navegación para su uso externo.
     *
     * @return Instancia de NavController.
     */
    public NavController getNavController() {
        return navController;
    }

    /**
     * Fragmento interno para mostrar un cuadro de diálogo con información.
     */
    public static class StartGameDialogFragment extends DialogFragment {

        /**
         * Crea un diálogo de alerta con un mensaje.
         *
         * @param savedInstanceState Estado previamente guardado, si lo hay.
         * @return Instancia del diálogo configurado.
         */
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setMessage(getString(R.string.about_main_menu))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            //return alertDialog.create();

            AlertDialog dialog = alertDialog.create();
            dialog.setOnShowListener(dialogInterface -> {
                TextView message = dialog.findViewById(android.R.id.message);
                if (message != null) {
                    message.setTypeface(ResourcesCompat.getFont(getContext(), R.font.mario)); // Reemplazamos la fuente
                    message.setTextSize(14); // Cambiar tamaño del texto si es necesario
                }

            });
            return dialog;
        }
    }

    /**
     * Sobrescribe el comportamiento de navegación hacia arriba en la ActionBar.
     *
     * @return True si se maneja la navegación, False en caso contrario.
     */
    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

    /**
     * Actualiza los títulos del menú contextual.
     */
    public void updateMenuTitles() {

       invalidateOptionsMenu();
    }

    /**
     * Configura el contexto base con el idioma seleccionado por el usuario.
     *
     * @param newBase Contexto base proporcionado por el sistema.
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        PreferencesHelper preferencesManager = new PreferencesHelper(newBase);
        String languageCode = preferencesManager.getLanguage();
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        Context context = newBase.createConfigurationContext(config);
        super.attachBaseContext(context);
    }
}
