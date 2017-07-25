package com.anthony.gestiontournoi.view.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class RVTournamentTeamAdapter extends RecyclerView.Adapter<RVTournamentTeamAdapter.ViewHolder>{
    private List<TeamBean> teamBeanArrayList;
    private Context context;

    public RVTournamentTeamAdapter(List<TeamBean> teamBeanArrayList) {
        this.teamBeanArrayList = teamBeanArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameTeam, tvNameClub, tvNbWin, tvNbLoose, tvLinkTeam;
        private ImageButton imgFav;
        private ImageView imgLogoteam;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNameTeam = (TextView) itemView.findViewById(R.id.tvNameTeam);
            tvNameClub = (TextView) itemView.findViewById(R.id.tvNameClub);
            tvNbWin = (TextView) itemView.findViewById(R.id.tvNbWin);
            tvNbLoose = (TextView) itemView.findViewById(R.id.tvNbLoose);
            imgLogoteam = (ImageView) itemView.findViewById(R.id.imgLogoTeam);
            imgFav = (ImageButton) itemView.findViewById(R.id.imgFav);
        }
    }


    @Override
    public RVTournamentTeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tournament_team, parent, false);
        return new RVTournamentTeamAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTournamentTeamAdapter.ViewHolder holder, int position) {
        context = holder.imgLogoteam.getContext();

        TeamBean teamBean = teamBeanArrayList.get(position);

        holder.tvNameTeam.setText(teamBean.getName());
        if (teamBean.getClub() != null) {
            holder.tvNameClub.setText((CharSequence) teamBean.getClub());

        } else {
            holder.tvNameClub.setText("");
        }
        holder.tvNbWin.setText("0");
        holder.tvNbLoose.setText("0");

        if (!teamBean.getPicture().isEmpty()) {
            Glide.with(context).load(teamBean.getPicture()).into(holder.imgLogoteam);
        } else {
            holder.imgLogoteam.setImageResource(R.drawable.ic_menu_gallery);
        }
        Glide.with(context).load(R.drawable.ic_heart_outline_white_48dp).into(holder.imgFav);


    }

    @Override
    public int getItemCount() {
        return teamBeanArrayList.size();
    }
}
