package com.example.ceiro.peopleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private Button clrBtn;
    private Button okBtn;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.first);
        lastName = findViewById(R.id.last);
        clrBtn = findViewById(R.id.clrBtn);
        okBtn = findViewById(R.id.okBtn);
        list = findViewById(R.id.list);

        final List<String> itemsList = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, itemsList);
        list.setAdapter(arrayAdapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsList.add(firstName.getText() + " " + lastName.getText());
                arrayAdapter.notifyDataSetChanged();
                firstName.setText("");
                lastName.setText("");
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                itemsList.remove(adapter.getItemAtPosition(position));
                arrayAdapter.notifyDataSetChanged();
            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.setText("");
                lastName.setText("");
            }
        });
    }

}
