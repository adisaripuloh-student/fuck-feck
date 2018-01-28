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

import sismul.periodik.table.tabelperiodik.Adapter.DaftarPeriodeAdapter;
import sismul.periodik.table.tabelperiodik.Model.DaftarGolonganPeriode;
import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 27/01/18.
 */

public class FragmentPeriode extends Fragment {

    private List<DaftarGolonganPeriode> periodeValues = new ArrayList<>();
    private RecyclerView recyclerView;
    private DaftarPeriodeAdapter mAdapter;
    private Context mContext;

    public static FragmentPeriode newInstance() {
        FragmentPeriode fragment = new FragmentPeriode();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        periodeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_periode, container, false);
        recyclerView = layout.findViewById(R.id.daftar_periode_recycler_view);

        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Daftar Periode");

        mAdapter = new DaftarPeriodeAdapter(periodeValues);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        return layout;
    }

    private void periodeList(){
        DaftarGolonganPeriode df = new DaftarGolonganPeriode("Periode 1");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 2");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 3");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 4");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 5");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 6");
        periodeValues.add(df);
        df = new DaftarGolonganPeriode("Periode 7");
        periodeValues.add(df);
    }
}
