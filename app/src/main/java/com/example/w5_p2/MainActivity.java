package com.example.w5_p2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements LeftRight.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if( fragmentManager.findFragmentById( R.id.left_right ) == null ) {
            androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction( );
            LeftRight fragment = new LeftRight();
            transaction.add(R.id.left_right, fragment );
            transaction.commit( );
        }

        if( fragmentManager.findFragmentById( R.id.image_rating ) == null ) {
            androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction( );
            ImageRating fragment = new ImageRating();
            transaction.add(R.id.image_rating, fragment );
            transaction.commit( );
        }

    }


    public void updateImage(int change) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ImageRating iRFragment = ( ImageRating )
                fragmentManager.findFragmentById( R.id.image_rating );
        iRFragment.updateIndex(change);
    }
}