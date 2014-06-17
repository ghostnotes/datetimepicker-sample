package jp.ghostnotes.datetimepickersample.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fourmob.datetimepicker.date.DatePickerDialog;

import java.lang.Override;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity implements DatePickerDialog.OnDateSetListener {
    private static final String TAG_DATEPICKERDIALOG = "TAG_DATEPICKERDIALOG";
    private static final int YEAR_RANGE_FROM = 1985;
    private static final int YEAR_RANGE_TO = 2020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
            MainActivity.this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            false
        );

        Button buttonDate = (Button) findViewById(R.id.button_date);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.setVibrate(false);
                datePickerDialog.setYearRange(YEAR_RANGE_FROM, YEAR_RANGE_TO);
                datePickerDialog.show(getSupportFragmentManager(), TAG_DATEPICKERDIALOG);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        Toast.makeText(MainActivity.this, year + "/" + (month + 1) + "/" + day, Toast.LENGTH_SHORT).show();
    }
}
