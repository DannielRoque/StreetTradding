package br.edu.fatecgarca.freetrading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditarClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_clientes);

        Button btnCancelar = (Button)findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encerrarCamada();
            }
        });
    }



    private void encerrarCamada(){
        EditarClientesActivity.this.finish();
        Intent intent = new Intent(EditarClientesActivity.this,ClientesActivity.class);
        startActivity(intent);
    }
}
