package society.community.endfamily;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Objects;

public class ResourcesFragment extends Fragment {
    Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = this.getActivity();
        return inflater.inflate(R.layout.fragment_resources, container, false);
    }

    @SuppressLint("NewApi")
    @Override
    public void onStart() {
        super.onStart();
        LinearLayout linearLayout = activity.findViewById(R.id.resources_linearLayout);
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
        ViewController.viewController.AddView(activity, linearLayout, new ValueController(ViewController.GetDrawable(R.drawable.ic_launcher_background, getActivity()), "TO", "aw"));
    }
}
