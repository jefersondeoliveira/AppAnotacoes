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
import java.util.Date;
import java.util.List;

/**
 * Created by jeferson on 14/09/16.
 */
public class AnotacaoAdapterOld extends ArrayAdapter<Anotacao> {

    private Context context;
    private List<Anotacao> anotacaoList;

    public AnotacaoAdapterOld(Context context, List<Anotacao> anotacaoList) {
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

        return view;
    }

}
