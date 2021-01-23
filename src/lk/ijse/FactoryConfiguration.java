package lk.ijse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();

    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }


}
