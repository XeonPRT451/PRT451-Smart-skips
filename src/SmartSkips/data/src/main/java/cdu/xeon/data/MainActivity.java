package cdu.xeon.data;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;


public class MainActivity extends AppCompatActivity {




    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        if(isServiceOK()){
//            init();
//        }
        Driver d= Repository.getDriverDetails();
    }

//    private void init(){
//        Button btnMap = (Button) findViewById(R.id.btnMap);
//        btnMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MapActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

//    public boolean isServiceOK(){
//        Log.d(TAG,"isServicesOK: checking google services version");
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
//        Dialog dialogtest= GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
//        dialogtest.show();
//
//        if(available == ConnectionResult.SUCCESS) {
//            //user can make request
//            Log.d(TAG, "isServicesOK: Google Play Services is working");
//            return true;
//        }
//        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
//            //occured errors can be resolved
//            Log.d(TAG, "isServicesOK: an error occured but we can fix this");
//            Dialog dialog= GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        }else{
//            Toast.makeText(this, " map request cannot be made",Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
}
