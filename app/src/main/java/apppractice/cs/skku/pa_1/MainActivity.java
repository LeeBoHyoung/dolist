package apppractice.cs.skku.pa_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import apppractice.cs.skku.pa_1.R;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity


{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText id_text = (EditText)findViewById(R.id.edit_login_id);
        final EditText pw_text = (EditText)findViewById(R.id.edit_login_pw);
        Button login = (Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id_text.getText().toString().equals("")){
                    id_text.requestFocus();
                    Toast.makeText(MainActivity.this, "아이디를 입력하세요", LENGTH_SHORT).show();
                }
                else if(pw_text.getText().toString().equals("")){
                    pw_text.requestFocus();
                    Toast.makeText(MainActivity.this, "비밀번호를 입력하세요", LENGTH_SHORT).show();
                }
                else if(id_text.getText().toString().equals("2014311945") && pw_text.getText().toString().equals("qhgu2sk")){
                    Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "아이디 혹은 비밀번호가 틀렸습니다.", LENGTH_SHORT).show();
                }
            }
        });


        id_text.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus == true)
                    v.setBackgroundResource(R.drawable.green_border);
                else
                    v.setBackgroundResource(R.drawable.gray_border);
            }
        });
        pw_text.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus == true)
                    v.setBackgroundResource(R.drawable.green_border);
                else
                    v.setBackgroundResource(R.drawable.gray_border);
            }
        });

    }
}
