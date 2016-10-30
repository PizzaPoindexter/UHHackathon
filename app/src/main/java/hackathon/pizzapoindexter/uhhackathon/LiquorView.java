package hackathon.pizzapoindexter.uhhackathon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;

public class LiquorView extends AppCompatActivity {
    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);
    }

    public void whiskey(View view){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null) == "Male")
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 105;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String shotsStr = settings.getString("noLiquor", null);
        Integer shotsInt = Integer.parseInt(shotsStr);
        shotsInt++;
        shotsStr = shotsInt.toString();
        settings.edit().putString("noLiquor", shotsStr).apply();

        String bacStr = settings.getString("BAC", null);
        double bacFt = Float.parseFloat(bacStr);
        bacFt = (((Integer.parseInt(settings.getString("noBeers", null)) * 12 * .045) +
                (Integer.parseInt(settings.getString("noWine", null)) * 5 * .116) +
                (Integer.parseInt(settings.getString("noLiquor", null)) * 1.5 * .40)) +
                (Integer.parseInt(settings.getString("noMargs", null)) * 8 * .333) *
                        5.14 )/ (Integer.parseInt(settings.getString("Weight", null)) * genConst);
                bacStr = Double.toString(bacFt);
        settings.edit().putString("BAC", bacStr).apply();

        finish();
    }

    public void vodka(View view){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null) == "Male")
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 96;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String shotsStr = settings.getString("noLiquor", null);
        Integer shotsInt = Integer.parseInt(shotsStr);
        shotsInt++;
        shotsStr = shotsInt.toString();
        settings.edit().putString("noLiquor", shotsStr).apply();

        String bacStr = settings.getString("BAC", null);
        double bacFt = Float.parseFloat(bacStr);
        bacFt = (((Integer.parseInt(settings.getString("noBeers", null)) * 12 * .045) +
                (Integer.parseInt(settings.getString("noWine", null)) * 5 * .116) +
                (Integer.parseInt(settings.getString("noLiquor", null)) * 1.5 * .40)) +
                (Integer.parseInt(settings.getString("noMargs", null)) * 8 * .333) *
                        5.14 )/ (Integer.parseInt(settings.getString("Weight", null)) * genConst);
        bacStr = Double.toString(bacFt);
        settings.edit().putString("BAC", bacStr).apply();

        finish();
    }

    public void margarita(View view){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null) == "Male")
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 455;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String margStr = settings.getString("noMargs", null);
        Integer margInt = Integer.parseInt(margStr);
        margInt++;
        margStr = margInt.toString();
        settings.edit().putString("noMargs", margStr).apply();

        String bacStr = settings.getString("BAC", null);
        double bacFt = Float.parseFloat(bacStr);
        bacFt = (((Integer.parseInt(settings.getString("noBeers", null)) * 12 * .045) +
                (Integer.parseInt(settings.getString("noWine", null)) * 5 * .116) +
                (Integer.parseInt(settings.getString("noLiquor", null)) * 1.5 * .40)) +
                (Integer.parseInt(settings.getString("noMargs", null)) * 8 * .333) *
                        5.14 )/ (Integer.parseInt(settings.getString("Weight", null)) * genConst);
        bacStr = Double.toString(bacFt);
        settings.edit().putString("BAC", bacStr).apply();

        finish();
    }

}
