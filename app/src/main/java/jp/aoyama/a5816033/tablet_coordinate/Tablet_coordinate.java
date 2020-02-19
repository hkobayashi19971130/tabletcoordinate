package jp.aoyama.a5816033.tablet_coordinate;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Tablet_coordinate extends Activity {

    private static final String TAG = "Tablet_coordinate";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tablet_coordinate);
        setContentView(new SurfaceTestView(this));
        //setContentView(new CanvasBasicView(this));
    }

    /*public boolean onTouchEvent(MotionEvent event) {
        //X軸の取得
        float coordinate_x = event.getX();
        //Y軸の取得
        float coordinate_y = event.getY();
        //取得した内容をログに表示
        Log.d("TouchEvent","X:" + coordinate_x + ",Y:" + coordinate_y);
        return true;
    }*/

    /*public class Draw extends View {
        public Draw(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.argb(255, 255, 255, 255));

            @SuppressLint("DrawAllocation") Rect rect = new Rect(10, 20, 30, 40);
            canvas.drawRect(rect, paint);

            RectF rectF = new RectF(40.5f, 20.5f, 60.5f, 40.5f);
            canvas.drawRect(rectF, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(12);
            canvas.drawRect(10, 50, 30, 80, paint);
        }
    }*/


//  public class CanvasBasicView extends View {
//        private  Paint mPaint = new Paint();
//
//        public CanvasBasicView(Context context) {
//            super(context);
//        }
//
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            for(int i=0;i<x_history.size();i++) {
//                canvas.drawCircle(x_history.get(i),y_history.get(i),10,mPaint);
//            }
//        }
//    }
}