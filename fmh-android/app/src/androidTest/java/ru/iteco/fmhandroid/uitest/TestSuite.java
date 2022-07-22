package ru.iteco.fmhandroid.uitest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthTest.class,
        LoadingTest.class,
        ClaimTest.class,
        FilterTest.class,
        MainTest.class,
        MenuTest.class,
        NewsTest.class
})
public class TestSuite {
}
