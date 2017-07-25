package com.anthony.gestiontournoi.control.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.view.adapter.RVTeamAdapter;

import java.util.ArrayList;

public class RVTeamActivity extends AppCompatActivity {
    private RecyclerView rv_team;
    private ArrayList<TeamBean> teamBeanArrayList;
    private RVTeamAdapter rvTeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvteam);

        teamBeanArrayList = new ArrayList<>();
        rvTeamAdapter = new RVTeamAdapter(teamBeanArrayList);

        rv_team = (RecyclerView) findViewById(R.id.rv_team);

        rv_team.setAdapter(rvTeamAdapter);

        rv_team.setLayoutManager(new LinearLayoutManager(this));
        rv_team.setItemAnimator(new DefaultItemAnimator());
    }
}
