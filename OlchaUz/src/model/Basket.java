package model;

import service.BasketService;
import service.ProductService;
import service.UserService;

import java.text.SimpleDateFormat;

public class Basket extends Base {
    UserService userService=new UserService();
    ProductService productService = new ProductService();
    private int productId;
    private int count;
    private boolean buy;
    private String buyTime;
    private double totalAmount;
    private int basketUserId;

    public Basket(int basketUserId, int productId, int count) {
        this.basketUserId = basketUserId;
        this.productId = productId;
        this.count = count;
    }

    public Basket() {

    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String  getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String  buyTime) {
        this.buyTime = buyTime;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBasketUserId() {
        return basketUserId;
    }

    public void setBasketUserId(int basketUserId) {
        this.basketUserId = basketUserId;
    }


    @Override
    public String toString() {
        return "USER NAME: '"+userService.getNameById(basketUserId).toUpperCase()+"'"+"\nPRODUCT NAME: "+productService.getNameById(productId).toUpperCase() + "\nCOUNT= " + count+"\nBUY TIME: "+buyTime+"\n";
    }
}
