package ru.dimasokol.demo.pam.model;

import android.database.Cursor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DemoModelImplTest {

    private Database mDatabase;
    private Cursor mCursor;
    private DemoModelImpl mModel;

    @Before
    public void setUp() throws Exception {
        mCursor = mock(Cursor.class);
        when(mCursor.getCount()).thenReturn(66);

        mDatabase = mock(Database.class);
        when(mDatabase.getSomething()).thenReturn(mCursor);

        mModel = new DemoModelImpl(mDatabase);
    }

    @Test
    public void something() {
        mModel.something();
        assertEquals(66, mModel.getCurrent());
    }
}