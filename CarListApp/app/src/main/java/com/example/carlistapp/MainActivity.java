package com.example.carlistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView carListView;
    private Car[] cars = {
            new Car("Toyota", 2020, 20000, R.drawable.toyota), // Remplacez par les ID des ressources d'image
            new Car("Honda", 2018, 18000, R.drawable.honda),
            new Car("BMW", 2022, 45000, R.drawable.bmw),
            new Car("Mercedes", 2021, 55000, R.drawable.mercedes)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carListView = findViewById(R.id.carListView);

        // Créer et définir l'adaptateur
        CarAdapter adapter = new CarAdapter(this, cars);
        carListView.setAdapter(adapter);

        // Définir un écouteur de clic pour les éléments de la ListView
        carListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtenir la voiture cliquée et afficher un toast avec sa description
                Car selectedCar = cars[position];
                String description = "C'est une " + selectedCar.getBrand() +
                        ", fabriquée en " + selectedCar.getYear() +
                        ", au prix de $" + selectedCar.getPrice();
                Toast.makeText(MainActivity.this, description, Toast.LENGTH_LONG).show();
            }
        });
    }
}
