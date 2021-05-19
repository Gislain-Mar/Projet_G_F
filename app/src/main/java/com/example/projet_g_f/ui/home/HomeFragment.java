package com.example.projet_g_f.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    private static TextView mTextView;
    private static ProgressBar mProgressBar;

    private static int mScore = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mScan_Button = root.findViewById(R.id.btn_Scan);
        mTextView = root.findViewById(R.id.messages_textView);
        mProgressBar = root.findViewById(R.id.ProgressBar);

        Text_Messages();

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
            mTextView.setText("You have collected "+ mScore + " g of plasitc waste ! Keep it up !");
        }
        else
        {
            mTextView.setText("Collect plastic waste to increase you score !");
        }
    }

    public static void Increase_Score(){
        mScore+=10;
        mProgressBar.setProgress(mScore);
    }
}