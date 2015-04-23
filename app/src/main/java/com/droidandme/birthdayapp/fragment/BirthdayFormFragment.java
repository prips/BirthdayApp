package com.droidandme.birthdayapp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.droidandme.birthdayapp.R;
import com.droidandme.birthdayapp.utils.BirthdaySession;

public class BirthdayFormFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BirthdayFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View retVal = inflater.inflate(R.layout.fragment_birthday_form, container, false);

        Button button = (Button) retVal.findViewById(R.id.fragment_birthday_form_next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
        return retVal;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            TextView firstNameText = (TextView) getActivity().findViewById(R.id.fragment_birthday_form_first_name);
            TextView lastNameText = (TextView) getActivity().findViewById(R.id.fragment_birthday_form_last_name);

            //update session state
            mListener.updateSessionState(BirthdaySession.BirthdayApp.FIRST_NAME, firstNameText.getText().toString());
            mListener.updateSessionState(BirthdaySession.BirthdayApp.LAST_NAME, lastNameText.getText().toString());

            mListener.onButtonPressed();

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
        public void updateSessionState(BirthdaySession.BirthdayApp param, Object value);
        public void onButtonPressed();
    }

}
