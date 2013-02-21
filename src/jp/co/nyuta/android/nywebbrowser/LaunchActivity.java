package jp.co.nyuta.android.nywebbrowser;

import jp.co.nyuta.android.overlaywindow.OverlayCreationActivity;

public class LaunchActivity extends OverlayCreationActivity {

	@Override
	protected Class<?> getOverlayWindowService() {
		return OverlayBrowser.class;
	}

}
