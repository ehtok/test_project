package DAO.Impl;

import DAO.interf.EntityDaoCourse;
import Entity.Course;

public class EntityDaoCourseImpl extends EntityDaoImpl<Course> implements EntityDaoCourse {
    public EntityDaoCourseImpl() {
        super(Course.class);
    }
}
