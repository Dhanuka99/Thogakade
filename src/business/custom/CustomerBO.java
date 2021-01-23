package business.custom;

import business.SuperBO;
import dto.CustomerDTO;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;


}
