package xyz.lurkin.startgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lur on 11-04-16.
 */
public class GameView extends View {

    private Paint mPaint;
    private Ball mBall;
    private final Bitmap test = BitmapFactory.decodeResource(getResources(),R.mipmap.bomb);

    public GameView(Context context, AttributeSet aSet) {
        super(context, aSet);

        mPaint = new Paint();
        mBall = new Ball(60, 60, 50, 50, 20);
    }

    public void next() {
        if(mBall.x+mBall.radius > getWidth() || mBall.x-mBall.radius < 0)
            mBall.verticalHit();
        if(mBall.y+mBall.radius > getHeight() || mBall.y-mBall.radius < 0)
            mBall.horizontalHit();
        mBall.next();
        invalidate();
    }

    @Override
    synchronized public void onDraw(Canvas canvas) {
        canvas.drawBitmap(test,mBall.x,mBall.y,mPaint);
    }

}
