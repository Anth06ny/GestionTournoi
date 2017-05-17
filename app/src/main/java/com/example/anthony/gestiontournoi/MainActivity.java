package com.example.anthony.gestiontournoi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import com.example.anthony.gestiontournoi.model.beans.ClubBean;

import studios.codelight.smartloginlibrary.SmartCustomLoginListener;
import studios.codelight.smartloginlibrary.SmartLoginBuilder;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.users.SmartFacebookUser;
import studios.codelight.smartloginlibrary.users.SmartGoogleUser;
import studios.codelight.smartloginlibrary.users.SmartUser;

// googleId : 113207748106039394539
//facebookId : 10210685228421137

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SmartCustomLoginListener, View.OnClickListener {

    private static final int GET_ACCOUNT_LOCATION_REQ_CODE = 1;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);

        ClubBean clubBean;








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }
        else if (id == R.id.nav_gallery) {

        }
        else if (id == R.id.nav_slideshow) {

        }
        else if (id == R.id.nav_manage) {

        }
        else if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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
            }
            catch (Exception e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }
        else if (resultCode == SmartLoginConfig.GOOGLE_LOGIN_REQUEST) {
            SmartGoogleUser user;
            try {
                Toast.makeText(this, "google login", Toast.LENGTH_SHORT).show();
                user = data.getParcelableExtra(SmartLoginConfig.USER);
                //use this user object as per your requirement
                Log.w("LOG_LOGIN", user.toString());
            }
            catch (Exception e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }
        else if (resultCode == SmartLoginConfig.CUSTOM_LOGIN_REQUEST) {
            Toast.makeText(this, "custom login", Toast.LENGTH_SHORT).show();
            SmartUser user = data.getParcelableExtra(SmartLoginConfig.USER);
            Log.w("LOG_LOGIN", user.toString());
            //use this user object as per your requirement
        }
        else if (resultCode == RESULT_CANCELED) {
            //Login Failed
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_ACCOUNT_LOCATION_REQ_CODE) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
                signIn(true);
            }
            else {
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
            }
            else {
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
}
