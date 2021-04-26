package com.example.profileapplication1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.profileapplication1.R

class WebViewActivity : AppCompatActivity() {
    private lateinit var  webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

       webView=findViewById<WebView>(R.id.webView)
        webView.webViewClient= WebViewClient()
        val webSettings=webView.settings
        webSettings.javaScriptEnabled=true
        webView.loadUrl("https://www.linkedin.com/")
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else {
            super.onBackPressed()
        }
    }


}