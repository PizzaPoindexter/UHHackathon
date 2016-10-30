package hackathon.pizzapoindexter.uhhackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkingActivity extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";
    private TextView calories;
    private TextView bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);


        calories = (TextView)findViewById(R.id.calories);
        bac = (TextView)findViewById(R.id.bac);

        calories.setText(settings.getString("Calories", null));
        bac.setText(settings.getString("BAC", null));
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //button will lead to addDrink
        //fab.setImageResource(R.drawable.ic_notifications_black_24dp);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drinking_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.settings:
                intent = new Intent(this, SettingsActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }
}
