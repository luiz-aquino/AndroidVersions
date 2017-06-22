package com.example.logonrm.androidversions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.androidversions.R;
import com.example.logonrm.androidversions.models.Android;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private List<Android> androids;

    public AndroidAdapter(List<Android> androids){
        this.androids = androids;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View myLayout = inflater.inflate(R.layout.android_row, parent, false);

        return new AndroidViewHolder(myLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        Android android = androids.get(position);
        holder.tvTitulo.setText(android.getNome());
        holder.tvSubtitulo.setText(android.getVersao());

        Picasso.with(holder.itemView.getContext())
                .load(android.getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public AndroidViewHolder(View itemView) {

            super(itemView);
            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo = (TextView) itemView.findViewById(R.id.tcTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tcSubtitulo);
        }
    }

    public void update(List<Android> androids){
        this.androids = androids;
        notifyDataSetChanged();
    }
}
