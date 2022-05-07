package DAO.Impl;

import Constants.ConstantsTechnology;
import Entity.Technology;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoTechnologyImplTest {
    @Test
    public void testSave() {
        EntityDaoTechnologyImpl daoTechnology =
                new EntityDaoTechnologyImpl();
        Technology expect = Utils.createTechnology();
        daoTechnology.save(expect);
        Technology actual = daoTechnology.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testFindId() {
        EntityDaoTechnologyImpl daoTechnology =
                new EntityDaoTechnologyImpl();
        Technology expect = Utils.createTechnology();
        daoTechnology.save(expect);
        Technology actual = daoTechnology.findId(expect.getId());
        Assert.assertNotNull(actual);

    }

    @Test
    public void testUpdate() {
        EntityDaoTechnologyImpl daoTechnology =
                new EntityDaoTechnologyImpl();
        Technology expect = Utils.createTechnology();
        daoTechnology.save(expect);
        Technology actual = daoTechnology.findId(expect.getId());
        actual.setTechnology(ConstantsTechnology.NAME_TECHNOLOGY_1);
        daoTechnology.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoTechnologyImpl daoTechnology =
                new EntityDaoTechnologyImpl();
        Technology expect = Utils.createTechnology();
        daoTechnology.save(expect);
        daoTechnology.delete(expect.getId());
        Technology actual = daoTechnology.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoTechnologyImpl daoTechnology =
                new EntityDaoTechnologyImpl();
        Technology technology = Utils.createTechnology();
        daoTechnology.save(technology);
        int expect = daoTechnology.findAll().size();
        Assert.assertEquals(expect, ConstantsTechnology.ACTUAL_SIZE_LIST_ALL);

    }
}