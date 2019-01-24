package com.example.a16alfonsofa.listaconmenucontext;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by a16alfonsofa on 15/01/2019.
 */

public class AdaptadorPersonalizado extends ArrayAdapter {

    private Activity context;
    private Animal[] ani;

    public AdaptadorPersonalizado(Activity context, Animal[] ani) {
        super(context, R.layout.fila_layout, ani);
        this.context = context;
        this.ani = ani;
    }

    static class ViewHolder {
        TextView txAnimal;
        TextView txDescrop;
        ImageView imagen;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;
        ViewHolder holder;

        if (fila == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            fila = layoutInflater.inflate(R.layout.fila_layout, null);

            holder = new ViewHolder();

            holder.txAnimal = (TextView) fila.findViewById(R.id.txAnimal);
            holder.imagen = (ImageView) fila.findViewById(R.id.imgIcon);
            holder.txDescrop = (TextView) fila.findViewById(R.id.txDescripcionAnimal);

            fila.setTag(holder);
        } else {
            holder = (ViewHolder) fila.getTag();
        }

        if (position%2 == 0) {
            fila.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
        else{
            fila.setBackgroundColor(context.getResources().getColor(R.color.grey));
        }

        holder.txAnimal.setText(ani[position].getNombre());
        holder.txDescrop.setText(ani[position].getDesc());
        holder.imagen.setImageDrawable(ani[position].getImg());

        return fila;
    }
}
