package exemplo.daiane.com.filterimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class FilterImageActivity extends Activity implements View.OnClickListener {

    private Button selectImage;
    private Button buttonInvertColor;
    private Button buttonBlackWhite;
    private ImageView imageView;
    private Bitmap originBitmap;
    private File tempFile = new File("/sdcard/.a.jpg");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_image);

        selectImage = (Button) findViewById(R.id.selectImage);
        buttonBlackWhite = (Button) findViewById(R.id.blackWrite);
        buttonInvertColor = (Button) findViewById(R.id.invertColor);
        imageView = (ImageView) findViewById(R.id.image);
        selectImage.setOnClickListener(this);
        buttonInvertColor.setOnClickListener(this);
        buttonBlackWhite.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.selectImage) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        }
        else if (v.getId() == R.id.blackWrite) {
            if (this.originBitmap != null) {
                this.imageView.setImageBitmap(BlackWriteFilter.convertColorIntoBlackAndWhiteImage(originBitmap));
            }
        }else if(v.getId() == R.id.invertColor){
            if (this.originBitmap != null) {
                this.imageView.setImageBitmap(InvertFilter.invertColor(originBitmap));

            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(selectedImage);
                originBitmap = BitmapFactory.decodeStream(imageStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (originBitmap != null) {
                tempFile.delete();
                this.imageView.setImageBitmap(originBitmap);
            }
        }
    }


}
