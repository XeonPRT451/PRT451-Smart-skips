package cdu.xeon.smartskips;

import android.app.ListActivity;
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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;

import cdu.xeon.smartskips.LifecycleLoggingActivity;
import cdu.xeon.smartskips.R;

public class Test extends ListActivity {
    private String[] mListTitle = { "姓名", "性别", "年龄", "居住地","邮箱"};
    private String[] mListStr = { "雨松MOMO", "男", "25", "北京",
            "xuanyusong@gmail.com" };
    ListView mListView = null;
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mListView = getListView();

        int lengh = mListTitle.length;
        for(int i =0; i < lengh; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            //item.put("image", R.drawable.jay);
            item.put("title", mListTitle[i]);
            item.put("text", mListStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,R.layout.item,
                new String[]{"title","text"},new int[]{R.id.image,R.id.title,R.id.text});
        setListAdapter(adapter);

        super.onCreate(savedInstanceState);
    }
}