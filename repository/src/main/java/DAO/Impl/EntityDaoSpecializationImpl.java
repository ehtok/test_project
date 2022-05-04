package DAO.Impl;

import DAO.interf.EntityDaoSpecialization;
import Entity.Specialization;

public class EntityDaoSpecializationImpl extends EntityDaoImpl<Specialization> implements EntityDaoSpecialization {
    public EntityDaoSpecializationImpl() {
        super(Specialization.class);
    }
}
