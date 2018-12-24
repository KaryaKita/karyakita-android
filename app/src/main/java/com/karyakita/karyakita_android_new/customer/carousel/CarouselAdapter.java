package com.karyakita.karyakita_android_new.customer.carousel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;

import java.util.ArrayList;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {
    private List<Item> carouselList;
    private Context context;

    public CarouselAdapter(List<Item> data, Context context) {
        this.carouselList = new ArrayList<>();
        this.carouselList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_carousel_customer, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(carouselList.get(position).getImage())
                .into(holder.image_carousel);
    }

    @Override
    public int getItemCount() {
        return carouselList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_carousel;

        public ViewHolder(View itemView) {
            super(itemView);
            image_carousel = itemView.findViewById(R.id.image_carousel);
        }
    }
}
