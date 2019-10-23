package br.edu.fatecgarca.freetrading.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.edu.fatecgarca.freetrading.R;

public class AdicionarClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cliente);
    }

    public void btnCancelar(View view){
        Intent intent = new Intent();
        setResult(1, intent);
        super.finish();
    }
}
