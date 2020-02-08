package ru.dimasokol.demo.pam.presentation;

import org.junit.Before;
import org.junit.Test;

import ru.dimasokol.demo.pam.model.DemoModel;
import ru.dimasokol.demo.pam.utils.StubRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DemoPresenterTest {

    private DemoView mView;
    private DemoPresenter mPresenter;
    private DemoModel mModel;

    @Before
    public void setUp() throws Exception {
        mView = mock(DemoView.class);
        mModel = mock(DemoModel.class);

        when(mModel.getCurrent()).thenReturn(42);
        when(mModel.increment()).thenReturn(666);

        mPresenter = new DemoPresenter(mModel, new StubRunner());
    }

    @Test
    public void increment() {
        mPresenter.increment();
        verify(mModel).increment();

        mPresenter.attachView(mView);
        verify(mView).showCount(eq(666));
    }

    @Test
    public void attachAndDetach() {
        mPresenter.attachView(mView);
        verify(mView).showCount(eq(42));

        mPresenter.detachView();
        mPresenter.increment();
        verify(mView).showCount(eq(42));
    }
}