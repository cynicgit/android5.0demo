package ip.cynic.recycleview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cynic on 2016/4/27.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {


    private Context context;
    private List<DataBean> datas;

    public ListAdapter(Context context, List<DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_list, null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.refreshDataUI(datas.get(position));
    }

    @Override
    public int getItemCount() {
        if (datas != null) {
            return datas.size();
        }
        return 0;
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv;

        public ListHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.item_list_iv);
            tv = (TextView) itemView.findViewById(R.id.item_list_tv);
        }

        public void refreshDataUI(DataBean dataBean) {
            iv.setImageResource(dataBean.iconRes);
            tv.setText(dataBean.des);
        }
    }

}



