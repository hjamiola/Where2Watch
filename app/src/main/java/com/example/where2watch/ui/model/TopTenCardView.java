package com.example.where2watch.ui.model;
// CustomCardView.java
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.example.where2watch.R;

public class TopTenCardView extends CardView {
    private CardView movieCard;
    private ImageView movieImage;
    private TextView movieTitle;
    private TextView movieNumber;

    public TopTenCardView(Context context) {
        super(context);
        init(context, null);
    }

    public TopTenCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TopTenCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // Inflate the layout
        LayoutInflater.from(context).inflate(R.layout.custom_card_view, this, true);

        // Initialize views
        movieCard = findViewById(R.id.movie_card_action_1);
        movieImage = findViewById(R.id.movie_image);
        movieTitle = findViewById(R.id.movie_title);
        movieNumber = findViewById(R.id.movie_number);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MovieCardView);
            try {
                // Set image
                int imageResId = a.getResourceId(R.styleable.MovieCardView_movieImage, -1);
                if (imageResId != -1) {
                    movieImage.setImageResource(imageResId);
                }

                // Set title if provided
                String title = a.getString(R.styleable.MovieCardView_movieTitle);
                if (title != null) {
                    movieTitle.setText(title);
                }

                // Set number if provided
                String number = a.getString(R.styleable.MovieCardView_movieNumber);
                if (number != null) {
                    movieNumber.setText(number);
                }

                // Set card background tint if provided
                int backgroundTint = a.getColor(R.styleable.MovieCardView_cardBackgroundTint,
                        getResources().getColor(android.R.color.transparent));
                movieCard.setCardBackgroundColor(backgroundTint);

            } finally {
                a.recycle();
            }
        }
    }

    // Setter methods auto
    public void setMovieImage(int resId) {
        movieImage.setImageResource(resId);
    }
    public void setMovieTitle(String title) {
        movieTitle.setText(title);
    }
    public void setMovieNumber(String number) {
        movieNumber.setText(number);
    }
    //getter methods auto. wont need this now since hardcoded.
    public ImageView getMovieImage() {
        return movieImage;
    }
    public TextView getMovieTitle() {
        return movieTitle;
    }
    public TextView getMovieNumber() {
        return movieNumber;
    }
    public CardView getMovieCard() {
        return movieCard;
    }
}