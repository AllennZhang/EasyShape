EasyShape:

   * 基于GradientDrawable实现，支持view设置圆角矩形背景，椭圆背景，圆形背景，支持纯色和渐变色。渐变色包括：线性渐变，径向渐变，扫描渐变

   * 可以替代XML的方式，减少apk包体积，调用方式是通过代码设置，文中的尺寸均以px为单位

```
 * param cornerRadiusPixel 圆角大小
 * param strokeWidthPixel 描边宽度
 * param strokeColor 描边颜色
 * param solidColor 填充颜色
 * param startColor 渐变开始颜色
  *   param endColor 渐变结束颜色

标准圆角矩形：

new EasyShape(view).buildRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int solidColor);
标准渐变圆角矩形:

new EasyShape(view).buildGradientRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int startColor,int endColor)
带虚线边框的圆角矩形：
new EasyShape(view).buildDashRectangle(int cornerRadiusPixel,int strokeWidthPixel,int strokeColor,int solidColor,float dashWidthPixel,float dashGapPixel)
标准椭圆(圆形)：

new EasyShape(view).buildOval(int widthPixel,int heightPixel,int strokeWidth,int strokeColor,int solidColor)
标准渐变椭圆(圆形)：

new EasyShape(view).buildGradientOval(int widthPixel,int heightPixel,int strokeWidth,int strokeColor,int startColor,int endColor)
更多定制化实现通过Builder实现：
new EasyShape.Builder(new EasyShape(view))
        .cornerRadius(DensityUtil.dp2px(5))
        .strokeWidth(DensityUtil.dp2px(3))
        .strokeColor(Color.parseColor("#e8e8e8"))
        .mGradientType(EasyShape.GradientType.RADIAL_GRADIENT)
        .gradientRadius(view.getMeasuredHeight())
        .gradientColors(new int[]{Color.GREEN,Color.WHITE,Color.RED})
        .dashWidthAndGap(DensityUtil.dp2px(6),DensityUtil.dp2px(4))
        .buildRectangle();
```
![image](https://github.com/YouriZhang/imagefolder/blob/master/easyshape.png)