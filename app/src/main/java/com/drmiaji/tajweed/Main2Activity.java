package com.drmiaji.tajweed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goTochap(View view) {
        int id = view.getId();
        if (id == R.id.intro0) {
            startActivity(new Intent(this, intro0.class));
        } else if (id == R.id.intro1) {
            startActivity(new Intent(this, intro1.class));
        } else if (id == R.id.chap01) {
            startActivity(new Intent(this, chap01.class));
        } else if (id == R.id.chap02) {
            startActivity(new Intent(this, Chap02.class));
        } else if (id == R.id.chap03) {
            startActivity(new Intent(this, Chap03.class));
        } else if (id == R.id.chap04) {
            startActivity(new Intent(this, Chap04.class));
        } else if (id == R.id.chap05) {
            startActivity(new Intent(this, Chap05.class));
        } else if (id == R.id.chap06) {
            startActivity(new Intent(this, Chap06.class));
        } else if (id == R.id.chap07) {
            startActivity(new Intent(this, Chap07.class));
        } else if (id == R.id.chap08) {
            startActivity(new Intent(this, Chap08.class));
        } else if (id == R.id.chap09) {
            startActivity(new Intent(this, Chap09.class));
        } else if (id == R.id.chap10) {
            startActivity(new Intent(this, Chap10.class));
        } else if (id == R.id.chap11) {
            startActivity(new Intent(this, Chap11.class));
        } else if (id == R.id.chap12) {
            startActivity(new Intent(this, chap12.class));
        } else if (id == R.id.chap13) {
            startActivity(new Intent(this, chap13.class));
        } else if (id == R.id.chap14) {
            startActivity(new Intent(this, chap14.class));
        } else if (id == R.id.chap15) {
            startActivity(new Intent(this, chap15.class));
        } else if (id == R.id.chap16) {
            startActivity(new Intent(this, chap16.class));
        } else if (id == R.id.chap17) {
            startActivity(new Intent(this, chap17.class));
        } else if (id == R.id.about2) {
            startActivity(new Intent(this, About.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            getOnBackPressedDispatcher();
        } else if (itemId == R.id.share) {
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
        } else if (itemId == R.id.action_about_us) {
            startActivity(new Intent(this, About.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}