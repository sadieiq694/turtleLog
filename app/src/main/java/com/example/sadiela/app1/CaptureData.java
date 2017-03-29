package com.example.sadiela.app1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
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

public class CaptureData extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
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
        View v = inflater.inflate(R.layout.fragment_capture_data2, container, false);
        Button b = (Button) v.findViewById(R.id.saveCapData);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveCapData:
                saveCapture(v);
                break;
        }
    }

    public static Integer TryParseInt(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    void parseField(View v)
    {
        switch (v.getId())
        {
            case R.id.captureNumber: {
                Integer data = TryParseInt(((EditText) v).getText().toString());
                if (data != null) {
                    captureNum = data;
                    Log.d("saved head depth", data.toString());
                    Log.d("saving field", "head depth");
                }
            }
            break;
            case R.id.enterLocation: {
                String data = (((EditText) v).getText().toString());
                if (data != null) {
                    Log.d("saved data", data.toString());
                    location = data;
                    Log.d("saving field", "head length");
                }
            }
            break;
            case R.id.enterDate:  {
                //save input
                String data = (((EditText) v).getText().toString());
                if (data != null) {
                    Log.d("saved data", data.toString());
                    location = data;
                    Log.d("saving field", "head width");
                }
            }
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            //save input
            parseField(v);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        cn = (EditText) getActivity().findViewById(R.id.captureNumber);
        cn.setOnFocusChangeListener(this);
        lc = (EditText) getActivity().findViewById(R.id.enterLocation);
        lc.setOnFocusChangeListener(this);
        dt = (EditText) getActivity().findViewById(R.id.enterDate);
        dt.setOnFocusChangeListener(this);

        dt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    //switch to new activity

                }
                return true;
            }
        });
    }

//    @Override
//    public void onStart() {
//        // set all focus change listeners to "this"
//        // hd = (EditText) getActivity().finddViewById(R.id.enterHeadDepth;
//        // hd.setOnFocusChangeListener(this);
//        super.onStart();
//        cn = (EditText)getActivity().findViewById(R.id.captureNumber);
//        cn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//    /* When focus is lost check that the text field
//    * has valid values.
//    */
//                if (!hasFocus) {
//                    //save input
//                    Integer data = TryParseInt(((EditText) v).getText().toString());
//                    if (data != null) {
//                        Log.d("saved data", data.toString());
//                        captureNum = data;
//                        Log.d("saving field", "capture number");
//                    }
//                }
//            }
//        });
//        lc = (EditText)getActivity().findViewById(R.id.enterLocation);
//        lc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//    /* When focus is lost check that the text field
//    * has valid values.
//    */
//                if (!hasFocus) {
//                    //save input
//                    location = ((EditText)v).getText().toString();
//                    Log.d("saving field", "location");
//
//                }
//            }
//        });
//
//        dt = (EditText)getActivity().findViewById(R.id.enterDate);
//        dt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//    /* When focus is lost check that the text field
//    * has valid values.
//    */
//                if (!hasFocus) {
//                    //save input
//                    date = ((EditText)v).getText().toString();
//                    Log.d("saving field", "date");
//                }
//            }
//        });
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void saveCapture(View v) {
        parseField(getActivity().findViewById(R.id.captureNumber));
        parseField(getActivity().findViewById(R.id.enterLocation));
        parseField(getActivity().findViewById(R.id.enterDate));

        if(captureNum != 0 && location != null && date != null) {
            FragmentCommunicator fc = (FragmentCommunicator)getActivity();
            fc.setCaptureData(captureNum, location, date);
            Log.d("setting fragment data", "Capture");
        }
        else {
            //notify user
            CharSequence text = "We have a problem!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
