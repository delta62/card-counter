package com.samnoedel.cardcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CARDS_PER_PAGE = 9;

    private TextView mPageNumberView;
    private EditText mCardNumberView;

    private ImageView mSlot0;
    private ImageView mSlot1;
    private ImageView mSlot2;
    private ImageView mSlot3;
    private ImageView mSlot4;
    private ImageView mSlot5;
    private ImageView mSlot6;
    private ImageView mSlot7;
    private ImageView mSlot8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPageNumberView = (TextView)findViewById(R.id.pageNumber);
        mCardNumberView = (EditText)findViewById(R.id.cardNumber);

        mSlot0 = (ImageView)findViewById(R.id.slot0);
        mSlot1 = (ImageView)findViewById(R.id.slot1);
        mSlot2 = (ImageView)findViewById(R.id.slot2);
        mSlot3 = (ImageView)findViewById(R.id.slot3);
        mSlot4 = (ImageView)findViewById(R.id.slot4);
        mSlot5 = (ImageView)findViewById(R.id.slot5);
        mSlot6 = (ImageView)findViewById(R.id.slot6);
        mSlot7 = (ImageView)findViewById(R.id.slot7);
        mSlot8 = (ImageView)findViewById(R.id.slot8);

        mCardNumberView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                resetView();

                if (str.isEmpty()) {
                    mPageNumberView.setText("");
                } else {
                    int cardNumber = Integer.parseInt(mCardNumberView.getText().toString());
                    int pageNumber = cardNumber / CARDS_PER_PAGE + 1;
                    int pagePosition = (cardNumber - 1) % CARDS_PER_PAGE;
                    selectSlot(pagePosition);
                    mPageNumberView.setText(String.format("Page %1$d", pageNumber));
                }
            }
        });
    }

    private void resetView() {
        mSlot0.setImageResource(R.drawable.no);
        mSlot1.setImageResource(R.drawable.no);
        mSlot2.setImageResource(R.drawable.no);
        mSlot3.setImageResource(R.drawable.no);
        mSlot4.setImageResource(R.drawable.no);
        mSlot5.setImageResource(R.drawable.no);
        mSlot6.setImageResource(R.drawable.no);
        mSlot7.setImageResource(R.drawable.no);
        mSlot8.setImageResource(R.drawable.no);
    }

    private void selectSlot(int slotNo) {
        switch (slotNo) {
            case 0:
                mSlot0.setImageResource(R.drawable.yes);
                break;
            case 1:
                mSlot1.setImageResource(R.drawable.yes);
                break;
            case 2:
                mSlot2.setImageResource(R.drawable.yes);
                break;
            case 3:
                mSlot3.setImageResource(R.drawable.yes);
                break;
            case 4:
                mSlot4.setImageResource(R.drawable.yes);
                break;
            case 5:
                mSlot5.setImageResource(R.drawable.yes);
                break;
            case 6:
                mSlot6.setImageResource(R.drawable.yes);
                break;
            case 7:
                mSlot7.setImageResource(R.drawable.yes);
                break;
            case 8:
                mSlot8.setImageResource(R.drawable.yes);
                break;
        }
    }
}
