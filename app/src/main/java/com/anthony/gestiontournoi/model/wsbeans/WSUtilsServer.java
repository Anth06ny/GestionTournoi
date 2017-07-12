package com.anthony.gestiontournoi.model.wsbeans;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.OkHttpUtils;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentContactBean;
import com.anthony.gestiontournoi.model.resultBean.ResultTournament;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas Th on 05/07/2017.
 */

public class WSUtilsServer {
    private static final Gson GSON = new Gson();
    private static final String URL = "http://localhost:8000/";
    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";



    public static void updateBeanTournament(long timestamp, ArrayList listId) throws Exception {
        // LISTE DES ID DES TOURNAMENT SUR LA BD MOBILE
        String listId_json = GSON.toJson(listId);

        String json = OkHttpUtils.sendPostOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT + timestamp, listId_json);

        ResultTournament resultTournament = GSON.fromJson(json, ResultTournament.class);

        // METHODE DELETE_TOURNAMENT

        // ON RECUPERE LA LISTE DE TOURNAMENT
        List<TournamentBean> listTournament = resultTournament.getTournaments();
        for (int i = 0; i < listTournament.size(); i++){
            
            // ON RECUPERE LA LISTE D'ID
            List<Long> contactId = listTournament.get(i).getContact();
            for (int j = 0; j < contactId.size(); i++){

                // ON CREE L'ASSOCIATION TOURNAMENT_CONTACT_BEAN
                TournamentContactBean tournamentContactBean = new TournamentContactBean();
                tournamentContactBean.setContactId(contactId.get(j));
                tournamentContactBean.setTournamentId(listTournament.get(i).getId());

                // PERSITER LE TOURNAMENT_CONTACT_BEAN
                MyApplication.getDaoSession().getTournamentContactBeanDao().insert(tournamentContactBean);
            }

            // ON PERSISTE LE TOURNAMENT_BEAN
            MyApplication.getDaoSession().getTournamentBeanDao().insert(listTournament.get(i));
        }
    }
}
