package duongnh.com.shareloca.activity;

import android.app.Activity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;


import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import duongnh.com.shareloca.PublicMethob;
import duongnh.com.shareloca.R;
import duongnh.com.shareloca.fragment.FragmentChat;
import duongnh.com.shareloca.fragment.FragmentFriends;
import duongnh.com.shareloca.fragment.FragmentNearby;
import duongnh.com.shareloca.fragment.FragmentSpecial;

public class MainActivity extends Activity implements View.OnClickListener {
    public LinearLayout llPanel2;
    public LinearLayout llMenuBar;
    private LinearLayout llMain;
    private DrawerLayout drawer;
    private LinearLayout llSpecial, llNearby, llFriends, llChat;
    private ImageView ivSpecial, ivNearby, ivFriends, ivChat;
    private TextView tvSpecial, tvNearby, tvFriends, tvChat;
    private ImageView ivMore, ivCancel;
    public  Fragment fragmentTemp = null;
    private FragmentSpecial fragmentSpecial = new FragmentSpecial();
    private FragmentNearby fragmentNearby = new FragmentNearby();
    private FragmentFriends fragmentFriends = new FragmentFriends();
    private FragmentChat fragmentChat = new FragmentChat();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        binData();
        initEven();
        initFragment();
    }

    private void initFragment() {
        fragmentTemp = fragmentSpecial;
       FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.panel, fragmentSpecial);
        transaction.add(R.id.panel, fragmentFriends);
        transaction.add(R.id.panel, fragmentNearby);
        transaction.add(R.id.panel, fragmentChat);
        transaction.hide(fragmentFriends);
        transaction.hide(fragmentNearby);
        transaction.hide(fragmentChat);
        transaction.commit();
    }

    private void initEven() {
        llSpecial.setOnClickListener(this);
        llNearby.setOnClickListener(this);
        llFriends.setOnClickListener(this);
        llChat.setOnClickListener(this);
        ivMore.setOnClickListener(this);
        llMain.setOnClickListener(this);
        drawer.setOnClickListener(this);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        ivCancel.setOnClickListener(this);
    }

    private void binData() {

    }

    private void initUI() {
        llPanel2 = (LinearLayout) findViewById(R.id.panel2);
        llMenuBar = (LinearLayout) findViewById(R.id.ll_menu_bar);
        llSpecial = (LinearLayout) findViewById(R.id.ll_special);
        llNearby = (LinearLayout) findViewById(R.id.ll_nearby);
        llFriends = (LinearLayout) findViewById(R.id.ll_friends);
        llChat = (LinearLayout) findViewById(R.id.ll_chat);
        ivSpecial = (ImageView) findViewById(R.id.iv_special);
        ivNearby = (ImageView) findViewById(R.id.iv_nearby);
        ivFriends = (ImageView) findViewById(R.id.iv_friends);
        ivChat = (ImageView) findViewById(R.id.iv_chat);
        ivMore= (ImageView) findViewById(R.id.iv_more);
        tvSpecial = (TextView) findViewById(R.id.tv_special);
        tvNearby = (TextView) findViewById(R.id.tv_nearby);
        tvFriends = (TextView) findViewById(R.id.tv_friends);
        tvChat = (TextView) findViewById(R.id.tv_chat);
        llMain = (LinearLayout) findViewById(R.id.ll_main);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        ivCancel = (ImageView) findViewById(R.id.iv_cancel);
        onChangeClickMenu(llSpecial);
    }
    public void showFragment(Fragment hide, Fragment show){
       FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(hide);
        transaction.show(show);
        fragmentTemp = show;
        transaction.commit();
        isScreen();
    }
    private void isScreen(){
        if (fragmentTemp == fragmentSpecial){
            onChangeClickMenu(llSpecial);
        }
        if (fragmentTemp == fragmentFriends){
            onChangeClickMenu(llFriends);
        }
        if (fragmentTemp == fragmentNearby){
            onChangeClickMenu(llNearby);
        }
        if(fragmentTemp == fragmentChat){
            onChangeClickMenu(llChat);
        }
    }
    public void addFragment(int panel, Fragment fragment){
       FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(panel, fragment);

        transaction.commit();
    }
    private void onChangeClickMenu(LinearLayout ll) {
        ivSpecial.setImageResource(R.mipmap.ic_special_gray);
        ivNearby.setImageResource(R.mipmap.ic_nearby_gray);
        ivFriends.setImageResource(R.mipmap.ic_people_gray);
        ivChat.setImageResource(R.mipmap.ic_chat);
        tvSpecial.setTextColor(getResources().getColor(R.color.colorGray));
        tvNearby.setTextColor(getResources().getColor(R.color.colorGray));
        tvFriends.setTextColor(getResources().getColor(R.color.colorGray));
        tvChat.setTextColor(getResources().getColor(R.color.colorGray));
        PublicMethob.anamationAlphaDark(this, ll);
        switch (ll.getId()){
            case R.id.ll_special:
                ivSpecial.setImageResource(R.mipmap.ic_special_green);
                tvSpecial.setTextColor(getResources().getColor(R.color.colorGreenText));
                break;
            case R.id.ll_nearby:
                ivNearby.setImageResource(R.mipmap.ic_nearby_green);
                tvNearby.setTextColor(getResources().getColor(R.color.colorGreenText));
                break;
            case R.id.ll_friends:
                ivFriends.setImageResource(R.mipmap.ic_people_green);
                tvFriends.setTextColor(getResources().getColor(R.color.colorGreenText));
                break;
            case R.id.ll_chat:
                ivChat.setImageResource(R.mipmap.ic_chat_green);
                tvChat.setTextColor(getResources().getColor(R.color.colorGreenText));
                break;
            default:
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_special:
                if (fragmentTemp != fragmentSpecial){
                    showFragment(fragmentTemp, fragmentSpecial);
                }
                break;
            case R.id.ll_nearby:
                if (fragmentTemp != fragmentNearby){
                    showFragment(fragmentTemp, fragmentNearby);
                }
                break;
            case R.id.ll_friends:
                if (fragmentTemp != fragmentFriends){
                    showFragment(fragmentTemp, fragmentFriends);
                }
                break;
            case R.id.ll_chat:
                if (fragmentTemp != fragmentChat){
                    showFragment(fragmentTemp, fragmentChat);
                }
                break;
            case R.id.iv_more:
                PublicMethob.animationShowLeft(this, llPanel2);
                drawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_cancel:
                drawer.closeDrawers();
                break;
            default:
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public Fragment getFragmentTemp() {
        return fragmentTemp;
    }

    public FragmentSpecial getFragmentSpecial() {
        return fragmentSpecial;
    }

    public FragmentNearby getFragmentNearby() {
        return fragmentNearby;
    }

    public FragmentFriends getFragmentFriends() {
        return fragmentFriends;
    }

    public FragmentChat getFragmentChat() {
        return fragmentChat;
    }


}
