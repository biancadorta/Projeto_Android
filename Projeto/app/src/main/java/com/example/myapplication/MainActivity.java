package com.example.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ListView listAlunos;
    FloatingActionButton btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlunos = findViewById(R.id.listAlunos);
        //btnAdicionar = findViewById(R.id.floatingActionButton);
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        Aluno al1 = new Aluno("Bianca","biancadorta14@gmail.com", "19997280222");
        Aluno al2 = new Aluno("Elisinhaa", "elisacs@hotmail.com","19998765435");
        listaAlunos.add(al1);
        listaAlunos.add(al2);
        listarAlunos(); //de inicio nao ha nenhum aluno noa array, so havera alunos quando houver a primeira
                          //inclusao e as demais posteriores
    }

    private void listarAlunos(){
        //Como vou pegar os alunos se é o começo?
        //pega os alunos do array list e os lista na tela
    }
}
