package DAO.Impl;

import Constants.ConstantsCompany;
import Entity.Company;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoCompanyImplTest {

    @Test
    public void testSave() {
        EntityDaoCompanyImpl daoCompany =
                new EntityDaoCompanyImpl();
        Company expect = Utils.createCompany();
        daoCompany.save(expect);
        Company actual = daoCompany.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());

    }

    @Test
    public void testFindId() {
        EntityDaoCompanyImpl daoCompany =
                new EntityDaoCompanyImpl();
        Company expect = Utils.createCompany();
        daoCompany.save(expect);
        Company actual = daoCompany.findId(expect.getId());
        Assert.assertNotNull(actual);

    }

    @Test
    public void testUpdate() {
        EntityDaoCompanyImpl daoCompany =
                new EntityDaoCompanyImpl();
        Company expect = Utils.createCompany();
        daoCompany.save(expect);
        Company actual = daoCompany.findId(expect.getId());
        actual.setName(ConstantsCompany.NAME_COMPANY_1);
        actual.setCompanySize(ConstantsCompany.SIZE_COMPANY_1);
        actual.setTypeCompany(ConstantsCompany.TYPE_COMPANY_1);
        daoCompany.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoCompanyImpl daoCompany =
                new EntityDaoCompanyImpl();
        Company expect = Utils.createCompany();
        daoCompany.save(expect);
        daoCompany.delete(expect.getId());
        Company actual = daoCompany.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoCompanyImpl daoCompany =
                new EntityDaoCompanyImpl();
        Company company = Utils.createCompany();
        daoCompany.save(company);
        int expect = daoCompany.findAll().size();
        Assert.assertEquals(expect, ConstantsCompany.ACTUAL_SIZE_LIST_ALL);


    }
}