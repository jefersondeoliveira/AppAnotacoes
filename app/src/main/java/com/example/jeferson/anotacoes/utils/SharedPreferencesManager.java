package com.example.jeferson.anotacoes.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.jeferson.anotacoes.data.Anotacao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeferson on 27/05/2015.
 */
public class SharedPreferencesManager {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor prefsEditor;
    private static SharedPreferencesManager instance = null;

    private SharedPreferencesManager(Activity activity){
        mPrefs = activity.getPreferences(activity.MODE_PRIVATE);
        prefsEditor = mPrefs.edit();
    }

    public static SharedPreferencesManager getInstance(Activity activity){
        if(instance == null){
            instance = new SharedPreferencesManager(activity);
        }
        return instance;
    }

    public void salvaAnotacoes(List<Anotacao> anotacoes){
        Gson gson = new Gson();
        String json = gson.toJson(anotacoes);
        prefsEditor.putString("anotacoes", json);
        prefsEditor.commit();
    }

    public List<Anotacao> getAnotacoes(){
        Gson gson = new Gson();
        String json = mPrefs.getString("anotacoes", "[]");
        List<Anotacao> anotacoes = new ArrayList<>(Arrays.asList(gson.fromJson(json, Anotacao[].class)));
        return anotacoes;
    }

}
