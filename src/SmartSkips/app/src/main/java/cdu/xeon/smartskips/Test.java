package cdu.xeon.smartskips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import cdu.xeon.smartskips.LifecycleLoggingActivity;
import cdu.xeon.smartskips.R;

public class Test extends LifecycleLoggingActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
