package ru.fmhandroid;

import android.os.Environment;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;


@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {
    @Before
    public void createAllureDir() {
        File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/allure-results/"
        );
        if (!path.exists()) {
            path.mkdirs();
        }
    }

}
