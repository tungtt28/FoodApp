package com.example.foodapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.ViewHolder>{
    ArrayList<Foods> items;
    Context context;

    public BestFoodsAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_best_deal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.starTxt.setText(""+items.get(position).getStar());
        holder.timeTxt.setText(items.get(position).getTimeValue()+" min");
        holder.priceTxt.setText("$"+items.get(position).getPrice());

        Glide.with(context).load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, starTxt, timeTxt, priceTxt;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            starTxt = itemView.findViewById(R.id.starTxt);
            pic = itemView.findViewById(R.id.pic);
            timeTxt = itemView.findViewById(R.id.timeTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
        }
    }
}
