package sismul.periodik.table.tabelperiodik.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sismul.periodik.table.tabelperiodik.Adapter.UnsurGolonganAdapter;
import sismul.periodik.table.tabelperiodik.MainActivity;
import sismul.periodik.table.tabelperiodik.Model.Unsur;
import sismul.periodik.table.tabelperiodik.R;
import sismul.periodik.table.tabelperiodik.Rest.ApiClient;
import sismul.periodik.table.tabelperiodik.Rest.ApiInterface;

/**
 * Created by x on 28/01/18.
 */

public class FragmentUnsurGolongan extends Fragment {

    private List<Unsur> uGolonganValues = new ArrayList<>();
    private RecyclerView recyclerView;
    private UnsurGolonganAdapter mAdapter;
    private Context mContext;

    public static FragmentUnsurGolongan newInstance() {
        FragmentUnsurGolongan fragment = new FragmentUnsurGolongan();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_unsur_row, container, false);
        recyclerView = layout.findViewById(R.id.unsur_row_recycler_view);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        int id = getArguments().getInt("id");
        Call<List<Unsur>> call = apiService.getGolongan(id);
        call.enqueue(new Callback<List<Unsur>>() {
            @Override
            public void onResponse(Call<List<Unsur>> call, Response<List<Unsur>> response) {
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new MainActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                List<Unsur> ugs = response.body();
                recyclerView.setAdapter(new UnsurGolonganAdapter(ugs, R.layout.unsur_item_row, mContext));
            }

            @Override
            public void onFailure(Call<List<Unsur>> call, Throwable t) {
                Toast.makeText(mContext, "Connection failed.", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
