package com.droidandme.birthdayapp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droidandme.birthdayapp.R;

public class PreviewFragment extends Fragment {
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_FIRST_NAME = "firstName";
    private static final String ARG_LAST_NAME = "lastName";

    private String mMessage;
    private String mFirstName;
    private String mLastName;

    //private OnFragmentInteractionListener mListener;

    public static PreviewFragment newInstance(String message, String firstName, String lastName) {
        PreviewFragment fragment = new PreviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_FIRST_NAME, firstName);
        args.putString(ARG_LAST_NAME, lastName);
        fragment.setArguments(args);
        return fragment;
    }

    public PreviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMessage = getArguments().getString(ARG_MESSAGE);
            mFirstName = getArguments().getString(ARG_FIRST_NAME);
            mLastName = getArguments().getString(ARG_LAST_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View retVal = inflater.inflate(R.layout.fragment_preview, container, false);

        bindMessage(retVal);
        bindName(retVal);

        return retVal;
    }

    private void bindMessage(View parent) {
        TextView message = (TextView) parent.findViewById(R.id.fragment_preview_message);
        message.setText(mMessage);
    }

    private void bindName(View parent) {
        TextView firstName = (TextView) parent.findViewById(R.id.fragment_preview_first_name);
        firstName.setText(mFirstName);

        TextView lastName = (TextView) parent.findViewById(R.id.fragment_preview_last_name);
        lastName.setText(mLastName);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // mListener = null;
    }


}
