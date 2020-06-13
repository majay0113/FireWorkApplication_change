package com.example.fireworkapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    List<Food> mNamesF ;

    List<Food> mNamesM;

    List<Food> mNamesV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.boomnav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(),MyFavouriteRecipeMainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_bar:
                        startActivity(new Intent(getApplicationContext(),SearchRecipeMainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ingredient:
                        startActivity(new Intent(getApplicationContext(),MyFridgeMainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });


        mNamesF = new ArrayList<>();
        mNamesM = new ArrayList<>();
        //fruit list
        mNamesV = new ArrayList<>();
        //fruit list
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fruit_list);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNamesF);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getJsonFile();


        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.meat_list);
        RecyclerViewAdapter adapterM = new RecyclerViewAdapter(this,mNamesM);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(adapterM);
        getJsonFileM();

        RecyclerView recyclerViewV = (RecyclerView) findViewById(R.id.veg_list);
        RecyclerViewAdapter adapterV = new RecyclerViewAdapter(this,mNamesV);
        recyclerViewV.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewV.setAdapter(adapterV);
        getJsonFileV();

    }
    public String LoadJSONFormAsset(){
        String json = null;
        try {
            InputStream inputStream = MainActivity.this.getAssets().open("fruit");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private  void getJsonFile() {
        try {
            JSONObject jsonObject = new JSONObject(LoadJSONFormAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("fruit");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String names = item.getString("name");
                String image = item.getString("image");
                int images = getResources().getIdentifier(image, "drawable", getPackageName());

                Food food = new Food(names, images);
                mNamesM.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String LoadJSONFormAssetM(){
        String json1 = null;
        try {
            InputStream inputStream = MainActivity.this.getAssets().open("meat");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json1 = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json1;
    }

    private  void getJsonFileM(){
        try {
            JSONObject jsonObject = new JSONObject(LoadJSONFormAssetM());
            JSONArray jsonArray = jsonObject.getJSONArray("meat");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String names = item.getString("name");
                String image = item.getString("image");
                int images = getResources().getIdentifier(image , "drawable", getPackageName());

                Food food = new Food(names,images);
                mNamesF.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String LoadJSONFormAssetV(){
        String json1 = null;
        try {
            InputStream inputStream = MainActivity.this.getAssets().open("vege");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json1 = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json1;
    }

    private  void getJsonFileV(){
        try {
            JSONObject jsonObject = new JSONObject(LoadJSONFormAssetV());
            JSONArray jsonArray = jsonObject.getJSONArray("vege");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String names = item.getString("name");
                String image = item.getString("image");
                int images = getResources().getIdentifier(image , "drawable", getPackageName());

                Food food = new Food(names,images);
                mNamesV.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}