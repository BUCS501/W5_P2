package com.example.w5_p2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageRating#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageRating extends Fragment {
    private LeftRight.Callbacks mCallbacks = sDummyCallbacks;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<Integer> images = new ArrayList<Integer>();
    private HashMap<Integer, Float> ratingDict = new HashMap<Integer, Float>();
    private int currIndex;

    private ImageView image;
    private RatingBar ratingBar;
    public interface Callbacks {
        public void updateImage(int change);
    }

    private static LeftRight.Callbacks sDummyCallbacks = new LeftRight.Callbacks( ) {
        public void updateImage(int change){};

    };
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageRating() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageRating.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageRating newInstance(String param1, String param2) {
        ImageRating fragment = new ImageRating();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( !( context instanceof LeftRight.Callbacks) ) {
            throw new IllegalStateException(
                    "Context must implement fragment's callbacks." );
        }
        mCallbacks = (LeftRight.Callbacks) context;
    }

    public void onDetach( ) {
        super.onDetach( );
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_rating, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View fragmentView = getView();
        image = (ImageView) fragmentView.findViewById(R.id.curr_image);
        ratingBar = (RatingBar) fragmentView.findViewById(R.id.ratingBar);
        images.add(R.drawable.bear);
        ratingDict.put(R.drawable.bear, 0.0F);
        images.add(R.drawable.corgi);
        ratingDict.put(R.drawable.corgi, 0.0F);
        images.add(R.drawable.monkey);
        ratingDict.put(R.drawable.monkey, 0.0F);
        images.add(R.drawable.seal);
        ratingDict.put(R.drawable.seal, 0.0F);
        images.add(R.drawable.eagle);
        ratingDict.put(R.drawable.eagle, 0.0F);

        currIndex = 0;
        image.setImageResource(R.drawable.bear);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int currImage = images.get(currIndex);
                ratingDict.put(currImage, v);
            }
        });
    }

    public void updateIndex(int change) {


        int newIndex = currIndex + change;
        if (newIndex < 0) {
            newIndex = images.size() - 1;
        }
        else if (newIndex > images.size() - 1) {
            newIndex = 0;
        }

        currIndex = newIndex;

        image.setImageResource(images.get(currIndex));
        ratingBar.setRating(ratingDict.get(images.get(currIndex)));

    }

}