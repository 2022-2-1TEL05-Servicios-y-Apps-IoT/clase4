package com.example.clase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        registerForContextMenu(findViewById(R.id.textView2));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_reply:
                Log.d("msg", "btn reply");
                return true;
            case R.id.btn_reply_all:
                Log.d("msg", "btn reply all");
                return true;
            case R.id.btn_forward_all:
                Log.d("msg", "btn forward");
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}