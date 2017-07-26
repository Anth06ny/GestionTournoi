package com.anthony.gestiontournoi.control.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;

public class DetailTeamActivity extends AppCompatActivity {
    private long team_id;
    private ImageView imgLogoOneteam;
    private TextView tvTitleOneteam;
    private ImageView imgLogoOneclub;
    private TextView tvTitleOneclub;
    private LinearLayout linearTel;
    private ImageView imgTel;
    private TextView tvTelHint;
    private TextView tvTel;
    private ImageView imgEditTel;
    private LinearLayout linearMail;
    private ImageView imgMail;
    private TextView tvMailHint;
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
        linearTel = (LinearLayout) findViewById(R.id.linear_tel);
        imgTel = (ImageView) findViewById(R.id.img_tel);
        tvTelHint = (TextView) findViewById(R.id.tv_tel_hint);
        tvTel = (TextView) findViewById(R.id.tv_tel);
        imgEditTel = (ImageView) findViewById(R.id.img_edit_tel);
        linearMail = (LinearLayout) findViewById(R.id.linear_mail);
        imgMail = (ImageView) findViewById(R.id.img_mail);
        tvMailHint = (TextView) findViewById(R.id.tv_mail_hint);
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
    }
}
