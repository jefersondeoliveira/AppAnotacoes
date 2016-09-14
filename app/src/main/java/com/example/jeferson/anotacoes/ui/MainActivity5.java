package com.example.jeferson.anotacoes.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jeferson.anotacoes.R;
import com.example.jeferson.anotacoes.data.Anotacao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private EditText editBox;
    private Button insertButton;
    private ListView notesList;

    private List<Anotacao> listAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        editBox = (EditText) findViewById(R.id.edit_box);
        insertButton = (Button) findViewById(R.id.insert_button);
        notesList = (ListView) findViewById(R.id.notes_list);

        listAnotacao = new ArrayList<>();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editBox.getText().toString();

                Anotacao anotacao = new Anotacao();
                anotacao.setDescricao(texto);

                listAnotacao.add(anotacao);

                Log.i("Log de teste", "-------");
                for(Anotacao a : listAnotacao){
                    int index = listAnotacao.indexOf(a);
                    Log.i("Log de teste", "["+index+"] "+a.getDescricao());
                }

            }
        });

    }

}
