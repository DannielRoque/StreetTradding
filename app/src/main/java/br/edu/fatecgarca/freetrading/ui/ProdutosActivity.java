package br.edu.fatecgarca.freetrading.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.edu.fatecgarca.freetrading.R;


public class ProdutosActivity extends AppCompatActivity {
    private Toolbar mainToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        setSupportActionBar(mainToolbar);

        Button novoCadastroCliente = findViewById(R.id.activity_novo_cadastro_fab);
        novoCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProdutosActivity.this, AdicionarProdutoActivity.class);
                startActivity(intent);
            }
        });
    }
}
