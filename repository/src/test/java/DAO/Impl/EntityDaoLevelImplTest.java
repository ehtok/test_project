package DAO.Impl;

import Constants.ConstantsLevel;
import Entity.Level;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoLevelImplTest {
    @Test
    public void testSave() {
        EntityDaoLevelImpl daoLevel = new EntityDaoLevelImpl();
        Level expect = Utils.createLevel();
        daoLevel.save(expect);
        Level actual = daoLevel.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());

    }

    @Test
    public void testFindId() {
        EntityDaoLevelImpl daoLevel = new EntityDaoLevelImpl();
        Level expect = Utils.createLevel();
        daoLevel.save(expect);
        Level actual = daoLevel.findId(expect.getId());
        Assert.assertNotNull(actual);

    }

    @Test
    public void testUpdate() {
        EntityDaoLevelImpl daoLevel = new EntityDaoLevelImpl();
        Level expect = Utils.createLevel();
        daoLevel.save(expect);
        Level actual = daoLevel.findId(expect.getId());
        actual.setLevel(ConstantsLevel.LEVEL_NAME_1);
        daoLevel.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoLevelImpl daoLevel = new EntityDaoLevelImpl();
        Level expect = Utils.createLevel();
        daoLevel.save(expect);
        daoLevel.delete(expect.getId());
        Level actual = daoLevel.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoLevelImpl daoLevel = new EntityDaoLevelImpl();
        Level level = Utils.createLevel();
        daoLevel.save(level);
        int expect = daoLevel.findAll().size();
        Assert.assertEquals(expect, ConstantsLevel.ACTUAL_SIZE_LIST_ALL);
    }
}