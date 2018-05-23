package cdu.xeon.smartskips;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



//public class MapPageActivity extends AppCompatActivity implements OnMapReadyCallback{
//
//    // initialisation of the variables
//    private MapView mapView;
//    private static final String TAG = "MapActivity";
//    private static final int ERROR_DIALOG_REQUEST = 9001;
//    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
//    private static final float DEFAULT_ZOOM = 15f;
//    private static final int LOCATION_REQUEST = 500;
//    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
//    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
//    private FusedLocationProviderClient mFusedLocationProviderClient;
//
//    //variables for checking for permission
//    private Boolean mLocationPermissionsGranted = false;
//    private GoogleMap mMap;
//
////     on creating the application
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mappage);
//
//        // Construct a FusedLocationProviderClient.
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//
////        if(isServiceOK()){
////            init();
////        }
//        getLocationPermission();
////        updateLocationUI();
//
//        mapView=findViewById(R.id.mapView1);
//        mapView.setBackgroundColor(0000);
//
//        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MapPageActivity.this,SkipDetails.class));
//            }
//        });
//        findViewById(R.id.userProfileButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(MapPageActivity.this,UserProfile.class );
//                startActivity(intent);
//                int version = Integer.valueOf(android.os.Build.VERSION.SDK);
//                if(version >= 5) {
//                    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
//                }
//            }
//        });
//    }

