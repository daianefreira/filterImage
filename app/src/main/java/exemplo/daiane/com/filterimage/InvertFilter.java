package exemplo.daiane.com.filterimage;

import android.graphics.Bitmap;
import android.graphics.Color;

public class InvertFilter {
    public static Bitmap invertColor(Bitmap originalBitmap) {
               int width = originalBitmap.getWidth();
        int height = originalBitmap.getHeight();
        Bitmap newBitmap = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
               int colorArray[] = new int[width * height];
        int r, g, b;
        originalBitmap.getPixels(colorArray, 0, width, 0, 0, width, height);
        for (int x = 0; x <height ; x++) {
            for (int y = 0; y < width; y++) {
                r =  255 - Color.red(colorArray[x * width + y]);
                g = 255 - Color.green(colorArray[x * width + y]);
                b = 255 - Color.blue(colorArray[x * width + y]);
                colorArray[x * width + y] = Color.rgb(r, g, b);
                newBitmap.setPixel(y, x, colorArray[x * width + y]);
            }       }
        return newBitmap;   }


}
