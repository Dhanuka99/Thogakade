package business;

import business.custom.CustomerBO;
import business.custom.impl.CustomerBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory==null) ? boFactory= new BOFactory() :boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes types){
        switch (types){
            case CUSTOMER: return (T) new CustomerBOImpl();
            default: return null;

        }
    }
}