//preparing the map
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onMapReady: map is ready");
//        mMap = googleMap;
//
////        List<Skip> ss=Repository.getSkip(getApplicationContext());
////          String first = ss.get(1).getName();
//
//        if (mLocationPermissionsGranted) {
//            getDeviceLocation();
////            getGeolocation();
//
//            String skip6N = Repository.getSkip(this).get(5).getName();
//            double lat6 = Repository.getSkip(this).get(5).getLatitude();
//            double lng6 = Repository.getSkip(this).get(5).getLongitude();
//
////            lat6 = (-12.366347);
//////            lng6 =(130.877126);
//
//            LatLng skip6L = new LatLng(lat6, lng6);
//            mMap.addMarker(new MarkerOptions().position(skip6L)
//                    .title(skip6N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip6L));
//
//
//
//            String skip5N = Repository.getSkip(this).get(4).getName();
//            double lat5 = Repository.getSkip(this).get(4).getLatitude();
//            double lng5 = Repository.getSkip(this).get(4).getLongitude();
//            LatLng skip5L = new LatLng(lat5, lng5);
//            mMap.addMarker(new MarkerOptions().position(skip5L)
//                    .title(skip5N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip5L));
//
//
//            String skip4N = Repository.getSkip(this).get(3).getName();
//            double lat4 = Repository.getSkip(this).get(3).getLatitude();
//            double lng4 = Repository.getSkip(this).get(3).getLongitude();
//            LatLng skip4L = new LatLng(lat4, lng4);
//            mMap.addMarker(new MarkerOptions().position(skip4L)
//                    .title(skip4N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip4L));
//
//
//
//            String skip3N = Repository.getSkip(this).get(2).getName();
//            double lat3 = Repository.getSkip(this).get(2).getLatitude();
//            double lng3 = Repository.getSkip(this).get(2).getLongitude();
//            LatLng skip3L = new LatLng(lat3, lng3);
//            mMap.addMarker(new MarkerOptions().position(skip3L)
//                    .title(skip3N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip3L));
//
//
//
//            String skip2N = Repository.getSkip(this).get(1).getName();
//            double lat2 = Repository.getSkip(this).get(1).getLatitude();
//            double lng2 = Repository.getSkip(this).get(1).getLongitude();
//            LatLng skip2L = new LatLng(lat2, lng2);
//            mMap.addMarker(new MarkerOptions().position(skip2L)
//                    .title(skip2N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2L));
//
//
//            String skip1N = Repository.getSkip(this).get(0).getName();
//            double lat1 = Repository.getSkip(this).get(0).getLatitude();
//            double lng1 = Repository.getSkip(this).get(0).getLongitude();
//            LatLng skip1L = new LatLng(lat1, lng1);
//            mMap.addMarker(new MarkerOptions().position(skip1L)
//                    .title(skip1N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip1L));
//
//
//
//
////            LatLng skip2 = new LatLng(-12.366347, 130.877126);
////            mMap.addMarker(new MarkerOptions().position(skip2)
////                    .title("Skip 2"));
////            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2));
//
//
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            mMap.setMyLocationEnabled(true);
//            mMap.getUiSettings().setMyLocationButtonEnabled(true);
//            mMap.getUiSettings().isMapToolbarEnabled();
//            mMap.getUiSettings().setScrollGesturesEnabled(true);
//            mMap.getUiSettings().isRotateGesturesEnabled();
//            mMap.getUiSettings().setZoomControlsEnabled(true);
//            mMap.getUiSettings().setMyLocationButtonEnabled(true);
//            updateLocationUI();
//
//        }
//    }
//
//        public void getGeolocation() {
//
////            // initialize and set skip location
//            String skip6N = Repository.getSkip(this).get(5).getName();
//            double lat = Repository.getSkip(this).get(5).getLatitude();
//            double lng = Repository.getSkip(this).get(5).getLongitude();
//
//            LatLng skip6L = new LatLng(lat, lng);
//            mMap.addMarker(new MarkerOptions().position(skip6L)
//                    .title(skip6N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip6L));
//
//
//        }
////
//    // getting device's location
//    private void getDeviceLocation(){
//        Log.d(TAG, "getDeviceLocation: getting the devices current location");
//
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//
//        try{
//            if(mLocationPermissionsGranted){
//
//                final Task location = mFusedLocationProviderClient.getLastLocation();
//                location.addOnCompleteListener(new OnCompleteListener() {
//                    @Override
//                    public void onComplete(@NonNull Task task) {
//                        if(task.isSuccessful()){
//                            Log.d(TAG, "onComplete: found location!");
//                            Location currentLocation = (Location) task.getResult();
//
//                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
//                                    DEFAULT_ZOOM,
//                                    "Driver Location");
//
//                        }else{
//                            Log.d(TAG, "onComplete: current location is null");
//                            Toast.makeText(MapPageActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        }catch (SecurityException e){
//            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
//        }
//    }
//
////    //camera movement
//    private void moveCamera(LatLng latLng, float zoom, String title){
//        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
//
//        if(!title.equals("My Location")){
//            MarkerOptions options = new MarkerOptions()
//                    .position(latLng)
//                    .title(title);
//            mMap.addMarker(options);
//        }
//    }
////updating location
//    private void updateLocationUI() {
//        if (mMap == null) {
//            return;
//        }
//        try {
//            if (mLocationPermissionsGranted) {
//                mMap.setMyLocationEnabled(true);
//                mMap.getUiSettings().setMyLocationButtonEnabled(true);
//            } else {
//                mMap.setMyLocationEnabled(false);
//                mMap.getUiSettings().setMyLocationButtonEnabled(false);
////
//                Task mLastKnownLocation = mFusedLocationProviderClient.getLastLocation();
//                mLastKnownLocation = null;
//                getLocationPermission();
//            }
//        } catch (SecurityException e)  {
//            Log.e("Exception: %s", e.getMessage());
//        }
//    }
//
////    //initialisation process
////    private void init(){
////        Button btnMap = (Button) findViewById(R.id.btnMap);
////        btnMap.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(MapPageActivity.this, MapPageActivity.class);
////                startActivity(intent);
////            }
////        });
////    }
//
//    private void initMap(){
//        Log.d(TAG, "initMap: initializing map");
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(MapPageActivity.this);
//    }
//
////     enabling all services and requesting permission
////     checking if the services are enabled
//    public boolean isServiceOK(){
//        Log.d(TAG,"isServicesOK: checking google services version");
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapPageActivity.this);
//
//        if(available == ConnectionResult.SUCCESS) {
//            //user can make request
//            Log.d(TAG, "isServicesOK: Google Play Services is working");
//            return true;
//        }
//        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
//            //occured errors can be resolved
//            Log.d(TAG, "isServicesOK: an error occured but we can fix this");
//            Dialog dialog= GoogleApiAvailability.getInstance().getErrorDialog(MapPageActivity.this, available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        }else{
//            Toast.makeText(this, " map request cannot be made",Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//    // checking the location permission
//    private void getLocationPermission(){
//        Log.d(TAG, "getLocationPermission: getting location permissions");
//        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION};
//
//        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//                mLocationPermissionsGranted = true;
//                initMap();
//            }else{
//                ActivityCompat.requestPermissions(this,
//                        permissions,
//                        LOCATION_PERMISSION_REQUEST_CODE);
//            }
//        }else{
//            ActivityCompat.requestPermissions(this,
//                    permissions,
//                    LOCATION_PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    public void onRequestPermissionsResults(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case LOCATION_REQUEST:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    mMap.setMyLocationEnabled(true);
//                }
//                break;
//        }
//        initMap();
//    }
//
//    //requesting permission on result
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        Log.d(TAG, "onRequestPermissionsResult: called.");
//        mLocationPermissionsGranted = false;
//
//        switch(requestCode){
//            case LOCATION_PERMISSION_REQUEST_CODE:{
//                if(grantResults.length > 0){
//                    for(int i = 0; i < grantResults.length; i++){
//                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
//                            mLocationPermissionsGranted = false;
//                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
//                            return;
//                        }
//                       break;
//                    }
//                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
//                    mLocationPermissionsGranted = true;
//                    //initialize our map
//                    initMap();
//                }
//            }
//        }
//    }
//}





















