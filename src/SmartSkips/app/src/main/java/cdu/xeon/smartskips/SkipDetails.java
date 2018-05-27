package cdu.xeon.smartskips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

import java.util.ArrayList;

import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.repository.Repository;

public class SkipDetails extends AppCompatActivity {
    SmsManager smsManager = SmsManager.getDefault();
    String content = "Hello World!";
    ArrayList<String> list = smsManager.divideMessage(content);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_details);
        final Operator operator=Repository.getOperator(this,1).get(0);
        findViewById(R.id.SMSButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < list.size(); i++) {
                    smsManager.sendTextMessage(operator.getPhone(), null, list.get(i), null, null);
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

