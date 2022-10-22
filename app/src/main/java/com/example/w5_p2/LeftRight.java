package com.example.w5_p2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftRight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftRight extends Fragment {
    private Callbacks mCallbacks = sDummyCallbacks;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int lastPressed = 0; // 0 when initialized, -1 if left, 1 if right

    private Button left_btn;
    private Button right_btn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LeftRight() {
        // Required empty public constructor
    }


    public interface Callbacks {
       public void updateImage(int change);
    }

    private static Callbacks sDummyCallbacks = new Callbacks( ) {
        public void updateImage(int change){};

    };

    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( !( context instanceof Callbacks ) ) {
            throw new IllegalStateException(
                    "Context must implement fragment's callbacks." );
        }
        mCallbacks = ( Callbacks ) context;
    }

    public void onDetach( ) {
        super.onDetach( );
        mCallbacks = sDummyCallbacks;
    }

    public void updateImage(int change) {
        mCallbacks.updateImage(change);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftRight.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftRight newInstance(String param1, String param2) {
        LeftRight fragment = new LeftRight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_left_right, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View fragmentView = getView();
        left_btn = (Button) fragmentView.findViewById(R.id.left_btn);
        right_btn = (Button) fragmentView.findViewById(R.id.right_btn);

        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(-1);
            }
        });

        right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateImage(1);
            }
        });

    }
}