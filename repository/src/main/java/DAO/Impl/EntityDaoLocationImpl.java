package DAO.Impl;

import DAO.interf.EntityDaoLocation;
import Entity.Location;

public class EntityDaoLocationImpl extends EntityDaoImpl<Location> implements EntityDaoLocation {
    public EntityDaoLocationImpl() {
        super(Location.class);
    }
}
