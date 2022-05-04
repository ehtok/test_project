package DAO.Impl;

import Constants.ConstantsCourse;
import Entity.Course;
import Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class EntityDaoCourseImplTest {
    @Test
    public void testSave() {
        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();
        Course expect = Utils.createCourse();
        daoCourse.save(expect);
        Course actual = daoCourse.findId(expect.getId());
        Assert.assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testFindId() {
        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();
        Course expect = Utils.createCourse();
        daoCourse.save(expect);
        Course actual = daoCourse.findId(expect.getId());
        Assert.assertNotNull(actual);
    }

    @Test
    public void testUpdate() {
        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();
        Course expect = Utils.createCourse();
        daoCourse.save(expect);
        Course actual = daoCourse.findId(expect.getId());
        actual.setDescription(ConstantsCourse.COURSE_DESCRIPTION_1);
        actual.setDateStart(ConstantsCourse.DATE_START_COURSE_1);
        actual.setDateFinish(ConstantsCourse.DATE_FINISH_COURSE_1);
        daoCourse.update(actual);
        Assert.assertNotEquals(expect.toString(), actual.toString());
    }

    @Test
    public void testDelete() {
        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();
        Course expect = Utils.createCourse();
        daoCourse.save(expect);
        daoCourse.delete(expect.getId());
        Course actual = daoCourse.findId(expect.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll() {
        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();
        Course course = Utils.createCourse();
        daoCourse.save(course);
        int actual = daoCourse.findAll().size();
        Assert.assertEquals(actual, ConstantsCourse.ACTUAL_SIZE_LIST_ALL);
    }
}