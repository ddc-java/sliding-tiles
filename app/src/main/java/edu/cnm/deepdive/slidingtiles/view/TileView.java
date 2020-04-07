package edu.cnm.deepdive.slidingtiles.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import edu.cnm.deepdive.slidingtiles.R;

public class TileView extends AppCompatImageView {

  private Paint paint;

  public TileView(Context context) {
    super(context);
    setWillNotDraw(false);
    setupPaint();
  }

  public TileView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setWillNotDraw(false);
    setupPaint();
  }

  public TileView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setWillNotDraw(false);
    setupPaint();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawRect(0, 0, getRight(), getBottom(), paint);
  }

  private void setupPaint() {
    paint = new Paint();
    paint.setColor(ContextCompat.getColor(getContext(), R.color.puzzleBackground));
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.cell_spacing));
  }

}
