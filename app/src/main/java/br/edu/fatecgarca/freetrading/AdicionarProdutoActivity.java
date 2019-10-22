package br.edu.fatecgarca.freetrading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdicionarProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);



    }

    public void btnCancelar(View view){
        Intent intent = new Intent();
        setResult(1, intent);
        super.finish();
    }
}
