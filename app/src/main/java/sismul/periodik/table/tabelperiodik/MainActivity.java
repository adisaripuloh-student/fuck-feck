package sismul.periodik.table.tabelperiodik;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import sismul.periodik.table.tabelperiodik.Fragment.FragmentCari;
import sismul.periodik.table.tabelperiodik.Fragment.FragmentGolongan;
import sismul.periodik.table.tabelperiodik.Fragment.FragmentPeriode;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mActionBarToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switchToFragmentCari();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_golongan:
                    switchToFragmentGolongan();
                    return true;
                case R.id.navigation_cari:
                    switchToFragmentCari();
                    return true;
                case R.id.navigation_periode:
                    switchToFragmentPeriode();
                    return true;
            }
            return false;
        }
    };

    public void switchToFragmentGolongan() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_container, new FragmentGolongan()).commit();
    }

    public void switchToFragmentPeriode() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_container, new FragmentPeriode()).commit();
    }

    public void switchToFragmentCari() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_container, new FragmentCari()).commit();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
