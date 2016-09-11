package com.example.wagh.jiobus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagh on 11/9/16.
 */
public class adapterrecycle extends RecyclerView.Adapter<adapterrecycle.ViewHolder> {


    List<adapterdata> bustime=new ArrayList<adapterdata>();

    public adapterrecycle(List<adapterdata> adapterdatas)
    {
        this.bustime=adapterdatas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardtiming,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        adapterdata adapterdata12=bustime.get(position);

        holder.tv1.setText(adapterdata12.getFromadapter());



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;

        public ViewHolder(View v)
        {
            super(v);

            tv1=(TextView)v.findViewById(R.id.cardtimingtv1);
        }

    }
}
