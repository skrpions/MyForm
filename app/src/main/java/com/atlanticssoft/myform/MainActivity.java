package com.atlanticssoft.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageView ivAvatar;
    EditText etNombreAll, etNacimientoAll, etTelefonoAll, etEmailAll, etDescripcionAll;

    private static final String TAG = "MainActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    int avatar;
    String nombre, nacimiento,telefono,email,descripcion;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazo los  view de la interfaz con la Logica de la Activity en la que estoy
        etNombreAll     = (EditText) findViewById(R.id.etNombre);  // Recibo todo lo que hay en etNombre, incluyendo sus atributos
        etNacimientoAll = (EditText) findViewById(R.id.etNacimiento); // Recibo todo lo que hay en etNacimiento, incluyendo sus atributos
        etTelefonoAll   = (EditText) findViewById(R.id.etTelefono); // Recibo todo lo que hay en etTelefono, incluyendo sus atributos
        etEmailAll      = (EditText) findViewById(R.id.etEmail); // Recibo todo lo que hay en etEmail, incluyendo sus atributos
        etDescripcionAll = (EditText) findViewById(R.id.etDescripcion); // Recibo todo lo que hay en etDescripcion, incluyendo sus atributos

        // SetOnclickListener  en etNacimiento para abrir el Calendario
        etNacimientoAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day   = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

    mDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {

            month = month + 1;
            Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);

            String date = dayOfMonth + "/" + month + "/" + year;
            etNacimientoAll.setText(date);
        }
    };

        //
        btnSiguiente = (Button)  findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Almaceno los datos del formulario de MainActivity
                nombre = etNombreAll.getText().toString();  // Guardo en la Variable nombre únicamente el atributo android:text en String
                //Log.d("Skrpion", "NOMBRE RECUPERADO: "+ nombre);
                nacimiento = etNacimientoAll.getText().toString();  // Guardo en la Variable nombre únicamente el atributo android:text en String
                //Log.d("Skrpion", "NACIMENTO RECUPERADO: "+ nacimiento);
                telefono = etTelefonoAll.getText().toString();  // Guardo en la Variable nombre únicamente el atributo android:text en String
                //Log.d("Skrpion", "TELEFONO RECUPERADO: "+ telefono);
                email = etEmailAll.getText().toString();  // Guardo en la Variable nombre únicamente el atributo android:text en String
                //Log.d("Skrpion", "EMAIL RECUPERADO: "+ email);
                descripcion = etDescripcionAll.getText().toString();  // Guardo en la Variable nombre únicamente el atributo android:text en String
                //Log.d("Skrpion", "DESCRIPCION RECUPERADO: "+ descripcion);


                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                //Crear el objeto que trasportará el Avatar, Nombre, Nacimiento, Telefono, Email y Descripción a la otra Activity
                Bundle mybundle = new Bundle();

                // Preparo los datos para enviarlos a ConfirmarDatos.java
                mybundle.putInt("avatar",R.drawable.logo); // Para enviar el avatar solamente se necesita buscarla la imagen desde R.drawable y ya.
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
        });


        // CODIGO PARA EDITAR LOS CAMPOS

        //Aqui estoy recuperando los datos que vienen desde ConfirmarDatos.java a través deL Objeto mybundle
        Bundle mybundle2 = this.getIntent().getExtras();

        if (mybundle2 != null)
        {
            Log.d("Skrpion","MAIN EDITAR AVATAR: "+ avatar);
            nombre = mybundle2.getString("nombre"); // El key "nombre" debe ser exactamente igual al que se envio desde el MainActivity. Video: https://www.youtube.com/watch?v=M76NNP-U2gA
            Log.d("Skrpion","MAIN EDITAR  NOMBRE: "+ nombre);
            nacimiento = mybundle2.getString("nacimiento");
            Log.d("Skrpion","MAIN EDITAR NACIMIENTO: "+ nacimiento);
            telefono = mybundle2.getString("telefono");
            Log.d("Skrpion","MAIN EDITAR TELEFONO: "+ telefono);
            email = mybundle2.getString("email");
            Log.d("Skrpion","MAIN EDITAR EMAIL: "+ email);
            descripcion = mybundle2.getString("descripcion");
            Log.d("Skrpion","MAIN EDITAR DESCRIPCION: "+ descripcion);
        }

        // Coloco los textos recuperados en los TextView de ConfirmarDatos.java
        etNombreAll.setText(nombre);
        etNacimientoAll.setText(nacimiento);
        etTelefonoAll.setText(telefono);
        etEmailAll.setText(email);
        etDescripcionAll.setText(descripcion);
    }
}



