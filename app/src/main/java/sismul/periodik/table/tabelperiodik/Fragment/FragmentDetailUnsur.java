package sismul.periodik.table.tabelperiodik.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sismul.periodik.table.tabelperiodik.Model.Unsur;
import sismul.periodik.table.tabelperiodik.R;
import sismul.periodik.table.tabelperiodik.Rest.ApiClient;
import sismul.periodik.table.tabelperiodik.Rest.ApiInterface;

/**
 * Created by x on 28/01/18.
 */

public class FragmentDetailUnsur extends Fragment {

    private Context mContext;
    TextToSpeech mySpeech;

    public static FragmentDetailUnsur newInstance() {
        FragmentDetailUnsur fragment = new FragmentDetailUnsur();
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
        View layout = inflater.inflate(R.layout.fragment_unsur, container, false);

        mySpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    mySpeech.setLanguage(new Locale("id", "ID"));
                }
            }
        });

        final TextView nama = layout.findViewById(R.id.nama_unsur_detail);
        final TextView deskripsi = layout.findViewById(R.id.deskripsi_detail);
        final ImageView ikon = layout.findViewById(R.id.ikon_detail);
        final TextView simbol = layout.findViewById(R.id.simbol_unsur_detail);
        final TextView masa = layout.findViewById(R.id.masa_atom_detail);
        final TextView nomor = layout.findViewById(R.id.nomor_atom_detail);
        final TextView golongan = layout.findViewById(R.id.golongan_atom_detail);
        final TextView priode = layout.findViewById(R.id.priode_detail);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        int id = getArguments().getInt("id");
        Call<Unsur> call = apiService.getUnsur(id);
        call.enqueue(new Callback<Unsur>() {
            @Override
            public void onResponse(Call<Unsur> call, Response<Unsur> response) {
                nama.setText("Nama Unsur : " + response.body().getNama_unsur());
                simbol.setText("Simbol : " + response.body().getSimbol());
                masa.setText("Massa Atom : " + response.body().getMasa_atom() + " g/Mol");
                nomor.setText("Nomor Atom : " + response.body().getNomor_atom());
                golongan.setText("Golongan : " + response.body().getGolongan());
                priode.setText("Periode : " + response.body().getPeriode());
                deskripsi.setText("Deskripsi\n\n" + response.body().getDeskripsi());
                Glide.with(mContext)
                        .load("http://128.199.88.3/images/" + response.body().getIkon_file_name())
                        .into(ikon);
                mySpeech.speak(response.body().getDeskripsi(), TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onFailure(Call<Unsur> call, Throwable t) {
                Toast.makeText(mContext, "Connection failed.", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }

    @Override
    public void onDetach() {
        if (mySpeech != null) {
            mySpeech.stop();
        }
        super.onDetach();
    }
}
