package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

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
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setTel(customerDTO.getTel());
        return dao.update(customer);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer search = dao.search(id);
        System.out.println("search customer boimpl layer"+search.getName());

        System.out.println("bo" + search.getName());
        return new CustomerDTO(search.getId(),search.getName(),search.getAddress(),search.getTel());
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

    @Override
    public List<CustomerDTO> getAll() throws Exception {
        List<Customer> all = dao.getAll();
        List<CustomerDTO> customer = new ArrayList<>();
        for (Customer customer1 : all) {
            customer.add(new CustomerDTO(customer1.getId(),customer1.getName(),customer1.getAddress(),customer1.getTel()));
        }
        return customer;

    }
}
