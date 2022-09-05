package com.example.clase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> Log.d("msg","fab presionado"));

        TextView textView = findViewById(R.id.hello_world);
        textView.setOnLongClickListener(view -> {

            MainActivity.this.startActionMode(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    getMenuInflater().inflate(R.menu.contextual_menu_bar, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.btn_phone:
                            Log.d("msg", "botón phone presionado");
                            actionMode.finish();
                            return true;
                        case R.id.btn_printer:
                            Log.d("msg", "botón printer presionado");
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public void onDestroyActionMode(ActionMode actionMode) {

                }
            });
            return true;
        });
    }

    public void abrirDialogo(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Alerta clase 4");
        alertDialog.setMessage("Este es un mensaje de alerta\n para avisarles que no estoy grabando");
        alertDialog.setPositiveButton(R.string.aceptar, (dialogInterface, i) ->
                Log.d("msg", "btn aceptar presionado"));

        alertDialog.setNegativeButton(R.string.cancelar, (dialogInterface, i) ->
                Log.d("msg", "btn cancelar presionado"));
        alertDialog.show();

    }

    public void abrirDialogoConLista(View view){
        String[] listaMejoresAmigos = {"Junior", "Victor","Wilmer","Melanie","Nicole"};

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Selección de tu mejor amigo(a) :v");
        //alertDialog.setMessage("Selecciona a tu mejor amigo(a) de la clase");
        alertDialog.setItems(listaMejoresAmigos, (dialogInterface, i) -> {
            String alumSeleccionado = listaMejoresAmigos[i];
            Log.d("msg",alumSeleccionado);
        });
        alertDialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
        return true;
    }

    public void textoClick(View view) {
        Log.d("msg", "clic texto");
    }

    public void botonAdd(MenuItem menuItem) {
        Toast.makeText(this, "Boton + presionado", Toast.LENGTH_SHORT).show();
    }

    public void btnToolAction(MenuItem menuItem) {
        Log.d("msg", "btn_tool");

        View view = findViewById(R.id.btn_tool);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sub_menu_tool, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem1.getItemId()) {
                case R.id.btn_tool_editar:
                    Log.d("msg", "btn_tool_editar pressed");
                    return true;
                case R.id.btn_tool_borrar:
                    Log.d("msg", "btn_tool_borrar pressed");
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_add:
                Log.d("msg", "botón + presionado");
                break;
            case R.id.btn_alert:
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                Log.d("msg", "botón alert presionado");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}