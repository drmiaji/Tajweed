package com.drmiaji.tajweed

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.net.toUri

open class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.itemIconTintList = null
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        return super.getOnBackInvokedDispatcher()
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressedDispatcher
        }
        createDialog()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    protected fun createDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(R.string.action_exit)
        alertDialog.setCancelable(false)

        alertDialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                super@MainActivity.onBackPressedDispatcher.onBackPressed()
            }
        })

        alertDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
            }
        })
        alertDialog.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val itemId = item.itemId
        if (itemId == R.id.share) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.setType("text/plain")
            val shareSub: String? = getString(R.string.share_subject)
            val shareBody: String? = getString(R.string.share_message)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareSub)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(myIntent, "Share using!"))
        } else if (itemId == R.id.more_apps) {
            val moreApp = Intent(Intent.ACTION_VIEW)
            moreApp.setData("https://play.google.com/store/search?q=drmiaji".toUri())
            startActivity(moreApp)
        } else if (itemId == R.id.action_content) {
            startActivity(Intent(this, Main2Activity::class.java))
        } else if (itemId == R.id.action_about_us) {
            startActivity(Intent(this, About::class.java))
        } else {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.boktiyar) {
            val boktiyar = Intent(Intent.ACTION_VIEW)
            boktiyar.setData("https://www.youtube.com/user/boktiyer/videos".toUri())
            startActivity(boktiyar)
        } else if (itemId == R.id.miaji) {
            val miaji = Intent(Intent.ACTION_VIEW)
            miaji.setData("https://www.facebook.com/DrMiaji".toUri())
            startActivity(miaji)
        } else if (itemId == R.id.ajmeer) {
            val ajmir = Intent(Intent.ACTION_VIEW)
            ajmir.setData("https://www.youtube.com/channel/UCC0QJFYdd4Wa4_4hlDlYF_g".toUri())
            startActivity(ajmir)
        } else if (itemId == R.id.naat2) {
            val naat2 = Intent(Intent.ACTION_VIEW)
            naat2.setData("https://www.youtube.com/channel/UCW1e-lIrTXIvzRHYWRfVKUA/videos".toUri())
            startActivity(naat2)
        } else if (itemId == R.id.qadri) {
            val qadri = Intent(Intent.ACTION_VIEW)
            qadri.setData("https://www.youtube.com/user/DrTAHIRulQADRI2626/videos".toUri())
            startActivity(qadri)
        } else if (itemId == R.id.qadri2) {
            val qadri2 = Intent(Intent.ACTION_VIEW)
            qadri2.setData("http://www.minhaj.org/english/index.html".toUri())
            startActivity(qadri2)
        } else {
            return true
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)

        return super.onOptionsItemSelected(item)
    }

    fun goToMenu(view: View?) {
        val nextPage = Intent(this, Main2Activity::class.java)
        startActivity(nextPage)
    }
}