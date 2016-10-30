package hackathon.pizzapoindexter.uhhackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewDrink extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);
    }

    public void newBeer(View view){
        Intent intent = new Intent(this, Beer.class);
        startActivity(intent);
    }

    public void wine(View view){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double genConst;
        if(settings.getString("Gender", null).equals("Male"))
            genConst = .73;
        else
            genConst = .66;

        String calStr = settings.getString("Calories", null);
        Integer calInt = Integer.parseInt(calStr);
        calInt += 123;
        calStr = calInt.toString();
        settings.edit().putString("Calories", calStr).apply();

        String wineStr = settings.getString("noWine", null);
        Integer wineInt = Integer.parseInt(wineStr);
        wineInt++;
        wineStr = wineInt.toString();
        settings.edit().putString("noWine", wineStr).apply();

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

    public void newLiquor(View view){
        Intent intent = new Intent(this, LiquorView.class);
        startActivity(intent);
    }


}
