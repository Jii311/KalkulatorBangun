package com.example.kalkulatorbangun.FragmentDatar;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalkulatorbangun.AdapterBangun;
import com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar.KalkulatorPersegi;
import com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar.KalkulatorLingkaran;
import com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar.KalkulatorPersegiPanjang;
import com.example.kalkulatorbangun.FragmentDatar.FragmentContentDatar.KalkulatorSegitiga;
import com.example.kalkulatorbangun.ModelBangun;
import com.example.kalkulatorbangun.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentDatar extends Fragment implements AdapterBangun.ItemClickListener{

    List<ModelBangun> modelBangun = new ArrayList<>();
    AdapterBangun adapterBangun;

    int[] image = {R.drawable.kotak,R.drawable.lingkaran,R.drawable.persegi_panjang,R.drawable.segitiga};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview1);

        menu();

        adapterBangun = new AdapterBangun(getContext(), modelBangun);
        recyclerView.setAdapter(adapterBangun);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBangun.setClickListener(this);

    }

    public void menu(){
        String[] bangunTitle = getResources().getStringArray(R.array.bangun_datar);

        for (int i = 0; i < bangunTitle.length;i++){
            modelBangun.add(new ModelBangun(bangunTitle[i],image[i]));
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapterBangun.getItem(position).getName().equals("Persegi")) {
            Intent intent = new Intent(getActivity(), KalkulatorPersegi.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Lingkaran")) {
            Intent intent = new Intent(getActivity(), KalkulatorLingkaran.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Persegi Panjang")) {
            Intent intent = new Intent(getActivity(), KalkulatorPersegiPanjang.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Segitiga")) {
            Intent intent = new Intent(getActivity(), KalkulatorSegitiga.class);
            startActivity(intent);
        }
    }
}