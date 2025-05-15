package com.drmiaji.tajweed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream
import java.io.IOException

class Chap07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap07)

        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById<FloatingActionButton>(R.id.fableft)
        fab.setOnClickListener { _: View? ->
            val right = Intent(this@Chap07, Chap06::class.java)
            startActivity(right)
        }

        val fab2 = findViewById<FloatingActionButton>(R.id.fabright)
        fab2.setOnClickListener { _: View? ->
            val right = Intent(this@Chap07, Chap08::class.java)
            startActivity(right)
        }

        // Set up WebView for bidirectional text
        setupWebViewForContent()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebViewForContent() {
        // Get the text content
        val textContent = readTxt()

        // Get WebView reference
        val webView = findViewById<WebView>(R.id.chap07)

        // Configure WebView settings
        webView.settings.javaScriptEnabled = true

        // Enable DOM storage
        webView.settings.domStorageEnabled = true

        // Set text zoom (100 is default)
        webView.settings.textZoom = 100

        // Enable zooming if needed
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false

        // Allow mixed content mode if needed
        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        // Convert content to HTML with proper bidirectional text handling
        val htmlContent = formatTextAsHtml(textContent)

        // Load the HTML content into WebView
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
    }

    private fun formatTextAsHtml(text: String): String {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        line-height: 1.6;
                        direction: ltr;
                        text-align: left;
                        padding: 16px;
                        margin: 0;
                        color: #333;
                        background-color: #fff;
                        font-size: 16px;
                    }
                    
                    .arabic {
                        direction: rtl;
                        unicode-bidi: isolate;
                        font-family: 'Noto Naskh Arabic', Arial, sans-serif;
                        font-size: 18px;
                    }
                    
                    .bengali {
                        direction: ltr;
                        unicode-bidi: isolate;
                        font-family: 'Noto Sans Bengali', Arial, sans-serif;
                    }
                    
                    p {
                        margin-bottom: 12px;
                    }
                </style>
            </head>
            <body>
                ${processTextForHtml(text)}
            </body>
            </html>
        """.trimIndent()
    }

    private fun processTextForHtml(text: String): String {
        // Split into paragraphs
        val paragraphs = text.split("\n\n")

        // Process each paragraph
        val processedParagraphs = paragraphs.map { paragraph ->
            if (paragraph.isNotEmpty()) {
                "<p>${detectAndWrapArabic(paragraph)}</p>"
            } else {
                ""
            }
        }

        return processedParagraphs.joinToString("\n")
    }

    private fun detectAndWrapArabic(text: String): String {
        val result = StringBuilder()
        var currentPos = 0
        var inArabic = false

        for (i in text.indices) {
            val c = text[i]
            val isArabic = isArabicChar(c)

            if (isArabic != inArabic) {
                // Script change detected
                if (currentPos < i) {
                    val segment = text.substring(currentPos, i)
                    if (inArabic) {
                        result.append("<span class=\"arabic\">").append(segment).append("</span>")
                    } else {
                        result.append(segment)
                    }
                }
                currentPos = i
                inArabic = isArabic
            }
        }

        // Handle the last segment
        if (currentPos < text.length) {
            val segment = text.substring(currentPos)
            if (inArabic) {
                result.append("<span class=\"arabic\">").append(segment).append("</span>")
            } else {
                result.append(segment)
            }
        }

        return result.toString()
    }

    private fun isArabicChar(c: Char): Boolean {
        val code = c.code
        return (code >= 0x0600 && code <= 0x06FF) ||   // Arabic
                (code >= 0x0750 && code <= 0x077F) ||   // Arabic Supplement
                (code >= 0x08A0 && code <= 0x08FF) ||   // Arabic Extended-A
                (code >= 0xFB50 && code <= 0xFDFF) ||   // Arabic Presentation Forms-A
                (code >= 0xFE70 && code <= 0xFEFF)      // Arabic Presentation Forms-B
    }

    private fun readTxt(): String {
        val inputStream = resources.openRawResource(R.raw.chap07)
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

        // Make sure the text is interpreted as UTF-8
        return byteArrayOutputStream.toString(Charsets.UTF_8.name())
    }
}
