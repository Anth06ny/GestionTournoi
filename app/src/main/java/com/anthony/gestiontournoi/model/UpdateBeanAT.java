package com.anthony.gestiontournoi.model;

import android.os.AsyncTask;
import android.util.Log;

import com.anthony.gestiontournoi.MainActivity;
import com.anthony.gestiontournoi.UpdateTournamentInterface;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsServer;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class UpdateBeanAT extends AsyncTask {
    private BeanType beanType;
    private long timestamp;
    private UpdateTournamentInterface updateTournamentInterface;
    ;

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
                break;
            case MATCHS:
                break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        ArrayList<TournamentBean> tournamentBeanArrayList = WSUtilsMobile.getAllTournament();
        Log.w("tag", "Size Touanments BDD Mobile : " + tournamentBeanArrayList.size());
        MainActivity.getBus().post(tournamentBeanArrayList);
    }
}
