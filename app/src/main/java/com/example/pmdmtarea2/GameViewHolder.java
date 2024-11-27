package com.example.pmdmtarea2;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdmtarea2.databinding.GameCardviewBinding;

/**
 * ViewHolder para gestionar las vistas de cada elemento en el RecyclerView.
 *
 * Este ViewHolder utiliza View Binding para acceder a las vistas definidas en el layout
 * de cada cardview y asignarles los datos correspondientes.
 */
public class GameViewHolder extends RecyclerView.ViewHolder {

    private final GameCardviewBinding binding; // Enlace al layout de la cardview.

    /**
     * Constructor que inicializa el ViewHolder con un objeto de View Binding.
     *
     * @param binding Objeto GameCardviewBinding que permite acceder a las vistas
     *                del layout asociado.
     */
    public GameViewHolder(GameCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un objeto GameData a las vistas del layout.
     *
     * Este método asigna los datos del objeto al ImageView y TextView correspondientes,
     * y asegura que los cambios se reflejen inmediatamente utilizando `executePendingBindings`.
     *
     * @param game Objeto GameData cuyos datos se mostrarán en las vistas.
     */
    public void bind(GameData game) {
        // Asigna la imagen y el texto del objeto GameData a las vistas de la cardview.
        binding.image.setImageResource(game.getImage());
        binding.name.setText(game.getName());

        // Asegura que las vinculaciones pendientes se ejecuten inmediatamente.
        binding.executePendingBindings();
    }
}
