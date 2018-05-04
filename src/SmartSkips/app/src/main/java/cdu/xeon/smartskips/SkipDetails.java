package cdu.xeon.smartskips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SkipDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_details);

        findViewById(R.id.userProfileButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SkipDetails.this,UserProfile.class );
                startActivity(intent);
                int version = Integer.valueOf(android.os.Build.VERSION.SDK);
                if(version >= 5) {
                    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                }
            }
        });

        findViewById(R.id.GoToMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SkipDetails.this,MapPageActivity.class );
                startActivity(intent);
                int version = Integer.valueOf(android.os.Build.VERSION.SDK);
                if(version >= 5) {
                    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                }
               // startActivity(new Intent(SkipDetails.this,MapPageActivity.class));
            }
        });
    }
}

