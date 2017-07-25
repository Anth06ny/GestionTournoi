package com.anthony.gestiontournoi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthony.gestiontournoi.model.beans.PlaceBean;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 25/07/2017.
 */

public class RVTournamentPlaceAdapter extends RecyclerView.Adapter<RVTournamentPlaceAdapter.ViewHolder>{
    private ArrayList<PlaceBean> placeBeanArrayList;

    public RVTournamentPlaceAdapter(ArrayList<PlaceBean> placeBeanArrayList) {
        this.placeBeanArrayList = placeBeanArrayList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvAdress, tvCity;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAdress = (TextView) itemView.findViewById(R.id.tvAdress);
            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
        }
    }

    @Override
    public RVTournamentPlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tournament_place, parent, false);
        return new RVTournamentPlaceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTournamentPlaceAdapter.ViewHolder holder, int position) {
        PlaceBean placeBean = placeBeanArrayList.get(position);
        holder.tvName.setText(placeBean.getName());
        holder.tvAdress.setText(placeBean.getAddress());
        holder.tvCity.setText("Ville?");
    }

    @Override
    public int getItemCount() {
        return placeBeanArrayList.size();
    }
}
