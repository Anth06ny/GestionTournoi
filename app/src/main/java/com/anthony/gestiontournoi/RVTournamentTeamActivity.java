package com.anthony.gestiontournoi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;

import java.util.List;

public class RVTournamentTeamActivity extends AppCompatActivity {
    private RecyclerView rv_tournament_team;
    private RVTournamentTeamAdapter rvTournamentTeamAdapter;
    private List<TeamBean> teamBeanArrayList;

    private void findView() {
        rv_tournament_team = (RecyclerView) findViewById(R.id.rv_tournament_team);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament_team);
        findView();

        // On récupère l'id du tournoi
        Intent intent = getIntent();
        long tournament_id = intent.getLongExtra("id", 0);

        // On récupère le tournoi en question
        TournamentBean tournament = null;
        // On récupère les teams du tournoi
        teamBeanArrayList = tournament.getTeamList();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            rvTournamentTeamAdapter = new RVTournamentTeamAdapter(teamBeanArrayList);
        }

        rv_tournament_team.setAdapter(rvTournamentTeamAdapter);

        rv_tournament_team.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament_team.setItemAnimator(new DefaultItemAnimator());


    }
}
