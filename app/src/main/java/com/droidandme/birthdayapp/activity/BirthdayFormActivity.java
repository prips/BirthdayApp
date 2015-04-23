package com.droidandme.birthdayapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.droidandme.birthdayapp.R;
import com.droidandme.birthdayapp.fragment.BirthdayFormFragment;
import com.droidandme.birthdayapp.utils.BirthdaySession;

import static com.droidandme.birthdayapp.fragment.BirthdayFormFragment.OnFragmentInteractionListener;


public class BirthdayFormActivity extends Activity implements OnFragmentInteractionListener {

    private BirthdaySession mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_form);
        getActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new BirthdayFormFragment())
                    .commit();
        }
        mSession = new BirthdaySession();
    }

    @Override
    public void updateSessionState(BirthdaySession.BirthdayApp param, Object value) {
        if (param.equals(BirthdaySession.BirthdayApp.FIRST_NAME)) {
            mSession.setFirstName((String)value);
        } else if (param.equals(BirthdaySession.BirthdayApp.LAST_NAME)) {
            mSession.setLastName((String) value);
        }
    }

    @Override
    public void onButtonPressed() {
        //Pass an intent to the AddMessageActivity
        Intent intent = new Intent(this, AddMessageActivity.class);
        intent.putExtra("session", mSession);
        startActivity(intent);
    }
}
