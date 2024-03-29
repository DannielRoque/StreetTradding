package br.edu.fatecgarca.freetrading.popOut;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import br.edu.fatecgarca.freetrading.R;

public class Pop extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int heigth = dm.heightPixels;

        getWindow().setLayout((int)(width*.7),(int)(heigth*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y = -20;

        getWindow().setAttributes(params);
    }
}
