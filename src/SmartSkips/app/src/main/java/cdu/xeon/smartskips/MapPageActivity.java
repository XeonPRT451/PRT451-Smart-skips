package cdu.xeon.smartskips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.MapView;

/**
 * Created by FlappyRex on 5/4/18.
 */

public class MapPageActivity extends LifecycleLoggingActivity{
private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mappage);

        mapView=findViewById(R.id.mapView1);
        mapView.setBackgroundColor(0000);

        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapPageActivity.this,SkipDetails.class));
            }
        });

    }
}
