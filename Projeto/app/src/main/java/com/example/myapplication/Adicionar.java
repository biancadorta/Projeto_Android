package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Adicionar extends AppCompatActivity {

    Button btnIncluir;
    TextView txtEmail;
    TextView txtNome;
    TextView txtTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        txtEmail = findViewById(R.id.txtEmail);
        txtNome  = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtPhone);
        btnIncluir = findViewById(R.id.btnIncluir);

        btnIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Adicionar.this, MainActivity.class);
                Bundle params = new Bundle(); //a classe Bundle é utilizada para definir o objeto que sera passado para a outra tela

                //verificar se o usuario realmente preencheu os campos
                params.putString("email", txtEmail.getText().toString());
                params.putString("nome", txtNome.getText().toString());
                params.putString("telefone", txtTelefone.getText().toString());

                intent.putExtras(params); //o metodo putExtras e usado para receber o objeto Bundle que sera passado para a outra tela

                startActivity(intent);
            }
        });
    }
}
