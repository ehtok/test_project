package DAO.Impl;

import Constants.ConstantsSpecialization;
import Entity.Specialization;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoSpecializationImplTest {
    @Test
    public void testSave() {
        EntityDaoSpecializationImpl daoSpecialization =
                new EntityDaoSpecializationImpl();
        Specialization expect = Utils.createSpecialization();
        daoSpecialization.save(expect);
        Specialization actual = daoSpecialization.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testFindId() {
        EntityDaoSpecializationImpl daoSpecialization =
                new EntityDaoSpecializationImpl();
        Specialization expect = Utils.createSpecialization();
        daoSpecialization.save(expect);
        Specialization actual = daoSpecialization.findId(expect.getId());
        Assert.assertNotNull(actual);
    }

    @Test
    public void testUpdate() {
        EntityDaoSpecializationImpl daoSpecialization =
                new EntityDaoSpecializationImpl();
        Specialization expect = Utils.createSpecialization();
        daoSpecialization.save(expect);
        Specialization actual = daoSpecialization.findId(expect.getId());
        actual.setExperience(ConstantsSpecialization.SPECIALIZATION_EXPERIENCE_1);
        actual.setProfession(ConstantsSpecialization.SPECIALIZATION_PROFESSION_1);
        actual.setSalary(ConstantsSpecialization.SPECIALIZATION_SALARY_1);
        daoSpecialization.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoSpecializationImpl daoSpecialization =
                new EntityDaoSpecializationImpl();
        Specialization expect = Utils.createSpecialization();
        daoSpecialization.save(expect);
        daoSpecialization.delete(expect.getId());
        Specialization actual = daoSpecialization.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoSpecializationImpl daoSpecialization =
                new EntityDaoSpecializationImpl();
        Specialization specialization = Utils.createSpecialization();
        daoSpecialization.save(specialization);
        int expect = daoSpecialization.findAll().size();
        Assert.assertEquals(expect, ConstantsSpecialization.ACTUAL_SIZE_LIST_ALL);
    }

}