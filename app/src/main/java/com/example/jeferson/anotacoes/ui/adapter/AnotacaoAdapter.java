package com.example.jeferson.anotacoes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jeferson.anotacoes.R;
import com.example.jeferson.anotacoes.data.Anotacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jeferson on 14/09/16.
 */
public class AnotacaoAdapter extends ArrayAdapter<Anotacao> {

    private Context context;
    private List<Anotacao> anotacaoList;

    public AnotacaoAdapter(Context context,  List<Anotacao> anotacaoList) {
        super(context, 0, anotacaoList);
        this.anotacaoList = anotacaoList;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Anotacao item = anotacaoList.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item, null);

        TextView txtDesc = (TextView) view.findViewById(R.id.descricao);
        txtDesc.setText(item.getDescricao());

        TextView txtDate = (TextView) view.findViewById(R.id.data);
        txtDate.setText(getDataFromModel(item.getData()));

        return view;
    }

    public String getDataFromModel(Date date){

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dataTexto = df.format(date);

        return dataTexto;
    }

}
