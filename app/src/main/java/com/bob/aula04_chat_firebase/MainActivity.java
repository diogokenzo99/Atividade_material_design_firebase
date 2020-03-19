package com.bob.aula04_chat_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void fazerLogin(View view){

    }

    public void irParaCadastro(View view){
        //Referência para outra classe
        startActivity(new Intent(this, NovoUsuarioActivity.class));
    }
}
