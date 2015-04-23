package com.droidandme.birthdayapp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.droidandme.birthdayapp.R;
import com.droidandme.birthdayapp.utils.BirthdaySession;

public class AddMessageFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public AddMessageFragment() {
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
        View retVal = inflater.inflate(R.layout.fragment_add_message, container, false);

        final EditText message = (EditText) retVal.findViewById(R.id.fragment_add_message_editText);
        final Button previewButton = (Button) retVal.findViewById(R.id.fragment_add_message_preview_button);
        final Button nextButton = (Button) retVal.findViewById(R.id.fragment_add_message_next_button);

        //Attach listeners
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.updateSessionState(BirthdaySession.BirthdayApp.MESSAGE, message.getText().toString());
                    mListener.onButtonPressed(previewButton.getId());
                }
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.updateSessionState(BirthdaySession.BirthdayApp.MESSAGE, message.getText().toString());
                    mListener.onButtonPressed(nextButton.getId());
                }
            }
        });
        return retVal;
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
        // TODO: Update argument type and name
        public void onButtonPressed(int buttonId);
        public void updateSessionState(BirthdaySession.BirthdayApp param, Object value);
    }

}
