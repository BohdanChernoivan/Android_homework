package com.example.dz_26_widgets;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();

        setEditFirstName();

        setEditLastName();

        setEditAge();

        setToolbar();
    }

    private void control() {
        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edt_last_name);
        editAge = findViewById(R.id.edt_age);
        toolbar = findViewById(R.id.tool_bar);
    }

    private void setToolbar() {
        toolbar.setTitle("Block");
        toolbar.setNavigationIcon(R.drawable.ic_block);
    }


    private void setEditLastName(){
        editLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().matches("\\d")) {
                    editLastName.setError("Should not be numbers");
                } else
                    editLastName.setError(null);
            }
        });
    }

    private void setEditAge() {
        editAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().matches("\\D")) {
                    editAge.setError("Only numbers");
                } else
                    editAge.setError(null);
            }
        });
    }

    private void setEditFirstName() {
        editFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().contains("-")) {
                    editFirstName.setError("Must not be \"-\"");
                } else if(s.toString().matches("\\d")) {
                    editFirstName.setError("Should not be numbers");
                } else
                    editFirstName.setError(null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        getMenuInflater().inflate(R.menu.stop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
