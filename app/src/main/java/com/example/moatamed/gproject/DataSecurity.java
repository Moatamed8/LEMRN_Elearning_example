package com.example.moatamed.gproject;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import io.reactivex.annotations.NonNull;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DataSecurity extends AppCompatActivity {
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    FirebaseStorage assgFireStorage;
    FirebaseDatabase assFireData;
    Uri pdfUri;
    ProgressDialog progressDialog;
    Button button,button2,button3,button4,button5,button6,button7;

    private Toolbar mToolbar;

    private ViewPager mViewPager;
    private DataSecuirtySectionPager dataSecuirtySectionPager;

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;


    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_security);
        assgFireStorage=FirebaseStorage.getInstance();
        assFireData=FirebaseDatabase.getInstance();


        mToolbar = (Toolbar) findViewById(R.id.main_page_datasecuirty_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("DataBase Materials");




        mViewPager = (ViewPager) findViewById(R.id.main_datasecuirty_tabPager);
        dataSecuirtySectionPager = new DataSecuirtySectionPager(getSupportFragmentManager());

        mViewPager.setAdapter(dataSecuirtySectionPager);

        mTabLayout = (TabLayout) findViewById(R.id.main_datasecuirty_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }
    private void downloadFiles(Context context, String fileName, String fileExtension , String destinationDirectory, String url) {
        DownloadManager downloadManager=(DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName + fileExtension);
        downloadManager.enqueue(request);

    }
    public void DawnloadDataBasev(View view){
        downloadmv();
    }
    public void DawnloadDataBaseiv(View view){
        downloadmiv();
    }
    public void DawnloadDataBaseiii(View view){
        downloadmiii();
    }
    public void DawnloadDataBaseii(View view){
        downloadmii();
    }
    public void DawnloadDataBasei(View view){
        downloadmi();
    }
    private void downloadmv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Database").child("IS255Lec1.ppt");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DataSecurity.this,"IS255Lec1",".ppt",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmiv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Database").child("IS255Lec2.ppt");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DataSecurity.this,"IS255Lec2",".ppt",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmiii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Database").child("IS255Lec4.ppt");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DataSecurity.this,"IS255Lec4",".ppt",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Database").child("IS255Lec6.ppt");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DataSecurity.this,"IS255Lec6",".ppt",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmi() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Database").child("IS255Lec7.ppt");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DataSecurity.this,"IS255Lec7",".ppt",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    ////////////////////////
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==86 &&resultCode==RESULT_OK &&data!=null)
        {
            textView1=(TextView)findViewById(R.id.databasetxt1);
            textView2=(TextView)findViewById(R.id.databasetxt2);
            textView3=(TextView)findViewById(R.id.databasetxt3);
            textView4=(TextView)findViewById(R.id.databasetxt4);
            textView5=(TextView)findViewById(R.id.databasetxt5);
            pdfUri=data.getData();
            textView1.setText("A file is: "+ data.getData().getLastPathSegment());
            textView2.setText("A file is: "+ data.getData().getLastPathSegment());
            textView3.setText("A file is: "+ data.getData().getLastPathSegment());
            textView4.setText("A file is: "+ data.getData().getLastPathSegment());
            textView5.setText("A file is: "+ data.getData().getLastPathSegment());


        }
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    private void selectPdf() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @android.support.annotation.NonNull int[] grantResults) {

        if (requestCode==9&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }else
            Toast.makeText(DataSecurity.this,"Please Provide permission",Toast.LENGTH_LONG).show();


    }
    public void BtnDatabaseChose(View view){
        if (ContextCompat.checkSelfPermission(DataSecurity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            ActivityCompat.requestPermissions(DataSecurity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);



    }
    public void BtnDatabaseUploadv(View view) {
        if (pdfUri!=null)
            uploadFilev(pdfUri);
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDatabaseUploadiv(View view) {
        if (pdfUri!=null)
            uploadFileiv(pdfUri);
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDatabaseUploadiii(View view) {
        if (pdfUri!=null)
            uploadFileiii(pdfUri);
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDatabaseUploadii(View view) {
        if (pdfUri!=null)
            uploadFileii(pdfUri);
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDatabaseUploadi(View view) {
        if (pdfUri!=null)
            uploadFilei(pdfUri);
        else
            Toast.makeText(DataSecurity.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    private void uploadFilev(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Database Sheet").child("Sheet One").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String uri=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=assFireData.getReference();
                        reference.child(filename).setValue(uri).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    button=(Button)findViewById(R.id.databasebtnu1);
                                    progressDialog.dismiss();
                                    button.setText("Done");
                                    button.setClickable(false);
                                    Toast.makeText(DataSecurity.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFileiv(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Database Sheet").child("Sheet Two").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String uri=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=assFireData.getReference();
                        reference.child(filename).setValue(uri).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    button2=(Button)findViewById(R.id.databasebtnu2);
                                    progressDialog.dismiss();
                                    button2.setText("Done");
                                    button2.setClickable(false);
                                    Toast.makeText(DataSecurity.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFileiii(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Database Sheet").child("Sheet Three").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String uri=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=assFireData.getReference();
                        reference.child(filename).setValue(uri).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    button3=(Button)findViewById(R.id.databasebtnu3);
                                    progressDialog.dismiss();
                                    button3.setText("Done");
                                    button3.setClickable(false);
                                    Toast.makeText(DataSecurity.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFileii(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Database Sheet").child("Sheet Four").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String uri=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=assFireData.getReference();
                        reference.child(filename).setValue(uri).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    button4=(Button)findViewById(R.id.databasebtnu4);
                                    progressDialog.dismiss();
                                    button4.setText("Done");
                                    button4.setClickable(false);
                                    Toast.makeText(DataSecurity.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFilei(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Database Sheet").child("Sheet Five").child(filename).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String uri=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference reference=assFireData.getReference();
                        reference.child(filename).setValue(uri).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    button5=(Button)findViewById(R.id.databasebtnu5);
                                    progressDialog.dismiss();
                                    button5.setText("Done");
                                    button5.setClickable(false);
                                    Toast.makeText(DataSecurity.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(DataSecurity.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }


}
