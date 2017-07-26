package com.anthony.gestiontournoi.control.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.view.adapter.RVTeamAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class RVTeamActivity extends AppCompatActivity {
    private RecyclerView rv_team;
    private ArrayList<TeamBean> teamBeanArrayList;
    private RVTeamAdapter rvTeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvteam);

        teamBeanArrayList = WSUtilsMobile.getAllTeam();
        rvTeamAdapter = new RVTeamAdapter(teamBeanArrayList);

        rv_team = (RecyclerView) findViewById(R.id.rv_team);

        rv_team.setAdapter(rvTeamAdapter);

        rv_team.setLayoutManager(new LinearLayoutManager(this));
        rv_team.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyApplication.getBus().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getBus().unregister(this);
    }

    @Subscribe
    public void refreshRecyclerView(ArrayList<TeamBean> teamBeanArrayList){
        this.teamBeanArrayList.clear();
        this.teamBeanArrayList.addAll(teamBeanArrayList);
        rvTeamAdapter.notifyDataSetChanged();
    }
}
