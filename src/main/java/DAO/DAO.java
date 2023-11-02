package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {
    private static final String ENTITY_MANAGER_FACTORY_NAME = "Fakultative";
    protected EntityManagerFactory factory;

    public DAO() {
        factory = Persistence.
                createEntityManagerFactory(ENTITY_MANAGER_FACTORY_NAME);
    }
}


