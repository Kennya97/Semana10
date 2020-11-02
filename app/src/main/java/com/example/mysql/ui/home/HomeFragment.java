package com.example.mysql.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mysql.MySingleton;
import com.example.mysql.R;
import com.example.mysql.Setting_VAR;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textView = root.findViewById(R.id.text_home);

        final Button btn1 = root.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //Toast.makeText(getContext(), "HOLA", Toast.LENGTH_SHORT).show();

              //pruebaVolley();

                //peticionGson();

                //recibirJson();
            }
        });


       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        return root;
    }

    private void baseRequest() {
        StringRequest requesst = new StringRequest(Request.Method.GET, Setting_VAR.URL_PRUEBA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("id", "1");
                return map;
            }
        };

        MySingleton.getInstance(getContext()).addToRequestQueue(requesst);
    }

    //METODO DE PRUEBA
    private void pruebaVolley() {
        String url = "http://httpbin.org/html";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response.substring(0, 100));
                textView.setText(response.substring(0, 100));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error  handling

                System.out.println("Something went wrong!");
                Toast.makeText(getContext(), "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);


    }

    private void peticionGson(){

        //  String url ="http://192.168.1.12/service2020/json1.php";
        String url = Setting_VAR.URL_PRUEBA;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,  null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                textView.setText("Response" + response.toString());
                Toast.makeText(getContext(), "" +response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }


    private void recibirJson(){
        StringRequest request = new StringRequest(Request.Method.GET, Setting_VAR.URL_PRUEBA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //SE CREA UN OBJETO JSON PARA ACCEDER A LOS ATRIBUTOS
                    JSONObject respuestaJSON = new JSONObject(response.toString());

                    String var1 = respuestaJSON.getString("id");
                    String var2 = respuestaJSON.getString("nombre");
                    textView.setText("Response: " + response.toString());
                    Toast.makeText(getContext(), "Id: " + var1 + "\nNombre: " + var2, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        );
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }

}


