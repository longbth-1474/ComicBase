package longhoang.com.comicbase.ui.user;


import android.os.Bundle;

import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.databinding.FragmentUserBinding;

public class UserFragment extends BaseFragment<FragmentUserBinding, UserViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    public static UserFragment newInstance() {

        Bundle args = new Bundle();

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
