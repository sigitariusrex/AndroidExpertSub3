package com.kingleoners.cinemaint;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class FilmViewModel {

    private static final String API_KEY = "5b6d881e3f28159c8de4b55c57a9a2c7";
    private MutableLiveData<ArrayList<Film>> listMutableLiveDataFilm = new MutableLiveData<>();

    public void setListMutableLiveDataFilm(){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<Film> item = new ArrayList<>();
        String URL = "https://api.themoviedb.org/3/tv/popular?api_key="+API_KEY+"&language=en-US&page=1";

        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject object = new JSONObject(result);
                    JSONArray array = object.getJSONArray("results");

                    for (int i = 0; i < array.length(); i++){
                        JSONObject film = array.getJSONObject(i);
                        Film filmItem = new Film(film);
                        item.add(filmItem);
                    }
                    listMutableLiveDataFilm.postValue(item);
                } catch (JSONException e){
                    Log.d("onFailure", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<Film>> getFilms(){
        return listMutableLiveDataFilm;
    }
}
