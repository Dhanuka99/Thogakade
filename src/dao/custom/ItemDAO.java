package dao.custom;

import dao.SuperDAO;
import entity.Item;

public interface ItemDAO extends SuperDAO<Item,String> {
    public String getID() throws Exception;

}
