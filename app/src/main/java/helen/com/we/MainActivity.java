package helen.com.we;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

import helen.com.we.adapter.ViewPagerAdapter;
import helen.com.we.base.BaseActivity;
import helen.com.we.fragment.profile.AccountFragment;
import helen.com.we.fragment.booking.HomeFragment;
import helen.com.we.fragment.booklistall.ListAllFragment;
import helen.com.we.fragment.notification.NotificationFragment;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tabOne;
    private TextView tabTwo;
    private TextView tabThree;
    private TextView tabTrue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Đăng ký");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_note_black, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Lịch học");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_list_black, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Thông báo");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_notification_black, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);


     /*   View tabView = getTabView(R.drawable.tab_home_selectoter);;
        tabLayout.addTab(tabLayout.newTab().setText("Danh Sách").setCustomView(tabView));*/

        tabTrue = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTrue.setText("Tài khoản");
        tabTrue.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_username_tab_black, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabTrue);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "ONE");
        adapter.addFrag(new ListAllFragment(), "TWO");
        adapter.addFrag(new NotificationFragment(), "THREE");
        adapter.addFrag(new AccountFragment(), "True");
        viewPager.setAdapter(adapter);
    }

    private View getTabView(int imgDrawable) {
        View view = getLayoutInflater().inflate(R.layout.custom_tab_image, null);
        ImageView imgTab = (ImageView) view.findViewById(R.id.imgTab);
        imgTab.setImageDrawable(getResources().getDrawable(imgDrawable));
        return view;
    }

}
