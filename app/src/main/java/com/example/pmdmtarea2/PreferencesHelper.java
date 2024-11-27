package com.example.pmdmtarea2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Clase auxiliar para gestionar las preferencias de la aplicación.
 *
 * Esta clase proporciona métodos para guardar y recuperar configuraciones persistentes,
 * como el idioma seleccionado por el usuario.
 */
public class PreferencesHelper {
    private static final String PREF_NAME = "app_preferences"; // Nombre del archivo de preferencias.
    private static final String KEY_LANGUAGE = "key_language"; // Clave para almacenar el idioma.
    private final SharedPreferences sharedPreferences; // Objeto para acceder a las preferencias compartidas.

    /**
     * Constructor de la clase.
     * Inicializa el acceso a las preferencias compartidas.
     *
     * @param context Contexto de la aplicación o actividad.
     */
    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Guarda el idioma seleccionado por el usuario en las preferencias compartidas.
     *
     * @param languageCode Código del idioma a guardar (por ejemplo, "es" para español o "en" para inglés).
     */
    public void setLanguage(String languageCode) {
        sharedPreferences.edit().putString(KEY_LANGUAGE, languageCode).apply();
    }

    /**
     * Recupera el idioma almacenado en las preferencias compartidas.
     *
     * Si no se encuentra un idioma guardado, devuelve "es" (español) como valor predeterminado.
     *
     * @return Código del idioma almacenado o "es" si no se encuentra ninguno.
     */
    public String getLanguage() {
        return sharedPreferences.getString(KEY_LANGUAGE, "es"); // "es" como valor predeterminado.
    }
}
