package sismul.periodik.table.tabelperiodik.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import sismul.periodik.table.tabelperiodik.Fragment.FragmentDetailUnsur;
import sismul.periodik.table.tabelperiodik.Model.Unsur;
import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 28/01/18.
 */

public class UnsurGolonganAdapter extends RecyclerView.Adapter<UnsurGolonganAdapter.MyViewHolder>{

    private Context mContext;
    private int rowLayout;
    private List<Unsur> unsurGolonganList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama, deskripsi;
        public ImageView ikon;

        public MyViewHolder(View view) {
            super(view);
            nama = view.findViewById(R.id.nama_unsur_row);
            deskripsi = view.findViewById(R.id.deskripsi_row);
            ikon = view.findViewById(R.id.ikon_row);
        }
    }

    public UnsurGolonganAdapter(List<Unsur> unsurGolonganList, int rowLayout, Context mContext) {
        this.unsurGolonganList = unsurGolonganList;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }

    @Override
    public UnsurGolonganAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UnsurGolonganAdapter.MyViewHolder holder, int position) {
        final Unsur ug = unsurGolonganList.get(position);
        holder.nama.setText(ug.getNama_unsur()+" ("+ug.getSimbol()+")");
        holder.deskripsi.setText("Periode "+ug.getPeriode()+" - Nomor "+ug.getNomor_atom());

        Glide.with(mContext)
                .load("http://128.199.88.3/images/"+ug.getIkon_file_name())
                .into(holder.ikon);

        holder.ikon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentDetailUnsur myFragment = new FragmentDetailUnsur();
                Bundle args = new Bundle();
                args.putInt("id", Integer.parseInt(String.valueOf(ug.getId())));
                TextView toolbarTitle = activity.findViewById(R.id.toolbar_title);
                toolbarTitle.setText(ug.getNama_unsur()+" ("+ug.getSimbol()+")");
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return unsurGolonganList.size();
    }
}
