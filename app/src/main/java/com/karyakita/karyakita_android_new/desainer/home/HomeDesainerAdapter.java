package com.karyakita.karyakita_android_new.desainer.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.karyakita.karyakita_android_new.R;

import java.util.ArrayList;
import java.util.List;

public class HomeDesainerAdapter extends RecyclerView.Adapter<HomeDesainerAdapter.Holder> {
    List<HomeDesainerModel> homeDesainerModelList;
    Context context;

    public HomeDesainerAdapter(List<HomeDesainerModel> homeDesainerModelList, Context context){
        this.homeDesainerModelList = new ArrayList<>();
        this.context = context;
    }

    public void addToList(HomeDesainerModel homeDesainerModel) {
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView iv_home_desainer;

        public Holder(View itemView){
            super(itemView);
            context = itemView.getContext();

            iv_home_desainer = itemView.findViewById(R.id.iv_gambar_home_desainer);
            iv_home_desainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context.getApplicationContext(), HomeDesainerActivity.class));
                }
            });

        }
    }
}