public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int LOCATION_REQUEST = 500;
    ArrayList<LatLng> listPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mappage);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        listPoints = new ArrayList<>();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }

        LatLng skip1 = new LatLng(-12.374196, 130.868760);
            mMap.addMarker(new MarkerOptions().position(skip1)
                    .title("skip 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip1));

            LatLng skip2 = new LatLng(-12.366347, 130.877126);
            mMap.addMarker(new MarkerOptions().position(skip2)
                    .title("Skip 2"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2));


        LatLng skip3 = new LatLng(-11.366347, 130.877126);
        mMap.addMarker(new MarkerOptions().position(skip2)
                .title("Skip 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2));


        mMap.setMyLocationEnabled(true);
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                //Reset marker when already 2
                if (listPoints.size() == 2) {
                    listPoints.clear();
                    mMap.clear();
                }
                //Save first point select
                listPoints.add(latLng);
                //Create marker
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);

                if (listPoints.size() == 1) {
                    //Add first marker to the map
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                } else {
                    //Add second marker to the map
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                }
                mMap.addMarker(markerOptions);

                if (listPoints.size() == 2) {
                    //Create the URL to get request from first marker to second marker
                    String url = getRequestUrl(listPoints.get(0), listPoints.get(1));
                    TaskRequestDirections taskRequestDirections = new TaskRequestDirections();
                    taskRequestDirections.execute(url);
                }
            }
        });

    }

    private String getRequestUrl(LatLng origin, LatLng dest) {
        //Value of origin
        String str_org = "origin=" + origin.latitude +","+origin.longitude;
        //Value of destination
        String str_dest = "destination=" + dest.latitude+","+dest.longitude;
        //Set value enable the sensor
        String sensor = "sensor=false";
        //Mode for find direction
        String mode = "mode=driving";
        //Build the full param
        String param = str_org +"&" + str_dest + "&" +sensor+"&" +mode;
        //Output format
        String output = "json";
        //Create url to request
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + param;
        return url;
    }

    private String requestDirection(String reqUrl) throws IOException {
        String responseString = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try{
            URL url = new URL(reqUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            //Get the response result
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            responseString = stringBuffer.toString();
            bufferedReader.close();
            inputStreamReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            httpURLConnection.disconnect();
        }
        return responseString;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                }
                break;
        }
    }

    public class TaskRequestDirections extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String responseString = "";
            try {
                responseString = requestDirection(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  responseString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Parse json here
            TaskParser taskParser = new TaskParser();
            taskParser.execute(s);
        }
    }

    public class TaskParser extends AsyncTask<String, Void, List<List<HashMap<String, String>>> > {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... strings) {
            JSONObject jsonObject = null;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jsonObject = new JSONObject(strings[0]);
                DirectionParser directionsParser = new DirectionParser();
                routes = directionsParser.parse(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> lists) {
            //Get list route and display it into the map

            ArrayList points = null;

            PolylineOptions polylineOptions = null;

            for (List<HashMap<String, String>> path : lists) {
                points = new ArrayList();
                polylineOptions = new PolylineOptions();

                for (HashMap<String, String> point : path) {
                    double lat = Double.parseDouble(point.get("lat"));
                    double lon = Double.parseDouble(point.get("lon"));

                    points.add(new LatLng(lat,lon));
                }

                polylineOptions.addAll(points);
                polylineOptions.width(15);
                polylineOptions.color(Color.BLUE);
                polylineOptions.geodesic(true);
            }

            if (polylineOptions!=null) {
                mMap.addPolyline(polylineOptions);
            } else {
                Toast.makeText(getApplicationContext(), "Direction not found!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}







