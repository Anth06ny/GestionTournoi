package com.anthony.gestiontournoi.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.bumptech.glide.Glide;

import java.util.List;


public class RVTournamentMatchAdapter extends RecyclerView.Adapter<RVTournamentMatchAdapter.ViewHolder> {
    private List<MatchBean> matchBeanList;
    private Context context;

    public RVTournamentMatchAdapter(List<MatchBean> matchBeanList) {
        Log.w("TAGONCREATE", matchBeanList.size() + "matchBeanList Adapter");
        this.matchBeanList = matchBeanList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvScoreTeam1, tvScoreTeam2, tvNameTeam1, tvNameTeam2, tvTable, tvTime, tvField, tvStatus;
        private ImageView imgLogoTeam1, imgLogoTeam2;
        private ImageButton imgField;

        public ViewHolder(View itemView) {
            super(itemView);
            tvScoreTeam1 = (TextView) itemView.findViewById(R.id.tvScoreTeamOne);
            tvScoreTeam2 = (TextView) itemView.findViewById(R.id.tvScoreTeamTwo);
            tvNameTeam1 = (TextView) itemView.findViewById(R.id.tvNameTeam1);
            tvNameTeam2 = (TextView) itemView.findViewById(R.id.tvNameTeam2);
            tvTable = (TextView) itemView.findViewById(R.id.tvTable);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvField = (TextView) itemView.findViewById(R.id.tvField);
            imgLogoTeam1 = (ImageView) itemView.findViewById(R.id.imgLogoTeam1);
            imgLogoTeam2 = (ImageView) itemView.findViewById(R.id.imgLogoTeam2);
            imgField = (ImageButton) itemView.findViewById(R.id.imgField);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
        }
    }

    @Override
    public RVTournamentMatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tournament_match, parent, false);
        return new RVTournamentMatchAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTournamentMatchAdapter.ViewHolder holder, int position) {
        context = holder.imgField.getContext();


        final MatchBean matchBean = matchBeanList.get(position);
        if (matchBean.getTeam1() != null || matchBean.getTeam2() != null) {

            holder.tvNameTeam1.setText(matchBean.getTeam1().getName());
            holder.tvNameTeam2.setText(matchBean.getTeam2().getName());
            holder.tvScoreTeam1.setText("" + matchBean.getScoreTeam1());
            holder.tvScoreTeam2.setText("" + matchBean.getScoreTeam2());


            holder.tvTable.setText(matchBean.getTeamTable().getName());
            holder.tvTime.setText("");
            holder.tvField.setText(matchBean.getTournament().getFieldType());
            holder.tvStatus.setText(matchBean.getState());


            if (!matchBean.getTeam1().getPicture().isEmpty()) {
                Glide.with(context).load(matchBean.getTeam1().getPicture()).into(holder.imgLogoTeam1);
            } else {
                holder.imgLogoTeam1.setImageResource(R.drawable.ic_menu_gallery);
            }
            if (!matchBean.getTeam2().getPicture().isEmpty()) {
                Glide.with(context).load(matchBean.getTeam2().getPicture()).into(holder.imgLogoTeam2);
            } else {
                holder.imgLogoTeam2.setImageResource(R.drawable.ic_menu_gallery);
            }
        }

        Glide.with(context).load(R.drawable.ic_place_black_48dp).into(holder.imgField);


    }

    @Override
    public int getItemCount() {
        return matchBeanList.size();
    }
}
