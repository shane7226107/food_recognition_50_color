package csie.ntu.foodRec.client;

import java.io.FileOutputStream;

import org.apache.cordova.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;


public class FoodRecognition extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setStringProperty("loadingDialog", "Loading...");
        
        super.loadUrl("file:///android_asset/www/index.html");
    }

    
}
