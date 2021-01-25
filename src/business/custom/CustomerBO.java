package business.custom;

import business.SuperBO;
import dto.CustomerDTO;
import entity.Customer;

import java.util.List;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    public CustomerDTO searchCustomer(String id) throws Exception;

    public String getID() throws Exception;

    public List<CustomerDTO> getAll() throws Exception;



}
