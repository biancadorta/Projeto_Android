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
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.layout.*;

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

            if(!intent.equals(null)){
                String email = params.getString("email");
                String nome = params.getString("nome");
                String fone = params.getString("telefone");

                Aluno aluno = new Aluno(nome, email, fone);
               // if(myAsync.equals(null)) {
                 //   myAsync = new MinhaAsyncTask();
                MinhaAsyncTask myAsync = new MinhaAsyncTask();
                myAsync.execute(aluno);
                //}
            }
        }
        catch(Exception e){
            Toast.makeText(getBaseContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }


        listAlunos = findViewById(R.id.listAlunos);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Adicionar.class);
                startActivity(intent2);
                //Toast.makeText(getBaseContext(),"Entrou no click",Toast.LENGTH_SHORT).show();
            }
        });
        //listarAlunos(); //de inicio nao ha nenhum aluno noa array, so havera alunos quando houver a primeira
                        //inclusao e as demais posteriores*/


    }

    public void listarAlunos(ArrayList<Aluno> lista){
        ArrayAdapter<Aluno> alunosAdapter = new ArrayAdapter<Aluno>(this, simple_list_item_2,lista);
        listAlunos.setAdapter(alunosAdapter);
    }

    class MinhaAsyncTask extends AsyncTask<Aluno,Void, ArrayList<Aluno>> {
        ArrayList<Aluno> listaAluno;

        public MinhaAsyncTask() {
            listaAlunos = new ArrayList<Aluno>();
        }

        @Override
        protected ArrayList<Aluno> doInBackground(Aluno... alunos) {
            Aluno al1 = alunos[0];
            listaAlunos.add(al1);
            return listaAlunos;
        }

        @Override
        protected void onPostExecute(ArrayList<Aluno> alunos) {
            listarAlunos(alunos);
        }
    }


}
