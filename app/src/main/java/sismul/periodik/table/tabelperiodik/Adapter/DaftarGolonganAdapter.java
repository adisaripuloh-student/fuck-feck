package sismul.periodik.table.tabelperiodik.Adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sismul.periodik.table.tabelperiodik.Fragment.FragmentUnsurGolongan;
import sismul.periodik.table.tabelperiodik.Model.DaftarGolonganPeriode;
import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 28/01/18.
 */

public class DaftarGolonganAdapter extends RecyclerView.Adapter<DaftarGolonganAdapter.MyViewHolder> {

    private List<DaftarGolonganPeriode> golonganList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nama;
        public MyViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
        }
    }

    public DaftarGolonganAdapter(List<DaftarGolonganPeriode> golonganList) {
        this.golonganList = golonganList;
    }

    @Override
    public DaftarGolonganAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daftar_golongan_periode_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DaftarGolonganAdapter.MyViewHolder holder, int position) {
        DaftarGolonganPeriode daftarGolonganPeriode = golonganList.get(position);
        holder.nama.setText(daftarGolonganPeriode.getNama());
        holder.nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = holder.nama.getText().toString();
                String[] vals = val.split(" ");
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentUnsurGolongan myFragment = new FragmentUnsurGolongan();
                Bundle args = new Bundle();
                args.putInt("id", Integer.parseInt(vals[1]));
                TextView toolbarTitle = activity.findViewById(R.id.toolbar_title);
                toolbarTitle.setText("Golongan "+ vals[1]);
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return golonganList.size();
    }
}
