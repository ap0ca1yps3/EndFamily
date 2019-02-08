package society.community.endfamily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResourcesView extends CardView {
    private ImageView contentImage;
    private TextView title;
    private TextView summary;
    public String titleString;
    public String summaryString;
    public Drawable imageDrawable;
    private ValueController valueController;

    public ResourcesView(@NonNull Context context, ValueController _valueController) {
        super(context);
        valueController = _valueController;
        titleString = valueController.titleString;//Values [0] is the title string;
        summaryString = valueController.summaryString;//Values [1] is the summary string;
        imageDrawable = valueController.imageDrawable;
        InitView(context);
    }

    public ResourcesView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        InitView(context);
        @SuppressLint({"Recycle", "CustomViewStyleable"}) TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ResourcesViewAttr);
        String titleString = typedArray.getString(R.styleable.ResourcesViewAttr_title);
        String summaryString = typedArray.getString(R.styleable.ResourcesViewAttr_summary);
        Drawable imageSrc = typedArray.getDrawable(R.styleable.ResourcesViewAttr_contentImage);
        title.setText(titleString);
        summary.setText(summaryString);
        contentImage.setImageDrawable(imageSrc);
    }

    private void InitView(Context context) {
        View.inflate(context, R.layout.layout_resourcesview, this);
        contentImage = findViewById(R.id.resources_view_content);
        title = findViewById(R.id.resources_view_title);
        summary = findViewById(R.id.resources_view_summary);
        contentImage.setImageDrawable(imageDrawable);
        title.setText(titleString);
        summary.setText(summaryString);
    }
}