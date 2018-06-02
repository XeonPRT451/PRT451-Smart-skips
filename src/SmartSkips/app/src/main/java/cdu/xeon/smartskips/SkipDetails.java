package cdu.xeon.smartskips;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.repository.Repository;

public class SkipDetails extends LifecycleLoggingActivity {
    TextView skipID;
    public static SkipDetails instance;
    Button eptButton;
    SmsManager smsManager = SmsManager.getDefault();
    String content = "Hello World!";
    ArrayList<String> list = smsManager.divideMessage(content);
    private String[] mListTitle = { "ID:", "Status", "Location:"};
    private String[] mListStr = new  String[3];
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();;
    ListView listView;
    int id=1;
   Skip aSkip=new Skip();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_details);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        instance=this;
        listView=findViewById(R.id.skipList);
      Bundle bundle=getIntent().getBundleExtra("bundle");
      String ID=bundle.getString("ID");
      ;ID=ID.substring(4);
     id=Integer.parseInt(ID)-1;
      //System.out.println(ID.substring(4));

         Skip skip=Repository.getSkip(SkipDetails.this).get(id);
         aSkip=skip;
               // System.out.println(id););
        mListStr[0]=ID;
       if(skip.getFull()==1){
           mListStr[1]="Full";
       }else {
           mListStr[1]="Empty";
       }
        mListStr[2]=skip.getLocation();

        int lengh = mListTitle.length;
        for (int i = 0; i < lengh; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            //item.put("image", R.drawable.jay);
            item.put("title", mListTitle[i]);
            item.put("text", mListStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,R.layout.item,
                new String[]{"image","title","text"},new int[]{R.id.image,R.id.title,R.id.text});
                 listView.setAdapter(adapter);

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
                SkipDetails.instance.finish();

                int version = Integer.valueOf(android.os.Build.VERSION.SDK);
                if(version >= 5) {
                    overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                }
               // startActivity(new Intent(SkipDetails.this,MapPageActivity.class));
            }
        });

        eptButton=findViewById(R.id.empertyBtn);
        if (aSkip.getFull()==0){
            eptButton.setEnabled(false);
        }
        findViewById(R.id.empertyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Driver driver=new Driver();
                //MapPageActivity.instance.finish();
   driver=Repository.getDriverDetails(SkipDetails.this,1);
                Repository.pickupSkip(SkipDetails.this,driver.getId(),aSkip.getId());

                Intent intent=new Intent(SkipDetails.this, MapPageActivity.class);
                Skip skip2=aSkip;
                Bundle bundle=new Bundle();
                bundle.putDouble("lan",skip2.getLatitude());
                bundle.putDouble("lon",skip2.getLongitude());
                intent.putExtra("location",bundle);

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

