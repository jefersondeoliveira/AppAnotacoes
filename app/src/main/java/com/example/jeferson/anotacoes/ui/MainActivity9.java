package com.example.jeferson.anotacoes.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jeferson.anotacoes.R;
import com.example.jeferson.anotacoes.data.Anotacao;
import com.example.jeferson.anotacoes.ui.adapter.AnotacaoAdapter;
import com.example.jeferson.anotacoes.utils.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity9 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private EditText editBox;
    private Button insertButton;
    private ListView notesList;

    private List<Anotacao> listAnotacao;
    private AnotacaoAdapter adapter;

    private SharedPreferencesManager preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        editBox = (EditText) findViewById(R.id.edit_box);
        insertButton = (Button) findViewById(R.id.insert_button);
        notesList = (ListView) findViewById(R.id.notes_list);

        preferences = SharedPreferencesManager.getInstance(this);

        listAnotacao = preferences.getAnotacoes();

        adapter = new AnotacaoAdapter(this, listAnotacao);
        notesList.setOnItemClickListener(this);
        notesList.setAdapter(adapter);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editBox.getText().toString();

                Anotacao anotacao = new Anotacao();
                anotacao.setDescricao(texto);
                anotacao.setData(Calendar.getInstance().getTime());

                listAnotacao.add(anotacao);

                preferences.salvaAnotacoes(listAnotacao);

                adapter.notifyDataSetChanged();

                editBox.setText("");

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final Anotacao anotacao = adapter.getItem(position);

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Alerta")
                .setMessage("Tem certeza que deseja excluir o item "+anotacao.getDescricao()+"?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        listAnotacao.remove(anotacao);
                        preferences.salvaAnotacoes(listAnotacao);
                        adapter.notifyDataSetChanged();

                    }

                })
                .setNegativeButton("Não", null)
                .show();

    }
}
