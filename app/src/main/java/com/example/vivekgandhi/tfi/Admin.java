package com.example.vivekgandhi.tfi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin extends AppCompatActivity {
    //private static final String TAG = Admin.class.getSimpleName();
    private String userId;
    private TextView txtDetails;
    private String email,pass,title,des,city,pin,ad,st,end,hr;
    private EditText e,p,t,d,c,zip,a,s,en,h;
    private EditText inputName, inputEmail;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    //private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);mFirebaseInstance = FirebaseDatabase.getInstance();



        // get reference to 'users' node

    }

    public void save(View view)
    {
        e = (EditText) findViewById(R.id.email);
        c = (EditText) findViewById(R.id.editText2);
        t = (EditText) findViewById(R.id.editText);
        d = (EditText) findViewById(R.id.editText1);
        a = (EditText) findViewById(R.id.editText3);
        zip = (EditText) findViewById(R.id.editText4);
        s = (EditText) findViewById(R.id.editText5);
        en = (EditText) findViewById(R.id.editText6);
        h = (EditText) findViewById(R.id.editText7);


        email = e.getText().toString().trim();
        title = t.getText().toString().trim();
        des = d.getText().toString().trim();
        city = c.getText().toString().trim();
        pin = zip.getText().toString().trim();
        ad = a.getText().toString().trim();
        st = s.getText().toString().trim();
        end = en.getText().toString().trim();
        hr = h.getText().toString().trim();
       // e.setText("ENJOY");

        //mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Opportunities");

// Creating new user node, which returns the unique key value
// new user node would be /users/$userid/
        String userId = mDatabase.push().getKey();

// creating user object
        Opportunity o = new Opportunity(email,title,des,city,ad,pin,st,end,hr);

// pushing user to 'users' node using the userId
        mDatabase.child(userId).setValue(o);


        //Toast t = Toast.makeText("")

        Toast.makeText(Admin.this,"Inserted Successfully", Toast.LENGTH_LONG).show();


    }

}
