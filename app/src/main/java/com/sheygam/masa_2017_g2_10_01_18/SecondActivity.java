package com.sheygam.masa_2017_g2_10_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = "";
        if(extras != null){
//            String name = extras.getString("NAME");
            name = extras.getString("NAME","empty");

        }

        String email = intent.getStringExtra("EMAIL");
        int age = intent.getIntExtra("AGE",-1);
        Log.d(TAG, "onCreate: " + name + " " + email + " " + age);

        Button finishBtn = findViewById(R.id.finish_btn);
        finishBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.finish_btn){
            Intent intent = new Intent();
            intent.putExtra("FIRST_NAME","data from second activity");
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
