package com.anthony.gestiontournoi.control;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.view.RVTournamentAdapter;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class RVTournamentActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv_tournament;
    private Button btn_add;
    private AlertDialog.Builder builder;
    private ArrayList<TournamentBean> tournamentBeanArrayList;
    private RVTournamentAdapter rvTournamentAdapter;


    private void findView() {
        rv_tournament = (RecyclerView) findViewById(R.id.rv_tournament);
        btn_add = (Button) findViewById(R.id.btn_add);

        btn_add.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament);
        findView();

        tournamentBeanArrayList = WSUtilsMobile.getAllTournament();
        rvTournamentAdapter = new RVTournamentAdapter(tournamentBeanArrayList);

        rv_tournament.setAdapter(rvTournamentAdapter);

        rv_tournament.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament.setItemAnimator(new DefaultItemAnimator());


    }


    @Override
    public void onClick(View v) {
        LayoutInflater layoutInflater = this.getLayoutInflater();
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter un tournoi").setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setView(layoutInflater.inflate(R.layout.alert_add_tournament, null));
        RadioGroup rg_club = (RadioGroup) findViewById(R.id.rg_club);
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText("Club 1");
        radioButton.setId(1);
        RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
        rg_club.addView(radioButton, params);
        builder.show();
    }




}


