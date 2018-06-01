package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

import com.beloo.widget.chipslayoutmanager.util.log.Log;

class CenterInRowGravityModifier implements IGravityModifier {
    private static final String TAG = "CenterInRowGravityModifier";

    @Override
    public Rect modifyChildRect(int minStart, int maxEnd, Rect childRect) {
        childRect = new Rect(childRect);

        if (childRect.top < minStart) {
            Log.e(TAG, "top point of input rect can't be lower than minTop");
            return childRect;
            //throw new IllegalArgumentException("top point of input rect can't be lower than minTop");
        }
        if (childRect.bottom > maxEnd) {
            throw new IllegalArgumentException("bottom point of input rect can't be bigger than maxTop");
        }



        int placeHeight = maxEnd - minStart;
        int rectHeight = childRect.bottom - childRect.top;
        //calculate needed offset
        int halfOffset = (placeHeight - rectHeight)/2;

        childRect.top = minStart + halfOffset;
        childRect.bottom = maxEnd - halfOffset;

        return childRect;
    }
}
