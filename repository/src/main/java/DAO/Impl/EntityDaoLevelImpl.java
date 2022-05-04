package DAO.Impl;

import DAO.interf.EntityDaoLevel;
import Entity.Level;

public class EntityDaoLevelImpl extends EntityDaoImpl<Level> implements EntityDaoLevel {
    public EntityDaoLevelImpl() {
        super(Level.class);
    }
}
