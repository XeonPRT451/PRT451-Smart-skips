package cdu.xeon.smartskips;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;

public class UserProfile extends LifecycleLoggingActivity {



    TextView nameTextView;
    TextView phoneTextView;
    TextView emailTextView;
    TextView statuTextView;
    ImageView Logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);
        Driver driver = new Driver();
        driver=Repository.getDriverDetails(this);
        nameTextView=findViewById(R.id.nameTextView);
        phoneTextView=findViewById(R.id.phoneTextView);
        emailTextView=findViewById(R.id.emailTextView);
        statuTextView=findViewById(R.id.stautTextView);
        //Logo=findViewById(R.id.logoImageView);
       nameTextView.setText(driver.getUsername());
        phoneTextView.setText(driver.getPhone());
        emailTextView.setText(driver.getEmail());
       if (driver.getStatus()==1){
           statuTextView.setText("working");
       }else {
           statuTextView.setText("rest");
       }


        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,MapPageActivity.class));
            }
        });
    }
}
