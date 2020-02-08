package ru.dimasokol.demo.pam;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.dimasokol.demo.pam.presentation.DemoPresenter;
import ru.dimasokol.demo.pam.presentation.DemoView;
import ru.dimasokol.demo.pam.presentation.PresentersHolder;

public class MainActivity extends AppCompatActivity implements DemoView {

    private TextView mTextView;
    private DemoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = ((PresentersHolder) getApplication()).getDemoPresenter();

        mTextView = findViewById(R.id.count_text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.increment();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        mPresenter.detachView();
        super.onStop();
    }

    @Override
    public void showCount(int count) {
        mTextView.setText(Integer.toString(count));
    }
}
