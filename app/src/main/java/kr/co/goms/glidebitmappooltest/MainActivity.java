package kr.co.goms.glidebitmappooltest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.glidebitmappool.GlideBitmapFactory;
import com.glidebitmappool.GlideBitmapPool;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int mWidth;
    private int mHeight;
    public static Bitmap mFileBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileFullPath = AppConstant.FULL_SAVE_IMAGE_FOLD_NAME  + File.separator + "storecamera_20170612164120_0.jpg"; //1440x1920
        //fileFullPath = AppConstant.FULL_SAVE_IMAGE_FOLD_NAME  + File.separator + "storecamera_20170626174825_0.jpg";
        //fileFullPath = Environment.getExternalStorageDirectory().getAbsolutePath()  + File.separator + "/DCIM/Screenshots/Screenshot_20170711-150851.png";
        //fileFullPath = Environment.getExternalStorageDirectory().getAbsolutePath()  + File.separator + "/DCIM/Camera/20170911_154859.jpg";
        //fileFullPath = Environment.getExternalStorageDirectory().getAbsolutePath()  + File.separator + "/DCIM/Camera/20170914_132207.jpg";

        mWidth = 1440;
        mHeight = 1920;

        File file = new File(fileFullPath);
        mFileBitmap = GlideBitmapFactory.decodeFile(fileFullPath);

        ImageView ivOrg = findViewById(R.id.iv_org);
        ImageView ivEffect = findViewById(R.id.iv_effect);

        Bitmap bitmap = GlideBitmapPool.getBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        ivOrg.setImageBitmap(mFileBitmap);

        bitmap = mFileBitmap.copy(mFileBitmap.getConfig(), true);
        ivEffect.setImageBitmap(bitmap);

    }
}
