package com.example.pmdmtarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdmtarea2.databinding.GameCardviewBinding;

import java.util.ArrayList;

/**
 * Adaptador personalizado para gestionar la lista de personajes en un RecyclerView.
 *
 * Esta clase enlaza los datos de los objetos de la clase GameData con las vistas correspondientes
 * en el RecyclerView, y maneja los eventos de clic en cada elemento.
 */
public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameViewHolder> {

    private final ArrayList<GameData> games; // Lista de personajes a mostrar en el RecyclerView.
    private final Context context; // Contexto de la aplicación, necesario para eventos.

    /**
     * Constructor para inicializar el adaptador con una lista de datos y un contexto.
     *
     * @param games   Lista de datos de tipo GameData.
     * @param context Contexto de la actividad o fragmento donde se utiliza el RecyclerView.
     */
    public GameRecyclerViewAdapter(ArrayList<GameData> games, Context context) {
        this.games = games;
        this.context = context;
    }

    /**
     * Crea un nuevo GameViewHolder inflando el layout de la cardview.
     *
     * @param parent   Vista padre donde se agregará el ViewHolder.
     * @param viewType Tipo de vista.
     * @return Un nuevo objeto GameViewHolder.
     */
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout utilizando View Binding para la cardview.
        GameCardviewBinding binding = GameCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new GameViewHolder(binding);
    }

    /**
     * Vincula los datos de un elemento GameData a un ViewHolder específico.
     *
     * @param holder   El ViewHolder que contiene las vistas para el elemento actual.
     * @param position Posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        GameData currentGame = this.games.get(position);
        holder.bind(currentGame); // Vincula los datos al ViewHolder.

        // Maneja el evento de clic en el elemento actual.
        holder.itemView.setOnClickListener(view -> itemClicked(currentGame, view));
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Cantidad de elementos en la lista.
     */
    @Override
    public int getItemCount() {
        return games.size();
    }

    /**
     * Maneja el evento de clic en un elemento del RecyclerView.
     *
     * Llama al método gameClicked en el MainActivity, pasando el elemento actual
     * y la vista asociada.
     *
     * @param currentGame Datos del elemento que fue seleccionado.
     * @param view        Vista asociada al elemento.
     */
    private void itemClicked(GameData currentGame, View view) {
        ((MainActivity) context).gameClicked(currentGame, view);
    }
}
