package br.edu.fatecgarca.freetrading.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.edu.fatecgarca.freetrading.R;


public class ClientesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        Button novoCadastroCliente = findViewById(R.id.activity_novo_cadastro_fab);
        novoCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientesActivity.this, AdicionarClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
