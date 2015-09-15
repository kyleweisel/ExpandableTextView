package com.kyleweisel.expandabletextview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public final class MaxLinesTextView extends TextView implements View.OnClickListener {

    private static final int DEFAULT_ANIMATION_DURATION_MS= 500;
    private static final int DEFAULT_NUM_LINES = 3;

    private boolean isExpanded;
    private int collapseAnimationDuration;
    private int expandAnimationDuration;
    private int numLinesWhenCollapsed;

    public MaxLinesTextView(final Context context) {
        super(context);
        this.setOnClickListener(this);
        this.setMinLines(1);
        this.setMaxLines(this.numLinesWhenCollapsed);
    }

    public MaxLinesTextView(final Context context, final AttributeSet attrs) {

        super(context, attrs);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaxLinesTextView);
        this.collapseAnimationDuration = typedArray.getInt(R.styleable.MaxLinesTextView_collapseAnimationDuration, DEFAULT_ANIMATION_DURATION_MS);
        this.expandAnimationDuration = typedArray.getInt(R.styleable.MaxLinesTextView_expandAnimationDuration, DEFAULT_ANIMATION_DURATION_MS);
        this.numLinesWhenCollapsed = typedArray.getInt(R.styleable.MaxLinesTextView_maxLinesWhenCollapsed, DEFAULT_NUM_LINES);
        typedArray.recycle();

        this.setMinLines(1);
        this.setMaxLines(this.numLinesWhenCollapsed);

        this.setOnClickListener(this);

    }

    public final void onClick(final View view) {

        this.isExpanded = !this.isExpanded;
        this.requestFocusFromTouch();

        if (this.isExpanded) {
            final ObjectAnimator animation = ObjectAnimator.ofInt(view, "maxLines", this.numLinesWhenCollapsed);
            animation.setDuration(this.collapseAnimationDuration);
            animation.start();
        }
        else {
            final ObjectAnimator animation = ObjectAnimator.ofInt(view, "maxLines", this.getLineCount());
            animation.setDuration(this.expandAnimationDuration);
            animation.start();
        }

    }

    public void setCollapseAnimationDuration(final int duration) {
        this.collapseAnimationDuration = duration;
    }

    public void setExpandAnimationDuration(final int duration) {
        this.expandAnimationDuration = duration;
    }

}
