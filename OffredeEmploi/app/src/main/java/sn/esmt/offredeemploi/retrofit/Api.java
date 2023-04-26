package sn.esmt.offredeemploi.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sn.esmt.offredeemploi.model.Cv;

public interface Api {
    @GET("/appcv/all")
    public Call<ArrayList<Cv>> all();

    @POST("/appcv/save")
    Call<Cv> save(@Body Cv cv);
}
