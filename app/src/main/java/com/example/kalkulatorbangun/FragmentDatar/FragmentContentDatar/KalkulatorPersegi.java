package com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

public class KalkulatorPersegi extends AppCompatActivity {

    EditText inputUserET;
    TextView textHasilTV;
    Button buttonHasilBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_kotak);

        inputUserET = findViewById(R.id.input1);
        textHasilTV = findViewById(R.id.textHasil);
        buttonHasilBtn = findViewById(R.id.buttonHasil);

        buttonHasilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rumus();
            }
        });
    }

    public void rumus(){
        String inputUser = inputUserET.getText().toString();
        if(inputUser.isEmpty()){
            Toast.makeText(this, "Masukkan input terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
        else {
            double sisi = Double.parseDouble(inputUser);
            double luas = sisi * sisi;
            String hasil = String.format("%.2f", luas) + "cm";
            textHasilTV.setText(hasil);
        }
    }
}