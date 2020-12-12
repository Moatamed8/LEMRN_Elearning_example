package com.example.moatamed.gproject;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.CountDownTimer;
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

import java.util.Calendar;
import java.util.GregorianCalendar;

import io.reactivex.annotations.NonNull;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Dsp extends AppCompatActivity {
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    FirebaseStorage assgFireStorage;
    FirebaseDatabase assFireData;
    Uri pdfUri;
    ProgressDialog progressDialog;

    private Toolbar mToolbar;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;

    private ViewPager mViewPager;
    private DspSectionsPagerAdapter dspSectionsPagerAdapter;
    Button button,button2,button3,button4,button5,button6,button7;



    private TabLayout mTabLayout;

    boolean timeout = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsp);





/////////////////////////////////////////////////////////////////////


        assgFireStorage=FirebaseStorage.getInstance();
        assFireData=FirebaseDatabase.getInstance();


        mToolbar = (Toolbar) findViewById(R.id.main_page_dsp_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Dsp Materials");




        mViewPager = (ViewPager) findViewById(R.id.main_dsp_tabPager);
        dspSectionsPagerAdapter = new DspSectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(dspSectionsPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.main_dsp_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }
    private void downloadFiles(Context context, String fileName, String fileExtension , String destinationDirectory, String url) {
        DownloadManager downloadManager=(DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName + fileExtension);
        downloadManager.enqueue(request);}


    public void BtnDspv(View view){
        downloaddspv();
    }
    public void BtnDspiv(View view){
        downloaddspiv();
    }
    public void BtnDspiii(View view){
        downloaddspiii();
    }
    public void BtnDspii(View view){
        downloaddspii();
    }
    public void BtnDspi(View view){
        downloaddspi();
    }
    public void Part1Dsp(View view){
        downloaddsppart1();
    }
    public void Part3Dsp(View view){
        downloaddsppart3();
    }
    private void downloaddsppart1() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Chapter4_1.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Chapter4_1",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddsppart3() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Chapter2_Part3.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Chapter2_Part3",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddspv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("DFT.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"DFT",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddspiv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Chapter2_Part1.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Chapter2_Part1",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddspiii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Chapter2_Part2.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Chapter2_Part2",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddspii() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Chapter4.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Chapter4",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddspi() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Convolution.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Convolution",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    ////////////textbook
    public void DspTextFirst(View view){
        downloaddsptextv();
    }
    public void DspTextSecond(View view){
        downloaddsptextiv();
    }
    private void downloaddsptextv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Convolution.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Convolution",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void downloaddsptextiv() {
        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("DSP").child("Convolution.pptx");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(Dsp.this,"Convolution",".pptx",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dsp.this,"Please check internet connection",Toast.LENGTH_LONG).show();

            }
        });

    }
    ///////////////////////////////////////////////////////////////////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==86 &&resultCode==RESULT_OK &&data!=null)
        {
            textView1=(TextView)findViewById(R.id.dsptxt1);
            textView2=(TextView)findViewById(R.id.dsptxt2);
            textView3=(TextView)findViewById(R.id.dsptxt3);
            textView4=(TextView)findViewById(R.id.dsptxt4);
            textView5=(TextView)findViewById(R.id.dsptxt5);
            textView6=(TextView)findViewById(R.id.dsptxt6);
            textView7=(TextView)findViewById(R.id.dsptxt7);
            pdfUri=data.getData();
            textView1.setText("A file is: "+ data.getData().getLastPathSegment());
            textView2.setText("A file is: "+ data.getData().getLastPathSegment());
            textView3.setText("A file is: "+ data.getData().getLastPathSegment());
            textView4.setText("A file is: "+ data.getData().getLastPathSegment());
            textView5.setText("A file is: "+ data.getData().getLastPathSegment());
            textView6.setText("A file is: "+ data.getData().getLastPathSegment());
            textView7.setText("A file is: "+ data.getData().getLastPathSegment());


        }
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

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
            Toast.makeText(Dsp.this,"Please Provide permission",Toast.LENGTH_LONG).show();


    }
    public void BTnChoseDspAss(View view){
        if (ContextCompat.checkSelfPermission(Dsp.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            selectPdf();
        }
        else
            ActivityCompat.requestPermissions(Dsp.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);



    }
    public void BtnDspUploadv(View view) {
        if (pdfUri!=null)
            uploadFilev(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadiv(View view) {
        if (pdfUri!=null)
            uploadFileiv(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadiii(View view) {
        if (pdfUri!=null)
            uploadFileiii(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadii(View view) {
        if (pdfUri!=null)
            uploadFileii(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadi(View view) {
        if (pdfUri!=null)
            uploadFilei(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadVI(View view) {
        if (pdfUri!=null)
            uploadFileVI(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }
    public void BtnDspUploadVII(View view) {
        if (pdfUri!=null)
            uploadFileVII(pdfUri);
        else
            Toast.makeText(Dsp.this,"Please Select File",Toast.LENGTH_LONG).show();

    }

    private void uploadFilev(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("DSP Sheet").child("Sheet One").child(filename).putFile(pdfUri)
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
                                    button=(Button)findViewById(R.id.dspbtn1);
                                    progressDialog.dismiss();
                                    button.setText("Done");
                                    button.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("DSP Sheet").child("Sheet Two").child(filename).putFile(pdfUri)
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
                                    button2=(Button)findViewById(R.id.dspbtn2);
                                    progressDialog.dismiss();
                                    button2.setText("Done");
                                    button2.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("DSP Sheet").child("Sheet Three").child(filename).putFile(pdfUri)
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
                                    button3=(Button)findViewById(R.id.dspbtn3);
                                    progressDialog.dismiss();
                                    button3.setText("Done");
                                    button3.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("DSP Sheet").child("Sheet Four").child(filename).putFile(pdfUri)
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
                                    button4=(Button)findViewById(R.id.dspbtn4);
                                    progressDialog.dismiss();
                                    button4.setText("Done");
                                    button4.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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
        storageReference.child("DSP Sheet").child("Sheet Five").child(filename).putFile(pdfUri)
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
                                    button5=(Button)findViewById(R.id.dspbtn5);
                                    progressDialog.dismiss();
                                    button5.setText("Done");
                                    button5.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFileVI(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("DSP Sheet").child("Sheet Six").child(filename).putFile(pdfUri)
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
                                    button6=(Button)findViewById(R.id.dspbtn6);
                                    progressDialog.dismiss();
                                    button6.setText("Done");
                                    button6.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });

    }
    private void uploadFileVII(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();



        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=assgFireStorage.getReference();
        storageReference.child("DSP Sheet").child("Sheet Seven").child(filename).putFile(pdfUri)
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
                                    button7=(Button)findViewById(R.id.dspbtn7);
                                    progressDialog.dismiss();
                                    button7.setText("Done");
                                    button7.setClickable(false);
                                    Toast.makeText(Dsp.this,"File successfully Uploaded",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@android.support.annotation.NonNull Exception e) {
                Toast.makeText(Dsp.this,"File not successfully Uploaded",Toast.LENGTH_LONG).show();

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

