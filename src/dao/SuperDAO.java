package dao;

import entity.Customer;
import entity.SuperEntity;


import java.io.Serializable;
import java.util.List;

public interface SuperDAO<Entity extends SuperEntity,ID extends Serializable> {
    public boolean add(Entity entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(Entity entity) throws Exception;

    public Entity search(ID id) throws Exception;

    public List<Entity> getAll() throws Exception;




}
