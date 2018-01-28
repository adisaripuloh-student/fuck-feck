package sismul.periodik.table.tabelperiodik.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sismul.periodik.table.tabelperiodik.Adapter.DaftarGolonganAdapter;
import sismul.periodik.table.tabelperiodik.Model.DaftarGolonganPeriode;
import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 27/01/18.
 */

public class FragmentGolongan extends Fragment {

    private List<DaftarGolonganPeriode> golonganValues = new ArrayList<>();
    private RecyclerView recyclerView;
    private DaftarGolonganAdapter mAdapter;
    private Context mContext;

    public static FragmentGolongan newInstance() {
        return new FragmentGolongan();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        golonganList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_golongan, container, false);
        recyclerView = layout.findViewById(R.id.daftar_golongan_recycler_view);

        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Daftar Golongan");

        mAdapter = new DaftarGolonganAdapter(golonganValues);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        return layout;
    }

    private void golonganList(){
        DaftarGolonganPeriode df = new DaftarGolonganPeriode("Golongan 1");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 2");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 3");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 4");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 5");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 6");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 7");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 8");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 9");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 10");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 11");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 12");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 13");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 14");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 15");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 16");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 17");
        golonganValues.add(df);
        df = new DaftarGolonganPeriode("Golongan 18");
        golonganValues.add(df);
    }
}
