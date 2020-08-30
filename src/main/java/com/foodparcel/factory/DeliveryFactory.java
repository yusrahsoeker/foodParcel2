package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;
import com.foodparcel.util.IDGenerator;

public class DeliveryFactory {

    public static Delivery createDelivery (String deliveryAddress , String deliveryDate , String deliveryID) {

        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryID(IDGenerator.generateId())
                .build();


        return delivery;

    }


    public static Delivery getDelivery(String long_street, Object o) {
        return null;
    }
}