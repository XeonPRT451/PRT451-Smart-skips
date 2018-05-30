package cdu.xeon.smartskips;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
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


    private int LOGIN_CHANCES = 3;
    //还剩几次登录机会的标志，初始值就是LOGIN_CHANCES
    private int count = LOGIN_CHANCES;
    private float WAIT_TIME = 30000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        userNameEditText=findViewById(R.id.nameEditText);
        passWordEditText=findViewById(R.id.passwordEditText);
        reminder=findViewById(R.id.remindTextView);




        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);

                //输入错误时的时间,如果为空的话就取0L
                long errorTime = sp.getLong("errorTime", 0L);
                //获取当前时间
                long recentTime = System.currentTimeMillis();

                if(recentTime - errorTime > WAIT_TIME) {

                    if (userNameEditText.getText().toString().trim().equals("") ||passWordEditText.getText().toString().trim().equals("") ){
                        Toast.makeText(getApplicationContext(), "Please Input Username or Password！", Toast.LENGTH_LONG).show();
                    }else {
                        driver = Repository.login(Login.this,userNameEditText.getText().toString(),passWordEditText.getText().toString());

                        if ( driver==null) {
                            count--;
                            Toast.makeText(Login.this, "you have" + " " + count + " " + "chance left！", Toast.LENGTH_LONG).show();
                            // reminder.setText("Login Fail");
                            if (count == 0) {
                                Toast.makeText(Login.this, "continue" + LOGIN_CHANCES + "times loginfail，pleas wait" + WAIT_TIME / 1000 + "s！", Toast.LENGTH_LONG).show();
                                count = LOGIN_CHANCES;
                                errorTime = System.currentTimeMillis();
                                SharedPreferences sp1 = getSharedPreferences("data", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp1.edit();
                                editor.putLong("errorTime", errorTime);
                                editor.commit();
                            }

                        } else {
                            Intent intent = new Intent();
                            Bundle bundle= new Bundle();
                            bundle.putString("name",driver.getUsername());
                            bundle.putString("phone",driver.getPhone());
                            bundle.putString("email",driver.getEmail());
                            bundle.putInt("status",driver.getStatus());
                            bundle.putInt("id",driver.getId());
                            intent.putExtra("bundle",bundle);
                            intent.setClass(Login.this, UserProfile.class);
                            startActivity(intent);
                            int version = Integer.valueOf(android.os.Build.VERSION.SDK);
                            if (version >= 5) {
                                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                            }
                        }
                    }
                }
            }
        });
   }
}
