package com.drmiaji.tajweed;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        createDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    protected void createDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(R.string.action_exit);
        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.create().show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.share:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareSub = getString(R.string.share_subject);
                String shareBody = getString(R.string.share_message);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using!"));
                break;
            case R.id.more_apps:
                Intent moreApp = new Intent(Intent.ACTION_VIEW);
                moreApp.setData(Uri.parse("https://play.google.com/store/search?q=drmiaji"));
                startActivity(moreApp);
                break;
            case R.id.action_content:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.action_about_us:
                startActivity(new Intent(this, About.class));
                break;
            default:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tauhid:
                Intent tauhid = new Intent(Intent.ACTION_VIEW);
                tauhid.setData(Uri.parse("http://www.drmiaji.com"));
                startActivity(tauhid);
                break;
            case R.id.boktiyar:
                Intent boktiyar = new Intent(Intent.ACTION_VIEW);
                boktiyar.setData(Uri.parse("https://www.youtube.com/user/boktiyer/videos"));
                startActivity(boktiyar);
                break;
            case R.id.arif:
                Intent arif = new Intent(Intent.ACTION_VIEW);
                arif.setData(Uri.parse("http://ahlesunnatbd.net"));
                startActivity(arif);
                break;
            case R.id.amarislam:
                Intent amarislam = new Intent(Intent.ACTION_VIEW);
                amarislam.setData(Uri.parse("http://www.amarislam.com"));
                startActivity(amarislam);
                break;
            case R.id.yanabi:
                Intent yanabi = new Intent(Intent.ACTION_VIEW);
                yanabi.setData(Uri.parse("http://yanabi.in"));
                startActivity(yanabi);
                break;
            case R.id.miaji:
                Intent miaji = new Intent(Intent.ACTION_VIEW);
                miaji.setData(Uri.parse("https://www.facebook.com/DrMiaji"));
                startActivity(miaji);
                break;
            case R.id.dawateislami:
                Intent dawateislami = new Intent(Intent.ACTION_VIEW);
                dawateislami.setData(Uri.parse("www.dawateislami.net"));
                startActivity(dawateislami);
                break;
            case R.id.sonarmadina:
                Intent sonarmadina = new Intent(Intent.ACTION_VIEW);
                sonarmadina.setData(Uri.parse("http://sonarmadina.com/"));
                startActivity(sonarmadina);
                break;
            case R.id.darsulquran:
                Intent darsulquran = new Intent(Intent.ACTION_VIEW);
                darsulquran.setData(Uri.parse("http://darsulquran.net/"));
                startActivity(darsulquran);
                break;
            case R.id.muzaddedia:
                Intent muzaddedia = new Intent(Intent.ACTION_VIEW);
                muzaddedia.setData(Uri.parse("https://khasmujaddedia.wordpress.com/"));
                startActivity(muzaddedia);
                break;
            case R.id.aswat:
                Intent aswat = new Intent(Intent.ACTION_VIEW);
                aswat.setData(Uri.parse("http://www.aswatalislam.net/"));
                startActivity(aswat);
                break;
            case R.id.alahazrat:
                Intent alahazrat = new Intent(Intent.ACTION_VIEW);
                alahazrat.setData(Uri.parse("http://www.alahazrat.net/"));
                startActivity(alahazrat);
                break;
            case R.id.rowshon:
                Intent rowshon = new Intent(Intent.ACTION_VIEW);
                rowshon.setData(Uri.parse("http://roushandalil.com/"));
                startActivity(rowshon);
                break;
            case R.id.sunnidotcom:
                Intent sunnidotcom = new Intent(Intent.ACTION_VIEW);
                sunnidotcom.setData(Uri.parse("http://www.sunni.com.bd"));
                startActivity(sunnidotcom);
                break;
            case R.id.anjuman:
                Intent anjuman = new Intent(Intent.ACTION_VIEW);
                anjuman.setData(Uri.parse("http://www.anjumantrust.org/"));
                startActivity(anjuman);
                break;
            case R.id.islamimedia:
                Intent islamimedia = new Intent(Intent.ACTION_VIEW);
                islamimedia.setData(Uri.parse("https://islamimedia24.wordpress.com/"));
                startActivity(islamimedia);
                break;
            case R.id.islamisena:
                Intent islamisena = new Intent(Intent.ACTION_VIEW);
                islamisena.setData(Uri.parse("http://chattrasena.com/"));
                startActivity(islamisena);
                break;
            case R.id.sunnidunia:
                Intent sunnidunia = new Intent(Intent.ACTION_VIEW);
                sunnidunia.setData(Uri.parse("http://www.sunniduniya.in/"));
                startActivity(sunnidunia);
                break;
            case R.id.sunnipedia:
                Intent sunnipedia = new Intent(Intent.ACTION_VIEW);
                sunnipedia.setData(Uri.parse("http://www.sunnipediabd.com/"));
                startActivity(sunnipedia);
                break;
            case R.id.aziz:
                Intent aziz = new Intent(Intent.ACTION_VIEW);
                aziz.setData(Uri.parse("https://imamazizulhoqsherebangla.blogspot.se/"));
                startActivity(aziz);
                break;
            case R.id.ahlussunnah:
                Intent ahlussunnah = new Intent(Intent.ACTION_VIEW);
                ahlussunnah.setData(Uri.parse("https://www.youtube.com/channel/UCL3OseqxPoxOlDT-5wWEepw/videos"));
                startActivity(ahlussunnah);
                break;
            case R.id.sunniwaz:
                Intent sunniwaz = new Intent(Intent.ACTION_VIEW);
                sunniwaz.setData(Uri.parse("https://www.youtube.com/channel/UC-Mi0Qfsg90zBJCFtUOR8LA/videos"));
                startActivity(sunniwaz);
                break;
            case R.id.sunnilibrary:
                Intent sunnilibrary = new Intent(Intent.ACTION_VIEW);
                sunnilibrary.setData(Uri.parse("https://syedmostafasakib.wordpress.com/2017/07/15/"));
                startActivity(sunnilibrary);
                break;
            case R.id.taheri:
                Intent tahei = new Intent(Intent.ACTION_VIEW);
                tahei.setData(Uri.parse("https://www.youtube.com/channel/UCkCdPdoBf5UpdGUPmLZxrxA/videos"));
                startActivity(tahei);
                break;
            case R.id.naat:
                Intent naat = new Intent(Intent.ACTION_VIEW);
                naat.setData(Uri.parse("https://www.youtube.com/channel/UC2a2XzyxRXYbOY3aROGlXeQ/videos"));
                startActivity(naat);
                break;
            case R.id.sahihaqida:
                Intent sahihaqida = new Intent(Intent.ACTION_VIEW);
                sahihaqida.setData(Uri.parse("https://www.sahihaqeedah.com/islamic-library/"));
                startActivity(sahihaqida);
                break;
            case R.id.ajmeer:
                Intent ajmir = new Intent(Intent.ACTION_VIEW);
                ajmir.setData(Uri.parse("https://www.youtube.com/channel/UCC0QJFYdd4Wa4_4hlDlYF_g"));
                startActivity(ajmir);
                break;
            case R.id.abul_kashem:
                Intent abul_kashem = new Intent(Intent.ACTION_VIEW);
                abul_kashem.setData(Uri.parse("https://www.facebook.com/akmfh"));
                startActivity(abul_kashem);
                break;
            case R.id.ershad:
                Intent ershad = new Intent(Intent.ACTION_VIEW);
                ershad.setData(Uri.parse("https://www.facebook.com/drirshadbukhari/"));
                startActivity(ershad);
                break;
            case R.id.boktiyar2:
                Intent boktiyar2 = new Intent(Intent.ACTION_VIEW);
                boktiyar2.setData(Uri.parse("https://www.facebook.com/Boktiyer?lst=100001296940524%3A100009131946186%3A1514306136"));
                startActivity(boktiyar2);
                break;
            case R.id.ainul:
                Intent ainul = new Intent(Intent.ACTION_VIEW);
                ainul.setData(Uri.parse("https://www.facebook.com/Muhammad.Ainul.Huda.65"));
                startActivity(ainul);
                break;
            case R.id.beauti:
                Intent beauti = new Intent(Intent.ACTION_VIEW);
                beauti.setData(Uri.parse("https://www.youtube.com/channel/UCn9Y2DetQWr5aNYqHUr3WcQ"));
                startActivity(beauti);
                break;
            case R.id.jasim:
                Intent jasim = new Intent(Intent.ACTION_VIEW);
                jasim.setData(Uri.parse("https://www.facebook.com/jashimuddinazhari"));
                startActivity(jasim);
                break;
            case R.id.madani:
                Intent madani = new Intent(Intent.ACTION_VIEW);
                madani.setData(Uri.parse("https://www.youtube.com/user/MadaniChannel/videos"));
                startActivity(madani);
                break;
            case R.id.jaalhaq:
                Intent jaalhaq = new Intent(Intent.ACTION_VIEW);
                jaalhaq.setData(Uri.parse("https://www.youtube.com/channel/UCJ_LA5iTmFyAQMXA5ekWpXA"));
                startActivity(jaalhaq);
                break;
            case R.id.tazedaremadani:
                Intent tazedaremadani = new Intent(Intent.ACTION_VIEW);
                tazedaremadani.setData(Uri.parse("https://www.youtube.com/channel/UCKwKV4YGF4LjAZySjfe7Kbw/videos"));
                startActivity(tazedaremadani);
                break;
            case R.id.naat2:
                Intent naat2 = new Intent(Intent.ACTION_VIEW);
                naat2.setData(Uri.parse("https://www.youtube.com/channel/UCW1e-lIrTXIvzRHYWRfVKUA/videos"));
                startActivity(naat2);
                break;
            case R.id.muslim:
                Intent muslim = new Intent(Intent.ACTION_VIEW);
                muslim.setData(Uri.parse("https://www.youtube.com/channel/UCSsBOPZeS_bu_AJU-RJrJOA/videos"));
                startActivity(muslim);
                break;
            case R.id.muslim2:
                Intent muslim2 = new Intent(Intent.ACTION_VIEW);
                muslim2.setData(Uri.parse("https://www.youtube.com/channel/UCUmwiAqhEQYhaV8UqEXXcIg/videos"));
                startActivity(muslim2);
                break;
            case R.id.ahleindia:
                Intent ahleindia = new Intent(Intent.ACTION_VIEW);
                ahleindia.setData(Uri.parse("https://www.youtube.com/channel/UC9feDqutm3dYPKMtFR7es9Q/videos"));
                startActivity(ahleindia);
                break;
            case R.id.kobir:
                Intent kobir = new Intent(Intent.ACTION_VIEW);
                kobir.setData(Uri.parse("https://www.youtube.com/channel/UC0XYo6JF5ar0bIBcjIGoo_Q?app=desktop"));
                startActivity(kobir);
                break;
            case R.id.qadri:
                Intent qadri = new Intent(Intent.ACTION_VIEW);
                qadri.setData(Uri.parse("https://www.youtube.com/user/DrTAHIRulQADRI2626/videos"));
                startActivity(qadri);
                break;
            case R.id.pirsakib:
                Intent pirsakib = new Intent(Intent.ACTION_VIEW);
                pirsakib.setData(Uri.parse("https://www.youtube.com/user/shoaibchishti/videos"));
                startActivity(pirsakib);
                break;
            case R.id.qadri2:
                Intent qadri2 = new Intent(Intent.ACTION_VIEW);
                qadri2.setData(Uri.parse("http://www.minhaj.org/english/index.html"));
                startActivity(qadri2);
                break;
            case R.id.bukhari:
                Intent bukhari = new Intent(Intent.ACTION_VIEW);
                bukhari.setData(Uri.parse("https://www.youtube.com/channel/UCPMKViTAR5WDlL2djsPZhug/videos"));
                startActivity(bukhari);
                break;
            case R.id.bukhariu:
                Intent bukhariu = new Intent(Intent.ACTION_VIEW);
                bukhariu.setData(Uri.parse("https://www.youtube.com/channel/UCLcGT6Arzk5Sf7OWQvvKFrw/videos"));
                startActivity(bukhariu);
                break;
            case R.id.iqra:
                Intent iqra = new Intent(Intent.ACTION_VIEW);
                iqra.setData(Uri.parse("https://www.youtube.com/channel/UCYlsnQLqqswlV7mKk598xGw"));
                startActivity(iqra);
                break;
            case R.id.bsena:
                Intent bsena = new Intent(Intent.ACTION_VIEW);
                bsena.setData(Uri.parse("http://www.chattrasena.org.bd/"));
                startActivity(bsena);
                break;
            case R.id.speech:
                Intent speech = new Intent(Intent.ACTION_VIEW);
                speech.setData(Uri.parse("https://www.youtube.com/channel/UCfou3oC9r16GfXvoz4zCg9g/videos"));
                startActivity(speech);
                break;
            case R.id.dawateislami2:
                Intent dawateislami2 = new Intent(Intent.ACTION_VIEW);
                dawateislami2.setData(Uri.parse("http://www.madanichannelbangla.tv/"));
                startActivity(dawateislami2);
                break;
            default:
                return true;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

    public void goToMenu(View view) {
        Intent nextPage = new Intent(this, Main2Activity.class);
        startActivity(nextPage);
    }
}