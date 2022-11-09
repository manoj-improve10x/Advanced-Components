package com.example.advancedcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    public ArrayList<String> locations;
    public Spinner locationSp;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        getSupportActionBar().setTitle("Location");
        setupData();
        setupLocation();
    }

    public void setupData() {
        locations = new ArrayList<>();
        locations.add("Andhra Pradesh");
        locations.add("Arunachal Pradesh");
        locations.add("Assam");
        locations.add("Chhattisgarh");
        locations.add("Goa");
        locations.add("Gujarat");
        locations.add("Haryana");
        locations.add("Himachal Pradesh");
        locations.add("Jammu & Kashmir");
        locations.add("Jharkhand");
        locations.add("Karnataka");
        locations.add("Kerala");
        locations.add("Madhya Pradesh");
        locations.add("Maharashtra");
        locations.add("Manipur");
        locations.add("Meghalaya");
        locations.add("Mizoram");
        locations.add("Nagaland");
        locations.add("Odisha");
        locations.add("Odisha");
        locations.add("Odisha");
        locations.add("Sikkim");
        locations.add("Tamil Nadu");
        locations.add("Telangana");
        locations.add("Tripura");
        locations.add("Uttar Pradesh");
        locations.add("Uttarakhand");
        locations.add("west Bengal");
    }

    public void setupLocation() {
        locationSp = findViewById(R.id.location_sp);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.upper_case_xml, locations);
        locationSp.setAdapter(arrayAdapter);
        locationSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(LocationActivity.this, "State: " + locations.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}