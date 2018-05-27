package cdu.xeon.smartskips;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;

public class UserProfile extends LifecycleLoggingActivity {



    TextView nameTextView;
    TextView phoneTextView;
    TextView emailTextView;
    TextView statuTextView;
    ListView listView;
    ImageView Logo;
    private String[] mListTitle = { "Name:", "Phone:", "Email:", "Status:"};
    private String[] mListStr = new  String[4];
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);
        Driver driver = new Driver();
        driver = Repository.getDriverDetails(this);
        mListStr[0]=driver.getUsername();
        mListStr[1]=driver.getPhone();
        mListStr[2]=driver.getEmail();
        if (driver.getStatus()==1){
            mListStr[3]="online";
        }else {
            mListStr[3]="offline";
        }
       listView = (ListView) findViewById(R.id.lv);
       /* nameTextView=findViewById(R.id.nameTextView);
        phoneTextView=findViewById(R.id.phoneTextView);
        emailTextView=findViewById(R.id.emailTextView);
        statuTextView=findViewById(R.id.stautTextView);*/
        //Logo=findViewById(R.id.logoImageView);
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

        // 绑定数据源
        listView.setAdapter(adapter);


      /* nameTextView.setText(driver.getUsername());
        phoneTextView.setText(driver.getPhone());
        emailTextView.setText(driver.getEmail());
       if (driver.getStatus()==1){
           statuTextView.setText("working");
       }else {
           statuTextView.setText("rest");
       }*/


        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,MapPageActivity.class));
            }
        });
    }
}
