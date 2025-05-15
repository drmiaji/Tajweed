package com.drmiaji.tajweed

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream
import java.io.IOException

class Chap07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap07)

        val toolbar = findViewById<Toolbar?>(R.id.app_bar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById<FloatingActionButton>(R.id.fableft)
        fab.setOnClickListener(View.OnClickListener { view: View? ->
            val right = Intent(this@Chap07, Chap06::class.java)
            startActivity(right)
        })
        val fab2 = findViewById<FloatingActionButton>(R.id.fabright)
        fab2.setOnClickListener(View.OnClickListener { view: View? ->
            val right = Intent(this@Chap07, Chap08::class.java)
            startActivity(right)
        })

        val textView = findViewById<TextView>(R.id.chap07)
        textView.text = readTxt()
    }

    private fun readTxt(): String {
        val inputStream = getResources().openRawResource(R.raw.chap07)

        val byteArrayOutputStream = ByteArrayOutputStream()

        try {
            var i = inputStream.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return byteArrayOutputStream.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mMenuInflater = menuInflater
        mMenuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        } else if (itemId == R.id.share) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.setType("text/plain")
            val shareSub: String? = getString(R.string.share_subject)
            val shareBody: String? = getString(R.string.share_message)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareSub)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(myIntent, "Share using!"))
        } else if (itemId == R.id.more_apps) {
            val moreApp = Intent(Intent.ACTION_VIEW)
            moreApp.setData("https://play.google.com/store/apps/details?id=com.drmiaji.tajweed".toUri())
            startActivity(moreApp)
        } else if (itemId == R.id.action_content) {
            startActivity(Intent(this, Main2Activity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
