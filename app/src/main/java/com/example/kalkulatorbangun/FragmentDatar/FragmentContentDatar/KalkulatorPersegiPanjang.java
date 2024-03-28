package com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

public class KalkulatorPersegiPanjang extends AppCompatActivity {

    EditText inputUserET1,inputUserET2;
    TextView textHasilTV;
    Button buttonHasilBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_persegi_panjang);

        inputUserET1 = findViewById(R.id.input1);
        inputUserET2 = findViewById(R.id.input2);
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
        String inputUser1 = inputUserET1.getText().toString();
        String inputUser2 = inputUserET2.getText().toString();
        if(inputUser1.isEmpty() && inputUser2.isEmpty()){
            Toast.makeText(this, "Masukkan input terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
        else {
            double tinggi = Double.parseDouble(inputUser1);
            double lebar = Double.parseDouble(inputUser2);
            double luas = tinggi * lebar;
            String hasil = String.format("%.2f", luas) + "cm";
            textHasilTV.setText(hasil);
        }
    }
}