package hackathon.pizzapoindexter.uhhackathon;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class DrinkingActivity extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";
    private TextView calories;
    private TextView bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);


        calories = (TextView) findViewById(R.id.calories);
        bac = (TextView) findViewById(R.id.bac);

        calories.setText(settings.getString("Calories", null));
        bac.setText(settings.getString("BAC", null));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newDrink(view);
            }
        });
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

    public void newDrink(View view){
        Intent intent = new Intent(this, NewDrink.class);
        startActivity(intent);
    }

    protected void onPause(){
        super.onPause();
    }

    protected void onResume(){
        super.onResume();

        calories = (TextView)findViewById(R.id.calories);
        bac = (TextView)findViewById(R.id.bac);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        calories.setText(settings.getString("Calories", null));
        bac.setText(settings.getString("BAC", null));

        double bacFt = Float.parseFloat(settings.getString("BAC", null));
        if(bacFt >= 0.08)
            theyDrunkTho();
    }

    private void theyDrunkTho(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        AlertDialog.Builder builder1 = builder.setView(inflater.inflate(R.layout.youdrunkpopup, null)).setPositiveButton("Thanks!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

            public void onClick(DialogInterface dialog) {
                Log.d("Drunk:", "They're drunk");
            }
        });
        builder.create().show();
    }
}


