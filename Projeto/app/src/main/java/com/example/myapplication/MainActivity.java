package com.example.myapplication;

import android.R.layout;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static android.R.layout.*;

public class MainActivity extends AppCompatActivity{

    ListView listViewAlunos;
    FloatingActionButton btnAdicionar;
    ArrayList<Aluno> listaAluno;
   // MinhaAsyncTask myAsync; //ele ira instanciar de novo
    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        txtMsg = findViewById(R.id.txtMsg);
        listaAluno = new ArrayList<Aluno>();

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Adicionar.class);
                intent2.putExtra("listaAlunos",(Serializable)listaAluno);
                startActivity(intent2);
            }
        });


        try{
            Intent intent = getIntent();
            Bundle params = intent.getExtras(); //o metodo getExtras -> retorna o objeto Bundle criado para enviar os parametros

            if(!(intent==null)){
                    String email = params.getString("email");
                    String nome = params.getString("nome");
                    String fone = params.getString("telefone");

                    Aluno aluno = new Aluno(nome, email, fone);

                    listaAluno = (ArrayList<Aluno>) intent.getSerializableExtra("listaAlunos");
                    listaAluno.add(aluno);
                    listarAlunos(listaAluno);
            }
        }
        catch(Exception e){
            Toast.makeText(getBaseContext(),"Ainda não há alunos para serem exibidos.",Toast.LENGTH_SHORT).show();
        }
    }

    public void listarAlunos(ArrayList<Aluno> lista){
        ArrayAdapter<Aluno> alunosAdapter = new ArrayAdapter<Aluno>(this, simple_gallery_item,lista);
        listViewAlunos.setAdapter(alunosAdapter);
    }
    
    public class MyAsyncTask extends AsyncTask<,Progresso,Resultado>{

    


    
    }
}
