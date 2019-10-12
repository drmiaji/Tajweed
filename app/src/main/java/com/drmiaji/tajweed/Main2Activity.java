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
        switch (view.getId()) {
            case R.id.intro0:
                startActivity(new Intent(this, intro0.class));
                break;
            case R.id.intro1:
                startActivity(new Intent(this, intro1.class));
                break;
            case R.id.chap01:
                startActivity(new Intent(this, chap01.class));
                break;
            case R.id.chap02:
                startActivity(new Intent(this, chap02.class));
                break;
            case R.id.chap03:
                startActivity(new Intent(this, chap03.class));
                break;
            case R.id.chap04:
                startActivity(new Intent(this, chap04.class));
                break;
            case R.id.chap05:
                startActivity(new Intent(this, chap05.class));
                break;
            case R.id.chap06:
                startActivity(new Intent(this, chap06.class));
                break;
            case R.id.chap07:
                startActivity(new Intent(this, chap07.class));
                break;
            case R.id.chap08:
                startActivity(new Intent(this, chap08.class));
                break;
            case R.id.chap09:
                startActivity(new Intent(this, chap09.class));
                break;
            case R.id.chap10:
                startActivity(new Intent(this, chap10.class));
                break;
            case R.id.chap11:
                startActivity(new Intent(this, chap11.class));
                break;
            case R.id.chap12:
                startActivity(new Intent(this, chap12.class));
                break;
            case R.id.chap13:
                startActivity(new Intent(this, chap13.class));
                break;
            case R.id.chap14:
                startActivity(new Intent(this, chap14.class));
                break;
            case R.id.chap15:
                startActivity(new Intent(this, chap15.class));
                break;
            case R.id.chap16:
                startActivity(new Intent(this, chap16.class));
                break;
            case R.id.chap17:
                startActivity(new Intent(this, chap17.class));
                break;
            case R.id.about2:
                startActivity(new Intent(this, About.class));
                break;
            default:
                break;
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
        switch (item.getItemId()) {
            case R.id.home:
                onBackPressed();
                break;
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
            case R.id.action_about_us:
                startActivity(new Intent(this, About.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}