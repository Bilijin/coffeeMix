package com.example.coffeemix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RelativeLayout editAddressLayout;
    private RelativeLayout editPhoneLayout;
    private TextView editAddress;
    private TextView editPhone;
    private Button saveAddress;
    private Button savePhone;
    private EditText phoneEditText;
    private EditText addressEditText;
    private TextView address;
    private TextView phone;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View settingsView = inflater.inflate(R.layout.fragment_settings, container, false);

        editAddressLayout = settingsView.findViewById(R.id.edit_address_layout);
        editPhoneLayout = settingsView.findViewById(R.id.edit_phone_layout);
        editPhone = settingsView.findViewById(R.id.edit_phone);
        editAddress = settingsView.findViewById(R.id.edit_address);
        saveAddress = settingsView.findViewById(R.id.save_address);
        savePhone = settingsView.findViewById(R.id.save_phone);
        phoneEditText = settingsView.findViewById(R.id.phone_edit);
        addressEditText = settingsView.findViewById(R.id.address_edit);
        address = settingsView.findViewById(R.id.address);
        phone = settingsView.findViewById(R.id.phone_no);

        editPhoneLayout.setVisibility(View.GONE);
        editAddressLayout.setVisibility(View.GONE);

        editPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPhoneLayout.setVisibility(View.VISIBLE);
            }
        });
        editAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAddressLayout.setVisibility(View.VISIBLE);
            }
        });
        saveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address.setText(addressEditText.getText());
                editAddressLayout.setVisibility(View.GONE);
            }
        });
        savePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone.setText(phoneEditText.getText());
                editPhoneLayout.setVisibility(View.GONE);
            }
        });
        return settingsView;
    }
}