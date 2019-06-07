package apppractice.cs.skku.pa_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import apppractice.cs.skku.pa_1.Fragment.DoFragment;
import apppractice.cs.skku.pa_1.Fragment.DoingFragment;
import apppractice.cs.skku.pa_1.R;

public class EditActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edit_activity);


    }

    public void editonclick(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String text1;
        String text2;
        String text3;
        if(bundle != null) {
            text1 = bundle.getString("data1");
            text2 = bundle.getString("data2");
            text3 = bundle.getString("data3");

            Intent intent1 = new Intent(EditActivity.this, PopupActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("data1", text1);
            bundle1.putString("data2", text2);
            bundle1.putString("data3", text3);
            intent1.putExtras(bundle1);
            startActivityForResult(intent1, 2);
        }
    }

    public void delonclick(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int pos;
        if(bundle != null) {
            pos = bundle.getInt("pos");
        }
        setResult(2, intent);

        finish();
    }

    public void do_click(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String text1;
        String text2;
        String text3;
        int cnt = 0;
        int check = 999;
        if(bundle != null) {
            text1 = bundle.getString("data1");
            text2 = bundle.getString("data2");
            text3 = bundle.getString("data3");
            check = bundle.getInt("check");

            cnt = ((App)getApplicationContext()).do_getCnt();
            ((App)getApplicationContext()).do_setTitle(text1, cnt);
            ((App)getApplicationContext()).do_setSub(text2, cnt);
            ((App)getApplicationContext()).do_setTime(text3, cnt);
        }

        if(check != 0)
            setResult(2, intent);
        else
            ((App)getApplicationContext()).do_setCnt(cnt);

        finish();
    }

    public void doing_click(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String text1;
        String text2;
        String text3;
        int cnt = 0;
        int check = 0;
        if(bundle != null) {
            text1 = bundle.getString("data1");
            text2 = bundle.getString("data2");
            text3 = bundle.getString("data3");
            check = bundle.getInt("check");

            cnt = ((App)getApplicationContext()).doing_getCnt();
            ((App)getApplicationContext()).doing_setTitle(text1, cnt);
            ((App)getApplicationContext()).doing_setSub(text2, cnt);
            ((App)getApplicationContext()).doing_setTime(text3, cnt);
        }

        if(check != 1)
            setResult(2, intent);
        else
            ((App)getApplicationContext()).doing_setCnt(cnt);

        finish();
    }

    public void done_click(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String text1;
        String text2;
        String text3;
        int cnt = 0;
        int check = 0;
        if(bundle != null) {
            text1 = bundle.getString("data1");
            text2 = bundle.getString("data2");
            text3 = bundle.getString("data3");
            check = bundle.getInt("check");

            cnt = ((App)getApplicationContext()).done_getCnt();
            ((App)getApplicationContext()).done_setTitle(text1, cnt);
            ((App)getApplicationContext()).done_setSub(text2, cnt);
            ((App)getApplicationContext()).done_setTime(text3, cnt);
        }

        if(check != 2)
            setResult(2, intent);
        else
            ((App)getApplicationContext()).doing_setCnt(cnt);

        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String text1;
                String text2;
                String text3;
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    text1 = bundle.getString("data1");
                    text2 = bundle.getString("data2");
                    text3 = bundle.getString("data3");

                    Intent intent = new Intent();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("data1", text1);
                    bundle1.putString("data2", text2);
                    bundle1.putString("data3", text3);
                    intent.putExtras(bundle1);
                    setResult(RESULT_OK, intent);
                }
            }
        }
        finish();
    }
}
