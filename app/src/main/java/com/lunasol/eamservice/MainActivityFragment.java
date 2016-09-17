package com.lunasol.eamservice;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lunasol.eamservice.databinding.LayoutUserProfileBinding;

/**
 * Created by chris on 9/7/2016.
 */
public class MainActivityFragment extends  Fragment implements DataBinder.DataBinderListener{
    private ContextListener mListener;
    private Button editButton;
    private DataBinder mDataBinder;
    private View mRoot;
    private static final String TAG = "MainActivityFragment";
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.layout_user_profile, container, false);
        if(mRoot != null && mDataBinder != null) {
            initDataBinder();
        }
        editButton = (Button) mRoot.findViewById(R.id.edit_user_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnFragmentChange(MainActivity.MENU_OPTION.EDIT_PROFILE);
            }
        });
        return mRoot;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ContextListener) {
            mListener = (ContextListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void setDataBinder(DataBinder dataBinder) {
        this.mDataBinder = dataBinder;
    }
    public void initDataBinder() {
        LayoutUserProfileBinding binding = LayoutUserProfileBinding.bind(mRoot);
        binding.setCustomer(mDataBinder.getCustomer());
        binding.setIVehicle(mDataBinder.getIVehicle());
    }
}
