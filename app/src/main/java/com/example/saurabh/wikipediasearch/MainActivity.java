package com.example.saurabh.wikipediasearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Call<GetWikipediaResponse> call = null;
    private SearchAdapter mSearchAdapter = null;
    private RecyclerView mRecyclerView = null;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Api api = retrofit.create(Api.class);

        final EditText etSearch = findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etSearch.getText().toString().length() > 1) {


                    call = api.getWikipideaResponse("query", "json", "pageimages|pageterms",
                            "prefixsearch", 1, "2", "thumbnail",
                            "50", "10", "description",
                            etSearch.getText().toString(), "10");
                } else {

                    if (mSearchAdapter != null) {
                        mSearchAdapter.clearData();
                    }
                    return;
                }


                call.enqueue(new Callback<GetWikipediaResponse>() {
                    @Override
                    public void onResponse(Call<GetWikipediaResponse> call, Response<GetWikipediaResponse> response) {
                        GetWikipediaResponse getWikipediaResponses = response.body();
                        if (getWikipediaResponses == null)
                            return;
                        mSearchAdapter = new SearchAdapter(getWikipediaResponses.getQuery().getPages(), MainActivity.this);
                        mRecyclerView.setAdapter(mSearchAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetWikipediaResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etSearch.getText().toString().length() < 1) {
                    if (mSearchAdapter != null) {
                        mSearchAdapter.clearData();
                    }
                }

            }
        });


        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

    }
}
