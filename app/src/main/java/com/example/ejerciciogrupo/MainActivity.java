package com.example.ejerciciogrupo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText id_mitexto;
    private TextView id_resultado;
    private TextView id_numeros;
    private Button id_verificado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        id_mitexto = findViewById(R.id.id_mitexto);
        id_resultado = findViewById(R.id.id_resultado);
        id_numeros = findViewById(R.id.id_numeros);
        id_verificado = findViewById(R.id.id_verificado);

        // Ajustar insets de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el botón para verificar si el número es par o impar
        id_verificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_mitexto.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                    return;
                }

                int numero = Integer.parseInt(id_mitexto.getText().toString());

                if (numero % 2 == 0) {
                    id_resultado.setText("El número es par");
                } else {
                    id_resultado.setText("El número es impar");
                }
            }
        });

        // Configurar otro botón para cambiar de fragmento
        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_mi_version, new OtroFragment())
                        .commit();
            }
        });
    }
}




