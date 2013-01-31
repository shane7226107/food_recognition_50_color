package org.apache.cordova.plugin;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.widget.Toast;


/**
 * This class echoes a string called from JavaScript.
 */
public class Echo extends Plugin {

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action        The action to execute.
     * @param args          JSONArry of arguments for the plugin.
     * @param callbackId    The callback id used when calling back into JavaScript.
     * @return              A PluginResult object with a status and message.
     */
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        try {
            if (action.equals("echo")) {
            	//get the first input argument
                String echo = args.getString(0); 
                if (echo != null && echo.length() > 0) {
                	//image processing
                	imageProcessing();
                	//return plugin status and first input argument
                    return new PluginResult(PluginResult.Status.OK, echo);
                } else {
                    return new PluginResult(PluginResult.Status.ERROR);
                }
            } else {
                return new PluginResult(PluginResult.Status.INVALID_ACTION);
            }
        } catch (JSONException e) {
            return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
        }
    }
    
    /*Image Processing*/
    public void imageProcessing(){
    	    	
    	//Load image by BitmapFactory
    	//Bitmap src = BitmapFactory.decodeFile("/sdcard/ntufrs/tmp.jpg");
    	Bitmap src = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getAbsolutePath()+"/ntufrs/tmp.jpg");
    	Bitmap dst;
    	
    	//Make a mutable copy
    	//First thing is to made a scale copy, avoiding memory leak
    	if(src.getHeight() > 300 && src.getWidth() > 300){
    		float dstHeight = (float)src.getHeight()*((float)300/(float)src.getWidth());
        	
        	dst = Bitmap.createScaledBitmap(src, 300, (int)dstHeight, false);
        	dst = dst.copy(Bitmap.Config.ARGB_8888, true);
        	
    	}else{
    		
    		dst = src.copy(Bitmap.Config.ARGB_8888, true);
    		
    	}
    	        
        //Manipulate
    	for (int y=0 ; y < dst.getHeight() ; y ++){
    		for(int x = 0 ; x < dst.getWidth() ; x++){
    			//dst.setPixel(x, y, Color.RED);
    		}    		
    	}
    	
    	//Save file
    	String Hist = "123";
    	try{
    		byte buf[] = Hist.getBytes();
    		//可以這樣前後class不一樣嗎?
    		FileOutputStream f0 = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+"/ntufrs/RGB_feature.txt"); 
    		
    		for (int i=0; i < buf.length; i ++) { 
    			f0.write(buf[i]); 
    		}
    		
    		f0.close();
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();

    	}
    	
        //Save image
        try {
        	
            //FileOutputStream out = new FileOutputStream("/sdcard/ntufrs/tmp.jpg");
        	//FileOutputStream out = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+"/ntufrs/tmp.jpg");
            //dst.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
        
    	
    }
}
