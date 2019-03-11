package longhoang.com.comicbase.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragmentActivity;
import longhoang.com.comicbase.databinding.ActivityMainBinding;
import longhoang.com.comicbase.ui.category.CategoryFragment;
import longhoang.com.comicbase.ui.home.HomeFragment;
import longhoang.com.comicbase.ui.user.UserFragment;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding,MainViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void changeFragment(Fragment fragment) {
        super.changeFragment(R.id.frame_layout, fragment);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigationScreen();
        getViewDataBinding().navigation.initBottomNavigationBadger(this);
        changeFragment(HomeFragment.newInstance());
        getViewDataBinding().navigation.setBottom(0);
    }

    private void navigationScreen() {
        getViewDataBinding().navigation.setBottomNavigationMenuListener(
                itemId -> {
                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
                    if (!(fragment instanceof HomeFragment || fragment instanceof CategoryFragment ||
                            fragment instanceof UserFragment)) {
                        getSupportFragmentManager().popBackStackImmediate();
                    }
                    switch (itemId) {
                        case R.id.home:
                            changeFragment(HomeFragment.newInstance());
                            break;
                        case R.id.category:
                            changeFragment(CategoryFragment.newInstance());
                            break;
                        case R.id.user:
                            changeFragment(UserFragment.newInstance());
                            break;
                    }
                });
    }

    @Override
    public void onBack() {
        super.onBack();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        Fragment currentFragment = mFragmentManager.getPrimaryNavigationFragment();
        if (currentFragment instanceof HomeFragment) {
            getViewDataBinding().navigation.setHighLight(R.id.home);
        } else if (currentFragment instanceof CategoryFragment) {
            getViewDataBinding().navigation.setHighLight(R.id.category);
        } else if (currentFragment instanceof UserFragment) {
            getViewDataBinding().navigation.setHighLight(R.id.user);
        }
    }

    public static Intent intentMainActivity(Activity activity) {
        return new Intent(activity, MainActivity.class);
    }
}
