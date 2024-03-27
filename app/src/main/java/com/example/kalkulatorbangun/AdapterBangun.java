package com.example.kalkulatorbangun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterBangun extends RecyclerView.Adapter<AdapterBangun.MyViewHolder> {
    Context context;
    List<ModelBangun> modelBangun;
    private ItemClickListener mClickListener;

    public AdapterBangun(Context context, List<ModelBangun> modelBangun){
        this.context = context;
        this.modelBangun = modelBangun;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content_layout, parent, false);

        return new AdapterBangun.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(modelBangun.get(position).getName());
        holder.imageView.setImageResource(modelBangun.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return modelBangun.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView tvName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public ModelBangun getItem(int id) {return  modelBangun.get(id);}
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}