package com.example.lab1.ui.video

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient:WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url
        val host: String? = url?.host
        return host != "learnenglish.britishcouncil.org"
    }
}