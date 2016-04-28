package ip.cynic.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View v1;
    private View v2;
    private View v3;
    private View v4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a1);

        Palette.Builder builder = Palette.from(bitmap);
//        Vibrant 鲜艳的
//        Vibrant dark鲜艳的暗色
//        Vibrant light鲜艳的亮色
//        Muted 柔和的
//        Muted dark柔和的暗色
//        Muted light柔和的亮色
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                v1.setBackgroundColor(palette.getLightMutedColor(0));
                v2.setBackgroundColor(palette.getLightVibrantColor(0));
                v3.setBackgroundColor(palette.getDarkVibrantColor(0XFF0000));
                v4.setBackgroundColor(palette.getDarkMutedColor(0));
            }
        });


    }

    private void initView() {
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
    }
}
