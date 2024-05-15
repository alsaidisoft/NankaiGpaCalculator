package com.nanaki.gpacalculator;

import android.text.InputFilter;
import android.text.Spanned;

public class DecimalDigitsInputFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        StringBuilder builder = new StringBuilder(dest);
        int maxDigitsBeforeDecimalPoint = 2;
        int maxDigitsAfterDecimalPoint = 2;
        builder.replace(dstart, dend, source
                .subSequence(start, end).toString());
        if (!builder.toString().matches(
                "(([1-9]{1})([0-9]{0," + (maxDigitsBeforeDecimalPoint - 1) + "})?)?(\\.[0-9]{0," + maxDigitsAfterDecimalPoint + "})?"

        )) {
            if (source.length() == 0)
                return dest.subSequence(dstart, dend);
            return "";
        }

        return null;
    }
}