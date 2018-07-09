package com.daimao.bluebubble.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;

import static com.daimao.bluebubble.util.Tools.checkNotNull;

/**
 * Created by 百戈 on 2017/6/7.
 */

/*http://blog.csdn.net/u011011744/article/details/52754032
* 首先我们来先想想如何加载一个Bitmap吧!
* Bitmap 在Android 中指的是一张图片
* 通过BitmapFactory 类提供的四个方法: decodeFile、decodeResouce、decodeStream和decodeByteArray，
* 分别用于支持从文件系统、资源、输入流以及字节数组中加载一个Bitmap对象。
*
* */
public class BitmapTools {


    /*
 * px像素
 */
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);//加载原图

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        //TODO BitmapFactory  无法被gc()回收，请不要使用
        return BitmapFactory.decodeResource(res, resId, options);//加载缩略图
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap drawCircleView(Bitmap bitmap, int width, int height) {

        float radius = Math.min(width / 2.0f, height / 2.0f);

        //这里可能需要调整一下图片的大小来让你的图片能在圆里面充分显示
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);

        //获得一种渲染方式对象
        //BitmapShader的作用是使用一张位图作为纹理来对某一区域进行填充。
        //可以想象成在一块区域内铺瓷砖，只是这里的瓷砖是一张张位图而已。
        Shader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        //获得一个画笔对象
        Paint bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);

        //设置画笔的渲染方式
        bitmapPaint.setShader(bitmapShader);

        //构建一个位图对象，画布绘制出来的图片将会绘制到此bitmap对象上
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //构建一个画布,
        Canvas canvas = new Canvas(bm);

        //通过画布的画圆方法将渲染后的图片绘制出来
        canvas.drawCircle(radius, radius, radius, bitmapPaint);
        //返回的就是一个圆形的bitmap对象
        return bm;
    }

    public static Bitmap createCircleLogo(String text, int radius, int backgroundColor, int fontColor){
        checkNotNull(text);
        Bitmap bitmap = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        //画背景圆
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(backgroundColor);
        canvas.drawCircle(radius, radius, radius, paint);

        //画字体
        Paint fontPaint = new Paint();
        // 设置字体边缘平滑
        fontPaint.setAntiAlias(true);
        fontPaint.setStyle(Paint.Style.FILL);
//        fontPaint.setStrokeWidth(2);
        fontPaint.setColor(fontColor);
        fontPaint.setTextSize(radius);
        fontPaint.setTypeface(Typeface.MONOSPACE);
        Rect rect = new Rect();
        fontPaint.getTextBounds(text, 0, 1, rect);

        // 文字宽度
        int textWidth = rect.width();
        // 文字高度
        int textHeight = rect.height();
        canvas.drawText(text.substring(0, 1), radius - textWidth/2, radius + textHeight / 2, fontPaint);

        return bitmap;
    }

    public static Bitmap drawCircleViewWithBorder(Bitmap bitmap, int width, int height, int borderWidth, int borderColor) {

        float radius = Math.min(width / 2.0f, height / 2.0f);

        //这里可能需要调整一下图片的大小来让你的图片能在圆里面充分显示
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);

        //获得一种渲染方式对象
        //BitmapShader的作用是使用一张位图作为纹理来对某一区域进行填充。
        //可以想象成在一块区域内铺瓷砖，只是这里的瓷砖是一张张位图而已。
        Shader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        //获得一个画笔对象
        Paint bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);

        //设置画笔的渲染方式
        bitmapPaint.setShader(bitmapShader);

        //构建一个位图对象，画布绘制出来的图片将会绘制到此bitmap对象上
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //构建一个画布,
        Canvas canvas = new Canvas(bm);

        //通过画布的画圆方法将渲染后的图片绘制出来
        canvas.drawCircle(radius, radius, radius, bitmapPaint);
        //返回的就是一个圆形的bitmap对象

        if(borderWidth > 0){
            Paint borderPaint = new Paint();
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setAntiAlias(true);
            borderPaint.setColor(borderColor);
            borderPaint.setStrokeWidth(borderWidth);
            canvas.drawCircle(radius, radius, radius, borderPaint);
        }
        return bm;
    }

//    private static void updateShaderMatrix(Matrix matrix, int width, int height) {
//        float scale;
//        float dx = 0;
//        float dy = 0;
//
//        matrix.set(null);
//
//        if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
//            scale = mDrawableRect.height() / (float) mBitmapHeight;
//            dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f;
//        } else {
//            scale = mDrawableRect.width() / (float) mBitmapWidth;
//            dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f;
//        }
//
//        matrix.setScale(scale, scale);
//        matrix.postTranslate((int) (dx + 0.5f) + mDrawableRect.left, (int) (dy + 0.5f) + mDrawableRect.top);
//
//
//    }
}
