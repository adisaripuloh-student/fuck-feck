package sismul.periodik.table.tabelperiodik.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sismul.periodik.table.tabelperiodik.R;

/**
 * Created by x on 27/01/18.
 */

public class FragmentCari extends Fragment {

    public static FragmentCari newInstance() {
        FragmentCari fragment = new FragmentCari();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Cari");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cari, container, false);
    }
}