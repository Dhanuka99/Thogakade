package business.custom;

import business.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {

    public boolean addItem(ItemDTO itemDTO)throws Exception;

    public boolean deleteItem(String id) throws Exception;

    public boolean updateItem(ItemDTO itemDTO) throws Exception;

    public ItemDTO searchItem(String id) throws Exception;

    public String getID() throws Exception;

    public List<ItemDTO> getAll() throws Exception;
}
