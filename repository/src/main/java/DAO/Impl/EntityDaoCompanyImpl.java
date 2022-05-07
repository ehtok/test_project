package DAO.Impl;

import DAO.interf.EntityDaoCompany;
import Entity.Company;

public class EntityDaoCompanyImpl extends EntityDaoImpl<Company> implements EntityDaoCompany {
    public EntityDaoCompanyImpl() {
        super(Company.class);
    }
}
