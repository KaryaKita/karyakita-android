package com.karyakita.karyakita_android_new.customer.karya;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;

import java.util.ArrayList;
import java.util.List;

public class ListKaryaAdapter extends RecyclerView.Adapter<ListKaryaAdapter.Holder> {
    List<ListKaryaModel> listKaryaModelList;
    Context context;

    public ListKaryaAdapter(List<ListKaryaModel> listKaryaModelList, Context context) {
        this.listKaryaModelList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_list_karya, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(listKaryaModelList.get(position).getDeploy_url()).into(holder.iv_listKarya);
        holder.tv_judulkarya.setText(listKaryaModelList.get(position).getNama());
//        holder.tv_kategorikarya.setText(listKaryaModelList.get(position).getKategori_karya_id().toString());
    }

    @Override
    public int getItemCount() {
        return this.listKaryaModelList.size();
    }

    public void addToList(ListKaryaModel listKaryaModel) {
        listKaryaModelList.add(listKaryaModel);
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView iv_listKarya;
        TextView tv_judulkarya, tv_kategorikarya;

        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            iv_listKarya = itemView.findViewById(R.id.iv_gambar_karya);
            tv_judulkarya = itemView.findViewById(R.id.iv_judul_karya);
//            tv_kategorikarya=itemView.findViewById(R.id.iv_category_karya);
            iv_listKarya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context.getApplicationContext(), DetailKaryaActivity.class));
                }
            });
        }
    }
}
