package hackathon.pizzapoindexter.uhhackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewDrink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);
    }

    public void newBeer(View view){
        Intent intent = new Intent(this, Beer.class);
        startActivity(intent);
    }

    public void newWine(View view){
        Intent intent = new Intent(this, Wine.class);
        startActivity(intent);
    }

    public void newLiquor(View view){
        Intent intent = new Intent(this, Liquor.class);
        startActivity(intent);
    }


}
