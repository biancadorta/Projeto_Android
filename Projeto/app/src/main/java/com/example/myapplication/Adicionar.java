package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Adicionar extends AppCompatActivity {

    Button btnIncluir;
    TextView txtEmail;
    TextView txtNome;
    TextView txtPhone;
    TextView txtMsg;
    ArrayList<Aluno> listaAlunos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        txtEmail = findViewById(R.id.txtEmail);
        txtNome  = findViewById(R.id.txtNome);
        txtPhone = findViewById(R.id.txtPhone);
        btnIncluir = findViewById(R.id.btnIncluir);
        txtMsg = findViewById(R.id.txtMsg);

        btnIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAux = getIntent();
                listaAlunos= (ArrayList<Aluno>)intentAux.getSerializableExtra("listaAlunos");

                Intent intent = new Intent(Adicionar.this, MainActivity.class);
                Bundle params = new Bundle(); //a classe Bundle é utilizada para definir o objeto que sera passado para a outra tela

                if(txtEmail.equals("") || txtNome.equals("") || txtPhone.equals("")){
                    txtMsg.setText("Preencha todos os campos.");
                    txtNome.setText("");
                    txtPhone.setText("");
                    txtEmail.setText("");
                    return;
                }

                params.putString("email", txtEmail.getText().toString());
                params.putString("nome", txtNome.getText().toString());
                params.putString("telefone", txtPhone.getText().toString());

                intent.putExtra("listaAlunos",(Serializable) listaAlunos);

                intent.putExtras(params); //o metodo putExtras e usado para receber o objeto Bundle que sera passado para a outra tela

                startActivity(intent);
            }
        });
    }
}
