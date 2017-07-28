package com.anthony.gestiontournoi.model;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsServer;

import java.util.ArrayList;



public class UpdateBeanAT extends AsyncTask {
    private BeanType beanType;
    private long timestamp;

    public UpdateBeanAT(BeanType beanType, long timestamp) {
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
            case CLUB:
                Log.w("tag", "AT club start");
                try {
                    WSUtilsServer.updateBeanClub(timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case PLACE:
                Log.w("tag", "AT place start");
                try {
                    WSUtilsServer.updateBeanPlace(timestamp);
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
                MyApplication.getBus().post(new Pair<>(tournamentBeanArrayList, BeanType.TOURNAMENT));
                break;
            case TEAM:
                ArrayList<TeamBean> teamBeanArrayList = WSUtilsMobile.getAllTeam();
                Log.w("tag", "Size Teams BDD Mobile : " + teamBeanArrayList.size());
                MyApplication.getBus().post(new Pair<>(teamBeanArrayList, BeanType.TEAM));
                break;
            case MATCHS:
                ArrayList<MatchBean> matchBeanArrayList = WSUtilsMobile.getAllMatch();
                Log.w("tag", "Size Matchs BDD Mobile : " + matchBeanArrayList.size());
                MyApplication.getBus().post(new Pair<>(matchBeanArrayList, BeanType.MATCHS));
                break;
            case CLUB:
                ArrayList<ClubBean> clubBeanArrayList = WSUtilsMobile.getAllClub();
                Log.w("tag", "Size Club BDD Mobile : " + clubBeanArrayList.size());
                MyApplication.getBus().post(new Pair<>(clubBeanArrayList, BeanType.CLUB));
                break;
            case PLACE:
                ArrayList<PlaceBean> placeBeanArrayList = WSUtilsMobile.getAllPlace();
                Log.w("tag", "Size Place BDD Mobile : " + placeBeanArrayList.size());
                MyApplication.getBus().post(new Pair<>(placeBeanArrayList, BeanType.PLACE));
                break;
        }

    }
}
