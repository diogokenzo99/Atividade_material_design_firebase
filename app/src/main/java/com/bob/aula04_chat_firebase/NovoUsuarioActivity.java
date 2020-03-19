package com.bob.aula04_chat_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class NovoUsuarioActivity extends AppCompatActivity {

    private EditText loginNovoUsuarioEditText;
    private EditText senhaNovoUsuarioEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        loginNovoUsuarioEditText = findViewById(R.id.loginNovoUsuarioEditText);
        senhaNovoUsuarioEditText = findViewById(R.id.senhaNovoUsuarioEditText);
        mAuth = FirebaseAuth.getInstance();
    }

    //Método chamado pelo XML
    public void criarNovoUsuario (View view){
        String login = loginNovoUsuarioEditText.getEditableText().toString();
        String senha = senhaNovoUsuarioEditText.getEditableText().toString();

        //Método asyn que é assincrono por causa de conexoes lentar
        //  por isso é necessario adicionar o listener, que só vai
        //  disparar açoes apos sucesso
        mAuth.createUserWithEmailAndPassword(login, senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(NovoUsuarioActivity.this, getString(R.string.sucesso_cadastro, authResult.getUser().toString()),Toast.LENGTH_SHORT).show();
                finish();  //metodo que chama os metodos de ciclo até o destroy
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NovoUsuarioActivity.this, getString(R.string.erro_cadastro),Toast.LENGTH_SHORT).show();
                finish();  //metodo que chama os metodos de ciclo até o destroy
            }
        });
    }
}
