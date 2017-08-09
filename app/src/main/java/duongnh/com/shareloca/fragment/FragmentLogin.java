package duongnh.com.shareloca.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import duongnh.com.shareloca.R;
import duongnh.com.shareloca.activity.ActivityLogin;
import duongnh.com.shareloca.activity.MainActivity;

/**
 * Created by Admin on 8/9/2017.
 */

public class FragmentLogin extends Fragment implements View.OnClickListener {
    private Button btnLogin;
    private ActivityLogin main;
    private TextView tvRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_login, container, false);
        main = (ActivityLogin) getActivity();
        initView(view);
        binData();
        initEvent();
        return view;
    }

    private void initEvent() {
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    private void binData() {

    }

    private void initView(View view) {
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        tvRegister = (TextView) view.findViewById(R.id.tv_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(main, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_register:
                if (main.getFragmentTemp1() != main.getFragmentRegister()) {
                    main.showFragment(main.getFragmentTemp1(), main.getFragmentRegister());
                }
                break;
        }
    }
}
