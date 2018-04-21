package cdu.xeon.smartskips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserProfile extends LifecycleLoggingActivity {

    TextView nameTextView;
    TextView phoneTextView;
    TextView emailTextView;
    TextView statuTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);
        nameTextView=findViewById(R.id.nameTextView);
        phoneTextView=findViewById(R.id.phoneTextView);
        emailTextView=findViewById(R.id.emailTextView);
        statuTextView=findViewById(R.id.stautTextView);

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,MapPageActivity.class));
            }
        });
    }
}
