package com.example.josep.mascotascoursera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FormularioMensaje extends AppCompatActivity {

    private TextInputLayout nombre , correo , mensaje;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mensaje);
    }
    @SuppressLint("WrongViewCast")
    void enviarMensaje(View v)
    {
        nombre = (TextInputLayout) findViewById(R.id.nombre);
        mensaje = (TextInputLayout) findViewById(R.id.mensaje);
        correo = (TextInputLayout)findViewById(R.id.correo);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(mensaje.getEditText().getText().toString(),correo.getEditText().getText().toString(), null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, nombre.getEditText().getText().toString());
        startActivity(Intent.createChooser(emailIntent,  mensaje.getEditText().getText().toString()));
    }
}
