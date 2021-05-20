package com.example.projet_g_f.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projet_g_f.Capture;
import com.example.projet_g_f.MainActivity;
import com.example.projet_g_f.R;
<<<<<<< HEAD
import com.getbase.floatingactionbutton.FloatingActionsMenu;
=======
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeFragment extends Fragment {

<<<<<<< HEAD
    private static Button mScan_Button,mButtonS,mButtonM,mButtonL,mButtonXL;
    private static TextView mTextView,mTextView_Score,mTextView_minimum,mTextView_maximum,mPlastic_scanned;
    private static ProgressBar mProgressBar;
    private static FloatingActionsMenu mFloatingActionsMenuSize;

    private static int progressbarlevel[]={0,20,40,80,160,250};
    private static int level = 0;
    private static String size="";
=======
    private static Button mScan_Button;
    private static TextView mTextView,mTextView_Score,mTextView_minimum,mPlastic_scanned;
    private static ProgressBar mProgressBar;
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da

    private static int mScore = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mScan_Button = root.findViewById(R.id.btn_Scan);
<<<<<<< HEAD
        mButtonS = root.findViewById(R.id.btn_SizeS);
        mButtonM = root.findViewById(R.id.btn_SizeM);
        mButtonL = root.findViewById(R.id.btn_SizeL);
        mButtonXL = root.findViewById(R.id.btn_SizeXL);
=======
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da
        mTextView = root.findViewById(R.id.messages_textView);
        mProgressBar = root.findViewById(R.id.ProgressBar);
        mTextView_Score = root.findViewById(R.id.textview_score);
        mTextView_minimum = root.findViewById(R.id.textview_minimum);
<<<<<<< HEAD
        mTextView_maximum = root.findViewById(R.id.textview_maximum);
        mPlastic_scanned = root.findViewById(R.id.plastic_scanned);
        mFloatingActionsMenuSize = root.findViewById(R.id.flmenuSize);

        setProgressBar();
        Text_Messages();

        mButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ="S";
                Increase_Score();
                Text_Messages();
                setProgressBar();
                mFloatingActionsMenuSize.collapse();
            }
        });
        mButtonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ="M";
                Increase_Score();
                Text_Messages();
                setProgressBar();
                mFloatingActionsMenuSize.collapse();
            }
        });
        mButtonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ="L";
                Increase_Score();
                Text_Messages();
                setProgressBar();
                mFloatingActionsMenuSize.collapse();
            }
        });
        mButtonXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ="XL";
                Increase_Score();
                Text_Messages();
                setProgressBar();
                mFloatingActionsMenuSize.collapse();
            }
        });
=======
        mPlastic_scanned = root.findViewById(R.id.plastic_scanned);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mProgressBar.setMin(0);
            mProgressBar.setMax(20);
        }
        Text_Messages();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTextView_minimum.setText(mProgressBar.getMin()+"");
        }
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da

        mScan_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });


<<<<<<< HEAD
=======

>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da
        return root;
    }

    private void scan(){
        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());;
        intentIntegrator.setPrompt("For flash use volume up key");
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();
    }

    public static void Text_Messages(){
        if(mScore != 0)
        {
            mTextView.setText("You have collected "+ mScore + " g of plasitc waste !\nKeep it up !");
        }
        else
        {
            mTextView.setText("Collect plastic waste to increase you score !");
        }
        mTextView_Score.setText(mScore+"");
    }

    public static void Increase_Score(){
<<<<<<< HEAD
        if(size.equals("S")){
            mScore+=4;
        }
        else if(size.equals("M")){
            mScore+=6;
        }
        else if(size.equals("L")){
            mScore+=8;
        }
        else if(size.equals("XL")){
            mScore+=10;
        }
=======
        mScore+=10;
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da
        mProgressBar.setProgress(mScore);
    }

    public static void setText_plastic_scan(String chaine){
        mPlastic_scanned.setText(mPlastic_scanned.getText()+"\n"+chaine);
    }
<<<<<<< HEAD

    public static void setProgressBar(){
        if(mProgressBar.getProgress() == progressbarlevel[level+1])
        {
            level++;
        }
        if (level <6) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mProgressBar.setMin(progressbarlevel[level]);
                mProgressBar.setMax(progressbarlevel[level+1]);
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTextView_minimum.setText(mProgressBar.getMin()+"");
            mTextView_maximum.setText(mProgressBar.getMax()+"");
        }
    }
    public static void expandSizeMenu(){
        mFloatingActionsMenuSize.expand();
    }
=======
>>>>>>> a342f5e93b14fd7b991bb2e674b7eaeb432f62da
}