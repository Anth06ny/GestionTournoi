package com.anthony.gestiontournoi.control.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.view.adapter.RVTournamentMatchAdapter;

import java.util.List;

public class RVTournamentMatchActivity extends AppCompatActivity {

    private RecyclerView rv_tournament_match;
    private RVTournamentMatchAdapter rvTournamentMatchAdapter;
    private List<MatchBean> matchBeanList;
    private long tournament_id;

    private void findView() {
        rv_tournament_match = (RecyclerView) findViewById(R.id.rv_tournament_match);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament_match);
        findView();


        tournament_id = getIntent().getExtras().getLong("id");
        TournamentBean tournamentBean = WSUtilsMobile.getTournament(tournament_id);
        matchBeanList = tournamentBean.getMatchList();
        Log.w("TAG", matchBeanList.size() + " matchBeanList size");


        rvTournamentMatchAdapter = new RVTournamentMatchAdapter(matchBeanList);
        rv_tournament_match.setAdapter(rvTournamentMatchAdapter);

        rv_tournament_match.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament_match.setItemAnimator(new DefaultItemAnimator());
    }
}
