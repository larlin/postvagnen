package larlin.postvagnenclassic;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PostActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		
		WebView main = (WebView) findViewById(R.id.mainView);
		
		main.setWebViewClient(new WebViewClient() {
			
			@Override
			public WebResourceResponse shouldInterceptRequest (WebView view, String url){
				if (url.contains(".css")) {
		            try {
		                return new WebResourceResponse("text/css", "UTF-8", getAssets().open("classic.css"));
		            } catch (IOException e) {
		                return null;
		            }
				}
				return null;
			}
		});
		
		main.loadUrl("http://www.postvagnen.com/forum/");

		 


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

}
