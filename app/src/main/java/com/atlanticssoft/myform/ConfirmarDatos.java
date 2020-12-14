package com.atlanticssoft.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    ImageView ivAvatar;
    TextView tvNombre, tvNacimiento, tvTelefono, tvEmail, tvDescripcion;

    int avatar;
    String nombre,nacimiento,telefono,email,descripcion;

    Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        //Aqui estoy recuperando los datos que vienen desde MainActivity.java a traves deL Objeto mybundle
        Bundle mybundle = this.getIntent().getExtras();

        if (mybundle != null)
        {
            avatar = mybundle.getInt("avatar");
            //
            nombre = mybundle.getString("nombre"); // El key "nombre" debe ser exactamente igual al que se envio desde el MainActivity. Video: https://www.youtube.com/watch?v=M76NNP-U2gA
            //Log.d("Skrpion","CONFIRMACION DE NOMBRE: "+ nombre);
            nacimiento = mybundle.getString("nacimiento");
            //Log.d("Skrpion","CONFIRMACION DE NACIMIENTO: "+ nacimiento);
            telefono = mybundle.getString("telefono");
            //Log.d("Skrpion","CONFIRMACION DE Telefono: "+ telefono);
            email = mybundle.getString("email");
            //Log.d("Skrpion","CONFIRMACION DE EMAIL: "+ email);
            descripcion = mybundle.getString("descripcion");
            //Log.d("Skrpion","CONFIRMACION DE DESCRIPCION: "+ descripcion);
        }

        // Enlazo los  view de la interfaz con la Logica de la Activity en la que estoy
        ivAvatar      = (ImageView) findViewById(R.id.ivAvatar);
        tvNombre      = (TextView) findViewById(R.id.tvNombre);
        tvNacimiento  = (TextView) findViewById(R.id.tvNacimiento);
        tvTelefono    = (TextView) findViewById(R.id.tvTelefono);
        tvEmail       = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripción);

        // Coloco los textos recuperados en los TextView de ConfirmarDatos.java
        ivAvatar.setImageResource(avatar);
        tvNombre.setText(nombre);
        tvNacimiento.setText(nacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);


        // Enlazo el botón Editar Datos de la interfaz con la Logica de la Activity en la que estoy
        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarDatos();
            }
        });

    }

    public void editarDatos(){
        Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class );
        //Crear el objeto que trasportará el Avatar, Nombre, Nacimiento, Telefono, Email y Descripción a la otra Activity
        Bundle mybundle = new Bundle();

        // Preparo los datos para enviarlos a ConfirmarDatos.java
        mybundle.putString("nombre",nombre);
        mybundle.putString("nacimiento",nacimiento);
        mybundle.putString("telefono",telefono);
        mybundle.putString("email",email);
        mybundle.putString("descripcion",descripcion);

        //El objeto intent sera el puente que pase los datos a la Siguiente Activity.
        intent.putExtras(mybundle);

        startActivity(intent);
        finish();
    }
}