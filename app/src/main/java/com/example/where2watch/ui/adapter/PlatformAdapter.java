package com.example.where2watch.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where2watch.R;
import com.example.where2watch.ui.model.Platform;

import java.util.List;

public class PlatformAdapter extends RecyclerView.Adapter<PlatformAdapter.PlatformViewHolder> {
    private List<Platform> platformList;

    public PlatformAdapter(List<Platform> platformList) {
        this.platformList = platformList;
    }

    @NonNull
    @Override
    public PlatformViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_platform, parent, false);
        return new PlatformViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatformViewHolder holder, int position) {
        Platform platform = platformList.get(position);
        holder.platformTextView.setText(platform.getPlatform());
        holder.priceTextView.setText(platform.getPrice());
        holder.platformImageView.setImageResource(platform.getImageResId());
    }

    @Override
    public int getItemCount() {
        return platformList.size();
    }

    public static class PlatformViewHolder extends RecyclerView.ViewHolder {
        TextView platformTextView, priceTextView;
        ImageView platformImageView;

        public PlatformViewHolder(View itemView) {
            super(itemView);
            platformTextView = itemView.findViewById(R.id.platform_name);
            priceTextView = itemView.findViewById(R.id.platform_price);
            platformImageView = itemView.findViewById(R.id.platform_image);
        }
    }
}
