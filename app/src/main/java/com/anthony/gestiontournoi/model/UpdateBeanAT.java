package com.anthony.gestiontournoi.model;

import android.os.AsyncTask;
import android.util.Log;

import com.anthony.gestiontournoi.control.activities.MainActivity;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsServer;

import java.util.ArrayList;



public class UpdateBeanAT extends AsyncTask {
    private BeanType beanType;
    private long timestamp;

    public UpdateBeanAT(BeanType beanType, long timestamp) {
        Log.w("tag", "Create AT");
        this.beanType = beanType;
        this.timestamp = timestamp;
    }


    @Override
    protected Object doInBackground(Object[] params) {
        switch (beanType) {
            case TOURNAMENT:
                Log.w("tag", "AT tournament start");
                try {
                    WSUtilsServer.updateBeanTournament(timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case TEAM:
                Log.w("tag", "AT team start");
                try {
                    WSUtilsServer.updateBeanTeam(timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case MATCHS:
                Log.w("tag", "AT match start");
                try {
                    WSUtilsServer.updateBeanMatchs(timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        switch (beanType){
            case TOURNAMENT:
                ArrayList<TournamentBean> tournamentBeanArrayList = WSUtilsMobile.getAllTournament();
                Log.w("tag", "Size Tournaments BDD Mobile : " + tournamentBeanArrayList.size());
                MainActivity.getBus().post(tournamentBeanArrayList);
                break;
            case TEAM:
                ArrayList<TeamBean> teamBeanArrayList = WSUtilsMobile.getAllTeam();
                Log.w("tag", "Size Teams BDD Mobile : " + teamBeanArrayList.size());
                MainActivity.getBus().post(teamBeanArrayList);
                break;
            case MATCHS:
                ArrayList<MatchBean> matchBeanArrayList = WSUtilsMobile.getAllMatch();
                Log.w("tag", "Size Matchs BDD Mobile : " + matchBeanArrayList.size());
                MainActivity.getBus().post(matchBeanArrayList);
                break;
        }

    }
}
