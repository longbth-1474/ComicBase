package longhoang.com.comicbase.ui.search;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.com.comicbase.data.model.api.Comic;
import longhoang.com.comicbase.data.model.db.HistorySearch;
import longhoang.com.comicbase.databinding.FragmentSearchBinding;
import longhoang.com.comicbase.ui.comic.ComicFragment;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> implements
    TextWatcher, SearchListener {
    private static final int WAITING_TIME = 1000;
    private String mSearchKey;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewDataBinding().editSearchComic.addTextChangedListener(this);
        initRecyclerSearch();
        initRecyclerHistory();
        getViewModel().updateHistory.observe(this, updateHistory -> {
            if (updateHistory) {
                getViewModel().fetchHistory();
            }
        });
    }

    private void initRecyclerHistory() {
        SingleTypeAdapter<HistorySearch> adapter =
            new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_history_search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        getViewDataBinding().recyclerHistorySearch
            .setLayoutManager(linearLayoutManager);
        getViewDataBinding().recyclerHistorySearch.setAdapter(adapter);
        adapter.setPresenter(this);
        getViewModel().mHistoryLiveData.observe(this,
            historySearches -> adapter.set(getViewModel().mHistoryLiveData.getValue()));
        getViewModel().fetchHistory();
    }

    private void initRecyclerSearch() {
        SingleTypeAdapter<Comic> adapter =
            new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_search);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseActivity(), 3);
        getViewDataBinding().recyclerResultSearch
            .setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerResultSearch.setAdapter(adapter);
        adapter.setPresenter(this);
        getViewModel().mComicLiveData.observe(this, comics
            -> adapter.set(getViewModel().mComicLiveData.getValue()));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        mSearchKey = editable.toString().trim();
        if (!mSearchKey.isEmpty()) {
            getViewModel().showHistory.postValue(false);
            mCountDownTimer.start();
        } else {
            getViewModel().showHistory.postValue(true);
        }
    }

    private CountDownTimer mCountDownTimer = new CountDownTimer(WAITING_TIME, WAITING_TIME) {
        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
            hideKeyboard();
            loadDataSearch();
        }
    };

    private void loadDataSearch() {
        getViewModel().addSearch(mSearchKey);
        getViewModel().fetchDataSearch(mSearchKey);
    }

    @Override
    public void onClickItemSearch(Comic comic) {
        addFragment(ComicFragment.newInstance(comic),
            getViewDataBinding().constraintLayout.getId());
    }

    @Override
    public void onClickItemHistory(HistorySearch historySearch) {
        getViewDataBinding().editSearchComic.setText(historySearch.getKeySearch());
    }
}
