package com.ym.quickrun;

import android.app.Application;

import com.ym.quickrun.di.component.ApiComponent;
import com.ym.quickrun.di.component.DaggerApiComponent;
import com.ym.quickrun.di.module.ApiModule;
import com.ym.quickrun.utils.AppUtils;
import com.ym.quickrun.utils.LogUtils;
import com.ym.quickrun.utils.NetworkUtils;

/**
 * ┏┓   ┏┓
 * ┏┛┻━━━┛┻┓
 * ┃       ┃
 * ┃   ━   ┃
 * ┃ ┳┛ ┗┳ ┃
 * ┃       ┃
 * ┃   ┻   ┃
 * ┃       ┃
 * ┗━┓   ┏━┛
 * ┃   ┃  神兽保佑
 * ┃   ┃  永无BUG！
 * ┃   ┗━━━┓
 * ┃       ┣┓
 * ┃       ┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫ ┃┫┫
 * ┗┻┛ ┗┻┛
 *
 * @author: ym
 * date: 2018/9/10
 * desc: APP启动页面
 */
public class QuickRunApplication extends Application {
    private static QuickRunApplication mContext;
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initLogic();
        mContext = this;
        initComponent();

    }

    /**
     * 初始化网络组件
     */
    private void initComponent() {
        mApiComponent = DaggerApiComponent.builder()
                .apiMoudle(new ApiModule())
                .build();
    }

    /**
     * 初始化工具类
     */
    private void initLogic() {
        //App工具类
        AppUtils.init(this);
        //Log工具类
        LogUtils.init(this);
        //网络工具类
        NetworkUtils.startNetService(this);
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    /**
     * 获取Application
     */
    public static QuickRunApplication getInstance() {
        return mContext;
    }


    /**
     * 初始化崩溃日志
     */
    private void initCrashHandler() {

    }

}