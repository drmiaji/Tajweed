package com.drmiaji.tajweed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab2 = findViewById(R.id.fableft);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent right = new Intent(About.this, chap17.class);
                startActivity(right);
            }
        });
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
                moreApp.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.drmiaji.tajweed"));
                startActivity(moreApp);
                break;
            case R.id.action_content:
                startActivity(new Intent(this, Main2Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToChap(View view) {
        switch (view.getId()) {

            case R.id.rateUs:
                Intent moreApp = new Intent(Intent.ACTION_VIEW);
                moreApp.setData(Uri.parse("https://play.google.com/store/search?q=drmiaji"));
                startActivity(moreApp);
                break;
            case R.id.link:
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.drmiaji.com"));
                startActivity(link);
                break;
            default:
                break;
        }
    }
}