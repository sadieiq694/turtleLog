package com.example.sadiela.app1;

import android.content.Context;
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
 * {@link CarapaceData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarapaceData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarapaceData extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // strCLmin, strCLnt, strCW, curCLmin, curCLnt, curCW
    private static final String  STR_CL_MIN = "Straight Carapace Length Minimum";
    private static final String STR_CL_NT = "Straight Carapace Length Notch to Tip";
    private static final String STR_CW = "Straight Carapace Width";
    private static final String CUR_CL_MIN = "Curved Carapace Length Minimum";
    private static final String CUR_CL_NT = "Curved Carapace Length Notch to Tip";
    private static final String CUR_CW = "Curved Carapace Width";

    // TODO: Rename and change types of parameters
    private double strCLmin;
    private double strCLnt;
    private double strCW;
    private double curCLmin;
    private double curCLnt;
    private double curCW;

    private EditText sclm;
    private EditText sclnt;
    private EditText scw;
    private EditText cclm;
    private EditText cclnt;
    private EditText ccw;


    private OnFragmentInteractionListener mListener;

    public CarapaceData() {
        // Required empty public constructor
    }

    public static CarapaceData newInstance(double strCLmin, double strCLnt, double strCW, double curCLmin, double curCLnt, double curCW) {
        CarapaceData fragment = new CarapaceData();
        Bundle args = new Bundle();
        args.putDouble(STR_CL_MIN, strCLmin);
        args.putDouble(STR_CL_NT, strCLnt);
        args.putDouble(STR_CW, strCW);
        args.putDouble(CUR_CL_MIN, curCLmin);
        args.putDouble(CUR_CL_NT, curCLmin);
        args.putDouble(CUR_CW, curCW);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            strCLmin = getArguments().getDouble(STR_CL_MIN);
            strCLnt = getArguments().getDouble(STR_CL_NT);
            strCW = getArguments().getDouble(STR_CW);
            curCLmin = getArguments().getDouble(CUR_CL_MIN);
            curCLnt = getArguments().getDouble(CUR_CL_NT);
            curCW = getArguments().getDouble(CUR_CW);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Function", "Started");
        // Inflate the layout for this fragment
        Button b = (Button) getView().findViewById(R.id.saveCarData);
        b.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_carapace_data, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveCarData:
                saveCarapace(v);
                break;
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
    public void onStart() {
        super.onStart();
        sclm = (EditText)getActivity().findViewById(R.id.enterStrCLMin);
        sclm.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input

                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        strCLmin = data;
                        Log.d("saving field", "straight carapace length minimum");
                    }
                }
            }
        });
        sclnt = (EditText)getActivity().findViewById(R.id.enterStrCarLenNT);
        sclnt.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        strCLnt = data;
                        Log.d("saving field", "straight carapace notch-tip");
                    }
                }
            }
        });
        scw = (EditText)getActivity().findViewById(R.id.enterStrCarWid);
        scw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        strCW = data;
                        Log.d("saving field", "straight carapace width");
                    }
                }
            }
        });
        cclm = (EditText)getActivity().findViewById(R.id.enterCurCarMin);
        cclm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        curCLmin = data;
                        Log.d("saving field", "curved carapace length minimum");
                    }
                }
            }
        });
        cclnt = (EditText)getActivity().findViewById(R.id.enterCurCarNT);
        cclnt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        curCLnt = data;
                        Log.d("saving field", "curved carapace length notch-tip");
                    }
                }
            }
        });
        ccw = (EditText)getActivity().findViewById(R.id.enterCurCarWid);
        ccw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
    /* When focus is lost check that the text field
    * has valid values.
    */
                if (!hasFocus) {
                    //save input
                    Double data = TryParseDouble(((EditText) v).getText().toString());
                    if (data != null) {
                        Log.d("saved data", data.toString());
                        curCW = data;
                        Log.d("saving field", "curved carapace width");
                    }
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void saveCarapace(View v) {
        if(strCLmin != 0 && strCLnt != 0 && strCW != 0 && curCLmin != 0 && curCLnt != 0 && curCW != 0) {
            FragmentCommunicator fc = (FragmentCommunicator)getActivity();
            fc.setCarapaceData(strCLmin, strCLnt, strCW, curCLmin, curCLnt, curCW);
        }
        else {
            //notify user
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
}
