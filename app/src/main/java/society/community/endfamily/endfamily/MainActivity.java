package society.community.endfamily.endfamily;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends FragmentActivity {
    private FragmentController rescourcesFragment = new FragmentController();
    private FragmentController gameToolFragment = new FragmentController();
    private FragmentController meController = new FragmentController();
    private android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_resources:
                    return true;
                case R.id.navigation_gameTool:
                    return true;
                case R.id.navigation_me:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        rescourcesFragment.fragmentID(R.layout.activity_resources);
        gameToolFragment.fragmentID(R.layout.activity_gametool);
        meController.fragmentID(R.layout.activity_me);
        fragmentTransaction.add(0,new Fragment());
    }

}
