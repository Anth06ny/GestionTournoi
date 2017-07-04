package com.anthony.gestiontournoi.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.view.RVTournamentAdapter;

import java.util.ArrayList;

public class RVTournamentActivity extends AppCompatActivity {
    private RecyclerView rv_tournament;
    private ArrayList<TournamentBean> tournamentBeanArrayList;
    private RVTournamentAdapter rvTournamentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament);

        tournamentBeanArrayList = new ArrayList<>();
        rvTournamentAdapter = new RVTournamentAdapter(tournamentBeanArrayList);

        rv_tournament = (RecyclerView) findViewById(R.id.rv_tournament);

        rv_tournament.setAdapter(rvTournamentAdapter);

        rv_tournament.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament.setItemAnimator(new DefaultItemAnimator());

    }
}
