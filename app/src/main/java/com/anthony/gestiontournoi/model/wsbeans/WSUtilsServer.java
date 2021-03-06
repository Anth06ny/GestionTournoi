package com.anthony.gestiontournoi.model.wsbeans;

import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.OkHttpUtils;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class WSUtilsServer {
    private static final Gson GSON = new Gson();
    private static final String URL = "http://192.168.56.1:8000/"; // NICO
//    private static final String URL = "http://192.168.60.137:8000/"; // MALO
    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";
    private static final String URL_UPDATE_BEAN_MATCHS = URL + "updateBeanMatchs/";
    private static final String URL_UPDATE_BEAN_TEAM = URL + "updateBeanTeam/";
    private static final String URL_UPDATE_BEAN_CLUB = URL + "updateBeanClub/";


    public static void updateBeanTournament(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT + timestamp);
        Log.w("tag", "" + json);

        ArrayList<TournamentBean> listTournaments = GSON.fromJson(json, new TypeToken<ArrayList<TournamentBean>>() {
        }.getType());
        Log.w("tag", "" + listTournaments.size());

        for (int i = 0; i < listTournaments.size(); i++) {
            TournamentBean tournamentBean = listTournaments.get(i);
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
    }

    public static void updateBeanMatchs(long timestamp) throws Exception {

            String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_MATCHS + timestamp);
        Log.w("tag", "" + json);

        ArrayList<MatchBean> listMatchs = GSON.fromJson(json, new TypeToken<ArrayList<MatchBean>>() {
        }.getType());
        Log.w("tag", "" + listMatchs.size());

        for (int i = 0; i < listMatchs.size(); i++) {
            MatchBean matchBean = listMatchs.get(i);
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
    }

    public static void updateBeanTeam(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TEAM + timestamp);
        Log.w("tag", "" + json);

        ArrayList<TeamBean> listTeam = GSON.fromJson(json, new TypeToken<ArrayList<TeamBean>>() {
        }.getType());
        Log.w("tag", "" + listTeam.size());

        for (int i = 0; i < listTeam.size(); i++) {
            TeamBean teamBean = listTeam.get(i);
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
    }

    public static void updateBeanClub(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_CLUB + timestamp);
        Log.w("tag", "" + json);

        ArrayList<ClubBean> listClub = GSON.fromJson(json, new TypeToken<ArrayList<TeamBean>>() {
        }.getType());
        Log.w("tag", "" + listClub.size());

        for (int i = 0; i < listClub.size(); i++) {
            ClubBean clubBean = listClub.get(i);
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
    }


}
