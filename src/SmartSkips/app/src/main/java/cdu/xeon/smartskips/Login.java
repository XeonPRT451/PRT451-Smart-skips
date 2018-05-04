package cdu.xeon.smartskips;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;

public class Login extends LifecycleLoggingActivity  {
EditText userNameEditText;
EditText passWordEditText;
TextView reminder;
Driver driver= new Driver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEditText=findViewById(R.id.nameEditText);
        passWordEditText=findViewById(R.id.passwordEditText);
        reminder=findViewById(R.id.remindTextView);




        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                driver = Repository.login(getApplicationContext(),userNameEditText.getText().toString(),passWordEditText.getText().toString());
                if (driver==null){
                    Toast toast=Toast.makeText(Login.this, "Username or Password Wrong!!", Toast.LENGTH_SHORT);
                    toast.show();
                   // reminder.setText("Login Fail");
                }else {
                        Intent intent = new Intent();
                        intent.setClass(Login.this,UserProfile.class );
                        startActivity(intent);
                        int version = Integer.valueOf(android.os.Build.VERSION.SDK);
                        if(version >= 5) {
                            overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                    }
                }
            }
        });
   }
}
