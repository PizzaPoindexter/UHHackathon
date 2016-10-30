package hackathon.pizzapoindexter.uhhackathon;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";
    private EditText units;
    private EditText gender;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        units = (EditText) findViewById(R.id.units);
        gender = (EditText) findViewById(R.id.gender);

        if(settings.getBoolean("my_first_time", true)){
            units.setText("Pounds");
            Log.d("Ayyy", "lmao ");
            gender.setText("Male");
            settings.edit().putBoolean("my_first_time", true).apply();
        }
        units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SettingsActivity.this, units);

                popup.getMenuInflater()
                        .inflate(R.menu.weightpopupfile, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        units.setText(item.getTitle().toString());
                        return true;
                    }
                });
                popup.show();
            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SettingsActivity.this, gender);

                popup.getMenuInflater()
                        .inflate(R.menu.genderpopupfile, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        gender.setText(item.getTitle().toString());
                        return true;
                    }
                });
                popup.show();
            }
        });

    }

   protected void onPause(){
        super.onPause();

        units = (EditText) findViewById(R.id.units);
        gender = (EditText) findViewById(R.id.gender);
        weight = (EditText)findViewById(R.id.weight);

        String weightChoice = weight.getText().toString();
        String unitChoice = units.getText().toString();
        String genderChoice = gender.getText().toString();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        settings.edit().putString("Weight", weightChoice).apply();
        settings.edit().putString("Units", unitChoice).apply();
        settings.edit().putString("Gender", genderChoice).apply();
    }

    @Override
    protected void onResume(){
        super.onResume();

        weight = (EditText)findViewById(R.id.weight);
        units = (EditText)findViewById(R.id.units);
        gender = (EditText)findViewById(R.id.gender);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String weightChoice = settings.getString("Weight", null);
        weight.setText(weightChoice);

        String unitChoice = settings.getString("Units", null);
        units.setText(unitChoice);

        String genderChoice = settings.getString("Gender", null);
        gender.setText(genderChoice);
    }
}
