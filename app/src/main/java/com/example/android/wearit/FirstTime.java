package com.example.android.wearit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Divyani on 17-03-2017.
 */
public class FirstTime extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firsttime);
    }
    public void selectImage()
    {
        String userSelect;

        //uniform read only access
       final CharSequence[]items={"Click Image","Pick image from Gallery","Cancel"};
        // Display alertDialog

        AlertDialog.Builder builder =new AlertDialog.Builder(FirstTime.this);
        builder.setTitle("Add Photo");
        // setItems in new Dialog interface listening to options in that interface
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Utility class created separate  method  check Permission
                boolean result = Utility.checkPermission(FirstTime.this);
                if (items[i].equals("Click Image")) {
                    //userChosen="Click Image";
                    Toast.makeText(getApplicationContext(), "You choose Click Image", Toast.LENGTH_SHORT).show();
                   // userSelect = "";
                    // if have permission
                    if (result) {
                        cameraIntent();
                    }
                } else if (items[i].equals("Pick image from Gallery")) {
                    Toast.makeText(getApplicationContext(), "You choose pick image from gallery", Toast.LENGTH_SHORT).show();
                    if (result) {
                        galleryIntent();
                    }
                }

            }
        });
    }

    private void galleryIntent()
    {
        final int SELECT_FILE =1998;
        Intent i=new Intent();
        // Select only image from gallery
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        // AT result back we want to choose the image
        startActivityForResult(Intent.createChooser(i,"Select image"),SELECT_FILE);

    }

    private void cameraIntent() {
        final int CAMERA_REQUEST = 1998;
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Method gives us a result back which is the image captured by the camera
        startActivityForResult(i,CAMERA_REQUEST);
    }
}
