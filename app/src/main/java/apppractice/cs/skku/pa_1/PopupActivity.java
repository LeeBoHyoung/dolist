package apppractice.cs.skku.pa_1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import apppractice.cs.skku.pa_1.Fragment.DoFragment;
import apppractice.cs.skku.pa_1.R;

public class PopupActivity extends Activity {
    EditText contents;
    EditText contents2;
    TextView contents3;
    DatePicker datePicker;
    String content;
    String text1;
    String text2;
    String text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        contents = (EditText)findViewById(R.id.txtText);
        contents2 = (EditText)findViewById(R.id.txtText2);
        contents3 = (TextView)findViewById(R.id.txtText3);

        contents3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PopupActivity.this, DatepickerActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            text1 = bundle.getString("data1");
            text2 = bundle.getString("data2");
            text3 = bundle.getString("data3");
        }

        contents.setText(text1);
        contents2.setText(text2);
        contents3.setText(text3);

        contents.requestFocus();
    }

    public void mOnclick(View v){

        if(contents.getText().toString().equals("")) {
            Toast.makeText(this, "할 일을 입력해주세요.",Toast.LENGTH_SHORT).show();
            contents.requestFocus();
        }
        else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();

            bundle.putString("data1", contents.getText().toString());
            bundle.putString("data2", contents2.getText().toString());
            bundle.putString("data3", contents3.getText().toString());
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String date = data.getStringExtra("date");
                contents3.setText(date);
            }
        }
    }

}
