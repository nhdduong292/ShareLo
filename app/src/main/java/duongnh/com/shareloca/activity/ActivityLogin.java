package duongnh.com.shareloca.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import duongnh.com.shareloca.R;
import duongnh.com.shareloca.fragment.FragmentLogin;
import duongnh.com.shareloca.fragment.FragmentRegister;

/**
 * Created by Admin on 8/9/2017.
 */

public class ActivityLogin extends Activity {

    public Fragment fragmentTemp1 = null;
    private FragmentLogin fragmentLogin = new FragmentLogin();
    private FragmentRegister fragmentRegister = new FragmentRegister();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        initView();
        binData();
        initEvent();
        initFragment();
    }
    private void initFragment() {
        fragmentTemp1 = fragmentLogin;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.panel, fragmentLogin);
        transaction.add(R.id.panel, fragmentRegister);
        transaction.hide(fragmentRegister);
        transaction.commit();
    }
    public void showFragment(Fragment hide, Fragment show){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(hide);
        transaction.show(show);
        fragmentTemp1 = show;
        transaction.commit();

    }
    private void initEvent() {

    }

    private void binData() {

    }

    private void initView() {

    }

    public Fragment getFragmentTemp1() {
        return fragmentTemp1;
    }

    public FragmentLogin getFragmentLogin() {
        return fragmentLogin;
    }

    public FragmentRegister getFragmentRegister() {
        return fragmentRegister;
    }
}
