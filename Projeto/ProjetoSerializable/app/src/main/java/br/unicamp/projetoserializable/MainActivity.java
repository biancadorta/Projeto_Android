package br.unicamp.projetoserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtModelo = findViewById(R.id.txtModelo);
        final EditText edtMarca  = findViewById(R.id.txtMarca);

        Button btnProcessar = findViewById(R.id.btnProcessar);

        btnProcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carro carro = new Carro();
                carro.setModelo(edtModelo.getText().toString());
                carro.setMarca(edtMarca.getText().toString());

                Intent intent = new Intent(MainActivity.this,Tela2.class);
                intent.putExtra("CarroSerializable",(Serializable)carro);
                startActivity(intent);
            }
        });

    }
}
