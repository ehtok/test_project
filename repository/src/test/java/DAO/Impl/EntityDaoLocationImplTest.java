package DAO.Impl;

import Constants.ConstantsLocation;
import Entity.Location;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoLocationImplTest {
    @Test
    public void testSave() {
        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();
        Location expect = Utils.creatLocation();
        daoLocation.save(expect);
        Location actual = daoLocation.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testFindId() {
        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();
        Location expect = Utils.creatLocation();
        daoLocation.save(expect);
        Location actual = daoLocation.findId(expect.getId());
        Assert.assertNotNull(actual);
    }

    @Test
    public void testUpdate() {
        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();
        Location expect = Utils.creatLocation();
        daoLocation.save(expect);
        Location actual = daoLocation.findId(expect.getId());
        actual.setCountry(ConstantsLocation.LOCATION_COUNTRY_1);
        actual.setCity(ConstantsLocation.LOCATION_CITY_1);
        daoLocation.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();
        Location expect = Utils.creatLocation();
        daoLocation.save(expect);
        daoLocation.delete(expect.getId());
        Location actual = daoLocation.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();
        Location location = Utils.creatLocation();
        daoLocation.save(location);
        int expect = daoLocation.findAll().size();
        Assert.assertEquals(expect, ConstantsLocation.ACTUAL_SIZE_LIST_ALL);
    }
}