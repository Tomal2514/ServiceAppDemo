package com.example.tomal.serviceappdemo.fragment;


import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.util.MoneyValueFilter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutsPlusBottomSheetDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private Button perServiceButton, perHourButton, perDayButton, perWeekButton, perMonthButton, prevSelectedButton,
    perServicelistDoneButton;
    private EditText perSeriviceRateEditText;

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {

                dismiss();
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {


        }
    };


    public TutsPlusBottomSheetDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View contentView = View.inflate(getContext(), R.layout.fragment_tuts_plus_bottom_sheet_dialog, null);


        initiliaze(contentView);
        dialog.setContentView(contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        final CoordinatorLayout.Behavior behavior = params.getBehavior();

        //getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY);



        perSeriviceRateEditText.setFilters(new InputFilter[] { new MoneyValueFilter() });

        perSeriviceRateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    ((BottomSheetBehavior) behavior).setPeekHeight(700);
                }else {
                    System.out.println("Dont have foucs");
                }
            }
        });

    }


    private void initiliaze(View root) {
        perServiceButton = (Button) root.findViewById(R.id.per_service_button);
        perServiceButton.setOnClickListener(this);

        perHourButton = (Button) root.findViewById(R.id.per_hour_button);
        perHourButton.setOnClickListener(this);

        perDayButton = (Button) root.findViewById(R.id.per_day_button);
        perDayButton.setOnClickListener(this);


        perWeekButton = (Button) root.findViewById(R.id.per_week_button);
        perWeekButton.setOnClickListener(this);

        perMonthButton = (Button) root.findViewById(R.id.per_month_button);
        perMonthButton.setOnClickListener(this);

        perServicelistDoneButton=(Button)root.findViewById(R.id.per_list_done_button);
        perServicelistDoneButton.setOnClickListener(this);
        perSeriviceRateEditText=(EditText)root.findViewById(R.id.per_serivice_rate_edit_text);


    }

    @Override
    public void onClick(View v) {
        if (v == perServiceButton) {
            if (prevSelectedButton == perServiceButton) {
                changeToUnlickState(perServiceButton);
                prevSelectedButton = null;
            } else {
                changeToClickState(perServiceButton);
                if (prevSelectedButton != null)
                    changeToUnlickState(prevSelectedButton);
                prevSelectedButton = perServiceButton;
            }

        }else if (v==perHourButton){
            if (prevSelectedButton == perHourButton) {
                changeToUnlickState(perHourButton);
                prevSelectedButton = null;
            } else {
                changeToClickState(perHourButton);
                if (prevSelectedButton != null)
                    changeToUnlickState(prevSelectedButton);
                prevSelectedButton = perHourButton;
            }
        }else if (v==perDayButton){
            if (prevSelectedButton == perDayButton) {
                changeToUnlickState(perDayButton);
                prevSelectedButton = null;
            } else {
                changeToClickState(perDayButton);
                if (prevSelectedButton != null)
                    changeToUnlickState(prevSelectedButton);
                prevSelectedButton = perDayButton;
            }
        }else if (v==perWeekButton){
            if (prevSelectedButton == perWeekButton) {
                changeToUnlickState(perWeekButton);
                prevSelectedButton = null;
            } else {
                changeToClickState(perWeekButton);
                if (prevSelectedButton != null)
                    changeToUnlickState(prevSelectedButton);
                prevSelectedButton = perWeekButton;
            }
        }else if (v==perMonthButton){

            if (prevSelectedButton == perMonthButton) {
                changeToUnlickState(perMonthButton);
                prevSelectedButton = null;
            } else {
                changeToClickState(perMonthButton);
                if (prevSelectedButton != null)
                    changeToUnlickState(prevSelectedButton);
                prevSelectedButton = perMonthButton;
            }
        }else if (v==perServicelistDoneButton){
            dismiss();
        }
    }


    private void changeToClickState(Button button) {

        button.setTextColor(ContextCompat.getColor(getActivity(), R.color.ggs_white));

        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.ggs_corner_button_click);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            button.setBackgroundDrawable(drawable);

        } else {
            button.setBackground(drawable);

        }
    }


    private void changeToUnlickState(Button button) {
        button.setTextColor(ContextCompat.getColor(getActivity(), R.color.ggs_per_list_text_color));

        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.ggs_corner_button);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            button.setBackgroundDrawable(drawable);

        } else {
            button.setBackground(drawable);

        }
    }
}
