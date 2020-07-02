package com.example.artist.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artist.R;
import com.example.artist.utils.DurationConverter;
import com.example.artist.utils.ImageLoader;

import java.util.Objects;

import butterknife.BindView;

import static java.lang.Integer.parseInt;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.img_track)
    ImageView trackImageView;
    @BindView(R.id.txt_track_name)
    TextView nameTextView;
    @BindView(R.id.txt_plays)
    TextView playCountTextView;
    @BindView(R.id.txt_track_artist)
    TextView artistTextView;
    @BindView(R.id.txt_duration)
    TextView durationTextView;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        bundle = getIntent().getExtras();
        assert bundle != null;
        trackImageView = findViewById(R.id.img_track);
        nameTextView = findViewById(R.id.txt_track_name);
        playCountTextView = findViewById(R.id.txt_plays);
        artistTextView = findViewById(R.id.txt_track_artist);
        durationTextView = findViewById(R.id.txt_duration);
        if (!Objects.equals(bundle.getString("image"), "")) {
            ImageLoader.loadImage(this, bundle.getString("image"), R.drawable.default_track, trackImageView);
        }
        nameTextView.setText(bundle.getString("name"));
        artistTextView.setText(bundle.getString("artist"));
        playCountTextView.setText(bundle.getString("playCount"));
        if (!Objects.equals(bundle.getString("duration"), "")) {
            try {
                durationTextView.setText(DurationConverter.getDurationInMinutesText(Long.parseLong(Objects.requireNonNull(bundle.getString("duration"))))+" Minuites");
            } catch (Exception e){

            }

        }
    }
}