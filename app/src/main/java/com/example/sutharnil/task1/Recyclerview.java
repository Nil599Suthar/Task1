package com.example.sutharnil.task1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.View;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview extends AppCompatActivity {

    private List<Movie> movieList=new ArrayList<>();
    private static final String url="https://api.myjson.com/bins/1b19ws";
    private RecyclerView recyclerView;
    private MovieAdapter adapter,adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        adapter=new MovieAdapter(movieList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        preparemovieData();
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);
    }

    private void preparemovieData() {

//        for(int i=0;i<21;i++){
//            Movie movie=new Movie("Movie :-"+i,"Drama","2011");
//            movieList.add(movie);
//        }

//        adapter.notifyDataSetChanged();


        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading data.......");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("Movie");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);

                        Movie m1=new Movie(
                          jsonObject1.getString("name"),
                          jsonObject1.getString("genre"),
                          jsonObject1.getString("year")
                        );

                        movieList.add(m1);

                    }
                    adapter=new MovieAdapter(movieList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
        progressDialog.dismiss();
                 Toast.makeText(Recyclerview.this, "error",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
