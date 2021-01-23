package dao;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory=new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes types){

        switch (types){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            default: return null;
        }
    }
}
