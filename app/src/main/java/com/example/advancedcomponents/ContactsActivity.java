package com.example.advancedcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    public ArrayList<Contacts> contactList;
    public ListView contactsLv;
    public ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getSupportActionBar().setTitle("Contacts");
        setupDataContacts();
        setContactsLv();
    }

    public void setupDataContacts() {
        contactList = new ArrayList<>();
        Contacts contact1 = new Contacts();
        contact1.name = "Viswanath";
        contact1.phoneNumber = "+91 9000303072";
        contactList.add(contact1);
        Contacts contact2 = new Contacts();
        contact2.name = "Renuka";
        contact2.phoneNumber = "+91 9000303073";
        contactList.add(contact2);
    }

    public void setContactsLv() {
        contactsLv = findViewById(R.id.contacts_lv);
        contactAdapter = new ContactAdapter(this, R.layout.listview_item, contactList);
        contactsLv.setAdapter(contactAdapter);
    }
}