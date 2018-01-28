package sismul.periodik.table.tabelperiodik.Rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sismul.periodik.table.tabelperiodik.Model.Unsur;

/**
 * Created by x on 28/01/18.
 */

public interface ApiInterface {
//    @GET("unsurs")
//    Call<List<UnsurGolongan>> getUnsurs();
//
    @GET("unsur/{id}")
    Call<Unsur> getUnsur(@Path("id") int id);

    @GET("search/{query}")
    Call<Unsur> getSearch(@Path("query") String query);

    @GET("golongan/{id}")
    Call<List<Unsur>> getGolongan(@Path("id") int id);

    @GET("periode/{id}")
    Call<List<Unsur>> getPeriode(@Path("id") int id);
}