package Service;

import Service.custom.impl.CustomerServiceImpl;
import Service.custom.impl.ProductServiceImpl;
import utill.ServiceType;

public class BoFactory {
    private static BoFactory instance;
    private BoFactory(){

    }

    public static BoFactory getInstance() {
       return instance == null?instance= new BoFactory():instance;
    }

    public <T extends  SuperBo> T getServiceType(ServiceType type){
        switch (type){
            case CUSTOMER: return (T) new CustomerServiceImpl();
            case PRODUCT: return (T) new ProductServiceImpl();
        }
        return null;
    }
    
}
