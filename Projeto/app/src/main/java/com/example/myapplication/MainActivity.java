package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ListView listAlunos;
    ArrayList<Aluno> listaAlunos = new ArrayList<>();
    FloatingActionButton btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Intent intent = getIntent();
            Bundle params = intent.getExtras(); //o metodo getExtras -> retorna o objeto Bundle criado para enviar os parametros

            String email = params.getString("email");
            String nome  = params.getString("nome");
            String fone  = params.getString("telefone");

            Aluno aluno = new Aluno(nome,email,fone);
            listaAlunos.add(aluno);
        }
        catch(Exception e){
            Toast.makeText(getBaseContext(),"Ainda nao há alunos para exibição",Toast.LENGTH_SHORT).show();
        }


        listAlunos = findViewById(R.id.listAlunos);
        btnAdicionar = findViewById(R.id.floatingActionButton);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Aluno al1 = new Aluno("Bianca","biancadorta14@gmail.com", "19997280222");
        Aluno al2 = new Aluno("Elisinhaa","elisacs@hotmail.com","19998765435");
        listaAlunos.add(al1);
        listaAlunos.add(al2);
        listarAlunos(); //de inicio nao ha nenhum aluno noa array, so havera alunos quando houver a primeira
                        //inclusao e as demais posteriores
    }

    private void listarAlunos(){
        //Como vou pegar os alunos se é o começo?
        //pega os alunos do array list e os lista na tela
        ArrayAdapter<Aluno> alunosAdapter = new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1,listaAlunos);
        listAlunos.setAdapter(alunosAdapter);
    }
}
