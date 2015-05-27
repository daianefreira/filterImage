package exemplo.daiane.com.filterimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

public class BlackWriteFilter {
        public static Bitmap convertColorIntoBlackAndWhiteImage(Bitmap originalBitmap) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0);

            ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(
                    colorMatrix);

            Bitmap blackAndWhiteBitmap = originalBitmap.copy(
                    Bitmap.Config.ARGB_8888, true);

            Paint paint = new Paint();
            paint.setColorFilter(colorMatrixFilter);


            Canvas canvas = new Canvas(blackAndWhiteBitmap);
            canvas.drawBitmap(blackAndWhiteBitmap, 0, 0, paint);

            return blackAndWhiteBitmap;
        }
    }


