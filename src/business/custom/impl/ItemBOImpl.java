package business.custom.impl;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.SuperDAO;
import dao.custom.ItemDAO;
import dto.CustomerDTO;
import dto.ItemDTO;
import entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO dao = DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        dao.add(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQuantity()));
        return true;
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        dao.update(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQuantity()));
        return true;
    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        Item search = dao.search(id);
        return new ItemDTO(search.getCode(),search.getDescription(),search.getUnitPrice(),search.getQuantity());
    }

    @Override
    public String getID() throws Exception {
        return dao.getID();
    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        List<Item> all = dao.getAll();
        List<ItemDTO> list = new ArrayList<>();
        for (ItemDTO itemDTO : list) {
            list.add(new ItemDTO(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQuantity()));
        }
        return list;
    }
}
