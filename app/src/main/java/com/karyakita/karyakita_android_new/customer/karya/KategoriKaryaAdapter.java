package com.karyakita.karyakita_android_new.customer.karya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;

import java.util.ArrayList;
import java.util.List;

public class KategoriKaryaAdapter extends RecyclerView.Adapter<KategoriKaryaAdapter.Holder> {

    List<KategoriKaryaModel> kategoriKaryaModelList;
    Context context;

    public KategoriKaryaAdapter(List<KategoriKaryaModel> kategoriKaryaModelList, Context context) {
        this.kategoriKaryaModelList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_kategori_home, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriKaryaAdapter.Holder holder, int position) {
        holder.tv_kategori_name_home.setText(kategoriKaryaModelList.get(position).getKategori());
        Glide.with(context).load(kategoriKaryaModelList.get(position).getDeploy_url()).into(holder.iv_image_kategori_home);
    }

    @Override
    public int getItemCount() {
        return this.kategoriKaryaModelList.size();
    }

    public void addToList(KategoriKaryaModel kategoriKaryaModel) {
        kategoriKaryaModelList.add(kategoriKaryaModel);
    }

    public class Holder extends RecyclerView.ViewHolder {
        FrameLayout layout_kategori_home;
        ImageView iv_image_kategori_home;
        TextView tv_kategori_name_home;

        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            layout_kategori_home = itemView.findViewById(R.id.layout_kategori_home);
            tv_kategori_name_home = itemView.findViewById(R.id.tv_kategori_name_home);
            iv_image_kategori_home = itemView.findViewById(R.id.iv_image_kategori_home);


            layout_kategori_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Bundle bundle = new Bundle();
                    bundle.putInt("kategori_id", kategoriKaryaModelList.get(position).getId());

                    Intent intent = new Intent(context.getApplicationContext(), ListKaryaActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
