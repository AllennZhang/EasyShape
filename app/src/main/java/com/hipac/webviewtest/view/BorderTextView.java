package com.hipac.webviewtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.hipac.webviewtest.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/**
 * Created by sheena on 17/7/3.
 */

public class BorderTextView extends AppCompatTextView {
    private float mBorderRadius;
    private float mBorderWidth;
    private int mStartColor;
    private int mEndColor;
    private int mBorderColor;
    private float mDashWidth;
    private float mDashGap;
    private int mSolidColor;
    private int mGradientOrientation;

    public BorderTextView(Context context) {
        this(context, null);

    }

    public BorderTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BorderTextView);
        mBorderColor = ta.getColor(R.styleable.BorderTextView_tvBorderColor, Color.TRANSPARENT);
        mBorderWidth = ta.getDimension(R.styleable.BorderTextView_tvBorderWidth, 1.0f);
        mBorderRadius = ta.getDimension(R.styleable.BorderTextView_tvBorderRadius, 1.0f);
        mDashWidth = ta.getDimension(R.styleable.BorderTextView_dashWidth, 0f);
        mDashGap = ta.getDimension(R.styleable.BorderTextView_dashGap, 0f);
        mStartColor = ta.getColor(R.styleable.BorderTextView_tvStartColor, Color.WHITE);
        mEndColor = ta.getColor(R.styleable.BorderTextView_tvEndColor, Color.WHITE);
        mSolidColor = ta.getColor(R.styleable.BorderTextView_tvSolidColor, Color.WHITE);
        mGradientOrientation = ta.getInt(R.styleable.BorderTextView_gradientOrientation,-1);
        ta.recycle();

        refresh();
    }

    private void refresh(){
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setCornerRadius(mBorderRadius);
        bg.setStroke((int) mBorderWidth, mBorderColor,mDashWidth,mDashGap);
        //设置渐变方向，线性
        switch (mGradientOrientation){
            case -1:
                bg.setColor(mSolidColor);
                break;
            case 0:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 1:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 2:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 3:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 4:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.TR_BL);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 5:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.BL_TR);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 6:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.BR_TL);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            case 7:
                bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                bg.setOrientation(GradientDrawable.Orientation.TL_BR);
                bg.setColors(new int[]{mStartColor,mEndColor});
                break;
            default:
                bg.setColor(mSolidColor);
        }
        this.setBackground(bg);
    }


    /**
     * @deprecated Use {@link #update(Builder builder)} instead.
     * @param color
     */
    @Deprecated
    public void setBorderColor(int color) {
        mBorderColor = color;
        refresh();
    }

    /**
     * @deprecated Use {@link #update(Builder builder)} instead.
     * @param borderWidth
     */
    @Deprecated
    public void setBorderWidth(float borderWidth) {
        mBorderWidth = borderWidth;
        refresh();
    }

    /**
     * @deprecated Use {@link #update(Builder builder)} instead.
     * @param borderRadius
     */
    @Deprecated
    public void setBorderRadius(float borderRadius) {
        mBorderRadius = borderRadius;
        refresh();

    }

    /**
     * @deprecated Use {@link #update(Builder builder)} instead.
     * @param startColor
     * @param endColor
     */
    @Deprecated
    public void setFillColor(int startColor, int endColor) {
        mStartColor = startColor;
        mEndColor = endColor;
        refresh();
    }


    public void update(Builder builder){
        if (builder == null) return;
        mBorderRadius = builder.mBorderRadius;
        mBorderWidth = builder.mBorderWidth;
        mBorderColor = builder.mBorderColor;
        mStartColor = builder.mStartColor;
        mEndColor = builder.mEndColor;
        mSolidColor = builder.mSolidColor;
        mDashWidth = builder.mDashWidth;
        mDashGap = builder.mDashGap;
        mGradientOrientation = builder.mGradientOrientation;
        refresh();
    }


    @IntDef({Orientation.LEFT_RIGHT,Orientation.RIGHT_LEFT,
            Orientation.TOP_BOTTOM,Orientation.BOTTOM_TOP,
            Orientation.TR_BL,Orientation.BL_TR,
            Orientation.BR_TL,Orientation.TL_BR,
            Orientation.NONE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
        /** draw the gradient from the left to the right */
        int  LEFT_RIGHT = 0;
        /** draw the gradient from the right to the left */
        int RIGHT_LEFT = 1;
        /** draw the gradient from the top to the bottom */
        int TOP_BOTTOM = 2;
        /** draw the gradient from the bottom to the top */
        int BOTTOM_TOP = 3;
        /** draw the gradient from the top-right to the bottom-left */
        int TR_BL = 4;
        /** draw the gradient from the bottom-left to the top-right */
        int BL_TR = 5;
        /** draw the gradient from the bottom-right to the top-left */
        int BR_TL = 6;
        /** draw the gradient from the top-left to the bottom-right */
        int TL_BR = 7;
        /** no gradient*/
        int NONE = -1;
    }


    public static class  Builder{
        private float mBorderRadius;
        private float mBorderWidth;
        private int mStartColor;
        private int mEndColor;
        private int mBorderColor;
        private float mDashWidth;
        private float mDashGap;
        private int mSolidColor;
        private int mGradientOrientation;
        private WeakReference<BorderTextView> reference;
        public Builder(BorderTextView borderTextView){
            reference = new WeakReference<>(borderTextView);
            if (reference.get() != null){
                //初始化builder 复制 BorderTextView的初始状态,重要
                BorderTextView textView = reference.get();
                this.mBorderRadius = textView.mBorderRadius;
                this.mBorderWidth = textView.mBorderWidth;
                this.mStartColor = textView.mStartColor;
                this.mEndColor = textView.mEndColor;
                this.mBorderColor = textView.mBorderColor;
                this.mSolidColor = textView.mSolidColor;
                this.mDashWidth = textView.mDashWidth;
                this.mDashGap = textView.mDashGap;
                this.mGradientOrientation = textView.mGradientOrientation;
            }
        }

        public Builder borderRadius(int radiusPixel){
            this.mBorderRadius = radiusPixel;
            return this;
        }

        public Builder borderWidth(int widthPixel){
            this.mBorderWidth = widthPixel;
            return this;
        }

        public Builder borderColor(int borderColor){
            this.mBorderRadius = borderColor;
            return this;
        }

        public Builder solidColor(int solidColor){
            this.mSolidColor = solidColor;
            return this;
        }

        public Builder gradientColor(int startColor,int endColor){
            this.mStartColor =startColor;
            this.mEndColor =  endColor;
            return this;
        }

        public Builder dashWidthAndGap(int dashWidthPixel,int dashGapPixel){
            this.mDashWidth = dashWidthPixel;
            this.mDashGap = dashGapPixel ;
            return this;
        }

        public Builder gradientOrientation(@Orientation int orientation){
            switch (orientation) {
                case Orientation.LEFT_RIGHT:
                    this.mGradientOrientation = Orientation.LEFT_RIGHT;
                    break;
                case Orientation.RIGHT_LEFT:
                    this.mGradientOrientation = Orientation.RIGHT_LEFT;
                    break;
                case Orientation.TOP_BOTTOM:
                    this.mGradientOrientation = Orientation.TOP_BOTTOM;
                    break;
                case Orientation.BOTTOM_TOP:
                    this.mGradientOrientation = Orientation.BOTTOM_TOP;
                    break;
                case Orientation.TR_BL:
                    this.mGradientOrientation = Orientation.TR_BL;
                    break;
                case Orientation.BL_TR:
                    this.mGradientOrientation = Orientation.BL_TR;
                    break;
                case Orientation.BR_TL:
                    this.mGradientOrientation = Orientation.RIGHT_LEFT;
                    break;
                case Orientation.TL_BR:
                    this.mGradientOrientation = Orientation.RIGHT_LEFT;
                    break;
                case Orientation.NONE:
                    this.mGradientOrientation = Orientation.NONE;
                    break;
                default:
                    this.mGradientOrientation = Orientation.NONE;
            }
            return this;
        }
    }

}
