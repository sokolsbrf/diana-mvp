package ru.dimasokol.demo.pam.presentation;

import ru.dimasokol.demo.pam.model.DemoModel;
import ru.dimasokol.demo.pam.utils.Runner;

public class DemoPresenter {

    private DemoView mView;

    private final DemoModel mModel;
    private final Runner mRunner;

    private int mLastCount;

    public DemoPresenter(DemoModel model, Runner runner) {
        mModel = model;
        mLastCount = model.getCurrent();
        mRunner = runner;
    }

    public void attachView(DemoView view) {
        mView = view;
        notifyView();
    }

    public void detachView() {
        mView = null;
    }

    public void increment() {
        mRunner.runInBackground(() -> {
            mLastCount = mModel.increment();
            mRunner.runOnMain(DemoPresenter.this::notifyView);
        });
    }

    private void notifyView() {
        if (mView != null) {
            mView.showCount(mLastCount);
        }
    }
}
