package com.example.logonrm.androidversions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.logonrm.androidversions.adapters.AndroidAdapter;
import com.example.logonrm.androidversions.api.APIUtils;
import com.example.logonrm.androidversions.api.IAndroidAPI;
import com.example.logonrm.androidversions.models.Android;
import com.example.logonrm.androidversions.models.ResponseAndroid;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAdapter androidAdapter;
    private IAndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        androidAdapter = new AndroidAdapter(new ArrayList<Android>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);

        carregaDados();
    }

    private void carregaDados(){
        androidAPI = APIUtils.getAndroidAPI();

        ResponseAndroid android = null;

        androidAPI.GetVersions().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if(response.isSuccessful()){
                    androidAdapter.update(response.body().getAndroid());
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {
                Log.i("AndroidVersions", "Deu ruim ao listar versoes");
            }
        });


    }
}
