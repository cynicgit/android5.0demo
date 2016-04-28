package ip.cynic.theme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int themeId = getIntent().getIntExtra("themeId", -1);
        if (themeId > -1) {
            setTheme(themeId);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void red(View v) {
        //关闭自己
        finish();
        //去除动画
        overridePendingTransition(0, 0);
        //重启自己
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("themeId", R.style.AppTheme_Red);
        startActivity(intent);
        //去除动画
        overridePendingTransition(0, 0);
    }

    public void pink(View v) {
        //关闭自己
        finish();
        //去除动画
        overridePendingTransition(0, 0);
        //重启自己
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("themeId", R.style.AppTheme_Pink);
        startActivity(intent);
        //去除动画
        overridePendingTransition(0, 0);

    }
}
