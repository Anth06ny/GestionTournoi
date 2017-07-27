package com.anthony.gestiontournoi.control.activities;

import android.os.Build;
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
        List<Long> matchsId = tournamentBean.getMatchsId();
        Log.w("TAG", matchsId.size() + " taille matchsId");

        for (int i = 0; i < matchsId.size(); i++) {

            MatchBean matchBean = WSUtilsMobile.getMatch(matchsId.get(i));
            matchBeanList.add(matchBean);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            rvTournamentMatchAdapter = new RVTournamentMatchAdapter(matchBeanList);
        }

        rv_tournament_match.setAdapter(rvTournamentMatchAdapter);

        rv_tournament_match.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament_match.setItemAnimator(new DefaultItemAnimator());
    }
}
