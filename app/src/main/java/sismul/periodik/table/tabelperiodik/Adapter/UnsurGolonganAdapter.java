package sismul.periodik.table.tabelperiodik.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

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
        Unsur ug = unsurGolonganList.get(position);
        holder.nama.setText(ug.getNama_unsur()+" ("+ug.getSimbol()+")");
        holder.deskripsi.setText("Periode "+ug.getPeriode()+" - Nomor "+ug.getNomor_atom());

        Glide.with(mContext)
                .load("http://128.199.88.3/assets/favicon-28e468f376ecf931cbdc38bfc3ed23b2762792e6fb92fbba26d56cf9d420a669.png")
                .into(holder.ikon);
    }

    @Override
    public int getItemCount() {
        return unsurGolonganList.size();
    }
}
