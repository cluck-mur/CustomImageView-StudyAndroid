package jp.camluck.mura.customimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyImageView my_image_view = findViewById(R.id.imageView);
        //my_image_view.Init(getPackageName());
        my_image_view.Init();
    }
}
