package DAO.Impl;

import DAO.interf.EntityDaoTechnology;
import Entity.Technology;

public class EntityDaoTechnologyImpl extends EntityDaoImpl<Technology> implements EntityDaoTechnology {
    public EntityDaoTechnologyImpl() {
        super(Technology.class);
    }
}
