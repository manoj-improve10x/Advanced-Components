package com.example.advancedcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddMembersActivity extends AppCompatActivity {

    public ArrayList<String> teams;
    public ArrayList<String> teamA;
    public ArrayList<String> teamB;
    public ArrayList<String> allMembers;
    public ArrayAdapter<String> arrayAdapter;
    public Spinner allMembersSp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        getSupportActionBar().setTitle("Add Members");
        setupDataForTeams();
        setupDataForTeamA();
        setupDataForTeamB();
        setupDataForAllMembers();
        setupAdd();
        setupTeam();
        setupAllMembers();
        setupTeamA();
        setupTeamB();
    }
    public void setupAdd() {
        Button addButtonBtn = findViewById(R.id.add_button_btn);
        addButtonBtn.setOnClickListener(view -> {
            EditText addNameTxt = findViewById(R.id.add_name_txt);
            String name = addNameTxt.getText().toString();
            if (name.equals("")==false) {
                arrayAdapter.add(name);
                arrayAdapter.notifyDataSetChanged();
            }
            addNameTxt.setText("");
        });
    }

    private void setupDataForTeams() {
        teams = new ArrayList<>();
        teams.add("Team A");
        teams.add("Team B");
    }
    public void setupDataForAllMembers() {
        allMembers = new ArrayList<>();
        allMembers.add("Viswanath");
        allMembers.add("Renuka");
    }
    public void setupDataForTeamA() {
        teamA = new ArrayList<>();
        teamA.add("Viswanath");
        teamA.add("Renuka");
    }
    public void setupDataForTeamB() {
        teamB = new ArrayList<>();
        teamB.add("Viswanath");
        teamB.add("Renuka");
    }

    public void setupTeam() {
        Spinner teamSp = findViewById(R.id.taem_sp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teams);
        teamSp.setAdapter(arrayAdapter);
    }

    public void setupAllMembers() {
        allMembersSp = findViewById(R.id.all_members_sp);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allMembers);
        allMembersSp.setAdapter(arrayAdapter);
    }

    public void setupTeamA() {
        Spinner teamASp = findViewById(R.id.team_a_sp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamA);
        teamASp.setAdapter(arrayAdapter);
        teamASp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(AddMembersActivity.this, "Name: " + teamA.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void setupTeamB() {
        Spinner teamBSp = findViewById(R.id.team_b_sp);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamB);
        teamBSp.setAdapter(arrayAdapter);
        teamBSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(AddMembersActivity.this, "Name: " + teamB.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}