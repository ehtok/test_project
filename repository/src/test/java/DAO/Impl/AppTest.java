package DAO.Impl;

import Utils.EntityFactoryManager;
import org.junit.AfterClass;

public class AppTest {
    @AfterClass
    public static void clean() {
        EntityFactoryManager.close();
    }
}
