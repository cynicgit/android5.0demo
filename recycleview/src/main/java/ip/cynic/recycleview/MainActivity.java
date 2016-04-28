package ip.cynic.recycleview;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] mListIcons = new int[]{R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4,
            R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g8, R.mipmap.g9, R.mipmap.g10, R
            .mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap
            .g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R
            .mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap
            .g27, R.mipmap.g28, R.mipmap.g29};

    private int[] mStraggeredIcons = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R
            .mipmap.p4, R.mipmap.p5, R.mipmap.p6, R.mipmap.p7, R.mipmap.p8, R.mipmap.p9, R
            .mipmap.p10, R.mipmap.p11, R.mipmap.p12, R.mipmap.p13, R.mipmap.p14, R.mipmap
            .p15, R.mipmap.p16, R.mipmap.p17, R.mipmap.p18, R.mipmap.p19, R.mipmap.p20, R
            .mipmap.p21, R.mipmap.p22, R.mipmap.p23, R.mipmap.p24, R.mipmap.p25, R.mipmap
            .p26, R.mipmap.p27, R.mipmap.p28, R.mipmap.p29, R.mipmap.p30, R.mipmap.p31, R
            .mipmap.p32, R.mipmap.p33, R.mipmap.p34, R.mipmap.p35, R.mipmap.p36, R.mipmap
            .p37, R.mipmap.p38, R.mipmap.p39, R.mipmap.p40, R.mipmap.p41, R.mipmap.p42, R
            .mipmap.p43, R.mipmap.p44};


    private List<DataBean> datas = new ArrayList<DataBean>();
    private List<DataBean> mStraggeredDatas = new ArrayList<DataBean>();

    private RecyclerView mRecycleView;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swip_refresh);
        initData();

        initRecycleListV();

        initListener();
    }


    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                                mRecycleView.getAdapter().notifyDataSetChanged();
                            }
                        });
                    }
                }.start();
            }
        });
    }

    //listview 垂直显示
    private void initRecycleListV() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecycleView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(getBaseContext(), datas);
        mRecycleView.setAdapter(adapter);
    }
    //listview 水平显示
    private void initRecycleListH() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecycleView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(getBaseContext(), datas);
        mRecycleView.setAdapter(adapter);
    }
    //gridview 垂直显示
    private void initRecycleGridV() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 2);
        mRecycleView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(getBaseContext(), datas);
        mRecycleView.setAdapter(adapter);
    }
    //gridview 水平显示
    private void initRecycleGridH() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 2,
                LinearLayoutManager.HORIZONTAL, false);
        mRecycleView.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter(getBaseContext(), datas);
        mRecycleView.setAdapter(adapter);
    }

    //瀑布流 垂直显示
    private void initRecycleStraggeredV() {
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(layoutManager);
        StraggeredAdapter adapter = new StraggeredAdapter(getBaseContext(), mStraggeredDatas);
        mRecycleView.setAdapter(adapter);
    }
    //瀑布流 水平显示
    private void initRecycleStraggeredH() {
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(layoutManager);
        StraggeredAdapter adapter = new StraggeredAdapter(getBaseContext(), mStraggeredDatas);
        mRecycleView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < mListIcons.length; i++) {
            datas.add(new DataBean(mListIcons[i], "我是item" + i));
        }

        for (int i = 0; i < mStraggeredIcons.length; i++) {
            mStraggeredDatas.add(new DataBean(mStraggeredIcons[i], "我是item" + i));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_list_v:
                initRecycleListV();
                break;
            case R.id.menu_list_h:
                initRecycleListH();
                break;
            case R.id.menu_grid_v:
                initRecycleGridV();
                break;
            case R.id.menu_grid_h:
                initRecycleGridH();
                break;
            case R.id.menu_straggered_v:
                initRecycleStraggeredV();
                break;
            case R.id.menu_straggered_h:
                initRecycleStraggeredH();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
