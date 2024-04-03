package com.example.kalkulatorbangun.FragmentRuang;

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
import com.example.kalkulatorbangun.FragmentRuang.FragmentContentRuang.KalkulatorBola;
import com.example.kalkulatorbangun.FragmentRuang.FragmentContentRuang.KalkulatorKerucut;
import com.example.kalkulatorbangun.FragmentRuang.FragmentContentRuang.KalkulatorKubus;
import com.example.kalkulatorbangun.FragmentRuang.FragmentContentRuang.KalkulatorTabung;
import com.example.kalkulatorbangun.ModelBangun;
import com.example.kalkulatorbangun.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentRuang extends Fragment implements AdapterBangun.ItemClickListener{

    List<ModelBangun> modelBangun = new ArrayList<>();
    AdapterBangun adapterBangun;

    int[] image = {R.drawable.bola,R.drawable.kerucut,R.drawable.kubus,R.drawable.tabung};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview2);

        menu();

        adapterBangun = new AdapterBangun(getContext(), modelBangun);
        recyclerView.setAdapter(adapterBangun);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBangun.setClickListener(this);

    }

    public void menu(){
        String[] bangunTitle = getResources().getStringArray(R.array.bangun_ruang);

        for (int i = 0; i < bangunTitle.length;i++){
            modelBangun.add(new ModelBangun(bangunTitle[i],image[i]));
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapterBangun.getItem(position).getName().equals("Bola")) {
            Intent intent = new Intent(getActivity(), KalkulatorBola.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Kerucut")) {
            Intent intent = new Intent(getActivity(), KalkulatorKerucut.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Kubus")) {
            Intent intent = new Intent(getActivity(), KalkulatorKubus.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getName().equals("Tabung")) {
            Intent intent = new Intent(getActivity(), KalkulatorTabung.class);
            startActivity(intent);
        }
    }
}