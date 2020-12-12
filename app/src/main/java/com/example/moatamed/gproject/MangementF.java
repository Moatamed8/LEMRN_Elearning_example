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

public class MangementF extends AppCompatActivity {
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    FirebaseStorage assgFireStorage;
    FirebaseDatabase assFireData;
    Uri pdfUri;
    ProgressDialog progressDialog;
    
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private MangementSectionPager mangementSectionPager;

    Button button,button2,button3,button4,button5,button6,button7;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;


    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangement_f);

        assgFireStorage=FirebaseStorage.getInstance();
        assFireData=FirebaseDatabase.getInstance();

        mToolbar = (Toolbar) findViewById(R.id.main_page_mangment_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Algorithms Materials");




        mViewPager = (ViewPager) findViewById(R.id.main_mangment_tabPager);
        mangementSectionPager = new MangementSectionPager(getSupportFragmentManager());

        mViewPager.setAdapter(mangementSectionPager);

        mTabLayout = (TabLayout) findViewById(R.id.main_mangment_tabs);
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
    public void DownloadAlgBtnv(View view){
        downloadmv();
    }
    public void DownloadAlgBtniv(View view){
        downloadmiv();
    }
    public void DownloadAlgBtniii(View view){
        downloadmiii();
    }
    public void DownloadAlgBtnii(View view){
        downloadmii();
    }
    public void DownloadAlgBtni(View view){
        downloadmi();
    }
    private void downloadmv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Algorithms").child("lec 1.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(MangementF.this,"lec 1",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MangementF.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmiv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Algorithms").child("lec 2.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(MangementF.this,"lec 2",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MangementF.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmiii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Algorithms").child("lec 4.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(MangementF.this,"lec 4",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MangementF.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Algorithms").child("master.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(MangementF.this,"master",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MangementF.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloadmi() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Algorithms").child("summations.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(MangementF.this,"master",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MangementF.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==86 &&resultCode==RESULT_OK &&data!=null)
        {
            textView1=(TextView)findViewById(R.id.algorithmtxt1);
            textView2=(TextView)findViewById(R.id.algorithmtxt2);
            textView3=(TextView)findViewById(R.id.algorithmtxt3);
            textView4=(TextView)findViewById(R.id.algorithmtxt4);
            textView5=(TextView)findViewById(R.id.algorithmtxt5);
            pdfUri=data.getData();
            textView1.setText("A file is: "+ data.getData().getLastPathSegment());
            textView2.setText("A file is: "+ data.getData().getLastPathSegment());
            textView3.setText("A file is: "+ data.getData().getLastPathSegment());
            textView4.setText("A file is: "+ data.getData().getLastPathSegment());
            textView5.setText("A file is: "+ data.getData().getLastPathSegment());


        }
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

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
            Toast.makeText(MangementF.this,"Please Provide permission",Toast.LENGTH_LONG).show();


    }
    public void BtnAlgoChose(View view){
        if (ContextCompat.checkSelfPermission(MangementF.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            ActivityCompat.requestPermissions(MangementF.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);



    }
    public void BtnUploadAlgov(View view) {
        if (pdfUri!=null)
            uploadFilev(pdfUri);
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnUploadAlgoiv(View view) {
        if (pdfUri!=null)
            uploadFileiv(pdfUri);
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnUploadAlgoiii(View view) {
        if (pdfUri!=null)
            uploadFileiii(pdfUri);
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnUploadAlgoii(View view) {
        if (pdfUri!=null)
            uploadFileii(pdfUri);
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnUploadAlgoi(View view) {
        if (pdfUri!=null)
            uploadFilei(pdfUri);
        else
            Toast.makeText(MangementF.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    private void uploadFilev(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("Algorithms Sheet").child("Sheet One").child(filename).putFile(pdfUri)
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
                                    button=(Button)findViewById(R.id.algorithmb1);
                                    progressDialog.dismiss();
                                    button.setText("Done");
                                    button.setClickable(false);
                                    Toast.makeText(MangementF.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("Algorithms Sheet").child("Sheet Two").child(filename).putFile(pdfUri)
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
                                    button2=(Button)findViewById(R.id.algorithmb2);
                                    progressDialog.dismiss();
                                    button2.setText("Done");
                                    button2.setClickable(false);
                                    Toast.makeText(MangementF.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("Algorithms Sheet").child("Sheet Three").child(filename).putFile(pdfUri)
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
                                    button3=(Button)findViewById(R.id.algorithmb3);
                                    progressDialog.dismiss();
                                    button3.setText("Done");
                                    button3.setClickable(false);
                                    Toast.makeText(MangementF.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("Algorithms Sheet").child("Sheet Four").child(filename).putFile(pdfUri)
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
                                    button4=(Button)findViewById(R.id.algorithmb4);
                                    progressDialog.dismiss();
                                    button4.setText("Done");
                                    button4.setClickable(false);
                                    Toast.makeText(MangementF.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("Algorithms Sheet").child("Sheet Five").child(filename).putFile(pdfUri)
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
                                    button5=(Button)findViewById(R.id.algorithmb5);
                                    progressDialog.dismiss();
                                    button5.setText("Done");
                                    button5.setClickable(false);
                                    Toast.makeText(MangementF.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(MangementF.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
