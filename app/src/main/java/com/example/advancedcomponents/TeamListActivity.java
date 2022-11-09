package com.example.advancedcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TeamListActivity extends AppCompatActivity {

    public ArrayList<String> membersList;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        getSupportActionBar().setTitle("Team List");
        setupDataForMembers();
        setupDataAdd();
        setupDelete();
        setupDataList();
    }

    public void setupDataForMembers() {
        membersList = new ArrayList<>();
        membersList.add("Viswanath");
        membersList.add("Renuka");
    }

    public void setupDataAdd() {
        Button membersAddBtn = findViewById(R.id.members_add_btn);
        membersAddBtn.setOnClickListener(view -> {
            EditText membersNameTxt = findViewById(R.id.members_name_txt);
            String membersNames = membersNameTxt.getText().toString();
            if (membersNames.equals("") == false) {
                arrayAdapter.add(membersNames);
                arrayAdapter.notifyDataSetChanged();
            }
            membersNameTxt.setText("");
        });
    }

    public void setupDelete() {
        Button deleteBtn = findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(view -> {
            EditText membersNameTxt = findViewById(R.id.members_name_txt);
            String memberName = membersNameTxt.getText().toString();
            arrayAdapter.remove(memberName);
            arrayAdapter.notifyDataSetChanged();
            membersNameTxt.setText("");
        });
    }

    public void setupDataList() {
        ListView membersLv = findViewById(R.id.members_lv);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, membersList);
        membersLv.setAdapter(arrayAdapter);
        membersLv.setOnItemClickListener((adapterView, view, position, l) -> {
            Toast.makeText(this, "Clicked : " + membersList.get(position), Toast.LENGTH_SHORT).show();
            String memberName = membersList.get(position);
            EditText membersNameTxt = findViewById(R.id.members_name_txt);
            membersNameTxt.setText(memberName);
        });
    }
}