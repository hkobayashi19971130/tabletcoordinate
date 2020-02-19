package jp.aoyama.a5816033.tablet_coordinate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;

class SurfaceTestView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    int x = 100;
    int y = 100;
    int flag=0;
    private ArrayList<Integer> x_history = new ArrayList<Integer>();
    private ArrayList<Integer> y_history = new ArrayList<Integer>();
    //private ArrayList<Integer> touch_time = new ArrayList<>();
    private Thread thread;
    private SurfaceHolder holder;
    private static final String TAG = "SurfaceTestView";

    public SurfaceTestView(Context context) {
        super(context);
        // コールバックの設定
        getHolder().addCallback(this);
    }


    // Surface が作成されたとき(実装必須)
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder=holder;
        thread=new Thread(this);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(thread!=null){
            thread.start();
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread=null;

    }

    public boolean onTouchEvent(MotionEvent ev) {
        int x2, y2;
        int check = 0;
        int _x = 1, _y = 1;
        boolean loop = true;
        int count = ev.getPointerCount();
        if(count == 1) {
            flag = 1;
        }
        else {
            flag = 0;
        }
        //touch_time.add((int) System.currentTimeMillis());
        for(int i=0;i<count;i++) {
            x = (int) ev.getX(i);
            y = (int) ev.getY(i);
            if((x < 500 || x > 1400) || (y <310 || y > 600)) {
                x_history.add(x);
                y_history.add(y);
            }
        }
        //for(int j=0;j<5;j++) {
        Log.v(TAG, "x : " + String.valueOf(x_history));
        Log.v(TAG, "y : " + String.valueOf(y_history));
        //}
        return true;
    }

    // 描画処理
    public void draw() {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            int size=x_history.size();
            for(int i=0;i<size;i++) {
                // 円を描画
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(Color.BLACK);
                canvas.drawCircle(x_history.get(i).intValue(), y_history.get(i).intValue(), 10.0f, paint);
                //線
                //この部分を入れるとマルチタップに対応しなくなる
                /*if(flag == 1) {
                    if(i != 0) {
                        if(touch_time.get(i) - touch_time.get(i-1) < 500) {
                            canvas.drawLine(x_history.get(i-1),y_history.get(i-1),x_history.get(i),y_history.get(i),paint);
                        }
                    }
                }*/
                // テキストを描画
                paint.setTextSize(20);
                paint.setColor(Color.BLACK);
                canvas.drawText("x=" + x + " y=" + y, x, y + 15, paint);
            }
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while(thread!=null){
            draw();

        }
    }

//    public void saveFile(String file, String str) {
//        try (FileOutputStream fileOutputstream = openFileOutput(file,Context.MODE_PRIVATE);) {
//            fileOutputstream.write(str.getBytes());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}