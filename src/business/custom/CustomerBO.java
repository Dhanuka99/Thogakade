package business.custom;

import business.SuperBO;
import dto.CustomerDTO;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    public String getID() throws Exception;



}
