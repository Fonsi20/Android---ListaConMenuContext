package com.example.a16alfonsofa.listaconmenucontext;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Animal[] anima;
    private Animal animalo;
    private String nombre;
    private ArrayList<Animal> animaList;
    private ArrayAdapter<> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv_animales);

        String[] arrayAnimales = getResources().getStringArray(R.array.animales);
        String[] arrayDescrip = getResources().getStringArray(R.array.DescripAnimales);
        TypedArray idFotos = getResources().obtainTypedArray(R.array.fotos);

        anima = new Animal[arrayAnimales.length];

        for (int i = 0; i < arrayAnimales.length; i++) {
            Drawable fotos = idFotos.getDrawable(i);
            Animal ani = new Animal(arrayAnimales[i], arrayDescrip[i], fotos);
            anima[i] = ani;
        }

        animaList.addAll(Arrays.asList(anima));

        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(this, animaList);
        lv.setAdapter(adaptador);

        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Elección: " + anima[position].getNombre(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        animalo = (Animal) lv.getAdapter().getItem(info.position);
        nombre = animalo.getNombre();
        menu.setHeaderTitle(animalo.getNombre());

        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (id) {
            case R.id.item1:
                adaptador.remove(adaptador.getItem(info.position));
                Toast.makeText(this, "Opción: " + item.getTitle() + " con nombre " + nombre, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Opción: " + item.getTitle() + " con nombre " + nombre, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}