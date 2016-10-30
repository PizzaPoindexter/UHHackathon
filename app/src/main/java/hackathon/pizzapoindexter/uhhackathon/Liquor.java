package hackathon.pizzapoindexter.uhhackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Liquor extends AppCompatActivity {
    public String name;
    public String abv; 
    public String calories;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);
    }
    
    public Liquor(String name, String abv, String calories) {
        this.name = name;
        this.abv = abv;
        this.calories = calories;
}

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 android:layout_width="match_parent"
 android:layout_height="match_parent" >
    <TextView
      android:id="@+id/drinkName"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Name" />
   <TextView
      android:id="@+id/drinkAbv"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="ABV" />
   <TextView
      android:id="@+id/drinkCalories"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Calories" />
</LinearLayout>
          
public class LiquorAdapter extends ArrayAdapter<Liquor> {
    public LiquorAdapter(Context context, ArrayList<Liquor> liquor) {
       super(context, 0, liquor);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
       User user = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
       }
       // Lookup view for data population
       TextView drinkName = (TextView) convertView.findViewById(R.id.drinkName);
       TextView drinkABV = (TextView) convertView.findViewById(R.id.drinkABV);
       TextView drinkCalories = (TextView) convertView.findViewById(R.id.drinkCalories);
       // Populate the data into the template view using the data object
       drinkName.setText(liquor.name);
       drinkABV.setText(liquor.abv);
       drinkCalories.setText(liquor.calories);
       // Return the completed view to render on screen
       return convertView;
   }
}
    
    // Construct the data source
ArrayList<Liquor> arrayOfLiquor = new ArrayList<Liquor>();
// Create the adapter to convert the array to views
UsersAdapter adapter = new UsersAdapter(this, arrayOfLiquor);
// Attach the adapter to a ListView
ListView listView = (ListView) findViewById(R.id.lvItems);
listView.setAdapter(adapter);
    
    // Add item to adapter
Liquor newLiquor1 = new Liquor("Whiskey", "40", "105");
adapter.add(newLiquor1);
Liquor newLiquor2 = new Liquor("Vodka", "40", "96");
adapter.add(newLiquor2);    
Liquor newLiquor3 = new Liquor("Rum", "37.5", "96");
adapter.add(newLiquor3);    
Liquor newLiquor4 = new Liquor("Sake", "15", "58.5");
adapter.add(newLiquor4);
Liquor newLiquor5 = new Liquor("Brandy", "40", "123");
adapter.add(newLiquor5);    
Liquor newLiquor6 = new Liquor("Gin", "40", "109.5");
adapter.add(newLiquor6);
Liquor newLiquor7 = new Liquor("Bourbon", "13.3", "97");
adapter.add(newLiquor7);
Liquor newLiquor8 = new Liquor("Tequila", "40", "103.5");
adapter.add(newLiquor8);    
Liquor newLiquor9 = new Liquor("Margarita", "33.3", "455");
adapter.add(newLiquor9);    
Liquor newLiquor10 = new Liquor("Long Island Ice Tea", "22", "138");
adapter.add(newLiquor10);    
Liquor newLiquor11 = new Liquor("Martini", "32", "240");
adapter.add(newLiquor11);
Liquor newLiquor12 = new Liquor("Cosmopolitan", "27.3", "213");
adapter.add(newLiquor12);    
// Or even append an entire new collection
// Fetching some data, data has now returned
// If data was JSON, convert to ArrayList of User objects.
JSONArray jsonArray = ...;
ArrayList<Liquor> newLiquor = Liquor.fromJson(jsonArray)
adapter.addAll(newLiquor);
