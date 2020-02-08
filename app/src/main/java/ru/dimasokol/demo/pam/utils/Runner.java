package ru.dimasokol.demo.pam.utils;

public interface Runner {
    void runInBackground(Runnable task);
    void runOnMain(Runnable task);
}
