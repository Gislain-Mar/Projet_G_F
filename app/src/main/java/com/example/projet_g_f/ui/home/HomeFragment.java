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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeFragment extends Fragment {

    private static Button mScan_Button;
    private static TextView mTextView,mTextView_Score,mTextView_minimum,mPlastic_scanned;
    private static ProgressBar mProgressBar;

    private static int mScore = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mScan_Button = root.findViewById(R.id.btn_Scan);
        mTextView = root.findViewById(R.id.messages_textView);
        mProgressBar = root.findViewById(R.id.ProgressBar);
        mTextView_Score = root.findViewById(R.id.textview_score);
        mTextView_minimum = root.findViewById(R.id.textview_minimum);
        mPlastic_scanned = root.findViewById(R.id.plastic_scanned);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mProgressBar.setMin(0);
            mProgressBar.setMax(20);
        }
        Text_Messages();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTextView_minimum.setText(mProgressBar.getMin()+"");
        }

        mScan_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });



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
        mScore+=10;
        mProgressBar.setProgress(mScore);
    }

    public static void setText_plastic_scan(String chaine){
        mPlastic_scanned.setText(mPlastic_scanned.getText()+"\n"+chaine);
    }
}