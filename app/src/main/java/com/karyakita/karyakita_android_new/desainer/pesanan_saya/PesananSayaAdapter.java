package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;

public class PesananSayaAdapter extends RecyclerView.Adapter<PesananSayaAdapter.Holder> {
     List<PesananSayaModel> pesananSayaModelList;
     Context context;

     public PesananSayaAdapter(List<PesananSayaModel> pesananSayaModelList, Context context) {
         this.pesananSayaModelList = new ArrayList<>();
         this.context = context;
     }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_daftar_pesanan, parent, false);
         return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Glide.with(context).load(pesananSayaModelList.get(position).getDeploy_url()).into(holder.iv_gambarPesanan);
        holder.tv_judulKarya.setText(pesananSayaModelList.get(position).getNama());
        holder.tv_deadline.setText(pesananSayaModelList.get(position).getDeadline().toString());
        holder.tv_ukuranKarya.setText(pesananSayaModelList.get(position).getUkuran_kertas());
        holder.tv_opsiBingkai.setText(pesananSayaModelList.get(position).getOpsi_bingkai());
        holder.tv_jenisPesanan.setText(pesananSayaModelList.get(position).getJenis_order_id());
    }

    @Override
    public int getItemCount() {
        return pesananSayaModelList.size();
    }

    public void addToList(PesananSayaModel pesananSayaModel) {
         pesananSayaModelList.add(pesananSayaModel);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
         ImageView iv_gambarPesanan;
         TextView tv_judulKarya, tv_deadline, tv_ukuranKarya, tv_opsiBingkai, tv_jenisPesanan;

         public Holder(View itemView){
             super(itemView);
             context = itemView.getContext();

             itemView.setOnClickListener(this);

             iv_gambarPesanan = itemView.findViewById(R.id.iv_pesanan);
             tv_judulKarya = itemView.findViewById(R.id.tv_judul_karya);
             tv_deadline = itemView.findViewById(R.id.tv_deadline);
             tv_ukuranKarya = itemView.findViewById((R.id.tv_ukuran_karya));
             tv_opsiBingkai = itemView.findViewById((R.id.tv_opsi_bingkai));
             tv_jenisPesanan = itemView.findViewById((R.id.tv_jenis_pesanan));
         }

        @Override
        public void onClick(View v) {
            Integer position = getAdapterPosition();
            Intent intent = null;

            if(position != RecyclerView.NO_POSITION){
                Bundle bundle = new Bundle();
                bundle.putInt("pesanan_id", pesananSayaModelList.get(position).getId());

                if(pesananSayaModelList.get(position).getJenis_order_id() == 1){
                    intent = new Intent(context.getApplicationContext(), TerimaPesananActivity.class);
                }
                if(pesananSayaModelList.get(position).getJenis_order_id() == 2){
                    intent = new Intent(context.getApplicationContext(), InputHargaActivity.class);
                }
               intent.putExtras(bundle);
                context.startActivity(intent);
            }
        }
    }
}
