package com.example.rancho.design;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rancho.R;
import com.example.rancho.Model.Animales;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class CustomAdapterVentas extends BaseAdapter {

    private final Context context;
    private final ArrayList<Animales> listaAnimales;

    private FirebaseFirestore firestore;
    private FirebaseStorage storage;
    private StorageReference storageRef;

    byte[] ImagenAnimal;

    public CustomAdapterVentas(Context context, ArrayList<Animales> listaAnimales) {
        this.context = context;
        this.listaAnimales = listaAnimales;
        FirebaseApp.initializeApp(context);
        firestore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }

    @Override
    public int getCount() {
        return listaAnimales.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAnimales.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.cardview_animalesventas,
                    parent, false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        }else{
            holderView = (HolderView) convertView.getTag();
        }

        Animales lista = listaAnimales.get(position);
        holderView.peso.setText(lista.getDescripcion());
        holderView.nombre_animal.setText(lista.getNombre());
        holderView.nombre_vendedor.setText(lista.getPropietario());
        holderView.nombre_comprador.setText(lista.getComprador());
        holderView.precio.setText("$"+lista.getPrecio());

        storageRef.child("/"+lista.getId()+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holderView.imagenAnimal);
                holderView.imagenAnimal.setRotation(90);
            }
        });

        return convertView;
    }

    private static class HolderView{
        private final ImageView imagenAnimal;
        private final TextView peso;
        private final TextView nombre_animal;
        private final TextView nombre_vendedor;
        private final TextView nombre_comprador;
        private final TextView precio;

        public HolderView(View view){
            imagenAnimal = view.findViewById(R.id.imagenAnimal);
            peso = view.findViewById(R.id.peso);
            nombre_animal = view.findViewById(R.id.nombre_animal);
            nombre_vendedor = view.findViewById(R.id.nombre_vendedor);
            nombre_comprador = view.findViewById(R.id.nombre_comprador);
            precio = view.findViewById(R.id.precio);
        }
    }

}