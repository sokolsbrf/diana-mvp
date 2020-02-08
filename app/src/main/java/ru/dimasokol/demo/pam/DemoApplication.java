package ru.dimasokol.demo.pam;

import android.app.Application;

import ru.dimasokol.demo.pam.model.DatabaseImpl;
import ru.dimasokol.demo.pam.model.DemoModelImpl;
import ru.dimasokol.demo.pam.presentation.DemoPresenter;
import ru.dimasokol.demo.pam.presentation.PresentersHolder;
import ru.dimasokol.demo.pam.utils.RealRunner;

public class DemoApplication extends Application implements PresentersHolder {

    private DemoPresenter mDemoPresenter;
    private RealRunner mRunner;

    @Override
    public void onCreate() {
        super.onCreate();
        mRunner = new RealRunner();
        mDemoPresenter = new DemoPresenter(new DemoModelImpl(new DatabaseImpl()), mRunner);
    }

    @Override
    public DemoPresenter getDemoPresenter() {
        return mDemoPresenter;
    }
}
