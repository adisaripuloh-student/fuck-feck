package sismul.periodik.table.tabelperiodik.Fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sismul.periodik.table.tabelperiodik.Model.Unsur;
import sismul.periodik.table.tabelperiodik.R;
import sismul.periodik.table.tabelperiodik.Rest.ApiClient;
import sismul.periodik.table.tabelperiodik.Rest.ApiInterface;

import static android.app.Activity.RESULT_OK;

/**
 * Created by x on 27/01/18.
 */

public class FragmentCari extends Fragment {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private SearchView tampilVoice;

    public static FragmentCari newInstance() {
        FragmentCari fragment = new FragmentCari();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView toolbarTitle = getActivity().findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Cari");

        ImageButton image_button = getView().findViewById(R.id.ibutton_cari);
        tampilVoice = getActivity().findViewById(R.id.searchView);

        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askSpeechInput();
            }
        });
    }

    // Showing google speech input dialog
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    // Receiving speech input
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tampilVoice.setQuery(result.get(0), false);
                    String dataString = result.get(0);

                    ApiInterface apiService =
                            ApiClient.getClient().create(ApiInterface.class);
                    Call<Unsur> call = apiService.getSearch(dataString);
                    call.enqueue(new Callback<Unsur>() {
                        @Override
                        public void onResponse(Call<Unsur> call, Response<Unsur> response) {
                            
                        }

                        @Override
                        public void onFailure(Call<Unsur> call, Throwable t) {
                            Toast.makeText(getActivity(), "Connection failed.", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                break;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cari, container, false);
    }
}