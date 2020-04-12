package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String FLOW_STATE_KEY = "flowState";

    private TextView storyTextView;
    private Button topButton;
    private Button bottomButton;
    private int flowState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        flowState = savedInstanceState == null ? 1 : savedInstanceState.getInt(FLOW_STATE_KEY);
        showViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(FLOW_STATE_KEY, flowState);
    }

    public void clickTopButton(View view) {
        if (flowState == 3) {
            flowState = 6;
        } else {
            flowState = 3;
        }

        showViews();
    }

    public void clickBottomButton(View view) {
        if (flowState == 1) {
            flowState = 2;
        } else if (flowState == 2) {
            flowState = 4;
        } else {
            flowState = 5;
        }

        showViews();
    }

    private void showViews() {
        switch (flowState) {
            case 2: showFlowState2(); break;
            case 3: showFlowState3(); break;
            case 4: showFlowState4(); break;
            case 5: showFlowState5(); break;
            case 6: showFlowState6(); break;
            default: showFlowState1();
        }
    }

    private void showFlowState1() {
        storyTextView.setText(R.string.T1_Story);
        topButton.setText(R.string.T1_Ans1);
        bottomButton.setText(R.string.T1_Ans2);
    }

    private void showFlowState2() {
        flowState = 2;
        storyTextView.setText(R.string.T2_Story);
        topButton.setText(R.string.T2_Ans1);
        bottomButton.setText(R.string.T2_Ans2);
    }

    private void showFlowState3() {
        flowState = 3;
        storyTextView.setText(R.string.T3_Story);
        topButton.setText(R.string.T3_Ans1);
        bottomButton.setText(R.string.T3_Ans2);
    }

    private void showFlowState4() {
        flowState = 4;
        storyTextView.setText(R.string.T4_End);
        topButton.setVisibility(View.GONE);
        bottomButton.setVisibility(View.GONE);
    }

    private void showFlowState5() {
        flowState = 5;
        storyTextView.setText(R.string.T5_End);
        topButton.setVisibility(View.GONE);
        bottomButton.setVisibility(View.GONE);
    }

    private void showFlowState6() {
        flowState = 6;
        storyTextView.setText(R.string.T6_End);
        topButton.setVisibility(View.GONE);
        bottomButton.setVisibility(View.GONE);
    }
}
