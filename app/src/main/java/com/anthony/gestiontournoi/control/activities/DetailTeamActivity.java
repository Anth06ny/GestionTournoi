package com.anthony.gestiontournoi.control.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.bumptech.glide.Glide;

public class DetailTeamActivity extends AppCompatActivity {
    private long team_id;
    private ImageView imgLogoOneteam;
    private TextView tvTitleOneteam;
    private ImageView imgLogoOneclub;
    private TextView tvTitleOneclub;
    private ImageView imgTel;
    private TextView tvTel;
    private ImageView imgEditTel;
    private ImageView imgMail;
    private TextView tvMail;
    private ImageView imgEditMail;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-07-26 12:24:35 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        imgLogoOneteam = (ImageView) findViewById(R.id.img_logo_oneteam);
        tvTitleOneteam = (TextView) findViewById(R.id.tv_title_oneteam);
        imgLogoOneclub = (ImageView) findViewById(R.id.img_logo_oneclub);
        tvTitleOneclub = (TextView) findViewById(R.id.tv_title_oneclub);
        imgTel = (ImageView) findViewById(R.id.img_tel);
        tvTel = (TextView) findViewById(R.id.tv_tel);
        imgEditTel = (ImageView) findViewById(R.id.img_edit_tel);
        imgMail = (ImageView) findViewById(R.id.img_mail);
        tvMail = (TextView) findViewById(R.id.tv_mail);
        imgEditMail = (ImageView) findViewById(R.id.img_edit_mail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        findViews();

        team_id = getIntent().getExtras().getLong("id");
        TeamBean teamBean = WSUtilsMobile.getTeam(team_id);

        tvTitleOneteam.setText(teamBean.getName());

        if (teamBean.getPicture() != null) {
            Glide.with(this).load(teamBean.getPicture()).into(imgLogoOneteam);
        } else {
            Glide.with(this).load(R.drawable.ic_menu_gallery).into(imgLogoOneteam);
        }


        long contact_id = teamBean.getContactId();
/*
        ContactBean contactBean = WSUtilsMobile.getContact(contact_id);
        if (contactBean.getPhoneNumber() != null) {
            tvTel.setText(contactBean.getPhoneNumber());
        } else {
            tvTel.setText("Pas de numéro associé");
        }
        if (contactBean.getEmail() != null) {
            tvMail.setText(contactBean.getEmail());
        } else {
            tvMail.setText("Pas d'email associé");
        }
*/

        long club_id = teamBean.getClubId();
/*
        ClubBean clubBean = WSUtilsMobile.getClub(club_id);
        tvTitleOneclub.setText(clubBean.getName());
        if(clubBean.getPicture() != null){
            Glide.with(this).load(clubBean.getPicture()).into(imgLogoOneclub);
        } else {
            Glide.with(this).load(R.drawable.ic_menu_gallery).into(imgLogoOneclub);
        }
*/
    }
}
