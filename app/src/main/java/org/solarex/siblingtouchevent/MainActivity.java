package org.solarex.siblingtouchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CustomButton1 btn1;
    private CustomButton2 btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (CustomButton1)findViewById(R.id.btn1);
        btn2 = (CustomButton2)findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Log.d("solarex", "btn1--onClick");
                break;
            case R.id.btn2:
                Log.d("solarex", "btn2--onClick");
                break;
        }
    }
}
