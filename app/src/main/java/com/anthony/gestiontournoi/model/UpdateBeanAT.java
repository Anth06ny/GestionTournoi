package com.anthony.gestiontournoi.model;

import android.os.AsyncTask;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class UpdateBeanAT extends AsyncTask {
    private BeanType beanType;

    public UpdateBeanAT(BeanType beanType) {
        this.beanType = beanType;
    }


    @Override
    protected Object doInBackground(Object[] params) {
        switch (beanType){
            case TOURNAMENT:
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
    }
}
