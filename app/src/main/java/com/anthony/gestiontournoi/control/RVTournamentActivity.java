package com.anthony.gestiontournoi.control;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.view.RVTournamentAdapter;

import java.util.ArrayList;

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
        Intent intent = new Intent(this, AddTournamentActivity.class);
        startActivity(intent);
    }
}


