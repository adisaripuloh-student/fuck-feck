package sismul.periodik.table.tabelperiodik.Adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sismul.periodik.table.tabelperiodik.Fragment.FragmentUnsurPeriode;
import sismul.periodik.table.tabelperiodik.Model.DaftarGolonganPeriode;
import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 28/01/18.
 */

public class DaftarPeriodeAdapter extends RecyclerView.Adapter<DaftarPeriodeAdapter.MyViewHolder>{
    private List<DaftarGolonganPeriode> periodeList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nama;
        public MyViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
        }
    }

    public DaftarPeriodeAdapter(List<DaftarGolonganPeriode> periodeList) {
        this.periodeList = periodeList;
    }

    @Override
    public DaftarPeriodeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daftar_golongan_periode_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DaftarPeriodeAdapter.MyViewHolder holder, int position) {
        DaftarGolonganPeriode daftarGolonganPeriode = periodeList.get(position);
        holder.nama.setText(daftarGolonganPeriode.getNama());
        holder.nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = holder.nama.getText().toString();
                String[] vals = val.split(" ");
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentUnsurPeriode myFragment = new FragmentUnsurPeriode();
                Bundle args = new Bundle();
                args.putInt("id", Integer.parseInt(vals[1]));
                TextView toolbarTitle = activity.findViewById(R.id.toolbar_title);
                toolbarTitle.setText("Periode "+ vals[1]);
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return periodeList.size();
    }
}
