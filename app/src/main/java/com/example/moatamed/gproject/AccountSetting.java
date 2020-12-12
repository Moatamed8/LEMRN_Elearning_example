
package com.example.moatamed.gproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class AccountSetting extends AppCompatActivity {

    private DatabaseReference mUserDataBase;
    private FirebaseUser mCurrentUser;
    private StorageReference mImagesStorage;

    private CircleImageView mDisplayimage;
    private TextView mName;
    private TextView mStatus;

    final static int GALLARY_PICK=1;
    private ProgressDialog mprogressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        mImagesStorage = FirebaseStorage.getInstance().getReference();


        mDisplayimage=(CircleImageView)findViewById(R.id.settings_image);
        mName=(TextView)findViewById(R.id.settings_display_name);
        mStatus=(TextView)findViewById(R.id.settings_status);


        mCurrentUser= FirebaseAuth.getInstance().getCurrentUser();
        String current_uid=mCurrentUser.getUid();

        mUserDataBase= FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
        mUserDataBase.keepSynced(true);
        mUserDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("name").getValue().toString();
                final String image=dataSnapshot.child("image").getValue().toString();
                String status=dataSnapshot.child("status").getValue().toString();
                String thumb_image=dataSnapshot.child("thumb_image").getValue().toString();

                mName.setText(name);
                mStatus.setText(status);
                if(!image.equals("default")) {
                    //  Picasso.get().load(image).placeholder(R.drawable.default_avtar).into(mDisplayimage);
                    Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE)
                            .placeholder(R.drawable.default_avtar).into(mDisplayimage, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                            Picasso.get().load(image).placeholder(R.drawable.default_avtar).into(mDisplayimage);

                        }
                    });


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    public void BTnGo(View view) {
        String status_value=mStatus.getText().toString();
        Intent home=new Intent(AccountSetting.this ,SatutsActivity.class);
        home.putExtra("status_value",status_value);
        startActivity(home);
    }

    public void BtnChose(View view) {
        Intent galleryIntent=new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(galleryIntent ,"SELECT IMAGE"),GALLARY_PICK);

        // start picker to get image for cropping and then use the image in cropping activity
        /*
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(SettingsActivity.this);
                 */
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLARY_PICK && resultCode==RESULT_OK){
            Uri imageUri=data.getData();
            CropImage.activity(imageUri)
                    .setAspectRatio(1,1)
                    .setMinCropResultSize(500,500)
                    .start(this);
        }


        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {
                mprogressDialog=new ProgressDialog(AccountSetting.this);
                mprogressDialog.setTitle("Uploading Image...");
                mprogressDialog.setMessage("Please wait while we upload and process image.");
                mprogressDialog.setCanceledOnTouchOutside(false);
                mprogressDialog.show();



                Uri resultUri = result.getUri();
                File thumb_filePath=new File(resultUri.getPath());
                String current_user_id=mCurrentUser.getUid();


                Bitmap thumb_bitmap = null;
                try {
                    thumb_bitmap = new Compressor(this)
                            .setMaxWidth(200)
                            .setMaxHeight(200)
                            .setQuality(75)
                            .compressToBitmap(thumb_filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                thumb_bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
                final byte[] thumb_byte=baos.toByteArray();


                StorageReference filepath=mImagesStorage.child("profile_images").child(current_user_id +".jpg");
                final StorageReference thumb_filepath=mImagesStorage.child("profile_images").child("thumbs").child(current_user_id +".jpg");

                filepath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()){

                            final String dawnload_url=task.getResult().getDownloadUrl().toString();

                            UploadTask uploadTask=thumb_filepath.putBytes(thumb_byte);
                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumb_task) {
                                    final String thumb_dawnload_url=thumb_task.getResult().getDownloadUrl().toString();


                                    if (thumb_task.isSuccessful()){
                                        Map update_hashmap=new HashMap<>();
                                        update_hashmap.put("image",dawnload_url);
                                        update_hashmap.put("thumb_image",thumb_dawnload_url);


                                        mUserDataBase.updateChildren(update_hashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    mprogressDialog.dismiss();
                                                    Toast.makeText(AccountSetting.this, "Success Uploading", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                    else {
                                        Toast.makeText(AccountSetting.this, "Error in uploading Thumbimage", Toast.LENGTH_SHORT).show();
                                        mprogressDialog.dismiss();

                                    }
                                }
                            });




                        }else {
                            Toast.makeText(AccountSetting.this, "Error in uploading image", Toast.LENGTH_SHORT).show();
                            mprogressDialog.dismiss();

                        }
                    }
                });

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
    public static String random(){
        Random generator=new Random();
        StringBuilder randomStringBuilder=new StringBuilder();
        int randomLength =generator.nextInt(10);
        char tempChar;
        for (int i=0;i<randomLength;i++){
            tempChar=(char)(generator.nextInt(96) +32 );
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}
