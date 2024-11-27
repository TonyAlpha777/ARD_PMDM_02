package com.example.pmdmtarea2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad que muestra una pantalla Splash al iniciar la aplicación.
 *
 * Dependiendo de la versión del sistema operativo, maneja la pantalla Splash de manera personalizada
 * o delega su gestión a Android si la versión es Android 12 (API 31) o superior.
 */
public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // Tiempo de duración de la Splash en milisegundos.

    /**
     * Método llamado cuando se crea la actividad.
     *
     * Muestra una pantalla Splash personalizada para versiones de Android inferiores a la API 31.
     * Para versiones iguales o superiores, se delega el manejo de la Splash a Android y se inicia
     * directamente la actividad principal.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verificar la versión de la API del sistema operativo.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            // Para versiones inferiores a Android 12 (API 31), usar una Splash personalizada.
            setContentView(R.layout.splash); // Layout XML personalizado para la Splash.

            // Usar un Handler para retrasar el inicio de la MainActivity.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Después del tiempo configurado, iniciar MainActivity.
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finalizar SplashActivity para que no permanezca en la pila.
                }
            }, SPLASH_TIME_OUT);
        } else {
            // Para Android 12 (API 31) o superior, dejar que Android maneje la Splash automáticamente.
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finalizar SplashActivity ya que no es necesaria.
        }
    }
}
