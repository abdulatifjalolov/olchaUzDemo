package service;

import model.Basket;
import model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketService implements BaseService {
   static List<Basket> baskets=new ArrayList<>();

    public void buy(int userId) {
        for (Basket basket : baskets) {
            if (basket != null) {
                if (basket.getBasketUserId() == userId) {
                    basket.setBuy(true);
                    SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    basket.setBuyTime(date.format(new Date()));
                }
            }
        }
    }

    public void showOrderListForUser(int userId) {
        for (Basket basket : baskets) {
            if (basket != null) {
                if (basket.getBasketUserId() == userId && basket.isBuy()) {
                    System.out.println(basket);
                }
            }
        }
    }

    public void deleteBasketByProductId(int productId){
        for (Basket basket : baskets) {
            if (basket!=null){
                if (basket.getProductId()==productId) {
                    baskets.remove(basket);
                    System.out.println("---SUCCESSFULLY DELETED---");
                    return;
                }
            }
        }
        System.out.println("---SMTH FALSE NOT DELETED---");
    }

    public void showAllOrders() {
        for (Basket basket : baskets) {
            if (basket != null) {
                if (basket.isBuy()) {
                    System.out.println(basket);
                }
            }
        }
    }

    public void showBasket(int userId) {
        for (Basket basket : baskets) {
            if (basket != null) {
                if (basket.getBasketUserId() == userId) {
                    System.out.println(basket);
                }
            }
        }
    }


    public void addBasket(Basket basket) {
        if (basket != null) {
            baskets.add(basket);
            System.out.println("---SUCCESSFULLY ADDED---");
            return;
        }
        System.out.println("---SMTH FALSE NOT ADDED---");
    }

    @Override
    public void delete(int id) {
        for (Basket basket : baskets) {
            if (basket != null) {
                if (basket.getId() == id) {
                    baskets.remove(basket);
                    System.out.println("---SUCCESSFULLY DELETED---");
                    return;
                }
            }
        }
        System.out.println("---SMTH FALSE NOT DELETED---");
    }


    @Override
    public Object getById(int id) {
        for (Basket basket : baskets) {
            if (id == basket.getId()) {
                return basket;
            }
        }
        return null;
    }
}
