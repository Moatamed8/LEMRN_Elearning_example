package com.example.moatamed.gproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Schedule extends AppCompatActivity {
    private RecyclerView mLogList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Schedule");
        mDatabase.keepSynced(true);

        mLogList=(RecyclerView)findViewById(R.id.screcyclerview);
        mLogList.setHasFixedSize(true);
        mLogList.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ScGrade,ScGradeHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<ScGrade, ScGradeHolder>
                (ScGrade.class,R.layout.schedual_view,ScGradeHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(ScGradeHolder viewHolder, ScGrade model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };
        mLogList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class ScGradeHolder extends RecyclerView.ViewHolder
    {

        View mView;
        public ScGradeHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String title)
        {
            TextView post_title=(TextView)mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }
        public void setDesc(String desc)
        {
            TextView post_desc=(TextView)mView.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }
        public void setImage(Context applicationContext, String image)
        {
            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);
            Picasso.get().load(image).into(post_image);
        }






    }
}
