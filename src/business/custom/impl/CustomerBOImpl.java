package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAOImpl dao = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
       return dao.add(new Customer(customer.getId(),customer.getName(),customer.getAddress(),customer.getTel()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return dao.update(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTel()));
    }

    @Override
    public Customer searchCustomer(String id) throws Exception {
        Customer search = dao.search(id);
        System.out.println("search customer boimpl layer"+search.getName());

        System.out.println("bo" + search.getName());
        return search;
    }

    @Override
    public String getID() throws Exception {
        String id = dao.getID();
        System.out.println("bo "+id);
        int newID = Integer.parseInt(id.substring(1, 4))+1;
        System.out.println("new ID"+newID);
        if (newID <10){
            return "C00"+newID;
        }else if (newID <100){
            return "C0"+newID;
        }else{
            return "C"+newID;
        }

    }
}
