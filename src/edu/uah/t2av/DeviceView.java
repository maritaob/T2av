package edu.uah.t2av;

import edu.uah.t2av.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class DeviceView extends Activity implements OnTouchListener {
   private static final String TAG = "Touch" ;
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      ImageView view = (ImageView) findViewById(R.id.imageView);
      view.setOnTouchListener(this);
   }
   
//   @Override
   public boolean onTouch(View v, MotionEvent event) {
	   // Dump touch event to log
	   dumpEvent(event);
	   return true; // indicate event was handled
   }
   
   /** Show an event in the LogCat view, for debugging */
   private void dumpEvent(MotionEvent event) {
      String names[] = { "DOWN" , "UP" , "MOVE" , "CANCEL" , "OUTSIDE" ,
         "POINTER_DOWN" , "POINTER_UP" , "7?" , "8?" , "9?" };
      StringBuilder sb = new StringBuilder();
      int action = event.getAction();
      int actionCode = action & MotionEvent.ACTION_MASK;
      sb.append("event ACTION_" ).append(names[actionCode]);
      if (actionCode == MotionEvent.ACTION_POINTER_DOWN
            || actionCode == MotionEvent.ACTION_POINTER_UP) {
         sb.append("(pid " ).append(
         action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
         sb.append(")" );
      }
      sb.append("[" );
      for (int i = 0; i < event.getPointerCount(); i++) {
         sb.append("#" ).append(i);
         sb.append("(pid " ).append(event.getPointerId(i));
         sb.append(")=" ).append((int) event.getX(i));
         sb.append("," ).append((int) event.getY(i));
         if (i + 1 < event.getPointerCount())
            sb.append(";" );
      }
      sb.append("]" );
      Log.d(TAG, sb.toString());
   }
}