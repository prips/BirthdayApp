package com.droidandme.birthdayapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.droidandme.birthdayapp.R;
import com.droidandme.birthdayapp.fragment.AddMessageFragment;
import com.droidandme.birthdayapp.fragment.PreviewFragment;
import com.droidandme.birthdayapp.utils.BirthdaySession;

public class AddMessageActivity extends Activity implements AddMessageFragment.OnFragmentInteractionListener {

    BirthdaySession mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);
        getActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState != null) {
            mSession = savedInstanceState.getParcelable("session");
        } else {
            mSession = getIntent().getParcelableExtra("session");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelable("session", mSession);
    }

    @Override
    public void updateSessionState(BirthdaySession.BirthdayApp param, Object value) {
        if (param == BirthdaySession.BirthdayApp.MESSAGE) {
            mSession.setMessage((String) value);
        }
    }

    @Override
    public void onButtonPressed(int buttonId) {
        if (buttonId == R.id.fragment_add_message_preview_button) {
            PreviewFragment previewFragment = PreviewFragment.newInstance(mSession.getMessage(), mSession.getFirstName(), mSession.getLastName());
            getFragmentManager().beginTransaction().add(R.id.fragment_add_message_preview, previewFragment, "PREVIEW").commit();
        } else if (buttonId == R.id.fragment_add_message_next_button) {
            Intent intent = new Intent(this, ShareMessageActivity.class);
            intent.putExtra("session", mSession);
            startActivity(intent);
        }
    }
}
