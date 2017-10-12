package kr.co.goms.glidebitmappooltest;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {
	private static final String TAG = PermissionActivity.class.getSimpleName();
	private PermissionActivity mPermissionActivity = this;

	private TextView mPermissionAlert;
	private TextView mPermissionBtn;

	private List<String> mPermissionList;
	private int mPermissionReadExternalStorage;

	private boolean isFirstPermission = true;
	private boolean isAskPermissionStorage = false;

	public static final int RequestPermissionCode = 1;
	public static final int RequestPermissionCodeSecond = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permission);

		/** Permission 관련 처리 */

		mPermissionList = new ArrayList<>();
		mPermissionReadExternalStorage = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);

		if (mPermissionReadExternalStorage != PackageManager.PERMISSION_GRANTED) {
			mPermissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
		}

		mPermissionAlert = (TextView) findViewById(R.id.tv_app_permission_alert);
		String alertText = goAlertTitle();
		mPermissionAlert.setText(Html.fromHtml(alertText));

		mPermissionBtn = (TextView) findViewById(R.id.tv_app_permission_btn);

	}

	private boolean checkAndRequestPermissions() {

		int storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

		List<String> listPermissionsNeeded = new ArrayList<>();
		if (storagePermission != PackageManager.PERMISSION_GRANTED) {
			listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
		}
		if (!listPermissionsNeeded.isEmpty()) {

			goAlertTitle();

			if(isAskPermissionStorage){
				goPermissionSetting();
			}else{
				if(isFirstPermission) {
					ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), RequestPermissionCode);
					isFirstPermission = false;
				}else{
					ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), RequestPermissionCodeSecond);
				}
			}
			return false;
		}else{
			goPermissionSetting();
		}
		return true;
	}

	private void goPermissionSetting(){
		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.parse("package:" + BuildConfig.APPLICATION_ID));
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		startActivityForResult(intent, AppConstant.ACTIVITY_REQUEST_CODE_PERMISSION_SETTING);
	}

	public void goFinish(View view){
		finish();
		System.exit(0);
		android.os.Process.killProcess(android.os.Process.myPid());
		ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		am.restartPackage(getPackageName());
	}

	public void goPermission(View view){

		checkPermission();

		if(mPermissionReadExternalStorage == PackageManager.PERMISSION_GRANTED ){
			goLoading();
		}else {
			checkAndRequestPermissions();
		}
	}

	private void checkPermission(){
		mPermissionReadExternalStorage = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
	}


	private String goAlertTitle(){

		checkPermission();

		StringBuffer sb = new StringBuffer();
		if(mPermissionReadExternalStorage != PackageManager.PERMISSION_GRANTED){
			sb.append(getString(R.string.permission_storage));
			sb.append("<br><br>");
		}
		return sb.toString();
	}

	private void goReadExternalStoragePermission(){
		if (mPermissionReadExternalStorage != PackageManager.PERMISSION_GRANTED) {
			// 이 권한을 필요한 이유를 설명해야하는가?
			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
				// 다이어로그같은것을 띄워서 사용자에게 해당 권한이 필요한 이유에 대해 설명합니다
				// 해당 설명이 끝난뒤 requestPermissions()함수를 호출하여 권한허가를 요청해야 합니다
				ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, AppConstant.ACTIVITY_REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE_RE);
			} else {
				ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, AppConstant.ACTIVITY_REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE);
				// 필요한 권한과 요청 코드를 넣어서 권한허가요청에 대한 결과를 받아야 합니다
			}
		}else{
			mPermissionReadExternalStorage = PackageManager.PERMISSION_GRANTED;
			goLoading();
		}
	}

	private void goLoading(){
		Intent intent = new Intent(mPermissionActivity, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		finish();
	}

	@Override
	public void onBackPressed() {
		finish();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case AppConstant.ACTIVITY_REQUEST_CODE_PERMISSION_SETTING:
				String alertText = goAlertTitle();
				mPermissionAlert.setText(Html.fromHtml(alertText));
				//goStoreCameraPermission();
				break;
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		switch (requestCode) {
			case RequestPermissionCode:
				for (int i = 0; i < permissions.length; i++) {
					String permission = permissions[i];
					int grantResult = grantResults[i];
					if(permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)){
						if (grantResult == PackageManager.PERMISSION_GRANTED) {
							mPermissionReadExternalStorage = PackageManager.PERMISSION_GRANTED;
						}
						break;
					}
				}

				checkPermission();

				if(mPermissionReadExternalStorage == PackageManager.PERMISSION_GRANTED ){
					goLoading();
				}

				break;
			case RequestPermissionCodeSecond:
				for (int i = 0; i < permissions.length; i++) {
					String permission = permissions[i];
					int grantResult = grantResults[i];
					if(permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
						if (grantResult == PackageManager.PERMISSION_GRANTED) {
							mPermissionReadExternalStorage = PackageManager.PERMISSION_GRANTED;
						} else {
							if (mPermissionReadExternalStorage != PackageManager.PERMISSION_GRANTED && !ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
								goPermissionSetting();
							}
						}
						break;
					}
				}

				checkPermission();

				if(mPermissionReadExternalStorage == PackageManager.PERMISSION_GRANTED){
					goLoading();
				}

				break;
			case AppConstant.ACTIVITY_REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE_RE:
				for (int i = 0; i < permissions.length; i++) {
					String permission = permissions[i];
					int grantResult = grantResults[i];
					if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
						if (grantResult == PackageManager.PERMISSION_GRANTED) {
							mPermissionReadExternalStorage = PackageManager.PERMISSION_GRANTED;
						} else {

							if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
								goReadExternalStoragePermission();
							}else{
								isAskPermissionStorage = true;
								goPermissionSetting();
								break;
							}
						}
					}
				}
				break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		String alertText = goAlertTitle();
		mPermissionAlert.setText(Html.fromHtml(alertText));

		if(mPermissionReadExternalStorage == PackageManager.PERMISSION_GRANTED){
			goLoading();
		}

	}

}