package ru.dimasokol.demo.pam.model;

import android.database.Cursor;
import android.database.MatrixCursor;

public class DatabaseImpl implements Database {
    @Override
    public Cursor getSomething() {
        MatrixCursor cursor = new MatrixCursor(new String[] {"test"});
        cursor.addRow(new Object[] {42});
        cursor.addRow(new Object[] {42});
        cursor.addRow(new Object[] {42});
        cursor.addRow(new Object[] {42});

        return cursor;
    }
}
