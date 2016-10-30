package hackathon.pizzapoindexter.uhhackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void startDrinking(View view){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        settings.edit().putString("Calories", "0").apply();
        settings.edit().putString("BAC", "0");
        Intent intent = new Intent(this, DrinkingActivity.class);
        startActivity(intent);
    }
}
