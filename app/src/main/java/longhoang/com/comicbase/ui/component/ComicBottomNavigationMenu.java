package longhoang.com.comicbase.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import longhoang.com.comicbase.R;

public class ComicBottomNavigationMenu extends BottomNavigationView {
    private BottomNavigationMenuListener bottomNavigationMenuListener;
    private boolean isDispatchEvent = true;

    public void setBottomNavigationMenuListener(
        BottomNavigationMenuListener bottomNavigationMenuListener) {
        this.bottomNavigationMenuListener = bottomNavigationMenuListener;
    }

    public ComicBottomNavigationMenu(Context context) {
        super(context);
        setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public ComicBottomNavigationMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public ComicBottomNavigationMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void initBottomNavigationBadger(Context context) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) this.getChildAt(0);
        BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(1);
        View notificationBadge =
            LayoutInflater.from(context).inflate(R.layout.notification_badger, menuView, false);
        itemView.addView(notificationBadge);
    }

    private OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = item -> {
        if(isDispatchEvent)
            bottomNavigationMenuListener.changeItemSelect(item.getItemId());
        isDispatchEvent = true;
        return true;
    };

    public interface BottomNavigationMenuListener {
        void changeItemSelect(int itemId);
    }
    public void setHighLight(int id){
        isDispatchEvent = false;
        setSelectedItemId(id);
    }
}
