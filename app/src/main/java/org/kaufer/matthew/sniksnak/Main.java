package org.kaufer.matthew.sniksnak;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;


public class Main extends Activity {
    Firebase sniks;
    private Location lastLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        sniks = new Firebase("https://sniksnak.firebaseio.com/").child("sniks");
        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sniks.push().setValue(new Snik(new double[]{Math.random() * 100, Math.random() * 100}, "http://google.com","Hello World").toHashMap());
            }
        });

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                lastLocation = location;
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

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