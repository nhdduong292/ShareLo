package duongnh.com.shareloca.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import duongnh.com.shareloca.R;

/**
 * Created by Admin on 8/9/2017.
 */

public class FragmentRegister extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_register, container, false);
        initView(view);
        binData();
        initEvent();
        return view;
    }

    private void initEvent() {
    }

    private void binData() {

    }

    private void initView(View view) {

    }
}
