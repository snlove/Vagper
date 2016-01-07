package com.aacer.vagper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

/**ViewPager 类，处理滑动时背景图片的处理
 * Created by acer on 2016/1/5.
 */
public class StartViewPager extends ViewPager {

    private Bitmap bg;
    private Paint paint = new Paint(1);

    public StartViewPager(Context context) {
        super(context);
    }

    public StartViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if(bg != null) {
            int width = this.bg.getWidth();
            int height = this.bg.getHeight();
            int count = getAdapter().getCount();
            int x = getScrollX();
            // 子View中背景图片需要显示的宽度，放大背景图或缩小背景图。
            int n = height * getWidth() / getHeight();
            int w = x * ((width - n) / (count - 1)) / getWidth();
            canvas.drawBitmap(this.bg, new Rect(w, 0, n + w, height), new Rect( x, 0, x + getWidth(), getHeight()), this.paint);
            Log.i("Back","data ：" + w + "   " + (n+w));
        }
        super.dispatchDraw(canvas);

    }

    public void setBack(Bitmap paraBitmap) {
        this.bg = paraBitmap;
        this.paint.setFilterBitmap(true);
    }
}
