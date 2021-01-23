package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.SuperDAO;
import dao.custom.impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAOImpl dao = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
       return dao.add(new Customer(customer.getId(),customer.getName(),customer.getAddress(),customer.getTel()));
    }
}
