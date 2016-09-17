package com.lunasol.eamservice;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements EditUserFragment.OnFragmentInteractionListener, ContextListener {
    private static final String TAG = "MainActivity";

    public enum MENU_OPTION {
        USER_PROFILE,
        EDIT_PROFILE
    }

    private DataBinder mDataBinder;
    private MENU_OPTION mMenu;
    private MainActivityFragment main = new MainActivityFragment();
    private EditUserFragment edit = new EditUserFragment().newInstance("p", "k");

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mDataBinder == null) {
            Customer customer = new Customer("Chris", "Carlos", "1319 N El Prado St", 28, "chris@example.com", "1234567890", new Automobile());
            mDataBinder = new DataBinder(customer);
        }
        main.setDataBinder(mDataBinder);
        edit.setDataBinder(mDataBinder);
        startMainFrag();
    }

    private void changeFragment(Fragment frag, String fragRef, DataBinder.DataBinderListener db) {
        //Get Support Transaction setup
        if (frag == null) {
            return;
        }
        db.setDataBinder(mDataBinder);
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.container, frag, fragRef);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
    }

    private void startMainFrag() {
        main.setDataBinder(mDataBinder);
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.container, main, "main");
        fragTrans.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void OnFragmentChange(MENU_OPTION menu_option) {
        mMenu = menu_option;
        switch (mMenu) {
            case EDIT_PROFILE:
                changeFragment(edit, "editUser", edit);
                break;
            case USER_PROFILE:
                changeFragment(main, "main", main);
                break;
        }
    }
    //TODO: Look up Picasso API and study GSON use, then investigate how to get a server?
}
