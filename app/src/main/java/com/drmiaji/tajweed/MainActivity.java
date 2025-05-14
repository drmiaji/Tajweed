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
        int itemId = item.getItemId();
        if (itemId == R.id.share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareSub = getString(R.string.share_subject);
            String shareBody = getString(R.string.share_message);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using!"));
        } else if (itemId == R.id.more_apps) {
            Intent moreApp = new Intent(Intent.ACTION_VIEW);
            moreApp.setData(Uri.parse("https://play.google.com/store/search?q=drmiaji"));
            startActivity(moreApp);
        } else if (itemId == R.id.action_content) {
            startActivity(new Intent(this, Main2Activity.class));
        } else if (itemId == R.id.action_about_us) {
            startActivity(new Intent(this, About.class));
        } else {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.tauhid) {
            Intent tauhid = new Intent(Intent.ACTION_VIEW);
            tauhid.setData(Uri.parse("http://www.drmiaji.com"));
            startActivity(tauhid);
        } else if (itemId == R.id.boktiyar) {
            Intent boktiyar = new Intent(Intent.ACTION_VIEW);
            boktiyar.setData(Uri.parse("https://www.youtube.com/user/boktiyer/videos"));
            startActivity(boktiyar);
        } else if (itemId == R.id.arif) {
            Intent arif = new Intent(Intent.ACTION_VIEW);
            arif.setData(Uri.parse("http://ahlesunnatbd.net"));
            startActivity(arif);
        } else if (itemId == R.id.amarislam) {
            Intent amarislam = new Intent(Intent.ACTION_VIEW);
            amarislam.setData(Uri.parse("http://www.amarislam.com"));
            startActivity(amarislam);
        } else if (itemId == R.id.yanabi) {
            Intent yanabi = new Intent(Intent.ACTION_VIEW);
            yanabi.setData(Uri.parse("http://yanabi.in"));
            startActivity(yanabi);
        } else if (itemId == R.id.miaji) {
            Intent miaji = new Intent(Intent.ACTION_VIEW);
            miaji.setData(Uri.parse("https://www.facebook.com/DrMiaji"));
            startActivity(miaji);
        } else if (itemId == R.id.dawateislami) {
            Intent dawateislami = new Intent(Intent.ACTION_VIEW);
            dawateislami.setData(Uri.parse("www.dawateislami.net"));
            startActivity(dawateislami);
        } else if (itemId == R.id.sonarmadina) {
            Intent sonarmadina = new Intent(Intent.ACTION_VIEW);
            sonarmadina.setData(Uri.parse("http://sonarmadina.com/"));
            startActivity(sonarmadina);
        } else if (itemId == R.id.darsulquran) {
            Intent darsulquran = new Intent(Intent.ACTION_VIEW);
            darsulquran.setData(Uri.parse("http://darsulquran.net/"));
            startActivity(darsulquran);
        } else if (itemId == R.id.muzaddedia) {
            Intent muzaddedia = new Intent(Intent.ACTION_VIEW);
            muzaddedia.setData(Uri.parse("https://khasmujaddedia.wordpress.com/"));
            startActivity(muzaddedia);
        } else if (itemId == R.id.aswat) {
            Intent aswat = new Intent(Intent.ACTION_VIEW);
            aswat.setData(Uri.parse("http://www.aswatalislam.net/"));
            startActivity(aswat);
        } else if (itemId == R.id.alahazrat) {
            Intent alahazrat = new Intent(Intent.ACTION_VIEW);
            alahazrat.setData(Uri.parse("http://www.alahazrat.net/"));
            startActivity(alahazrat);
        } else if (itemId == R.id.rowshon) {
            Intent rowshon = new Intent(Intent.ACTION_VIEW);
            rowshon.setData(Uri.parse("http://roushandalil.com/"));
            startActivity(rowshon);
        } else if (itemId == R.id.sunnidotcom) {
            Intent sunnidotcom = new Intent(Intent.ACTION_VIEW);
            sunnidotcom.setData(Uri.parse("http://www.sunni.com.bd"));
            startActivity(sunnidotcom);
        } else if (itemId == R.id.anjuman) {
            Intent anjuman = new Intent(Intent.ACTION_VIEW);
            anjuman.setData(Uri.parse("http://www.anjumantrust.org/"));
            startActivity(anjuman);
        } else if (itemId == R.id.islamimedia) {
            Intent islamimedia = new Intent(Intent.ACTION_VIEW);
            islamimedia.setData(Uri.parse("https://islamimedia24.wordpress.com/"));
            startActivity(islamimedia);
        } else if (itemId == R.id.islamisena) {
            Intent islamisena = new Intent(Intent.ACTION_VIEW);
            islamisena.setData(Uri.parse("http://chattrasena.com/"));
            startActivity(islamisena);
        } else if (itemId == R.id.sunnidunia) {
            Intent sunnidunia = new Intent(Intent.ACTION_VIEW);
            sunnidunia.setData(Uri.parse("http://www.sunniduniya.in/"));
            startActivity(sunnidunia);
        } else if (itemId == R.id.sunnipedia) {
            Intent sunnipedia = new Intent(Intent.ACTION_VIEW);
            sunnipedia.setData(Uri.parse("http://www.sunnipediabd.com/"));
            startActivity(sunnipedia);
        } else if (itemId == R.id.aziz) {
            Intent aziz = new Intent(Intent.ACTION_VIEW);
            aziz.setData(Uri.parse("https://imamazizulhoqsherebangla.blogspot.se/"));
            startActivity(aziz);
        } else if (itemId == R.id.ahlussunnah) {
            Intent ahlussunnah = new Intent(Intent.ACTION_VIEW);
            ahlussunnah.setData(Uri.parse("https://www.youtube.com/channel/UCL3OseqxPoxOlDT-5wWEepw/videos"));
            startActivity(ahlussunnah);
        } else if (itemId == R.id.sunniwaz) {
            Intent sunniwaz = new Intent(Intent.ACTION_VIEW);
            sunniwaz.setData(Uri.parse("https://www.youtube.com/channel/UC-Mi0Qfsg90zBJCFtUOR8LA/videos"));
            startActivity(sunniwaz);
        } else if (itemId == R.id.sunnilibrary) {
            Intent sunnilibrary = new Intent(Intent.ACTION_VIEW);
            sunnilibrary.setData(Uri.parse("https://syedmostafasakib.wordpress.com/2017/07/15/"));
            startActivity(sunnilibrary);
        } else if (itemId == R.id.taheri) {
            Intent tahei = new Intent(Intent.ACTION_VIEW);
            tahei.setData(Uri.parse("https://www.youtube.com/channel/UCkCdPdoBf5UpdGUPmLZxrxA/videos"));
            startActivity(tahei);
        } else if (itemId == R.id.naat) {
            Intent naat = new Intent(Intent.ACTION_VIEW);
            naat.setData(Uri.parse("https://www.youtube.com/channel/UC2a2XzyxRXYbOY3aROGlXeQ/videos"));
            startActivity(naat);
        } else if (itemId == R.id.sahihaqida) {
            Intent sahihaqida = new Intent(Intent.ACTION_VIEW);
            sahihaqida.setData(Uri.parse("https://www.sahihaqeedah.com/islamic-library/"));
            startActivity(sahihaqida);
        } else if (itemId == R.id.ajmeer) {
            Intent ajmir = new Intent(Intent.ACTION_VIEW);
            ajmir.setData(Uri.parse("https://www.youtube.com/channel/UCC0QJFYdd4Wa4_4hlDlYF_g"));
            startActivity(ajmir);
        } else if (itemId == R.id.abul_kashem) {
            Intent abul_kashem = new Intent(Intent.ACTION_VIEW);
            abul_kashem.setData(Uri.parse("https://www.facebook.com/akmfh"));
            startActivity(abul_kashem);
        } else if (itemId == R.id.ershad) {
            Intent ershad = new Intent(Intent.ACTION_VIEW);
            ershad.setData(Uri.parse("https://www.facebook.com/drirshadbukhari/"));
            startActivity(ershad);
        } else if (itemId == R.id.boktiyar2) {
            Intent boktiyar2 = new Intent(Intent.ACTION_VIEW);
            boktiyar2.setData(Uri.parse("https://www.facebook.com/Boktiyer?lst=100001296940524%3A100009131946186%3A1514306136"));
            startActivity(boktiyar2);
        } else if (itemId == R.id.ainul) {
            Intent ainul = new Intent(Intent.ACTION_VIEW);
            ainul.setData(Uri.parse("https://www.facebook.com/Muhammad.Ainul.Huda.65"));
            startActivity(ainul);
        } else if (itemId == R.id.beauti) {
            Intent beauti = new Intent(Intent.ACTION_VIEW);
            beauti.setData(Uri.parse("https://www.youtube.com/channel/UCn9Y2DetQWr5aNYqHUr3WcQ"));
            startActivity(beauti);
        } else if (itemId == R.id.jasim) {
            Intent jasim = new Intent(Intent.ACTION_VIEW);
            jasim.setData(Uri.parse("https://www.facebook.com/jashimuddinazhari"));
            startActivity(jasim);
        } else if (itemId == R.id.madani) {
            Intent madani = new Intent(Intent.ACTION_VIEW);
            madani.setData(Uri.parse("https://www.youtube.com/user/MadaniChannel/videos"));
            startActivity(madani);
        } else if (itemId == R.id.jaalhaq) {
            Intent jaalhaq = new Intent(Intent.ACTION_VIEW);
            jaalhaq.setData(Uri.parse("https://www.youtube.com/channel/UCJ_LA5iTmFyAQMXA5ekWpXA"));
            startActivity(jaalhaq);
        } else if (itemId == R.id.tazedaremadani) {
            Intent tazedaremadani = new Intent(Intent.ACTION_VIEW);
            tazedaremadani.setData(Uri.parse("https://www.youtube.com/channel/UCKwKV4YGF4LjAZySjfe7Kbw/videos"));
            startActivity(tazedaremadani);
        } else if (itemId == R.id.naat2) {
            Intent naat2 = new Intent(Intent.ACTION_VIEW);
            naat2.setData(Uri.parse("https://www.youtube.com/channel/UCW1e-lIrTXIvzRHYWRfVKUA/videos"));
            startActivity(naat2);
        } else if (itemId == R.id.muslim) {
            Intent muslim = new Intent(Intent.ACTION_VIEW);
            muslim.setData(Uri.parse("https://www.youtube.com/channel/UCSsBOPZeS_bu_AJU-RJrJOA/videos"));
            startActivity(muslim);
        } else if (itemId == R.id.muslim2) {
            Intent muslim2 = new Intent(Intent.ACTION_VIEW);
            muslim2.setData(Uri.parse("https://www.youtube.com/channel/UCUmwiAqhEQYhaV8UqEXXcIg/videos"));
            startActivity(muslim2);
        } else if (itemId == R.id.ahleindia) {
            Intent ahleindia = new Intent(Intent.ACTION_VIEW);
            ahleindia.setData(Uri.parse("https://www.youtube.com/channel/UC9feDqutm3dYPKMtFR7es9Q/videos"));
            startActivity(ahleindia);
        } else if (itemId == R.id.kobir) {
            Intent kobir = new Intent(Intent.ACTION_VIEW);
            kobir.setData(Uri.parse("https://www.youtube.com/channel/UC0XYo6JF5ar0bIBcjIGoo_Q?app=desktop"));
            startActivity(kobir);
        } else if (itemId == R.id.qadri) {
            Intent qadri = new Intent(Intent.ACTION_VIEW);
            qadri.setData(Uri.parse("https://www.youtube.com/user/DrTAHIRulQADRI2626/videos"));
            startActivity(qadri);
        } else if (itemId == R.id.pirsakib) {
            Intent pirsakib = new Intent(Intent.ACTION_VIEW);
            pirsakib.setData(Uri.parse("https://www.youtube.com/user/shoaibchishti/videos"));
            startActivity(pirsakib);
        } else if (itemId == R.id.qadri2) {
            Intent qadri2 = new Intent(Intent.ACTION_VIEW);
            qadri2.setData(Uri.parse("http://www.minhaj.org/english/index.html"));
            startActivity(qadri2);
        } else if (itemId == R.id.bukhari) {
            Intent bukhari = new Intent(Intent.ACTION_VIEW);
            bukhari.setData(Uri.parse("https://www.youtube.com/channel/UCPMKViTAR5WDlL2djsPZhug/videos"));
            startActivity(bukhari);
        } else if (itemId == R.id.bukhariu) {
            Intent bukhariu = new Intent(Intent.ACTION_VIEW);
            bukhariu.setData(Uri.parse("https://www.youtube.com/channel/UCLcGT6Arzk5Sf7OWQvvKFrw/videos"));
            startActivity(bukhariu);
        } else if (itemId == R.id.iqra) {
            Intent iqra = new Intent(Intent.ACTION_VIEW);
            iqra.setData(Uri.parse("https://www.youtube.com/channel/UCYlsnQLqqswlV7mKk598xGw"));
            startActivity(iqra);
        } else if (itemId == R.id.bsena) {
            Intent bsena = new Intent(Intent.ACTION_VIEW);
            bsena.setData(Uri.parse("http://www.chattrasena.org.bd/"));
            startActivity(bsena);
        } else if (itemId == R.id.speech) {
            Intent speech = new Intent(Intent.ACTION_VIEW);
            speech.setData(Uri.parse("https://www.youtube.com/channel/UCfou3oC9r16GfXvoz4zCg9g/videos"));
            startActivity(speech);
        } else if (itemId == R.id.dawateislami2) {
            Intent dawateislami2 = new Intent(Intent.ACTION_VIEW);
            dawateislami2.setData(Uri.parse("http://www.madanichannelbangla.tv/"));
            startActivity(dawateislami2);
        } else {
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