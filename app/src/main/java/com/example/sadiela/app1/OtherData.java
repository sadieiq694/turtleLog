package com.example.sadiela.app1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OtherData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OtherData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherData extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
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

    public static Double TryParseDouble(String inputStr){
        try {
            return Double.parseDouble(inputStr);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_other_data2, container, false);
        Button b = (Button) v.findViewById(R.id.saveOthData);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveOthData:
                saveOther(v);
                break;
        }
    }

    void parseField(View v)
    {
        switch (v.getId())
        {
            case R.id.enterHeadDepth: {
                Double data = TryParseDouble(((EditText) v).getText().toString());
                if (data != null) {
                    headDep = data;
                    Log.d("saved head depth", data.toString());
                    Log.d("saving field", "head depth");
                }
            }
            break;
            case R.id.enterHeadLength: {
                Double data = TryParseDouble((((EditText) v).getText().toString()));
                if (data != null) {
                    Log.d("saved data", data.toString());
                    headLen = data;
                    Log.d("saving field", "head length");
                }
            }
            break;
            case R.id.enterHeadWidth:  {
                //save input
                Double data = TryParseDouble((((EditText) v).getText().toString()));
                if (data != null) {
                    Log.d("saved data", data.toString());
                    headWid = data;
                    Log.d("saving field", "head width");
                }
            }
            break;
            case R.id.enterBodyDepth:
            {
                //save input
                Double data = TryParseDouble((((EditText) v).getText().toString()));
                if (data != null) {
                    Log.d("saved data", data.toString());
                    bodyDep = data;
                }
                Log.d("saving field", "body depth");
            }
        }
    }

    //@Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            //save input
            parseField(v);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        hd = (EditText) getActivity().findViewById(R.id.enterHeadDepth);
        hd.setOnFocusChangeListener(this);
        hl = (EditText) getActivity().findViewById(R.id.enterHeadLength);
        hl.setOnFocusChangeListener(this);
        hw = (EditText) getActivity().findViewById(R.id.enterHeadWidth);
        hw.setOnFocusChangeListener(this);
        bd = (EditText) getActivity().findViewById(R.id.enterBodyDepth);
        bd.setOnFocusChangeListener(this);

        bd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    //switch to new activity

                }
                return true;
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void saveOther(View v) {

        parseField(getActivity().findViewById(R.id.enterHeadDepth));
        parseField(getActivity().findViewById(R.id.enterHeadLength));
        parseField(getActivity().findViewById(R.id.enterHeadWidth));
        parseField(getActivity().findViewById(R.id.enterBodyDepth));

        if(headDep != 0 && headWid != 0 && headLen != 0 && bodyDep != 0) {
            com.example.sadiela.app1.FragmentCommunicator fc = (com.example.sadiela.app1.FragmentCommunicator)getActivity();
            fc.setOtherData(headDep, headWid, headLen, bodyDep);
        }
        else {
            CharSequence text = "We have a problem!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
        }
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

    public interface FragmentCommunicator{
        public void passDataToActivity();
    }
}
