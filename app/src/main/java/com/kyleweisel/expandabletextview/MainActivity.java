package com.kyleweisel.expandabletextview;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String yourText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Ut volutpat interdum interdum. Nulla laoreet lacus diam, vitae " +
                    "sodales sapien commodo faucibus. Vestibulum et feugiat enim. Donec " +
                    "semper mi et euismod tempor. Sed sodales eleifend mi id varius. Nam " +
                    "et ornare enim, sit amet gravida sapien. Quisque gravida et enim vel " +
                    "volutpat. Vivamus egestas ut felis a blandit. Vivamus fringilla " +
                    "dignissim mollis. Maecenas imperdiet interdum hendrerit. Aliquam" +
                    " dictum hendrerit ultrices. Ut vitae vestibulum dolor. Donec auctor ante" +
                    " eget libero molestie porta. Nam tempor fringilla ultricies. Nam sem " +
                    "lectus, feugiat eget ullamcorper vitae, ornare et sem. Fusce dapibus ipsum" +
                    " sed laoreet suscipit. ";

            final MaxLinesTextView expandableTextView = (MaxLinesTextView) rootView.findViewById(R.id.lorem_ipsum);
            expandableTextView.setText(yourText);

            return rootView;
        }
    }
}
