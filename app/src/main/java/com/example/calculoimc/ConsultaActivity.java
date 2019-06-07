package com.example.calculoimc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    private ArrayAdapter<Pessoa> arrayAdapter;
    private EditText nomePesquisa;
    private ListView listView;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        nomePesquisa = findViewById(R.id.idNomePesquisa);
        listView = findViewById(R.id.idListConsultaPessoa);
        iniciarFireBase();
        eventoEdit();
    }

    private void iniciarFireBase(){
        FirebaseApp.initializeApp(ConsultaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void eventoEdit(){
        nomePesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                listaPessoas.clear();
                String palavra = nomePesquisa.getText().toString();
                pesquisarPalavra(palavra);
            }
        });
    }

    private void pesquisarPalavra(String palavra){
        Query query;
        if (palavra.equals("")){
            query = databaseReference.child("Pessoa").orderByChild("nome");
        }else{
            query = databaseReference.child("Pessoa").orderByChild("nome").startAt(palavra).endAt(palavra+"\uf0ff");
        }
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot objSnap: dataSnapshot.getChildren()){
                    Pessoa p = objSnap.getValue(Pessoa.class);
                    listaPessoas.add(p);
                }
                arrayAdapter = new ArrayAdapter<Pessoa>(ConsultaActivity.this, android.R.layout.simple_list_item_1, listaPessoas);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
