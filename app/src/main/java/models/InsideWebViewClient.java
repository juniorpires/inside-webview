package models;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.juniorpires.insidewebview.ui.MainActivity;

/**
 * Created by Júnior Pires on 27/01/17.
 */

public class InsideWebViewClient extends WebViewClient {

    private AppCompatActivity activity;

    public InsideWebViewClient(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals(MainActivity.URL)) {
            // This is my web site, so do not override; let my WebView load the page
            return false;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }
}
