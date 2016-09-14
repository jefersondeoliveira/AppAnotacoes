package com.example.jeferson.anotacoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private EditText editBox;
    private Button insertButton;
    private ListView notesList;

    private List<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        editBox = (EditText) findViewById(R.id.edit_box);
        insertButton = (Button) findViewById(R.id.insert_button);
        notesList = (ListView) findViewById(R.id.notes_list);

        values = new ArrayList<>();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editBox.getText().toString();

                values.add(texto);

                Log.i("Log de teste", values.size()+"");

            }
        });

    }

}
