package com.anthony.gestiontournoi.model.wsbeans;

import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.control.activities.MainActivity;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TimestampBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentPlaceBean;
import com.anthony.gestiontournoi.model.beans.TournamentTeamBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class WSUtilsServer {
    private static final Gson GSON = new Gson();

    //    private static final String URL = "http://192.168.1.14:8000/"; // NICO MAISON
//   private static final String URL = "http://192.168.42.31:8000/"; // NICO
    private static final String URL = "http://192.168.60.137:8000/"; // MALO

    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";
    private static final String URL_UPDATE_BEAN_MATCHS = URL + "updateBeanMatch/";
    private static final String URL_UPDATE_BEAN_TEAM = URL + "updateBeanTeam/";
    private static final String URL_UPDATE_BEAN_CLUB = URL + "updateBeanClub/";
    private static final String URL_UPDATE_BEAN_PLACE = URL + "updateBeanPlace/";


    public static void updateBeanTournament(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT + timestamp);
        Log.w("tag", "Json tournament : " + json);

        ArrayList<TournamentBean> listTournaments = GSON.fromJson(json, new TypeToken<ArrayList<TournamentBean>>() {
        }.getType());
        Log.w("tag", "" + listTournaments.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listTournaments.size(); i++) {
            TournamentBean tournamentBean = listTournaments.get(i);
            Log.w("tag", "ID : " + tournamentBean.getId() + " delete : " + tournamentBean.isDelete());

            List<Long> placesId = tournamentBean.getPlaceId();
            for (int j = 0; j < placesId.size(); j++) {
                Log.w("tag", "TournamentPlaceBean : " + j + "PlaceId : " + placesId.get(j));
                TournamentPlaceBean tournamentPlaceBean = new TournamentPlaceBean();
                tournamentPlaceBean.setTournamentId(tournamentBean.getId());
                tournamentPlaceBean.setPlaceId(placesId.get(j));
                MyApplication.getDaoSession().getTournamentPlaceBeanDao().insert(tournamentPlaceBean);
            }
            List<Long> teamId = tournamentBean.getTeamId();
            for (int k = 0; k < teamId.size(); k++) {
                Log.w("tag", "TournamentTeamBean : " + k + "TeamId : " + teamId.get(k));
                TournamentTeamBean tournamentTeamBean = new TournamentTeamBean();
                tournamentTeamBean.setTournamentId(tournamentBean.getId());
                tournamentTeamBean.setTeamId(placesId.get(k));
                MyApplication.getDaoSession().getTournamentTeamBeanDao().insert(tournamentTeamBean);
            }

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean tournament " + tournamentBean.getId() + " : " + tournamentBean.getTimeStamp());
            if (maxTimestamp < tournamentBean.getTimeStamp()) {
                maxTimestamp = tournamentBean.getTimeStamp();
            }

            if (tournamentBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getTournamentBeanDao().delete(tournamentBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getTournamentBeanDao().load(tournamentBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getTournamentBeanDao().insert(tournamentBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getTournamentBeanDao().update(tournamentBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listTournaments.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setTournamentTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }

    public static void updateBeanMatchs(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_MATCHS + timestamp);
        Log.w("tag", "Json matchs : " + json);


        ArrayList<MatchBean> listMatchs = GSON.fromJson(json, new TypeToken<ArrayList<MatchBean>>() {
        }.getType());
        Log.w("tag", "Matchs " + listMatchs.size());


        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;


        for (int i = 0; i < listMatchs.size(); i++) {
            MatchBean matchBean = listMatchs.get(i);
            Log.w("tag", "ID : " + matchBean.getId() + " delete : " + matchBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean match " + matchBean.getId() + " : " + matchBean.getTimeStamp());
            if (maxTimestamp < matchBean.getTimeStamp()) {
                maxTimestamp = matchBean.getTimeStamp();
            }

            if (matchBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getMatchBeanDao().delete(matchBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getMatchBeanDao().load(matchBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getMatchBeanDao().insert(matchBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getMatchBeanDao().update(matchBean);

                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE

        if (!listMatchs.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setMatchTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);

        }
    }

    public static void updateBeanTeam(long timestamp) throws Exception {
        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TEAM + timestamp);
        Log.w("tag", "Json team : " + json);

        ArrayList<TeamBean> listTeams = GSON.fromJson(json, new TypeToken<ArrayList<TeamBean>>() {
        }.getType());
        Log.w("tag", "listTeams size : " + listTeams.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listTeams.size(); i++) {
            TeamBean teamBean = listTeams.get(i);
            Log.w("tag", "ID team : " + teamBean.getId() + " delete : " + teamBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            if (maxTimestamp < teamBean.getTimeStamp()) {
                maxTimestamp = teamBean.getTimeStamp();
            }

            if (teamBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getTeamBeanDao().delete(teamBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getTeamBeanDao().load(teamBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getTeamBeanDao().insert(teamBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getTeamBeanDao().update(teamBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listTeams.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setTeamTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }

    public static void updateBeanClub(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_CLUB + timestamp);
        Log.w("tag", "Json clubs : " + json);

        ArrayList<ClubBean> listClubs = GSON.fromJson(json, new TypeToken<ArrayList<ClubBean>>() {
        }.getType());
        Log.w("tag", "Clubs " + listClubs.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listClubs.size(); i++) {
            ClubBean clubBean = listClubs.get(i);
            Log.w("tag", "ID : " + clubBean.getId() + " delete : " + clubBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean club " + clubBean.getId() + " : " + clubBean.getTimeStamp());
            if (maxTimestamp < clubBean.getTimeStamp()) {
                maxTimestamp = clubBean.getTimeStamp();
            }

            if (clubBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getClubBeanDao().delete(clubBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getClubBeanDao().load(clubBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getClubBeanDao().insert(clubBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getClubBeanDao().update(clubBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listClubs.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setClubTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }


    public static void updateBeanPlace(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_PLACE + timestamp);
        Log.w("tag", "Json place : " + json);

        ArrayList<PlaceBean> listPlaces = GSON.fromJson(json, new TypeToken<ArrayList<PlaceBean>>() {
        }.getType());
        Log.w("tag", "Places : " + listPlaces.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listPlaces.size(); i++) {
            PlaceBean placeBean = listPlaces.get(i);
            Log.w("tag", "ID : " + placeBean.getId() + " delete : " + placeBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean place " + placeBean.getId() + " : " + placeBean.getTimeStamp());
            if (maxTimestamp < placeBean.getTimeStamp()) {
                maxTimestamp = placeBean.getTimeStamp();
            }

            if (placeBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getPlaceBeanDao().delete(placeBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getPlaceBeanDao().load(placeBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getPlaceBeanDao().insert(placeBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getPlaceBeanDao().update(placeBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listPlaces.isEmpty()) {
            updateMobileTimeStamp(maxTimestamp);
        }
    }

    public static void updateMobileTimeStamp(long maxTimestamp) {
        TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
        timestampBean.setTournamentTimestamp(maxTimestamp);
        MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
    }


}
