package top.qvisa.servicedemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText_number1;
    private EditText mEditText_number2;
    private static TextView mTextView_result;
    private String mString_number1, mString_number2;
    private int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText_number1 = findViewById(R.id.et_number1);
        mEditText_number2 = findViewById(R.id.et_number2);
        mTextView_result = findViewById(R.id.tv_result);

        MyReceiver_open_music myReceiver_open_music = new MyReceiver_open_music();
        IntentFilter intentFilter_open_music = new IntentFilter("open_music");
        registerReceiver(myReceiver_open_music,intentFilter_open_music);

        MyReceiver_close_music myReceiver_close_music = new MyReceiver_close_music();
        IntentFilter intentFilter_close_music = new IntentFilter("close_music");
        registerReceiver(myReceiver_close_music,intentFilter_close_music);

    }

    public void Click_Start_service(View view) {
        mString_number1 = mEditText_number1.getText().toString();
        mString_number2 = mEditText_number2.getText().toString();
        if (mString_number1.equals("") || mString_number2.equals("")) {
            mTextView_result.setText("Error! EditText is NULL");
            mTextView_result.setTextColor(Color.RED);
            mEditText_number1.setText("");
        } else {
            number1 = Integer.parseInt(mString_number1);
            number2 = Integer.parseInt(mString_number2);
            Intent intent = new Intent(this, MyService.class);
            intent.putExtra("a", number1);
            intent.putExtra("b", number2);
            startService(intent);
        }
    }

    public void Click_Stop_service(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public void Click_Start_broadcast_open_music(View view) {
        Intent intent  = new Intent();
        intent.setAction("open_music");
        sendBroadcast(intent);
    }

    public void Click_Start_broadcast_close_music(View view){
        Intent intent  = new Intent();
        intent.setAction("close_music");
        sendBroadcast(intent);
    }



    public static void Update(String result) {
        mTextView_result.setText(result);
        mTextView_result.setTextColor(Color.BLACK);
    }




}
