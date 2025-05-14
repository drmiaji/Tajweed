package com.drmiaji.tajweed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri

class Main2Activity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val toolbar = findViewById<Toolbar?>(R.id.app_bar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun goTochap(view: View) {
        val id = view.id
        if (id == R.id.intro0) {
            startActivity(Intent(this, Intro0::class.java))
        } else if (id == R.id.intro1) {
            startActivity(Intent(this, Intro1::class.java))
        } else if (id == R.id.chap01) {
            startActivity(Intent(this, chap01::class.java))
        } else if (id == R.id.chap02) {
            startActivity(Intent(this, Chap02::class.java))
        } else if (id == R.id.chap03) {
            startActivity(Intent(this, Chap03::class.java))
        } else if (id == R.id.chap04) {
            startActivity(Intent(this, Chap04::class.java))
        } else if (id == R.id.chap05) {
            startActivity(Intent(this, Chap05::class.java))
        } else if (id == R.id.chap06) {
            startActivity(Intent(this, Chap06::class.java))
        } else if (id == R.id.chap07) {
            startActivity(Intent(this, Chap07::class.java))
        } else if (id == R.id.chap08) {
            startActivity(Intent(this, Chap08::class.java))
        } else if (id == R.id.chap09) {
            startActivity(Intent(this, Chap09::class.java))
        } else if (id == R.id.chap10) {
            startActivity(Intent(this, Chap10::class.java))
        } else if (id == R.id.chap11) {
            startActivity(Intent(this, Chap11::class.java))
        } else if (id == R.id.chap12) {
            startActivity(Intent(this, Chap12::class.java))
        } else if (id == R.id.chap13) {
            startActivity(Intent(this, Chap13::class.java))
        } else if (id == R.id.chap14) {
            startActivity(Intent(this, Chap14::class.java))
        } else if (id == R.id.chap15) {
            startActivity(Intent(this, Chap15::class.java))
        } else if (id == R.id.chap16) {
            startActivity(Intent(this, Chap16::class.java))
        } else if (id == R.id.chap17) {
            startActivity(Intent(this, Chap17::class.java))
        } else if (id == R.id.about2) {
            startActivity(Intent(this, About::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mMenuInflater = menuInflater
        mMenuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        when (itemId) {
            R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
            R.id.share -> {
                val myIntent = Intent(Intent.ACTION_SEND)
                myIntent.setType("text/plain")
                val shareSub: String? = getString(R.string.share_subject)
                val shareBody: String? = getString(R.string.share_message)
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub)
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(myIntent, "Share using!"))
            }
            R.id.more_apps -> {
                val moreApp = Intent(Intent.ACTION_VIEW)
                moreApp.setData("https://play.google.com/store/apps/details?id=com.drmiaji.tajweed".toUri())
                startActivity(moreApp)
            }
            R.id.action_content -> {
                startActivity(Intent(this, Main2Activity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}