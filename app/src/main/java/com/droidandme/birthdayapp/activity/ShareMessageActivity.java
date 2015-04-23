package com.droidandme.birthdayapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

import com.droidandme.birthdayapp.R;
import com.droidandme.birthdayapp.fragment.PreviewFragment;
import com.droidandme.birthdayapp.utils.BirthdaySession;

public class ShareMessageActivity extends Activity {

    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_message);
        getActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) {
            BirthdaySession session = getIntent().getParcelableExtra("session");
            PreviewFragment fragment = PreviewFragment.newInstance(session.getMessage(), session.getFirstName(), session.getLastName());
            getFragmentManager().beginTransaction()
                    .add(R.id.activity_share_message_preview_fragment, fragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share_message, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.menu_item_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            setShareIntent(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
