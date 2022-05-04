package DAO.Impl;

import DAO.interf.EntityDaoVacancy;
import Entity.Vacancy;

public class EntityDaoVacancyImpl extends EntityDaoImpl<Vacancy> implements EntityDaoVacancy {
    public EntityDaoVacancyImpl() {
        super(Vacancy.class);
    }
}
