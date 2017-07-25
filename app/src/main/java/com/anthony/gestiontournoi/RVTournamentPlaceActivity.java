package com.anthony.gestiontournoi;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anthony.gestiontournoi.model.beans.PlaceBean;

import java.util.ArrayList;

public class RVTournamentPlaceActivity extends AppCompatActivity {

    private RecyclerView rv_tournament_place;
    private RVTournamentPlaceAdapter rvTournamentPlaceAdapter;
    private ArrayList<PlaceBean> placeBeanArrayList;

    private void findView() {
        rv_tournament_place = (RecyclerView) findViewById(R.id.rv_tournament_place);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtournament_place);
        findView();

        placeBeanArrayList = new ArrayList<>();
        //placeBeanArrayList = WSUtilsMobile.getAllPlace();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            rvTournamentPlaceAdapter = new RVTournamentPlaceAdapter(placeBeanArrayList);
        }

        rv_tournament_place.setAdapter(rvTournamentPlaceAdapter);

        rv_tournament_place.setLayoutManager(new LinearLayoutManager(this));
        rv_tournament_place.setItemAnimator(new DefaultItemAnimator());

    }
}
