package com.example.a2582;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView edList;


    HashMap<String,String>hashMap;
    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(+
                 R.layout.activity_main);
        //edText=findViewById(R.id.edText);
        edList=findViewById(R.id.edList);


        String url="https://dummyjson.com/users";
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {





                try {
                    JSONArray jsonArray = response.getJSONArray("users");
                    for (int x = 0; x < jsonArray.length(); x++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(x);
                        String userName = jsonObject.getString("firstName");
                        String userName1 = jsonObject.getString("lastName");
                        String userName2 = jsonObject.getString("maidenName");
                      //  String proPrice = jsonObject.getString("price");
                        String userPhoto = jsonObject.getString("image");
                      //  String des=jsonObject.getString("description");
                        String edAge=jsonObject.getString("age");

                        hashMap = new HashMap<>();
                        hashMap.put("firstName", userName);
                        hashMap.put("lastName", userName1);
                        hashMap.put("maidenName", userName2);
                     //   hashMap.put("price", proPrice);
                        hashMap.put("image", userPhoto);
                      //  hashMap.put("description",des);
                        hashMap.put("age",edAge);

                        arrayList.add(hashMap);
                    }
                    MyAdapter myAdapter = new MyAdapter();
                    edList.setAdapter(myAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjectRequest);


    }

    public class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView=layoutInflater.inflate(R.layout.layout1,viewGroup,false);

            HashMap<String,String>hashMap1=arrayList.get(position);



            TextView edUser1=myView.findViewById(R.id.edUser1);
            TextView edUser2=myView.findViewById(R.id.edUser2);
            TextView edUser3=myView.findViewById(R.id.edUser3);

            ImageView edImage=myView.findViewById(R.id.edImage);
            TextView edAge=myView.findViewById(R.id.edAge);




            String title=hashMap1.get("firstName");
            String title1=hashMap1.get("lastName");
            String title2=hashMap1.get("maidenName");
            String userssPhoto=hashMap1.get("image");
            String userAge=hashMap1.get("age");




            edUser1.setText(title);
            edUser2.setText(title1);
            edUser3.setText(title2);
            edAge.setText(userAge);

            Picasso.get().load(userssPhoto).into(edImage);
            edUser1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  MainActivity2.DetName=title+""+ title1;
                  MainActivity2.DetAge=userAge;


Intent myIntent=new Intent(MainActivity.this,MainActivity2.class);
startActivity(myIntent);

                }
            });








            return myView;
        }
    }
    }
