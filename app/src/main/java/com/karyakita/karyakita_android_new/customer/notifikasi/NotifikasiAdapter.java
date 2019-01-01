package com.karyakita.karyakita_android_new.customer.notifikasi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.DetailPesananSayaActivity;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;

import java.util.ArrayList;
import java.util.List;

public class NotifikasiAdapter extends RecyclerView.Adapter<NotifikasiAdapter.Holder> {

    List<NotifikasiModel> notifikasiModelList;
    Context context;

    public NotifikasiAdapter(Context context) {
        this.notifikasiModelList = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_notifikasi_customer, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotifikasiAdapter.Holder holder, int position) {
        //Glide.with(context).load(notifikasiModelList.get(position).getDeploy_url()).into(holder.iv_user);
        holder.tv_judul_notifikasi.setText(notifikasiModelList.get(position).getJudul_notifikasi());
        holder.tv_informasi.setText(String.valueOf(notifikasiModelList.get(position).getDeskripsi()));
        holder.tv_tanggal_notifikasi.setText(String.valueOf(notifikasiModelList.get(position).getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return this.notifikasiModelList.size();
    }

    public void addToList(NotifikasiModel notifikasiModel) {
        notifikasiModelList.add(notifikasiModel);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_user;
        TextView tv_judul_notifikasi, tv_informasi, tv_tanggal_notifikasi;

        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            itemView.setOnClickListener(this);

            iv_user = itemView.findViewById(R.id.iv_user);
            tv_judul_notifikasi = itemView.findViewById((R.id.tv_judul_notifikasi));
            tv_informasi = itemView.findViewById(R.id.tv_informasi);
            tv_tanggal_notifikasi = itemView.findViewById(R.id.tv_tanggal_notifikasi);
        }

        @Override
        public void onClick(View v) {
            Integer position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                Bundle bundle = new Bundle();
                bundle.putInt("notifikasi_id", notifikasiModelList.get(position).getId());
                Intent intent = new Intent(context.getApplicationContext(), DetailNotifikasi.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        }
    }

}
