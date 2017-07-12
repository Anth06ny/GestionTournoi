package com.anthony.gestiontournoi.model.wsbeans;

import com.anthony.gestiontournoi.model.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 05/07/2017.
 */

public class WSUtilsServer {
    private static final Gson GSON = new Gson();
    private static final String URL = "http://localhost:8000/";
    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";



    public static void updateBeanTournament(long timestamp, ArrayList listId) throws Exception {
        String listId_json = GSON.toJson(listId);
        String json = OkHttpUtils.sendPostOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT, listId_json);
        
    }
}
