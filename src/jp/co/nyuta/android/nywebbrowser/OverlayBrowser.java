package jp.co.nyuta.android.nywebbrowser;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import jp.co.nyuta.android.nywebbrowser.webcnt.WebController;
import jp.co.nyuta.android.overlaywindow.OverlayApplication;
import jp.co.nyuta.android.overlaywindow.OverlayWindow;
import jp.co.nyuta.android.overlaywindow.classes.Attribute;

public class OverlayBrowser extends OverlayApplication {

	private WebView 					mWebView = null;
	private WebController				mController = null;

	/* ########################################################## */
	/* #														# */
	/* #				[OverlayApplication]					# */
	/* #														# */
	/* ########################################################## */
	@Override
	protected int getWindowIconResourceId() {
		return R.drawable.ic_launcher;
	}

	@Override
	protected int getNotificationId() {
		return 200;
	}

	@Override
	protected Attribute getOverlayApplicationAttribute(Attribute default_attr) {
		Point size = OverlayWindow.getOptimizedWindowSize(getApplicationContext());
		default_attr.window_width = size.x;
		default_attr.window_height = size.y - 82;	// 少しだけ小さく表示
		default_attr.only_windowbar_move = true;
		default_attr.overlay_window_flag &= ~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;	// OverlayWindowの仕様にかぎらず、Key入力のために必要
		default_attr.overlay_window_layer = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;	// Layerを上位に変更
		return default_attr;
	}

	@Override
	protected Class<?> getThisClass() {
		return OverlayBrowser.class;
	}

	@Override
	protected View onCreateView(LayoutInflater inflater, ViewGroup root) {
		View thisRoot = inflater.inflate(R.layout.overlay_browser, root);
		mWebView = (WebView)thisRoot.findViewById(R.id.overlay_browser_webView);
		setupWebView();
		mController = new WebController(getApplicationContext(), thisRoot, mWebView);
		mController.show();
		return thisRoot;
	}


	/* ########################################################## */
	/* #														# */
	/* #						[private]						# */
	/* #														# */
	/* ########################################################## */
	private void setupWebView(){
		// Defaultのページを指定
		mWebView.loadUrl("https://www.google.co.jp/");

		// WebViewクライアントを設定
		mWebView.setWebViewClient(new WebViewClient(){});

		// Zoomを有効化
		mWebView.getSettings().setBuiltInZoomControls(true);
	}

	/* ########################################################## */
	/* #														# */
	/* #						[Listener]						# */
	/* #														# */
	/* ########################################################## */



}
