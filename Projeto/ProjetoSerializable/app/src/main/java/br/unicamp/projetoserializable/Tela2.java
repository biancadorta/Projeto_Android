package br.unicamp.projetoserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView tvModelo = findViewById(R.id.txtModelo);
        TextView tvMarca = findViewById(R.id.txtMarca);


        Intent intent = getIntent();
        Carro carro = (Carro) intent.getSerializableExtra("carroSerializable");

        if(carro != null) {
            tvModelo.setText(carro.getModelo());
            tvMarca.setText(carro.getMarca());
        }
        else
        {
            tvModelo.setText("Modelo não encontrado");
            tvMarca.setText("Marca não encontrada");
        }
    }
}
