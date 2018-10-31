package com.karyakita.karyakita_android_new.desainer.list_desainer;

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
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaActivity;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import java.util.ArrayList;
import java.util.List;

public class ListDesainerAdapter extends RecyclerView.Adapter<ListDesainerAdapter.Holder>{
    List<ListDesainerModel> listDesainerModelList;
    Context context;

    public ListDesainerAdapter(List<ListDesainerModel> listDesainerModelList, Context context) {
        this.listDesainerModelList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_list_desainer2, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //Glide.with(context).load(listDesainerModelList.get(position).getDeploy_url()).into(holder.iv_listDesainer);
        holder.tv_nama_desainer.setText(listDesainerModelList.get(position).getNama());
        holder.tv_kota_asal_desainer.setText(listDesainerModelList.get(position).getKota_kab());
        //holder.tv_jumlah_karya.setText(listDesainerModelList.get(position).getHarga().toString());
        holder.rating.setText(listDesainerModelList.get(position).getRating().toString());
    }

    @Override
    public int getItemCount() {
        return this.listDesainerModelList.size();
    }

    public void addToList(ListDesainerModel listDesainerModel) {
        listDesainerModelList.add(listDesainerModel);
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView iv_listDesainer;
        TextView tv_nama_desainer, tv_kota_asal_desainer, tv_jumlah_karya, rating;

        public Holder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            iv_listDesainer = itemView.findViewById(R.id.iv_profile_image);
            tv_nama_desainer = itemView.findViewById(R.id.tv_nama_desainer);
            tv_kota_asal_desainer=itemView.findViewById(R.id.tv_kota_asal_desainer);
            tv_jumlah_karya = itemView.findViewById(R.id.tv_jumlah_karya);
            rating = itemView.findViewById(R.id.rating);
            iv_listDesainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context.getApplicationContext(), DetailKaryaActivity.class));
                }
            });
        }
    }


}
