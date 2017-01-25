package com.example.anthony.gestiontournoi.exercice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.example.anthony.gestiontournoi.control.MyApplication;
import com.example.anthony.gestiontournoi.model.beans.TournamentBean;
import com.example.anthony.gestiontournoi.model.beans.TournamentBeanDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityUtils {

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static boolean isConnected(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info != null && info.isConnected());
    }

    public static String sendGetOkHttpRequest(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.code() != HttpURLConnection.HTTP_OK) {
            throw new Exception("Reponse du serveur incorrect : " + response.code());
        } else {
          return response.body().string();
        }
    }

    public static class LoadAt extends AsyncTask<Void, Void, String> {

        private String url;

        public LoadAt(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                return ConnectivityUtils.sendGetOkHttpRequest(url);
            }
            catch (Exception e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.w("onPostExecute",s);
            Gson gson = new Gson();
            ArrayList<TournamentBean> tournaments
                    = gson.fromJson((s),new TypeToken<ArrayList<TournamentBean>>(){}.getType());
            Log.w("onPostExecute",tournaments.toString());
            insertTournaments(tournaments);
        }

    }

    public static void insertTournaments(ArrayList<TournamentBean> tournaments) {
        getTournamentDao().deleteAll();
        for (TournamentBean tournament : tournaments) {
            insertTournament(tournament);
        }
    }

    public static void insertTournament(TournamentBean tournament) {
        getTournamentDao().insert(tournament);
    }

    public static TournamentBeanDao getTournamentDao () {
        return MyApplication.getDaoSession().getTournamentBeanDao();
    }

}
