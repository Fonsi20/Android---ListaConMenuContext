package com.example.a16alfonsofa.listaconmenucontext;

import android.graphics.drawable.Drawable;

/**
 * Created by a16alfonsofa on 17/01/2019.
 */

public class Animal {
    private String nombre;
    private String desc;
    private Drawable img;

    public Animal(String nombre, String desc, Drawable img) {
        this.nombre = nombre;
        this.desc = desc;
        this.img = img;
    }

    public Animal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
