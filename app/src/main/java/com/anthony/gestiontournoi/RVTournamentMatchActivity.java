package com.anthony.gestiontournoi;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.model.beans.MatchBean;

import java.util.ArrayList;

public class RVTournamentMatchActivity extends AppCompatActivity {

    private RecyclerView rv_tournament_match;
    private RVTournamentMatchAdapter rvTournamentMatchAdapter;
    private ArrayList<MatchBean> matchBeanArrayList;

    private void findView() {
        rv_tournament_match = (RecyclerView) findViewById(R.id.rv_tournament_match);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament_match);
        findView();

        matchBeanArrayList = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            rvTournamentMatchAdapter = new RVTournamentMatchAdapter(matchBeanArrayList);
        }

        rv_tournament_match.setAdapter(rvTournamentMatchAdapter);

        rv_tournament_match.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament_match.setItemAnimator(new DefaultItemAnimator());
    }
}
