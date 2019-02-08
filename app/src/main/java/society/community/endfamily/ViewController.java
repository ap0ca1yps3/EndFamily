package society.community.endfamily;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import java.util.Objects;

class ViewController implements IFragmentUIController {
    static ViewController viewController = new ViewController();
    @SuppressLint("NewApi")
    static Drawable GetDrawable(int ID, Activity activity) {
        return activity.getDrawable(ID);
    }

    @Override
    public void AddView(Activity activity, ViewGroup _viewGroup, ValueController _valueController) {

        ViewGroup viewGroup = _viewGroup;
        @SuppressLint({"NewApi", "LocalSuppress"}) ResourcesView resourcesView = new ResourcesView((Context) activity,_valueController);
        resourcesView.setMaxCardElevation(20.0f);
        viewGroup.addView(resourcesView);

    }
}
