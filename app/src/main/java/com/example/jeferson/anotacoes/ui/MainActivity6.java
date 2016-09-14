package com.example.jeferson.anotacoes.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jeferson.anotacoes.R;
import com.example.jeferson.anotacoes.data.Anotacao;
import com.example.jeferson.anotacoes.ui.adapter.AnotacaoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    private EditText editBox;
    private Button insertButton;
    private ListView notesList;

    private List<Anotacao> listAnotacao;
    private AnotacaoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        editBox = (EditText) findViewById(R.id.edit_box);
        insertButton = (Button) findViewById(R.id.insert_button);
        notesList = (ListView) findViewById(R.id.notes_list);

        listAnotacao = new ArrayList<>();
        adapter = new AnotacaoAdapter(this, listAnotacao);
        notesList.setAdapter(adapter);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editBox.getText().toString();

                Anotacao anotacao = new Anotacao();
                anotacao.setDescricao(texto);

                listAnotacao.add(anotacao);

                adapter.notifyDataSetChanged();

                editBox.setText("");

            }
        });

    }

}
