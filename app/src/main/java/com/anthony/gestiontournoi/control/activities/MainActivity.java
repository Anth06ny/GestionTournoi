package com.anthony.gestiontournoi.control.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.ServiceTournament;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TimestampBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.bumptech.glide.Glide;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import studios.codelight.smartloginlibrary.SmartCustomLoginListener;
import studios.codelight.smartloginlibrary.SmartLoginBuilder;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.users.SmartFacebookUser;
import studios.codelight.smartloginlibrary.users.SmartGoogleUser;
import studios.codelight.smartloginlibrary.users.SmartUser;

import static com.anthony.gestiontournoi.R.menu.main;

// googleId : 113207748106039394539
// facebookId : 10210685228421137
// malo : 192.168.60.137:8000

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SmartCustomLoginListener, View.OnClickListener {

    private static final int GET_ACCOUNT_LOCATION_REQ_CODE = 1;
    public static final Long ID_TIMESTAMP = 1L;
    private Button bt_login;
    //private static final String URL = "http://192.168.56.1:8000/"; // NICO
    private static final String URL = "http://192.168.60.137:8000/"; // MALO
    private static Bus bus;
    private int sizeTournaments;
    private MenuItem tournamentItem;
    private ImageView image;

    private ArrayList<TournamentBean> tournamentBeanArrayList;
    private ArrayList<TeamBean> teamBeanArrayList;

    public static Bus getBus() {
        return bus;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////
        // INITIALISATION DU TIMESTAMP MOBILE
        //////////////////////////////////////
        if (MyApplication.getDaoSession().getTimestampBeanDao().load(ID_TIMESTAMP) == null) {
            Log.w("tag", "CREATE NEW TIMESTAMPBEAN");
            TimestampBean timestampBean = new TimestampBean();
            MyApplication.getDaoSession().getTimestampBeanDao().insert(timestampBean);
        }
        ///////////////////////////////////////

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // FIND VIEW
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        tournamentItem = navigationView.getMenu().findItem(R.id.tournaments);
        image = (ImageView) findViewById(R.id.iv);

        // PETIT CHAT
        Glide.with(this).load(URL + "chat.jpg").into(image);

        // INITIALISATION DU BUS
        bus = new Bus();

        // START SERVICE UPDATE_TOURNAMENT
        Intent intent = new Intent(this, ServiceTournament.class);
        intent.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_TOURNAMENT);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_profile) {
            // Handle the camera action
        } else if (id == R.id.follow_tournament) {

        } else if (id == R.id.follow_team) {

        } else if (id == R.id.tournaments) {
            Intent intent = new Intent(this, RVTournamentActivity.class);
            startActivity(intent);
        } else if (id == R.id.teams) {
            Intent intent = new Intent(this, DetailTournamentActivity.class);
            startActivity(intent);
        } else if (id == R.id.about_me) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Intent "data" contains the user object
        if (resultCode == SmartLoginConfig.FACEBOOK_LOGIN_REQUEST) {
            SmartFacebookUser user;
            try {
                Toast.makeText(this, "facebook login", Toast.LENGTH_SHORT).show();
                user = data.getParcelableExtra(SmartLoginConfig.USER);
                //use this user object as per your requirement
                Log.w("LOG_LOGIN", user.toString());
            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        } else if (resultCode == SmartLoginConfig.GOOGLE_LOGIN_REQUEST) {
            SmartGoogleUser user;
            try {
                Toast.makeText(this, "google login", Toast.LENGTH_SHORT).show();
                user = data.getParcelableExtra(SmartLoginConfig.USER);
                //use this user object as per your requirement
                Log.w("LOG_LOGIN", user.toString());
            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        } else if (resultCode == SmartLoginConfig.CUSTOM_LOGIN_REQUEST) {
            Toast.makeText(this, "custom login", Toast.LENGTH_SHORT).show();
            SmartUser user = data.getParcelableExtra(SmartLoginConfig.USER);
            Log.w("LOG_LOGIN", user.toString());
            //use this user object as per your requirement
        } else if (resultCode == RESULT_CANCELED) {
            //Login Failed
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        String toto = "toto";


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_ACCOUNT_LOCATION_REQ_CODE) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
                signIn(true);
            } else {
                signIn(false);
            }
        }
    }

    /* ---------------------------------
    //    CallBack SmartLogin
    // -------------------------------- */
    @Override
    public boolean customSignin(SmartUser smartUser) {
        Toast.makeText(this, "customSignin", Toast.LENGTH_SHORT).show();
        Log.w("LOG_LOGIN", smartUser.toString());
        return false;
    }

    @Override
    public boolean customSignup(SmartUser smartUser) {
        Toast.makeText(this, "customSignup", Toast.LENGTH_SHORT).show();
        Log.w("LOG_LOGIN", smartUser.toString());
        return false;
    }

    @Override
    public boolean customUserSignout(SmartUser smartUser) {
        Toast.makeText(this, "customUserSignout", Toast.LENGTH_SHORT).show();
        Log.w("LOG_LOGIN", smartUser.toString());
        return false;
    }

    /* ---------------------------------
    // Gestion clic
    // -------------------------------- */
    public void onClick(View view) {

        if (R.id.bt_login == view.getId()) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
                signIn(true);
            } else {
                Toast.makeText(this, R.string.permission_get_account_message, Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, GET_ACCOUNT_LOCATION_REQ_CODE);
            }
        }
    }

    /* ---------------------------------
    // Private
    // -------------------------------- */
    private void signIn(boolean withGoogle) {
        SmartLoginBuilder loginBuilder = new SmartLoginBuilder();

        Intent intent = loginBuilder.with(this)
                .setAppLogo(R.mipmap.ic_launcher)
                .isCustomLoginEnabled(true).setSmartCustomLoginHelper(this)
                .isFacebookLoginEnabled(true).withFacebookAppId(getString(R.string.facebook_app_id))
                .isGoogleLoginEnabled(withGoogle)
                .build();
        startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);
    }

    //---------------------------
    //     SUBSCRIBE
    //---------------------------
    @Subscribe
    public void refreshNbTournamentMenu(ArrayList<TournamentBean> tournamentBeanArrayList) {
        this.tournamentBeanArrayList = tournamentBeanArrayList;
        sizeTournaments = tournamentBeanArrayList.size();

        Toast.makeText(this, "" + sizeTournaments, Toast.LENGTH_SHORT).show();
        if (tournamentItem != null) {
            tournamentItem.setTitle("Tournament : " + sizeTournaments);
        }
    }

    @Subscribe
    public void refreshNbTeamMenu(ArrayList<TeamBean> teamBeanArrayList) {
        this.teamBeanArrayList = teamBeanArrayList;
        sizeTournaments = tournamentBeanArrayList.size();

        Toast.makeText(this, "" + sizeTournaments, Toast.LENGTH_SHORT).show();
        if (tournamentItem != null) {
            tournamentItem.setTitle("Tournament : " + sizeTournaments);
        }
    }
}