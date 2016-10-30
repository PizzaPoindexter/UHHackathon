package hackathon.pizzapoindexter.uhhackathon;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Beer extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
    }

    public void beer(View view){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null).equals("Male"))
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 154;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String beerStr = settings.getString("noBeers", null);
        Integer beerInt = Integer.parseInt(beerStr);
        beerInt++;
        beerStr = beerInt.toString();
        settings.edit().putString("noLiquor", beerStr).apply();

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

    public void beerLite(View view){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null).equals("Male"))
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 104;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String beerStr = settings.getString("noBeers", null);
        Integer beerInt = Integer.parseInt(beerStr);
        beerInt++;
        beerStr = beerInt.toString();
        settings.edit().putString("noLiquor", beerStr).apply();

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
