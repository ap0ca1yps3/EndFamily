package society.community.endfamily;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.Objects;


public class MainActivity extends AppCompatActivity{
    private BottomNavigationView mainNavigationView;
    private ResourcesFragment resourcesFragment;
    private GameToolFragment gameToolFragment;
    private MeFragment meFragment;

    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainNavigationView = findViewById(R.id.mainBottomNavigation);
        resourcesFragment = new ResourcesFragment();
        gameToolFragment = new GameToolFragment();
        meFragment = new MeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout,resourcesFragment).commit();
        mainNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_resources: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout, resourcesFragment).commit();
                        return true;
                    }
                    case R.id.nav_menu_gametool: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout, gameToolFragment).commit();
                        return true;
                    }
                    case R.id.nav_menu_me: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout, meFragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }


}
