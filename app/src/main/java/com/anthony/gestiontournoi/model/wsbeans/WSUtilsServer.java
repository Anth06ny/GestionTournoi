package com.anthony.gestiontournoi.model.wsbeans;

import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.OkHttpUtils;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 05/07/2017.
 */

public class WSUtilsServer {
    private static final Gson GSON = new Gson();
    private static final String URL = "http://192.168.56.1:8000/";
    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";


    public static void updateBeanTournament(long timestamp) throws Exception {
//        // LISTE DES ID DES TOURNAMENT SUR LA BD MOBILE
//        List<TournamentBean> listTournamentBean = MyApplication.getDaoSession().getTournamentBeanDao().loadAll();
//        ArrayList<Long> listId = new ArrayList<>();
//        for (int k = 0; k < listTournamentBean.size(); k++){
//            listId.add(listTournamentBean.get(k).getId());
//        }
//        String listId_json = GSON.toJson(listId);
//
        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT + timestamp);
        Log.w("tag", "" + json);

        ArrayList<TournamentBean> listTournaments = GSON.fromJson(json, new TypeToken<ArrayList<TournamentBean>>(){}.getType());

        for (int i = 0; i < listTournaments.size(); i++) {
            TournamentBean tournamentBean = listTournaments.get(i);
            if (tournamentBean.isDelete()){
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getTournamentBeanDao().delete(tournamentBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getTournamentBeanDao().load(tournamentBean.getId()) == null){
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getTournamentBeanDao().insert(tournamentBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getTournamentBeanDao().update(tournamentBean);
                }
            }
        }

//        // METHODE DELETE_TOURNAMENT
//
//        // ON RECUPERE LA LISTE DE TOURNAMENT
//        List<TournamentBean> listTournament = resultTournament.getTournaments();
//        for (int i = 0; i < listTournament.size(); i++) {
//
//            // ON RECUPERE LA LISTE D'ID
//            List<Long> contactId = (List<Long>) listTournament.get(i).getContact();
//            for (int j = 0; j < contactId.size(); i++) {
//
//                // ON CREE L'ASSOCIATION TOURNAMENT_CONTACT_BEAN
//                TournamentContactBean tournamentContactBean = new TournamentContactBean();
//                tournamentContactBean.setContactId(contactId.get(j));
//                tournamentContactBean.setTournamentId(listTournament.get(i).getId());
//
//                // PERSITER LE TOURNAMENT_CONTACT_BEAN
//                MyApplication.getDaoSession().getTournamentContactBeanDao().insert(tournamentContactBean);
//            }
//
//            // ON PERSISTE LE TOURNAMENT_BEAN
//            MyApplication.getDaoSession().getTournamentBeanDao().insert(listTournament.get(i));
//        }
    }
}
