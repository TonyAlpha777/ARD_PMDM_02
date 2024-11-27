package com.example.pmdmtarea2;

/**
 * Representa el modelo de datos para un personaje de Super Mario Bros, utilizado para
 * llenar una lista de elementos.
 * Esta clase encapsula las propiedades de cada personaje, como su imagen,
 * nombre, descripción y habilidades.
 */
public class GameData {
    private final int image; // ID del recurso de la imagen del personaje.
    private final String name; // Nombre del personaje.
    private final String description; // Descripción breve del personaje.
    private final String skills; // Habilidades o características del personaje.

    /**
     * Constructor para crear instancias de GameData.
     *
     * @param image       El ID del recurso para la imagen del personaje.
     * @param name        El nombre del personaje.
     * @param description Una breve descripción del personaje.
     * @param skills      Una lista de habilidades o características del personaje.
     */
    public GameData(int image, String name, String description, String skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    /**
     * Obtiene el ID del recurso de la imagen del personaje.
     *
     * @return El ID del recurso de la imagen.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del personaje.
     *
     * @return Una breve descripción del personaje.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene las habilidades o características del personaje.
     *
     * @return Una Lista de las habilidades del personaje.
     */
    public String getSkills() {
        return skills;
    }
}
