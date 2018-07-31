package com.hipac.webviewtest.view;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/**
 * Created by youri 2017.07.30
 *
 * EasyShape can help you use and customized Android Shape easily without xml
 * support rectangel, oval, gradient shape
 */

public class EasyShape {
    private WeakReference<View> weakReference;

   public EasyShape(View view){
       weakReference = new WeakReference<>(view);
   }



    /**
     * build an oval shape
     * @param widthPixel
     * @param heightPixel
     * @param strokeWidth
     * @param strokeColor
     * @param solidColor
     */
    public void buildOval(int widthPixel,int heightPixel,int strokeWidth,int strokeColor,int solidColor){
        if (strokeWidth <0){
            strokeWidth = 0;
        }
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.OVAL);
        bg.setSize(widthPixel,heightPixel);
        bg.setStroke(strokeWidth,strokeColor);
        bg.setColor(solidColor);
        if (weakReference != null && weakReference.get() != null){
            weakReference.get().setBackground(bg);
        }

    }

    /**
     * build a gradientOval
     * @param widthPixel
     * @param heightPixel
     * @param strokeWidth
     * @param strokeColor
     * @param startColor
     * @param endColor
     *
     */
    public void buildGradientOval(int widthPixel,int heightPixel,int strokeWidth,int strokeColor,int startColor,int endColor){
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.OVAL);
        bg.setSize(widthPixel,heightPixel);
        bg.setStroke(strokeWidth,strokeColor);
        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        bg.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        bg.setColors(new int[]{startColor,endColor});
        if (weakReference != null && weakReference.get() != null){
            weakReference.get().setBackground(bg);
        }
    }

    /**
     * build a rectangle
     * @param cornerRadiusPixel
     * @param strokeWidthPixel
     * @param strokeColor
     * @param solidColor
     */
    public void buildRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int solidColor){
        if (cornerRadiusPixel < 0){
            cornerRadiusPixel = 0;
        }
        if (strokeWidthPixel <0){
            strokeWidthPixel =0;
        }
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setStroke(strokeWidthPixel,strokeColor);
        bg.setCornerRadius(cornerRadiusPixel);
        bg.setColor(solidColor);
        if (weakReference != null && weakReference.get() != null){
            weakReference.get().setBackground(bg);
        }
    }

    /**
     * build a rectangle with dash line
     * @param cornerRadiusPixel
     * @param strokeWidthPixel
     * @param strokeColor
     * @param solidColor
     * @param dashWidthPixel
     * @param dashGapPixel
     */
    public void buildDashRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int solidColor,float dashWidthPixel,float dashGapPixel){
        if (cornerRadiusPixel < 0){
            cornerRadiusPixel = 0;
        }
        if (strokeWidthPixel <0){
            strokeWidthPixel =0;
        }
        if (dashWidthPixel <0){
            dashWidthPixel = 0;
        }
        if (dashGapPixel <0){
            dashGapPixel = 0;
        }
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setCornerRadius(cornerRadiusPixel);
        bg.setStroke(strokeWidthPixel,strokeColor,dashWidthPixel,dashGapPixel);
        bg.setColor(solidColor);
        if (weakReference != null && weakReference.get() != null){
            weakReference.get().setBackground(bg);
        }
    }

    /**
     *
     * @param cornerRadiusPixel
     * @param strokeWidthPixel
     * @param strokeColor
     * @param startColor
     * @param endColor
     */
    public void buildGradientRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int startColor,int endColor){
        if (cornerRadiusPixel <0){
            cornerRadiusPixel = 0;
        }
        if (strokeWidthPixel <0){
            strokeWidthPixel = 0;
        }
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setStroke(strokeWidthPixel,strokeColor);
        bg.setCornerRadius(cornerRadiusPixel);
        bg.setColors(new int[]{startColor,endColor});
        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        bg.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        if (weakReference != null && weakReference.get() != null){
            weakReference.get().setBackground(bg);
        }
    }




    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape{
       //矩形
        int RECTANGLE = 0;
        //椭圆
        int OVAL = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientType{
       //线性渐变
       int LINEAR_GRADIENT = 0;
       //径向渐变
       int RADIAL_GRADIENT = 1;
       //扫描渐变
       int SWEEP_GRADIENT = 2;
       //无渐变
       int NO_GRADIENT = -1;
    }


    public static class  Builder{
        private float mCornerRadius;
        private int mStrokeWidth;
        private int[] mGradientColors;
        private int mStrokeColor = Color.TRANSPARENT;
        private int mSolidColor = Color.TRANSPARENT;
        private float mDashWidth;
        private float mDashGap;
        private int mOvalWidth;  //椭圆的宽
        private int mOvalHeight; //椭圆的高
        private GradientDrawable.Orientation mInternalOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
        private int mShape = Shape.RECTANGLE;
        private int mGradientType = GradientType.NO_GRADIENT;
        private float mGradientRadius;
        private float mCenterX = 0.5f;
        private float mCenterY = 0.5f;
        private float[] eachCornerRadius = new float[]{0,0,0,0,0,0,0,0};
        private WeakReference<EasyShape> reference;
        public Builder(EasyShape gradientShape){
            reference = new WeakReference<>(gradientShape);
        }

        public Builder cornerRadius(int radiusPixel){
            if (radiusPixel <0){
                radiusPixel = 0;
            }
            this.mCornerRadius = radiusPixel;
            return this;
        }

        public Builder strokeWidth(int widthPixel){
            if (widthPixel <0){
                widthPixel = 0;
            }
            this.mStrokeWidth = widthPixel;
            return this;
        }

        public Builder strokeColor(int strokeColor){
            this.mStrokeColor = strokeColor;
            return this;
        }

        public Builder solidColor(int solidColor){
            this.mSolidColor = solidColor;
            return this;
        }

        public Builder gradientColor(int startColor,int endColor){
            mGradientColors = new int[] {startColor,endColor};
            return this;
        }

        public Builder gradientColors(int[] colors){
            mGradientColors = colors;
            return this;
        }

        public Builder dashWidthAndGap(float dashWidthPixel,float dashGapPixel){
            if (dashGapPixel <0 ){
                dashGapPixel = 0;
            }
            if (dashWidthPixel < 0){
                dashWidthPixel = 0;
            }
            this.mDashWidth = dashWidthPixel;
            this.mDashGap = dashGapPixel ;
            return this;
        }

        public Builder ovalWidthAndHeight(int ovalWidthPixel,int ovalHeightPixel){
            if (ovalWidthPixel <0){
                ovalHeightPixel = 0;
            }
            if (ovalHeightPixel <0){
                ovalHeightPixel = 0;
            }
            this.mOvalWidth = ovalWidthPixel;
            this.mOvalHeight = ovalHeightPixel;
            return this;
        }

        public Builder centerXAndY(float centerX,float centerY){
            if (centerX < 0 ){
                centerX = 0f;
            }else if (centerX > 1.0f){
                centerX = 1.0f;
            }
            if (centerY < 0){
                centerY = 0f;
            }else if (centerY > 1.0f){
                centerY = 1.0f;
            }
            this.mCenterX = centerX;
            this.mCenterY = centerY;
            return this;
        }

        public Builder eachCornerRadius(float topLeftPixel,float topRightPixel,float bottomRightPixel,float bottomLeftPixel){
            if (topLeftPixel <0){
                topLeftPixel = 0;
            }
            if (topRightPixel <0){
                topRightPixel = 0;
            }
            if (bottomLeftPixel <0){
                bottomLeftPixel = 0;
            }
            if (bottomRightPixel <0){
                bottomRightPixel = 0;
            }
            //Path.addRoundRect 是以左上角开始顺时针旋转一圈
            this.eachCornerRadius = new float[]{topLeftPixel,topLeftPixel,topRightPixel,topRightPixel,bottomRightPixel,bottomRightPixel,bottomLeftPixel,bottomLeftPixel};
            return this;
        }

        public Builder gradientRadius(float gradientRadius){
            if (gradientRadius <0){
                gradientRadius = 0;
            }
            this.mGradientRadius = gradientRadius;
            return this;
        }

        @GradientType
        public Builder mGradientType(@GradientType int gradientType){
            switch (gradientType){
                case GradientType.LINEAR_GRADIENT:
                    this.mGradientType = GradientType.LINEAR_GRADIENT;
                    break;
                case GradientType.RADIAL_GRADIENT:
                    this.mGradientType = GradientType.RADIAL_GRADIENT;
                    break;
                case GradientType.SWEEP_GRADIENT:
                    this.mGradientType = GradientType.SWEEP_GRADIENT;
                    break;
                default:
                    this.mGradientType = GradientType.NO_GRADIENT;

            }
            return this;
        }




        public Builder gradientOrientation(GradientDrawable.Orientation  orientation){
            this.mInternalOrientation = orientation;
            return this;
        }


        /**
         * build normal rect with gradient
         */
        public void buildRectangle(){
             this.mShape = Shape.RECTANGLE;
             GradientDrawable bg = new GradientDrawable();
             bg.setShape(GradientDrawable.RECTANGLE);
             bg.setStroke(mStrokeWidth,mStrokeColor,mDashWidth,mDashGap);
             bg.setCornerRadius(mCornerRadius);
             if (mGradientType == GradientType.NO_GRADIENT){
                 bg.setColor(mSolidColor);
             }else {
                 if (mGradientColors == null || mGradientColors.length == 0){
                     mGradientColors = new int[] {Color.TRANSPARENT,Color.TRANSPARENT};
                 }
                 //设置渐变方向，线性
                 switch (mGradientType){
                     case GradientType.LINEAR_GRADIENT:
                         bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                         bg.setOrientation(mInternalOrientation);
                         bg.setGradientCenter(mCenterX,mCenterY);
                         bg.setColors(mGradientColors);
                         break;
                     case GradientType.RADIAL_GRADIENT:
                         bg.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                         bg.setOrientation(mInternalOrientation);
                         bg.setGradientCenter(mCenterX,mCenterY);
                         bg.setGradientRadius(mGradientRadius);
                         bg.setColors(mGradientColors);
                         break;
                     case GradientType.SWEEP_GRADIENT:
                         bg.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                         bg.setOrientation(mInternalOrientation);
                         bg.setGradientCenter(mCenterX,mCenterY);
                         bg.setGradientRadius(mGradientRadius);
                         bg.setColors(mGradientColors);
                         break;
                     default:
                         bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                         bg.setOrientation(mInternalOrientation);
                         bg.setGradientCenter(mCenterX,mCenterY);
                         bg.setColors(mGradientColors);
                 }

             }

             if (reference != null && reference.get() != null && reference.get().weakReference !=null && reference.get().weakReference.get() != null){
                 reference.get().weakReference.get().setBackground(bg);
             }

        }

        /**
         * build specialfied corner with gradient
         */
        public void buildCornerRect(){
            this.mShape = Shape.RECTANGLE;
            GradientDrawable bg = new GradientDrawable();
            bg.setShape(GradientDrawable.RECTANGLE);
            bg.setStroke(mStrokeWidth,mStrokeColor,mDashWidth,mDashGap);
            bg.setCornerRadius(mCornerRadius);
            bg.setCornerRadii(eachCornerRadius );
            if (mGradientType == GradientType.NO_GRADIENT){
                bg.setColor(mSolidColor);
            }else {
                if (mGradientColors == null || mGradientColors.length == 0){
                    mGradientColors = new int[] {Color.TRANSPARENT,Color.TRANSPARENT};
                }
                //设置渐变方向，线性
                switch (mGradientType){
                    case GradientType.LINEAR_GRADIENT:
                        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                        bg.setOrientation(mInternalOrientation);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                        break;
                    case GradientType.RADIAL_GRADIENT:
                        bg.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                        break;
                    case GradientType.SWEEP_GRADIENT:
                        bg.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                        break;
                    default:
                        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                        bg.setOrientation(mInternalOrientation);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                }

            }

            if (reference != null && reference.get() != null && reference.get().weakReference !=null && reference.get().weakReference.get() != null){
                reference.get().weakReference.get().setBackground(bg);
            }
        }


        /**
         * build oval with gradient
         */
        public void buildOval(){
            this.mShape = Shape.OVAL;
            GradientDrawable bg = new GradientDrawable();
            bg.setShape(GradientDrawable.OVAL);
            bg.setStroke(mStrokeWidth,mStrokeColor,mDashWidth,mDashGap);
            bg.setSize(mOvalWidth,mOvalHeight);
            if (mGradientType == GradientType.NO_GRADIENT){
                bg.setColor(mSolidColor);
            }else {
                if (mGradientColors == null || mGradientColors.length == 0){
                    mGradientColors = new int[] {Color.TRANSPARENT,Color.TRANSPARENT};
                }
                //设置渐变方向，线性
                switch (mGradientType){
                    case GradientType.LINEAR_GRADIENT:
                        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                        bg.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                        break;
                    case GradientType.RADIAL_GRADIENT:
                        bg.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setGradientRadius(mGradientRadius);
                        bg.setColors(mGradientColors);
                        break;
                    case GradientType.SWEEP_GRADIENT:
                        bg.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                        break;
                    default:
                        bg.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                        bg.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        bg.setGradientCenter(mCenterX,mCenterY);
                        bg.setColors(mGradientColors);
                }
            }

            if (reference != null && reference.get() != null && reference.get().weakReference !=null && reference.get().weakReference.get() != null){
                reference.get().weakReference.get().setBackground(bg);
            }
        }


    }

}
