package com.grayhatcorp.invetsa.invetsa;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class Touch extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout layout1;
    Button borrar;
    Vista fondo;
    Path path=new Path();

    int x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        borrar=(Button)findViewById(R.id.borrar);

       layout1 = (RelativeLayout) findViewById(R.id.layout1);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);


        borrar.setOnClickListener(this);

        path=new Path();
        fondo = new Vista(this,path);
        layout1.addView(fondo);



        layout1.setOnTouchListener( new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.borrar)
        {
            path=new Path();
            fondo = new Vista(this,path);
            layout1.addView(fondo);
        }
    }


    class Vista extends View{
        float x;
        float y;
        String accion="accion";
        Path path;
        public  Vista(Context context,Path path)
        {
            super(context);
           this.path=path;
        }
        public  void onDraw(Canvas canvas)
        {
            Paint paint=new Paint();
            paint = new Paint(Paint.DITHER_FLAG);
            paint.setAntiAlias(true);
            paint.setColor(Color.parseColor("#5D4037"));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(3);
            setWillNotDraw(false);
            /*
            Paint paint=new Paint();
           paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.BLUE);
*/
            if(accion=="down")
            {
             path.moveTo(x,y);
            }
            if(accion=="move")
            {
                path.lineTo(x,y);
            }
            if(accion=="accion")
            {
                Paint pa=new Paint();
                pa = new Paint(Paint.DITHER_FLAG);
                pa.setAntiAlias(true);
                pa.setColor(Color.parseColor("#777777"));
                pa.setStyle(Paint.Style.FILL);
                pa.setStrokeJoin(Paint.Join.ROUND);
                pa.setStrokeWidth(4);
                setWillNotDraw(false);
                canvas.drawPath(path, pa);

            }else {
                canvas.drawPath(path, paint);
            }
        }

        public boolean onTouchEvent(MotionEvent e)
        {
            x=e.getX();
            y=e.getY();
            if(e.getAction()==MotionEvent.ACTION_DOWN)
            {
                accion="down";
            }
            if(e.getAction()==MotionEvent.ACTION_MOVE)
            {
                accion="move";
            }
            invalidate();
            return true;
        }
    }
}
