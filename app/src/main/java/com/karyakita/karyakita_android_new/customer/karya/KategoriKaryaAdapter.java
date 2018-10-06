package com.karyakita.karyakita_android_new.customer.karya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.Result;

import java.util.List;

public class KategoriKaryaAdapter extends RecyclerView.Adapter<KategoriKaryaAdapter.Holder> {

    List<KategoriKaryaModel> kategoriKaryaModelList;
    Context context;

    public KategoriKaryaAdapter(List<KategoriKaryaModel> kategoriKaryaModelList, Context context) {
        this.kategoriKaryaModelList = kategoriKaryaModelList;
        this.context = context;
    }

    public KategoriKaryaAdapter() {
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_kategori_home, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriKaryaAdapter.Holder holder, int position) {
        Glide.with(context).load(kategoriKaryaModelList.get(position).getLocal_url()).into(holder.iv_image_kategori_home);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void addToList(KategoriKaryaModel kategoriKaryaModel) {
        kategoriKaryaModelList.add(kategoriKaryaModel);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView iv_image_kategori_home;
        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            iv_image_kategori_home = itemView.findViewById(R.id.iv_image_kategori_home);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "OKe", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
