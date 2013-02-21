package jp.co.nyuta.android.nywebbrowser.webcnt;

import jp.co.nyuta.android.nywebbrowser.R;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;

public class WebController {

	private ImageButton mNextButton;
	private ImageButton mPrevButton;
	private View		mControllerView;
	private WebView		mClientWebView;

	/* ########################################################## */
	/* #														# */
	/* #					[WebController]						# */
	/* #														# */
	/* ########################################################## */
	/*
	 * R.id.webcntbar_next : 次へ
	 * R.id.webcntbar_prev : 前へ
	 */
	public WebController(Context context, View controllerContainsView, WebView target){
		mClientWebView = target;

		// viewのセットアップ
		mControllerView = controllerContainsView.findViewById(R.id.overlay_webcontroller_layout);
		mNextButton = (ImageButton) controllerContainsView.findViewById(R.id.webcntbar_next);
		mPrevButton = (ImageButton) controllerContainsView.findViewById(R.id.webcntbar_prev);

		mNextButton.setOnClickListener(mButtonClickListener);
		mPrevButton.setOnClickListener(mButtonClickListener);
	}

	/* ########################################################## */
	/* #														# */
	/* #						[public]						# */
	/* #														# */
	/* ########################################################## */
	public void show(){
		mControllerView.setVisibility(View.VISIBLE);
	}

	public void hide(){
		mControllerView.setVisibility(View.GONE);
	}

	public void toggleShowStatus(){
		if(mControllerView.getVisibility() == View.VISIBLE){
			hide();
		}else{
			show();
		}
	}


	/* ########################################################## */
	/* #														# */
	/* #						[Listener]						# */
	/* #														# */
	/* ########################################################## */
	private final OnClickListener mButtonClickListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.webcntbar_next:
				mClientWebView.goForward();
				break;
			case R.id.webcntbar_prev:
				mClientWebView.goBack();
				break;
			}
		}

	};
}
