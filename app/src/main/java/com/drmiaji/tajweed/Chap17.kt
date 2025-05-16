package com.drmiaji.tajweed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import com.drmiaji.tajweed.Chap10
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Chap17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap17)

        // ✅ Back navigation override (modern)
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val intent = Intent(this@Chap17, Main2Activity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                    finish()
                }
            }
        )

        val toolbar = findViewById<Toolbar?>(R.id.app_bar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById<FloatingActionButton>(R.id.fableft)
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val right = Intent(this@Chap17, Chap16::class.java)
                startActivity(right)
            }
        })
        val fab2 = findViewById<FloatingActionButton>(R.id.fabright)
        fab2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val right = Intent(this@Chap17, About::class.java)
                startActivity(right)
            }
        })
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
            R.id.about2 -> {
                startActivity(Intent(this, About::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
