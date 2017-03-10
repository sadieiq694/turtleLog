package com.example.sadiela.app1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CaptureData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CaptureData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CaptureData extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CAPT_NUM = "Capture Number";
    private static final String LOCATION = "Location";
    private static final String DATE = "Date";

    // TODO: Rename and change types of parameters

    private int captureNum;
    private String location;
    private String date;


    private EditText cn;
    private EditText dt;
    private EditText lc;

    private OnFragmentInteractionListener mListener;

    public CaptureData() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CaptureData newInstance(int captureNum, String location, String date) {
        CaptureData fragment = new CaptureData();
        Bundle args = new Bundle();
        args.putInt(CAPT_NUM, captureNum);
        args.putString(LOCATION, location);
        args.putString(DATE, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            captureNum = getArguments().getInt(CAPT_NUM);
            location = getArguments().getString(LOCATION);
            date = getArguments().getString(DATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capture_data2, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cn = (EditText)getActivity().findViewById(R.id.captureNumber);
        cn.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    validateInput(v);
                }
            }
        });
        lc = (EditText)getActivity().findViewById(R.id.enterLocation);
        lc.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    validateInput(v);
                }
            }
        });

        dt = (EditText)getActivity().findViewById(R.id.enterDate);
        dt.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    validateInput(v);
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
