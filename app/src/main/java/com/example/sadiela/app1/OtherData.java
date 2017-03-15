package com.example.sadiela.app1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OtherData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OtherData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherData extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String HEAD_DEPTH = "Head Depth";
    private static final String HEAD_WIDTH = "Head Width";
    private static final String HEAD_LENGTH = "Head Length";
    private static final String BODY_DEPTH = "Body Depth";

    // TODO: Rename and change types of parameters
    private double headDep;
    private double headWid;
    private double headLen;
    private double bodyDep;

    private EditText hd;
    private EditText hw;
    private EditText hl;
    private EditText bd;

    private OnFragmentInteractionListener mListener;

    public OtherData() {
        // Required empty public constructor
    }

    public static OtherData newInstance(double headDep, double headWid, double headLen, double bodyDep) {
        OtherData fragment = new OtherData();
        Bundle args = new Bundle();
        args.putDouble(HEAD_DEPTH, headDep);
        args.putDouble(HEAD_WIDTH, headWid);
        args.putDouble(HEAD_LENGTH, headLen);
        args.putDouble(BODY_DEPTH, bodyDep);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            headDep = getArguments().getDouble(HEAD_DEPTH);
            headWid = getArguments().getDouble(HEAD_WIDTH);
            headLen = getArguments().getDouble(HEAD_LENGTH);
            bodyDep = getArguments().getDouble(BODY_DEPTH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_data2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        hd = (EditText) getActivity().findViewById(R.id.enterHeadDepth);
        hd.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Log.d("saved data", (((EditText) v).getText().toString()));
                    headDep = Integer.parseInt(((EditText) v).getText().toString());
                    Log.d("saving field", "head depth");
                }
            }
        });
        hl = (EditText) getActivity().findViewById(R.id.enterHeadLength);
        hl.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Log.d("saved data", (((EditText) v).getText().toString()));
                    headLen = Integer.parseInt(((EditText) v).getText().toString());
                    Log.d("saving field", "head length");
                }
            }
        });
        hw = (EditText) getActivity().findViewById(R.id.enterHeadWidth);
        hw.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Log.d("saved data", (((EditText) v).getText().toString()));
                    headWid = Integer.parseInt(((EditText) v).getText().toString());
                    Log.d("saving field", "head width");
                }
            }
        });
        bd = (EditText) getActivity().findViewById(R.id.enterBodyDepth);
        bd.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Log.d("saved data", (((EditText) v).getText().toString()));
                    bodyDep = Integer.parseInt(((EditText) v).getText().toString());
                    Log.d("saving field", "body depth");
                }
            }
        });
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

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
