package com.example.advancedcomponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contacts> {
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item,parent,false);
        Contacts contacts = getItem(position);
        TextView contactNameTxt = view.findViewById(R.id.contact_name_txt);
        contactNameTxt.setText(contacts.name);
        TextView phoneNumberTxt = view.findViewById(R.id.phone_number_txt);
        phoneNumberTxt.setText(contacts.phoneNumber);
        return view;
    }
}
