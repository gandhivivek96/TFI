package com.example.vivekgandhi.tfi;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowActivity extends AppCompatActivity {

    //created for firebaseui android tutorial by Vamsi Tallapudi

    private FloatingActionButton fab;
    String tp="msg";
    ScaleAnimation shrinkAnim;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
    private TextView tvNoMovies;

    //Getting reference to Firebase Database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference();

    private static final String userId = "53";
     String fname,fval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Bundle firstData = getIntent().getExtras();
        fname = firstData.getString("filtername");
        fval = firstData.getString("filtervalue");
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        //Initializing our Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        tvNoMovies = (TextView) findViewById(R.id.titletext);

        //scale animation to shrink floating actionbar
        shrinkAnim = new ScaleAnimation(1.15f, 0f, 1.15f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        if (mRecyclerView != null) {
            //to enable optimization of recyclerview
            mRecyclerView.setHasFixedSize(true);
        }
        //using staggered grid pattern in recyclerview
        mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

if(fname.equals("null"))
{
    //Say Hello to our new FirebaseUI android Element, i.e., FirebaseRecyclerAdapter
    FirebaseRecyclerAdapter<Opportunity,OpportunityViewHolder> adapter = new FirebaseRecyclerAdapter<Opportunity, OpportunityViewHolder>(
            Opportunity.class,
            R.layout.showall,
            OpportunityViewHolder.class,
            //referencing the node where we want the database to store the data from our Object
            mDatabaseReference.child("Opportunities")//.orderByChild(fname).equalTo(fval)
    ) {
        @Override
        protected void populateViewHolder(OpportunityViewHolder viewHolder, Opportunity model, int position) {
            if(tvNoMovies.getVisibility()== View.VISIBLE){
                tvNoMovies.setVisibility(View.GONE);
            }
            viewHolder.title.setText(model.getTitle());
            viewHolder.desc.setText(model.getDescription());
            viewHolder.h.setText(model.getHours());
            viewHolder.e.setText(model.getEnd());
            viewHolder.s.setText(model.getSt());
            viewHolder.p.setText(model.getPincode());
            viewHolder.ad.setText(model.getAddress());
            viewHolder.ci.setText(model.getCity());

        }
    };
    mRecyclerView.setAdapter(adapter);
}
        else {
    //Say Hello to our new FirebaseUI android Element, i.e., FirebaseRecyclerAdapter
    FirebaseRecyclerAdapter<Opportunity, OpportunityViewHolder> adapter = new FirebaseRecyclerAdapter<Opportunity, OpportunityViewHolder>(
            Opportunity.class,
            R.layout.showall,
            OpportunityViewHolder.class,
            //referencing the node where we want the database to store the data from our Object
            mDatabaseReference.child("Opportunities").orderByChild(fname).equalTo(fval)
    ) {
        @Override
        protected void populateViewHolder(OpportunityViewHolder viewHolder, Opportunity model, int position) {
            if (tvNoMovies.getVisibility() == View.VISIBLE) {
                tvNoMovies.setVisibility(View.GONE);
            }
            viewHolder.title.setText(model.getTitle());
            viewHolder.desc.setText(model.getDescription());
            viewHolder.h.setText(model.getHours());
            viewHolder.e.setText(model.getEnd());
            viewHolder.s.setText(model.getSt());
            viewHolder.p.setText(model.getPincode());
            viewHolder.ad.setText(model.getAddress());
            viewHolder.ci.setText(model.getCity());

        }
    };
    mRecyclerView.setAdapter(adapter);
}
Log.i(tp,"b4 setadapter");


        Log.i(tp,"after adapter");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //ViewHolder for our Firebase UI
    public static class OpportunityViewHolder extends RecyclerView.ViewHolder{
        //Log.i(tp,"inside");
        TextView title,desc,h,s,e,p,ad,ci;

        public OpportunityViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tv_name);
            desc = (TextView) v.findViewById(R.id.des);
            h = (TextView) v.findViewById(R.id.htv);
            s = (TextView) v.findViewById(R.id.stv);
            e = (TextView) v.findViewById(R.id.etv);
            ci = (TextView) v.findViewById(R.id.citytv);
            ad = (TextView) v.findViewById(R.id.addresstv);
            p = (TextView) v.findViewById(R.id.pintv);


        }
    }
}
