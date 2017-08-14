package com.anthony.gestiontournoi.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.ContactBean;

import java.util.List;

/**
 * Created by Malorie on 14/08/2017.
 */

public class RVTournamentContactAdapter extends RecyclerView.Adapter<RVTournamentContactAdapter.ViewHolder> {
    private List<ContactBean> contactBeanArrayList;

    public RVTournamentContactAdapter(List<ContactBean> contactBeanArrayList) {
        this.contactBeanArrayList = contactBeanArrayList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_tel_hint;
        private TextView tv_tel;
        private TextView tv_mail_hint;
        private TextView tv_mail;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_tel_hint = (TextView) itemView.findViewById(R.id.tv_tel_hint);
            tv_tel = (TextView) itemView.findViewById(R.id.tv_tel);
            tv_mail_hint = (TextView) itemView.findViewById(R.id.tv_mail_hint);
            tv_mail = (TextView) itemView.findViewById(R.id.tv_mail);

        }
    }

    @Override
    public RVTournamentContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contacts, parent, false);
        return new RVTournamentContactAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTournamentContactAdapter.ViewHolder holder, int position) {
        ContactBean contactBean = contactBeanArrayList.get(position);
        holder.tv_tel_hint.setText(contactBean.getFirstName() + " " + contactBean.getLastName());
        holder.tv_mail_hint.setText(contactBean.getFirstName() + " " + contactBean.getLastName());
        holder.tv_tel.setText(contactBean.getPhoneNumber());
        holder.tv_mail.setText(contactBean.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactBeanArrayList.size();
    }

}
