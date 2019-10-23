package br.edu.fatecgarca.freetrading.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.edu.fatecgarca.freetrading.R;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    @Override
    protected void onStart() {
        super.onStart();

//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if(currentUser == null){
//            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(loginIntent);
//            finish();
        //}
    }

    public void abrirProdutos(View view){
        Intent intent = new Intent(this, ProdutosActivity.class);
        startActivity(intent);
    }
    public void abrirClientes(View view){
        Intent intent = new Intent(this, ClientesActivity.class);
        startActivity(intent);
    }
    public void abrirPendencias(View view){
        Intent intent = new Intent(this, PendenciasActivity.class);
        startActivity(intent);
    }

}
