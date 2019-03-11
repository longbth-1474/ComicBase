package longhoang.com.comicbase.ui.home;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.com.comicbase.data.model.api.home.NewUpdate;
import longhoang.com.comicbase.data.model.api.home.Proposal;
import longhoang.com.comicbase.databinding.FragmentHomeBinding;


public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel>
        implements HomeNavigator {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewModel().fetchHome();
        getViewModel().setHomeNavigator(this);
        initRecyclerNewUpdate();
        initRecyclerTopRead();
    }

    private void initRecyclerTopRead() {
        SingleTypeAdapter<Proposal> adapter =
                new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_top_read);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseActivity(), 4);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        getViewDataBinding().recyclerTopRead.setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerTopRead.setAdapter(adapter);
//        adapter.setPresenter(this);
        getViewModel().mProposalLiveData.observe(this, proposals
                -> adapter.set(getViewModel().mProposalLiveData.getValue()));
    }

    private void initRecyclerNewUpdate() {
        SingleTypeAdapter<NewUpdate> adapter =
                new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_new_update);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseActivity(), 3);
        getViewDataBinding().recyclerNewUpdate
                .setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerNewUpdate.setAdapter(adapter);
//        adapter.setPresenter(this);
        getViewModel().mNewUpdateLiveData.observe(this, newUpdates
                -> adapter.set(getViewModel().mNewUpdateLiveData.getValue()));
    }

    @Override
    public void showMoreTopRead() {

    }

    @Override
    public void showMoreNewUpdate() {

    }

    @Override
    public void clickSearch() {

    }
}
