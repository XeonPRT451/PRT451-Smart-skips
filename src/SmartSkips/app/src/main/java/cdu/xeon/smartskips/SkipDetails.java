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


        findViewById(R.id.GoToMap).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(SkipDetails.this,MapPageActivity.class));
            }
        });
    }
}

