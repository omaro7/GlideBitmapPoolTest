package kr.co.goms.glidebitmappooltest;

import android.os.Environment;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

	/* App Name */
	public final static String APP_NAME = "GomsCamera";
	public final static String APP_HEADER_TITLE = "GomsCamera";

	// SD card image directory
	public static final String PHOTO_ALBUM_NAME = "StoreCamera";
	public static final String PHOTO_ALBUM_IMAGE = "StoreCameraPhoto";
	public static final String PHOTO_ALBUM_MOVIE = "StoreCameraMovie";
	public static final String PHOTO_ALBUM_TEMP = "StoreCameraTemp";
	public static final String SAVE_FOLD_NAME = "/StoreCamera/";
	public static final String SAVE_TEMP_FOLD_NAME =  SAVE_FOLD_NAME + PHOTO_ALBUM_TEMP;
	public static final String SAVE_IMAGE_FOLD_NAME =  SAVE_FOLD_NAME + PHOTO_ALBUM_IMAGE;
	public static final String SAVE_MOVIE_FOLD_NAME =  SAVE_FOLD_NAME + PHOTO_ALBUM_MOVIE;
	public static final String SAVE_GPUIMAGE_FOLD_NAME =  "/StoreCamera/StoreCameraPhoto";
	public static final String FULL_SAVE_IMAGE_FOLD_NAME = Environment.getExternalStorageDirectory().getAbsolutePath() + SAVE_IMAGE_FOLD_NAME;
	public static final String FULL_SAVE_MOVIE_FOLD_NAME = Environment.getExternalStorageDirectory().getAbsolutePath() + SAVE_MOVIE_FOLD_NAME;
	public static final String FULL_SAVE_TEMP_FOLD_NAME = Environment.getExternalStorageDirectory().getAbsolutePath() + SAVE_TEMP_FOLD_NAME;

	public static final int REQUEST_SUCCESS 					= 200;
	public static final int REQUEST_ERROR_PARAM   			= 201;
	public static final int REQUEST_ALREADY_DATA			= 301;
	public static final int REQUEST_MEMBER_NICKNAME_ALREADY_DATA			= 303;
	public static final int REQUEST_MEMBER_NOT			= 305;
	public static final int REQUEST_MEMBER_NOT_PWD			= 306;
	public static final int REQUEST_IMAGE_UPLOAD_FAIL = 701;
	public static final int REQUEST_IMAGE_ALREADY_DATA	= 800;
	public static final int REQUEST_FAILURE						= 999;

	public static final int RC_REQUEST = 10001;

	//Activity Request Code
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_CAMERA						= 400;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_CAMERA_RE					= 4009;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_READ_PHONE_STATE			= 401;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_READ_PHONE_STATE_RE		= 4019;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE		= 402;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_READ_EXTERNAL_STORAGE_RE	= 4029;
	public static final int ACTIVITY_REQUEST_CODE_PERMISSION_SETTING				= 403;

	public static final int ACTIVITY_REQUEST_CODE_CAMERA_BASE	= 502;
	public static final int ACTIVITY_REQUEST_CODE_CAMERA_TITLE	= 503;
	public static final int ACTIVITY_REQUEST_CODE_MACRO			= 504;
	public static final int ACTIVITY_REQUEST_CODE_WEB_PAGE		= 511;
	public static final int ACTIVITY_REQUEST_CODE_PHOTOPREVIEW	= 519;
	public static final int ACTIVITY_REQUEST_CODE_PHOTOWRITE	= 520;
	public static final int ACTIVITY_REQUEST_CODE_MAIN			= 521;
	public static final int ACTIVITY_REQUEST_CODE_PC_FORM		= 530;
	public static final int ACTIVITY_REQUEST_CODE_PC_LOGIN		= 531;
	public static final int ACTIVITY_REQUEST_CODE_PC_CONNECT	= 532;
	public static final int ACTIVITY_REQUEST_CODE_SEND_TO_SETTING	= 533;	//보내기에서 환경설정으로

	public static final int ACTIVITY_REQUEST_CODE_LOCALPHOTO_PHOTO	= 550;
	public static final int ACTIVITY_REQUEST_CODE_LOCALPHOTO_CAMERA	= 551;
	public static final int ACTIVITY_REQUEST_CODE_LOCALPHOTO_CROP	= 552;
	public static final int ACTIVITY_REQUEST_CODE_EXTERNAL_GALLERY_DETAIL	= 553;

	public static final int ACTIVITY_REQUEST_CODE_GALLERY_PHOTO	= 606;
	public static final int ACTIVITY_REQUEST_CODE_GALLERY_PIC_CROP= 607;

	public static final int ACTIVITY_REQUEST_CODE_WEBVIEW_COMMON = 700;

	public static final int ACTIVITY_RESULT_CODE_MACRO			= 801;

	public static final int ACTIVITY_REQUEST_CODE_FINISH_AD = 9991;	//종료

	public static final int WEBVIEW_COMMON_URL		= 100;

	public static final String DEVICE_MAKE_HUAWEI 	= "HUAWEI";
	public static final String DEVICE_MAKE_LGE 		= "LGE";
	public static final String DEVICE_MAKE_XIAOMI 	= "Xiaomi";
	public static final String DEVICE_MAKE_VU2 		= "LG-F200K";
	public static final String DEVICE_MAKE_PRIORI	= "Plus One Japan Limited";
	public static final String DEVICE_MAKE_KYOCERA	= "KYOCERA";
	public static final String DEVICE_MAKE_PANTECH	= "PANTECH";
	public static final String DEVICE_MAKE_SHARP	= "SHARP";
	public static final String DEVICE_MAKE_TELECA	= "Symphony Teleca";



}