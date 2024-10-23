package com.example.carlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CarAdapter extends BaseAdapter {

    private Context context;
    private Car[] cars;

    public CarAdapter(Context context, Car[] cars) {
        this.context = context;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.length;
    }

    @Override
    public Object getItem(int position) {
        return cars[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false);
        }

        TextView carBrandTextView = convertView.findViewById(R.id.carBrandTextView);
        TextView carYearTextView = convertView.findViewById(R.id.carYearTextView);
        TextView carPriceTextView = convertView.findViewById(R.id.carPriceTextView);
        ImageView carImageView = convertView.findViewById(R.id.carImageView); // Ajouter une référence à l'image

        Car currentCar = cars[position];

        carBrandTextView.setText(currentCar.getBrand());
        carYearTextView.setText(String.valueOf(currentCar.getYear()));
        carPriceTextView.setText("$" + String.valueOf(currentCar.getPrice()));
        carImageView.setImageResource(currentCar.getImageResourceId()); // Afficher l'image

        return convertView;
    }
}
