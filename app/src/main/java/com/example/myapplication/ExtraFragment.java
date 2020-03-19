package com.example.myapplication;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class ExtraFragment extends Fragment {
    public ExtraFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.extra_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView mExtraTextView = view.findViewById(R.id.extra_text);

        Bundle args = getArguments();
        if (args != null) {
            int number = args.getInt(CommonConstants.EXTRA_NUMBER);
            int color = args.getInt(CommonConstants.EXTRA_NUMBER_COLOR);
            ListViewNumber listViewNumber = new ListViewNumber(number);
            mExtraTextView.setText(listViewNumber.toString());
            mExtraTextView.setTextColor(color);
        }
    }
}