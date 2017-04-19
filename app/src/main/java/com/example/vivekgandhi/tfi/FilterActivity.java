package com.example.vivekgandhi.tfi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class FilterActivity extends AppCompatActivity {
    RadioButton hour, city;
    private String filtername,filtervalue;
    EditText fval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }
    public String onRadioButtonClicked(View view)
    {
        hour = (RadioButton) findViewById(R.id.hour);
        city = (RadioButton) findViewById(R.id.city);
        if(hour.isChecked())
        {
            filtername="hours";

        }
        else if(city.isChecked())
        {
            filtername="city";
        }
        else
        {
            filtername="null";
        }
        return filtername;
    }
    public void filterData(View view){
        fval = (EditText) findViewById(R.id.fv);
        filtervalue = fval.getText().toString().trim();
        filtername = onRadioButtonClicked(view);
        Intent i = new Intent(FilterActivity.this,ShowActivity.class);
        i.putExtra("filtername",filtername);
        i.putExtra("filtervalue",filtervalue);
        startActivity(i);
    }

}
