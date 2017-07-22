package com.example.bptestingapp.auxiliary;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by C0RRUP70R.
 */

public class InputFilterMinMaxInt implements InputFilter {
    private int min, max;

    public InputFilterMinMaxInt(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMaxInt(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if((input + "").length() < 8) {
                if (isInRange(min, max, input))
                    return null;
            } else{
                return "";
            }
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
