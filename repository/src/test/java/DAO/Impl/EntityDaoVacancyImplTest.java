package DAO.Impl;

import Constants.ConstantsVacancy;
import Entity.Vacancy;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoVacancyImplTest {

    @Test
    public void testSave() {
        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();
        Vacancy expect = Utils.createVacancy();
        daoVacancy.save(expect);
        Vacancy actual = daoVacancy.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testFindId() {
        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();
        Vacancy expect = Utils.createVacancy();
        daoVacancy.save(expect);
        Vacancy actual = daoVacancy.findId(expect.getId());
        Assert.assertNotNull(actual);
    }

    @Test
    public void testUpdate() {
        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();
        Vacancy expect = Utils.createVacancy();
        daoVacancy.save(expect);
        Vacancy actual = daoVacancy.findId(expect.getId());
        actual.setDescription(ConstantsVacancy.VACANCY_DESCRIPTION1);
        daoVacancy.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();
        Vacancy expect = Utils.createVacancy();
        daoVacancy.save(expect);
        daoVacancy.delete(expect.getId());
        Vacancy actual = daoVacancy.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();
        Vacancy vacancy = Utils.createVacancy();
        daoVacancy.save(vacancy);
        int expect = daoVacancy.findAll().size();
        Assert.assertEquals(expect, ConstantsVacancy.ACTUAL_SIZE_LIST_ALL);
    }
}