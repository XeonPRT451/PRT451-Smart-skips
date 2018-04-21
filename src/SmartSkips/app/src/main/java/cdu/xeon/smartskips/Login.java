package cdu.xeon.smartskips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends LifecycleLoggingActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(Login.this,UserProfile.class));
            }
        });
   }
}
