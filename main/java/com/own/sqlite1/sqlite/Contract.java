package com.own.sqlite1.sqlite;

import com.own.sqlite1.model.Cartoon;

import java.util.UUID;

/**
 * Created by devtacho on 9/03/18.
 */

public class Contract {
    interface OrderHeaderColumns{
        String ID = "id";
        String ID_CUSTOMER = "id_customer";
        String ID_METHOD_PAYMENT = "id_method_payment";
        String DATE = "record_date";
    }

    interface OrderDetailColumns{
        String ID = "id";
        String SEQUENCE = "sequence";
        String ID_PRODUCT = "id_product";
        String QUANTITY = "quantity";
        String PRICE = "price";
    }

    interface ProductColumns{
        String ID = "id";
        String NAME = "name";
        String PRICE = "price";
        String STOCK = "stock";
    }

    interface CartoonColumns{
        String ID = "id";
        String NAME = "name";
        String TYPE = "type";
        String LANGUAGE = "language";
        String AUTHOR = "author";
        String CAPITULOS = "capitulos";
        String YEAR = "year";
    }

    interface  CustomerColumns{
        String ID = "id";
        String FIRSTNAME = "firstname";
        String LASTNAME = "lastname";
        String PHONE = "phone";
    }

    interface MethodPaymentColumns{
        String ID = "id";
        String NAME = "name";
    }

    public static class OrderHeaders implements OrderHeaderColumns{
        public static String generateIdOrderHeader(){
            return  "OH-"+ UUID.randomUUID().toString();
        }
    }


    public static class OrderDetails implements OrderDetailColumns{

    }

    public static class Products implements ProductColumns{
        public static String generateIdProduct(){
            return  "PR-"+ UUID.randomUUID().toString();
        }
    }

    public static class Cartoons implements CartoonColumns{
        public static String generateIdCartoon(){
            return  "CA-"+ UUID.randomUUID().toString();
        }
    }

    public static class Customers implements CustomerColumns{
        public static String generateIdCustomer(){
            return  "CU-"+ UUID.randomUUID().toString();
        }
    }

    public static class MethodsPayment implements MethodPaymentColumns{
        public static String generateIdMethodPayment(){
            return  "MP-"+ UUID.randomUUID().toString();
        }
    }


    private Contract() {

    }


}
