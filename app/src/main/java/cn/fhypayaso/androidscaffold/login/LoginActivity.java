package cn.fhypayaso.androidscaffold.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cn.fhypayaso.androidscaffold.MainActivity;
import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.activity.BasePresenterActivity;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/14 16:31.
 * email fanhongyu@hrsoft.net.
 */

public class LoginActivity extends BasePresenterActivity<LoginContract.Presenter> implements LoginContract.View {


    EditText editUserName;
    EditText editPassword;


    @Override
    public void showError(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void onLoginSuccess() {

        dismissProgressDialog();
        ToastUtil.showToast("登录成功");
        startActivity(MainActivity.class);
    }

    @Override
    protected LoginContract.Presenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        editUserName = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void initView() {

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(editUserName.getText().toString(), editPassword.getText().toString());
                showProgressDialog();
            }
        });
    }
}
