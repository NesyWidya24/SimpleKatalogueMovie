package com.kagu.moviecatalogueapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvObject;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle(R.string.titleMovie);

        tvObject = findViewById(R.id.tv_object);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (movie!=null){
            TextView txtName = findViewById(R.id.tv_object);
            txtName.setText(movie.getName());

            TextView txtDesc = findViewById(R.id.tv_detail);
            txtDesc.setText(movie.getDescription());

            ImageView imgPhoto = findViewById(R.id.img_movie);
            imgPhoto.setImageResource(movie.getPhoto());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

