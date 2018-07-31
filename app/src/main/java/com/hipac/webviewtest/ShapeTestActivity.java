package com.hipac.webviewtest;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hipac.webviewtest.view.DensityUtil;
import com.hipac.webviewtest.view.EasyShape;

public class ShapeTestActivity  extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_test);
        view = findViewById(R.id.tv_test);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                EasyShape bg = new EasyShape(view);
                bg.buildDashRectangle(DensityUtil.dp2px(5),2,Color.parseColor("#ed3a4a"),Color.WHITE,20,10);
//                bg.buildRectangle(DensityUtil.dp2px(5),DensityUtil.dp2px(1), Color.parseColor("#ed3a4a"),Color.WHITE);
                break;
            case R.id.btn_2:
                EasyShape bg2 = new EasyShape(view);
                new EasyShape.Builder(bg2)
                        .cornerRadius(DensityUtil.dp2px(5))
                        .strokeWidth(0)
                        .strokeColor(Color.parseColor("#ed3a4a"))
                        .mGradientType(EasyShape.GradientType.LINEAR_GRADIENT)
                        .gradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT)
                        .gradientColor(Color.GREEN,Color.RED)
                        .buildRectangle();
                break;
            case R.id.btn_3:
                EasyShape bg3 = new EasyShape(view);
                new EasyShape.Builder(bg3)
                        .cornerRadius(DensityUtil.dp2px(5))
                        .strokeWidth(DensityUtil.dp2px(3))
                        .strokeColor(Color.parseColor("#e8e8e8"))
                        .mGradientType(EasyShape.GradientType.RADIAL_GRADIENT)
                        .gradientRadius(view.getMeasuredHeight())
                        .gradientColors(new int[]{Color.GREEN,Color.WHITE,Color.RED})
                        .dashWidthAndGap(DensityUtil.dp2px(6),DensityUtil.dp2px(4))
                        .buildRectangle();
                break;
            case R.id.btn_4:
                EasyShape bg4 = new EasyShape(view);
                new EasyShape.Builder(bg4)
                        .cornerRadius(DensityUtil.dp2px(5))
                        .strokeWidth(1)
                        .strokeColor(Color.parseColor("#ed3a4a"))
                        .mGradientType(EasyShape.GradientType.SWEEP_GRADIENT)
                        .gradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT)
                        .gradientRadius(view.getMeasuredHeight())
                        .centerXAndY(0.5f,0.5f)
                        .gradientColors(new int[]{Color.GREEN,Color.RED,Color.BLUE,Color.YELLOW})
                        .buildRectangle();
                break;
            case R.id.btn_5:
                EasyShape bg5 = new EasyShape(view);
                new EasyShape.Builder(bg5)
                        .cornerRadius(DensityUtil.dp2px(5))
                        .strokeWidth(1)
                        .strokeColor(Color.parseColor("#ed3a4a"))
                        .mGradientType(EasyShape.GradientType.LINEAR_GRADIENT)
                        .gradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT)
                        .gradientColor(Color.GREEN,Color.RED)
                        .cornerRadius(DensityUtil.dp2px(4))
                        .eachCornerRadius(DensityUtil.dp2px(16),0,DensityUtil.dp2px(16),0)
                        .buildCornerRect();
                break;
            case R.id.btn_6:
                EasyShape bg6= new EasyShape(view);
                bg6.buildOval(0,0,DensityUtil.dp2px(1),Color.parseColor("#ed3a4a"),Color.WHITE);
                break;
            case R.id.btn_7:
                new EasyShape(view).buildGradientOval(100,100,1,Color.parseColor("#ed3a4a"),Color.GREEN,Color.RED);
//                EasyShape bg7 = new EasyShape(view);
//                new EasyShape.Builder(bg7)
//                        .strokeWidth(1)
//                        .strokeColor(Color.parseColor("#ed3a4a"))
//                        .gradientColor(Color.GREEN,Color.RED)
//                        .ovalWidthAndHeight(DensityUtil.dp2px(20),DensityUtil.dp2px(20))
//                        .mGradientType(EasyShape.GradientType.LINEAR_GRADIENT)
//                        .gradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT)
//                        .buildOval();
                break;
            case R.id.btn_8:
                EasyShape bg8 = new EasyShape(view);
                new EasyShape.Builder(bg8)
                        .strokeWidth(1)
                        .strokeColor(Color.parseColor("#ed3a4a"))
                        .gradientColor(Color.GREEN,Color.RED)
                        .ovalWidthAndHeight(DensityUtil.dp2px(20),DensityUtil.dp2px(20))
                        .mGradientType(EasyShape.GradientType.RADIAL_GRADIENT)
                        .gradientRadius(view.getMeasuredHeight()*0.5f)
                        .buildOval();
                break;
            case R.id.btn_9:
                EasyShape bg9 = new EasyShape(view);
                new EasyShape.Builder(bg9)
                        .strokeWidth(1)
                        .strokeColor(Color.parseColor("#ed3a4a"))
                        .gradientColors(new int[]{Color.GREEN,Color.RED,Color.BLUE,Color.YELLOW,Color.GRAY})
                        .ovalWidthAndHeight(DensityUtil.dp2px(100),DensityUtil.dp2px(100))
                        .mGradientType(EasyShape.GradientType.SWEEP_GRADIENT)
                        .gradientRadius(view.getMeasuredHeight())
                        .buildOval();
                break;
        }
    }



}
