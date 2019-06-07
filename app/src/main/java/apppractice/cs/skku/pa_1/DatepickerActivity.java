package apppractice.cs.skku.pa_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatepickerActivity extends Activity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.date_picker);

        DatePicker datePicker = (DatePicker)findViewById(R.id.date_Picker);
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                date = year + "." + monthOfYear + "." + dayOfMonth;
            }
        });
    }

    public void dOnclick(View v){

            Intent intent = new Intent();
            intent.putExtra("date", date);
            setResult(RESULT_OK, intent);
            finish();
    }
}

