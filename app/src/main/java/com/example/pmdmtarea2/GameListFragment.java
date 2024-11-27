package com.example.pmdmtarea2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pmdmtarea2.databinding.GameListFragmentBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * Fragmento que muestra una lista de personajes de Super Mario Bros utilizando un RecyclerView.
 *
 * Este fragmento se encarga de inicializar un RecyclerView con un listado de personajes,
 * configurando el adaptador y gestionando los datos a través de una lista.
 */
// Este fragment es el del reciclerView
public class GameListFragment extends Fragment {
    private GameListFragmentBinding binding; //Binding para el layout
    private ArrayList<GameData> games;//Lista de personajes
    private GameRecyclerViewAdapter adapter; //Adaptador del RecyclerView

    /**
     * Infla el diseño del fragmento utilizando View Binding.
     *
     * @param inflater  Inflador para crear las vistas del fragmento.
     * @param container Contenedor donde se agrega el fragmento.
     * @param savedInstanceState Estado guardado, si está disponible.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Inflar el layout utilizando el binding
        binding = GameListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Configura el RecyclerView y carga la lista de datos al crearse la vista del fragmento.
     *
     * @param view               La vista creada del fragmento.
     * @param savedInstanceState Estado guardado, si está disponible.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inicializa la lista de juegos
        loadGames(); // Cargar los juegos (puedes implementar esta función para obterner datos)

        //Configurar el RecyclerView
        adapter = new GameRecyclerViewAdapter(games, getActivity());
        binding.gamesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.gamesRecyclerview.setAdapter(adapter);
    }

    // Método para cargar los datos de un ArrayList que contiene los datos de cada personaje.
    /**
     * Carga los datos de los personajes en un ArrayList.
     *
     * Este método inicializa la lista de personajes con sus respectivas imágenes, nombres,
     * descripciones y habilidades, utilizando recursos de la aplicación.
     *
     * Las imágenes utilizadas han sido descargadas desde https://mario.nintendo.com/es/characters/.
     */
    private void loadGames() {
        games = new ArrayList<GameData>();

        // 1. Boo
        games.add(new GameData(
                R.drawable.boo,
                getString(R.string.name_boo_supermario),
                getString(R.string.description_boo_supermario),
                getString(R.string.skills_boo_supermario)
        ));

        // 2. Bowser
        games.add(new GameData(
                R.drawable.bowser,
                getString(R.string.name_bowser_supermario),
                getString(R.string.description_bowser_supermario),
                getString(R.string.skills_bowser_supermario)
        ));

        // 3. Bowser Jr.
        games.add(new GameData(
                R.drawable.bowser_jr,
                getString(R.string.name_bowserjr_supermario),
                getString(R.string.description_bowserjr_supermario),
                getString(R.string.skills_bowserjr_supermario)
        ));

        // 4. Diddy Kong
        games.add(new GameData(
                R.drawable.diddy_kong,
                getString(R.string.name_diddykong_supermario),
                getString(R.string.description_diddykong_supermario),
                getString(R.string.skills_diddykong_supermario)
        ));

        // 5. Donkey Kong
        games.add(new GameData(
                R.drawable.donkey_kong,
                getString(R.string.name_donkeykong_supermario),
                getString(R.string.description_donkeykong_supermario),
                getString(R.string.skills_donkeykong_supermario)
        ));

        // 6. Luigi
        games.add(new GameData(
                R.drawable.luigi,
                getString(R.string.name_luigi_supermario),
                getString(R.string.description_luigi_supermario),
                getString(R.string.skills_luigi_supermario)
        ));

        // 7. Mario
        games.add(new GameData(
                R.drawable.mario,
                getString(R.string.name_mario_supermario),
                getString(R.string.description_mario_supermario),
                getString(R.string.skills_mario_supermario)
        ));

        // 8. Princess Daisy
        games.add(new GameData(
                R.drawable.daisy,
                getString(R.string.name_daisy_supermario),
                getString(R.string.description_daisy_supermario),
                getString(R.string.skills_daisy_supermario)
        ));

        // 9. Princess Peach
        games.add(new GameData(
                R.drawable.peach,
                getString(R.string.name_peach_supermario),
                getString(R.string.description_peach_supermario),
                getString(R.string.skills_peach_supermario)
        ));

        // 10. Rosalina
        games.add(new GameData(
                R.drawable.rosalina,
                getString(R.string.name_rosalina_supermario),
                getString(R.string.description_rosalina_supermario),
                getString(R.string.skills_rosalina_supermario)
        ));

        // 11. Toad
        games.add(new GameData(
                R.drawable.toad,
                getString(R.string.name_toad_supermario),
                getString(R.string.description_toad_supermario),
                getString(R.string.skills_toad_supermario)
        ));

        // 12. Waluigi
        games.add(new GameData(
                R.drawable.waluigi,
                getString(R.string.name_waluigi_supermario),
                getString(R.string.description_waluigi_supermario),
                getString(R.string.skills_waluigi_supermario)
        ));

        // 13. Wario
        games.add(new GameData(
                R.drawable.wario,
                getString(R.string.name_wario_supermario),
                getString(R.string.description_wario_supermario),
                getString(R.string.skills_wario_supermario)
        ));

        // 14. Yoshi
        games.add(new GameData(
                R.drawable.yoshi,
                getString(R.string.name_yoshi_supermario),
                getString(R.string.description_yoshi_supermario),
                getString(R.string.skills_yoshi_supermario)
        ));
    }

    /**
     * Configura el título del ActionBar y muestra un mensaje al inicio del fragmento.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar, para que no aparezca siempre el nombre de la clase
        if(getActivity() != null){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_actionbar_list_fragment));
           //Mensaje cuando se accede a la lista de personajes.
            Snackbar.make(binding.getRoot(),getString(R.string.snackbar_listFragment), Snackbar.LENGTH_LONG).show();
        }
    }




}
