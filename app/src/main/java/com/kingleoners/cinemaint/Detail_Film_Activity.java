package com.kingleoners.cinemaint;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import io.paperdb.Paper;

public class Detail_Film_Activity extends AppCompatActivity {

    ImageView imgCoverFilm;
    TextView txtNameFilm, txtFromFilm;

    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__film_);

        Log.d(EXTRA_FILM,"onCreate: started.");

        imgCoverFilm = findViewById(R.id.img_coverview_film);
        txtNameFilm = findViewById(R.id.txt_name_detailfilm);
        txtFromFilm = findViewById(R.id.txt_from_detailfilm);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        String coverFilm = film.getPoster_path();
        String nameFilm = film.getTitle();
        String fromFilm = film.getOverview();


        Glide.with(this)
                .asBitmap()
                .load(coverFilm)
                .into(imgCoverFilm);
        txtNameFilm.setText(nameFilm);
        txtFromFilm.setText(fromFilm);

        /*Paper.init(this);

        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","in");

        updateView((String)Paper.book().read("language"));
        */

        /*imgCoverFilm = findViewById(R.id.img_coverview_film);
        txtNameFilm = findViewById(R.id.txt_name_detailfilm);
        txtFromFilm = findViewById(R.id.txt_from_detailfilm);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        String coverFilm = film.getCover();
        String nameFilm = film.getName();
        String fromFilm = film.getFrom();

        txtNameFilm.setText(nameFilm);
        txtFromFilm.setText(fromFilm);
       */
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.language_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.language_in){
            Paper.book().write("language","in");
            updateView((String)Paper.book().read("language"));
        } else if (item.getItemId() == R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }


        return true;
    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(this,language);
        Resources resources = context.getResources();

        imgCoverFilm = findViewById(R.id.img_coverview_film);
        txtNameFilm = findViewById(R.id.txt_name_detailfilm);
        txtFromFilm = findViewById(R.id.txt_from_detailfilm);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        String coverFilm = film.getCover();
        String nameFilm = film.getName();
        String fromFilm = film.getFrom();

        txtNameFilm.setText(nameFilm);
        txtFromFilm.setText(fromFilm);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"in"));
    }
    */

    /*private void getIncomingIntent(){
        Log.d(EXTRA_FILM,"getIncomingIntent : checking.");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("film_name")){
            Log.d(EXTRA_FILM,"getIncomingIntent : found.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String filmName = getIntent().getStringExtra("film_name");
        }
    }

    private void setImage(String imageUrl, String filmName){
        Log.d(EXTRA_FILM,"setImage : setting.");

        TextView name = findViewById(R.id.txt_name_detailfilm);
        name.setText(filmName);

        ImageView image = findViewById(R.id.img_coverview_film);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
    */


}
