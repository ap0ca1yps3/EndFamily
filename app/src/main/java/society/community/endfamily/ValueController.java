package society.community.endfamily;

import android.graphics.drawable.Drawable;

public class ValueController {
    public ValueController(Drawable _imageDrawable, String _titleString, String _summaryString) {
        imageDrawable = _imageDrawable;
        titleString = _titleString;
        summaryString = _summaryString;
    }

    public Drawable imageDrawable;
    public String titleString;
    public String summaryString;
}
