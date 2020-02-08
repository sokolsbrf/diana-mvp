package ru.dimasokol.demo.pam.model;

public class DemoModelImpl implements DemoModel {

    private int mCounter = 0;

    private final Database mDatabase;

    public DemoModelImpl(Database database) {
        mDatabase = database;
    }

    @Override
    public int getCurrent() {
        return mCounter;
    }

    @Override
    public int increment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mCounter++;
    }

    @Override
    public void something() {
        mCounter = mDatabase.getSomething().getCount();
    }
}
