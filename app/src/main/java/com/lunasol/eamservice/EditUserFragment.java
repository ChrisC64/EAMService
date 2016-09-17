package com.lunasol.eamservice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lunasol.eamservice.databinding.LayoutEditUserProfileBinding;

public class EditUserFragment extends Fragment implements DataBinder.DataBinderListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private DataBinder mDataBinder;
    private OnFragmentInteractionListener mListener;
    private ContextListener mConListener;
    private LayoutEditUserProfileBinding binding;
    public EditUserFragment() {
        // Required empty public constructor
    }

    public static EditUserFragment newInstance(String param1, String param2) {
        EditUserFragment fragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.layout_edit_user_profile, container, false);
        binding = LayoutEditUserProfileBinding.bind(root);
        binding.setDataBinder(mDataBinder); // TODO: Probably don't need this anymore...?
        binding.setCustomer(mDataBinder.getCustomer()); // Customer Data access
        binding.setEditFragment(this); // Save Customer Data ref
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            mConListener = (ContextListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void setDataBinder(DataBinder dataBinder) {
        this.mDataBinder = dataBinder;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void saveCustomerData() {
        Customer customer;
        String firstName;
        String lastName;
        String maker;
        String model;
        String phoneNumber;
        String email;
        String address;
        double mi;
        int age;
        int vehYear;
        try {
            firstName = binding.customerFirstNameEdit.getText().toString();
            lastName = binding.customerLastNameEdit.getText().toString();
            address = binding.customerAddressEdit.getText().toString();
            age = Integer.parseInt(binding.customerAge.getText().toString());
            email = binding.customerEmailEdit.getText().toString();
            phoneNumber = binding.customerPhoneEdit.getText().toString();
            mi = Double.parseDouble(binding.customerVehicleMilesEdit.getText().toString());
            vehYear = Integer.parseInt(binding.customerVehicleYearEdit.getText().toString());
            model = binding.customerVehicleModelEdit.getText().toString();
            maker = binding.customerVehicleMakeEdit.getText().toString();
            customer = new Customer(firstName, lastName, address, age, email, phoneNumber, new Automobile(mi, vehYear, model, maker));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            customer = new Customer(binding.customerFirstNameEdit.getText().toString(),
                    binding.customerLastNameEdit.getText().toString(),
                    "123 Fake St",
                    24,
                    binding.customerEmailEdit.getText().toString(),
                    binding.customerPhoneEdit.getText().toString(),
                    new Automobile(2147.21,
                            1234,
                            binding.customerVehicleModelEdit.getText().toString(),
                            binding.customerVehicleMakeEdit.getText().toString()));
        }

        mDataBinder.SaveCustomer(customer);
        mConListener.OnFragmentChange(MainActivity.MENU_OPTION.USER_PROFILE);
    }
}
