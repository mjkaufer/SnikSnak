package org.kaufer.matthew.sniksnak;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;


public class Main extends Activity {
    Firebase sniks;
    private Location lastLocation;
    private Camera camera;
    private ImageView imgView;
    AsyncHttpClient client = new AsyncHttpClient();
    TextView t;
    EditText et;

    private boolean safeToTakePicture = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        sniks = new Firebase("https://sniksnak.firebaseio.com/").child("sniks");
        Button b = (Button)findViewById(R.id.button);
        Button c = (Button)findViewById(R.id.button2);
        t = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        camera = Camera.open(0);
        Camera.CameraInfo ci = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(0, ci);
        System.out.println();
        System.out.print(camera);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                camera.stopPreview();
//                camera.startPreview();
//                camera.takePicture(null, null, new Camera.PictureCallback() {
//                    @Override
//                    public void onPictureTaken(byte[] bytes, Camera camera) {
//                        try {
//                            Bitmap bMap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);//turns taken picture into bitmap
//                            imgView.setImageBitmap(bMap);//sets the image of imgView to the freshly taken image
//                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                            bMap.compress(Bitmap.CompressFormat.PNG, 100, baos); // Not sure whether this should be jpeg or png, try both and see which works best
//                            String url = "https://api.imgur.com/3/upload.json";
//                            String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encode(baos.toByteArray(), Base64.DEFAULT).toString(), "UTF-8");
//                            data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("da9f0c5a31cf2a6", "UTF-8");
//                            String actualUrl = url + "?" + data;
//                            client.post(actualUrl, null, new JsonHttpResponseHandler(){
//                                public void onSuccess(int status, Header[] headers, String response){
//                                    System.out.println(response);
//                                    t.setText(response);
//                                }
//
//                                public void onFailure(int status, Header[] headers, String response){
//                                    System.out.println(response);
//                                    t.setText(response);
//                                }
//                            });
//
//
//                        } catch(Exception e){
//                            System.out.println("You messed up");
//                        }
//                    }
//                });
                //we're not going to do images because it's not fun...
//                camera.stopPreview();

                sniks.push().setValue(new Snik(new double[]{Math.random() * 100, Math.random() * 100}, "http://google.com",et.getText().toString()).toHashMap());


            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sniks.push().setValue(new Snik(new double[]{Math.random() * 100, Math.random() * 100}, "http://google.com","Hello World").toHashMap());
            }
        });

//        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//
//        LocationListener locationListener = new LocationListener() {
//            public void onLocationChanged(Location location) {
//                // Called when a new location is found by the network location provider.
//                lastLocation = location;
//            }
//
//            public void onStatusChanged(String provider, int status, Bundle extras) {}
//
//            public void onProviderEnabled(String provider) {}
//
//            public void onProviderDisabled(String provider) {}
//        };
//
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//        lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        //lastLocation is coordinate in Location form - if null, we haven't found a location yet
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
/*

database setup

[
	{
		location: lat,long
		image: url
		text: text
		score:x

par	}
]
 */