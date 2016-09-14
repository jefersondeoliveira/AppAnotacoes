package com.example.jeferson.anotacoes.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jeferson.anotacoes.R;

public class MainActivity3 extends AppCompatActivity {

    private EditText editBox;
    private Button insertButton;
    private ListView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        editBox = (EditText) findViewById(R.id.edit_box);
        insertButton = (Button) findViewById(R.id.insert_button);
        notesList = (ListView) findViewById(R.id.notes_list);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editBox.getText().toString();

                Log.i("Log de teste", texto);

            }
        });

    }

}
