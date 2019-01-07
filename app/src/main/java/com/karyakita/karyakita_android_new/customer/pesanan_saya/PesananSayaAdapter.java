package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
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

    public PesananSayaAdapter(Context context) {
        this.pesananSayaModelList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_pesanan_saya_customer, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
//        Glide.with(context).load(pesananSayaModelList.get(position).getDeploy_url()).into(holder.iv_gambar);
        Glide.with(context).load(R.drawable.desainer_2).into(holder.iv_gambar);
        holder.tv_nama_desainer.setText(pesananSayaModelList.get(position).getNama_desainer());
        holder.tv_kategori.setText(String.valueOf(pesananSayaModelList.get(position).getKategori()));
        holder.tv_harga.setText("Rp. " + String.valueOf(pesananSayaModelList.get(position).getHarga()));
        holder.tv_deadline.setText(String.valueOf(pesananSayaModelList.get(position).getTanggalDeadline()));
    }

    @Override
    public int getItemCount() {
        return this.pesananSayaModelList.size();
    }

    public void addToList(PesananSayaModel pesananSayaModel) {
        pesananSayaModelList.add(pesananSayaModel);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_gambar;
        TextView tv_nama_desainer, tv_kategori, tv_harga, tv_deadline, tv_jenis_pesanan, tv_opsi_pesanan;
        LinearLayoutCompat item_pesanan;

        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            itemView.setOnClickListener(this);

            iv_gambar = itemView.findViewById(R.id.iv_gambar_pesanan);
            tv_nama_desainer = itemView.findViewById((R.id.tv_nama_desainer));
            tv_kategori = itemView.findViewById(R.id.tv_kategori_pesanan);
            tv_harga = itemView.findViewById(R.id.tv_harga_pesanan);
            tv_deadline = itemView.findViewById((R.id.tv_deadline_pesanan));
            tv_jenis_pesanan = itemView.findViewById((R.id.tv_jenis_pesanan));
            tv_opsi_pesanan = itemView.findViewById(R.id.tv_opsi_pesanan);
            item_pesanan = itemView.findViewById(R.id.item_pesanan);

        }

        @Override
        public void onClick(View v) {
            Integer position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                Bundle bundle = new Bundle();
                bundle.putInt("pesanan_id", pesananSayaModelList.get(position).getId());
                Intent intent = new Intent(context, DetailPesananSayaActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        }
    }
}
