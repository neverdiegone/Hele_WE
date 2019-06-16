package helen.com.we.intro.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import helen.com.we.R;
import helen.com.we.model.ItemSiderModel;

public class IntroSliderAdapter extends PagerAdapter {

    private List<ItemSiderModel> lisItemSider = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public IntroSliderAdapter(List<ItemSiderModel> lisItemSider, Context context) {
        this.lisItemSider = lisItemSider;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lisItemSider != null ? lisItemSider.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ItemSiderModel itemSiderModel = lisItemSider.get(position);
        View view = layoutInflater.inflate(R.layout.item_slider_signin, container, false);
        TextView tvContent = (TextView) view.findViewById(R.id.item_silder_content);
        TextView tvTitle = (TextView) view.findViewById(R.id.item_silder_title);
        tvContent.setText(itemSiderModel.getContentSider());
        tvTitle.setText(itemSiderModel.getTitleSilder());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
