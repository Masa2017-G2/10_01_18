package com.sheygam.masa_2017_g2_10_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MY_TAG";
    private EditText inputName, inputEmail;
    private TextView nameTxt, emailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myBtn = findViewById(R.id.my_btn);
        Button mySecondBtn  = findViewById(R.id.my_second_btn);
        mySecondBtn.setOnClickListener(this);

        Button okBtn = findViewById(R.id.ok_btn);
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        nameTxt = findViewById(R.id.name_txt);
        emailTxt = findViewById(R.id.email_txt);


        okBtn.setOnClickListener(this);

        Button nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
    }

    public void myClick(View v){
        Log.d("MY_TAG","Was clicked my btn");
        Log.d(TAG, "myClick: test");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.my_second_btn){
            Toast.makeText(this, "Was clicket btn", Toast.LENGTH_SHORT).show();
        }else if(v.getId()  == R.id.ok_btn){
            String name = inputName.getText().toString();
            String email = inputEmail.getText().toString();
            nameTxt.setText(name);
            emailTxt.setText(email);
        }else if(v.getId() == R.id.next_btn){
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("NAME","Vasya");
            intent.putExtra("EMAIL","vasya@mail.com");
            intent.putExtra("AGE",27);
//            startActivity(intent);
            startActivityForResult(intent,1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                String name = data.getStringExtra("FIRST_NAME");
                Log.d(TAG, "onActivityResult: " + name);
            }
        }
    }
}
