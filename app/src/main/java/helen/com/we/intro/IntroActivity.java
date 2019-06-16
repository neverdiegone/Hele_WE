package helen.com.we.intro;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import helen.com.we.R;
import helen.com.we.base.BaseActivity;
import helen.com.we.intro.adapter.IntroSliderAdapter;
import helen.com.we.model.ItemSiderModel;
import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends BaseActivity {
    private CircleIndicator indicator;
    private ViewPager viewPager;
    private ItemSiderModel itemSiderModel;
    private IntroSliderAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager = findViewById(R.id.vpgSlider);
        indicator = findViewById(R.id.indicator);
        adapter = new IntroSliderAdapter(initListSlider(), this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

    }

    private List<ItemSiderModel> initListSlider() {
        List<ItemSiderModel> siderModelList = new ArrayList<>();
        itemSiderModel = new ItemSiderModel(R.string.slide_1_title, R.string.slide_1_desc);
        siderModelList.add(itemSiderModel);
        itemSiderModel = new ItemSiderModel(R.string.slide_2_title, R.string.slide_2_desc);
        siderModelList.add(itemSiderModel);
        itemSiderModel = new ItemSiderModel(R.string.slide_3_title, R.string.slide_3_desc);
        siderModelList.add(itemSiderModel);
        return siderModelList;
    }
}
