import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserService userService = new UserService();
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();
    static BasketService basketService = new BasketService();

    public static void main(String[] args) {
        int var1 = 10;
        while (var1 != 0) {
            System.out.println("1.LOG IN 2.REGISTER 0.EXIT");
            var1 = scannerInt.nextInt();
            switch (var1) {
                case 1 -> {
                    System.out.print("PHONE NUMBER\n(+998)");
                    String phoneNumber = scannerStr.nextLine();
                    System.out.println("PASSWORD");
                    String password = scannerStr.nextLine();
                    User currentUser = userService.login(phoneNumber, password);
                    if (currentUser != null) {
                        if (currentUser.getRole().equals("ADMIN")) {
                            System.out.println("---WELCOME TO OLCHA UZ '" + currentUser.getName().toUpperCase() + "'---");
                            forAdmin();
                        } else if (currentUser.getRole().equals("USER")) {
                            System.out.println("---WELCOME OLCHA UZ '" + currentUser.getName().toUpperCase() + "'---");
                            int var6 = 10;
                            while (var6 != 0) {
                                System.out.println("1.CATEGORY LIST 2.ORDER LIST 0.BACK");
                                var6 = scannerInt.nextInt();
                                switch (var6) {
                                    case 1 -> {
                                        int var7 = 10;
                                        categoryService.showParentCategories();
                                        while (var7 != 0) {
                                            System.out.println("CATEGORY ID  (0.BACK)");
                                            var7 = scannerInt.nextInt();
                                            categoryService.showSubCategories(var7);
                                            productService.showProductsByCategoryId1(var7);
                                            if (productService.showProductsByCategoryId(var7) != null) {
                                                int var8 = 10;
                                                while (var8 != 0) {
                                                    System.out.println("1.ADD PRODUCT IN BASKET 2.SHOW BASKET 0.BACK");
                                                    var8 = scannerInt.nextInt();
                                                    switch (var8) {
                                                        case 1 -> {
                                                            Basket basket = new Basket();
                                                            basket.setBasketUserId(currentUser.getId());

                                                            System.out.println("PRODUCT ID");
                                                            int productId = scannerInt.nextInt();
                                                            basket.setProductId(productId);

                                                            System.out.println("COUNT");
                                                            int count = scannerInt.nextInt();
                                                            basket.setCount(count);

                                                            Product currentProduct = (Product) productService.getById(productId);
                                                            basket.setName(currentProduct.getName());
                                                            if (currentProduct.getCount() >= count) {
                                                                basketService.addBasket(basket);
                                                                currentProduct.setCount(currentProduct.getCount() - count);
                                                            } else {
                                                                System.out.println("---SORRY THIS PRODUCT NOT ENOUGH AVAILABLE---");
                                                                break;
                                                            }
                                                        }
                                                        case 2 -> {
                                                            basketService.showBasket(currentUser.getId());
                                                            int var9 = 10;
                                                            while (var9 != 0) {
                                                                System.out.println("1.ORDER 2.EDIT 0.BACK");
                                                                var9 = scannerInt.nextInt();
                                                                switch (var9) {
                                                                    case 1 -> {
                                                                        basketService.buy(currentUser.getId());

                                                                        System.out.println("DONE☑ (THANKS FOR BUYING \uD83D\uDE0A)");

                                                                    }
                                                                    case 2 -> {
                                                                        System.out.println("PRODUCT ID");
                                                                        var9 = scannerInt.nextInt();
                                                                        basketService.deleteBasketByProductId(var9);
                                                                    }
                                                                    case 0 -> {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        case 0 -> {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        basketService.showOrderListForUser(currentUser.getId());
                                    }
                                    case 0 -> {
                                    }
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    User user = new User();
                    System.out.println("NAME");
                    user.setName(scannerStr.nextLine());
                    System.out.print("PHONE NUMBER\n(+998)");
                    user.setPhoneNumber(scannerStr.nextLine());
                    System.out.println("PASSWORD");
                    user.setPassword(scannerStr.nextLine());
                    System.out.println("ROLE (1.ADMIN 2.USER)");
                    int var10 = 10;
                    var10 = scannerInt.nextInt();
                    if (var10 == 1)
                        user.setRole("ADMIN");
                    else if (var10 == 2)
                        user.setRole("USER");
                    userService.add(user);
                }
                case 0 -> {
                }
            }
        }
    }

    private static void forAdmin() {
        int var2 = 10;
        while (var2 != 0) {
            System.out.println("1.CATEGORY 2.PRODUCT 3.ORDER LIST 0.BACK");
            var2 = scannerInt.nextInt();
            switch (var2) {
                case 1 -> {
                    categoryForAdmin();
                }
                case 2 -> {
                    productForAdmin();
                }
                case 3 -> {
                    basketService.showAllOrders();
                }
                case 0 -> {
                }
            }
        }
    }

    private static void productForAdmin() {
        int var3 = 10;
        while (var3 != 0) {
            System.out.println("1.ADD PRODUCT 2.DELETE PRODUCT 3.SHOW PRODUCT LIST 0.BACK");
            var3 = scannerInt.nextInt();
            switch (var3) {
                case 1 -> {
                    Product product = new Product();
                    System.out.println("NAME");
                    product.setName(scannerStr.nextLine());
                    System.out.println("PRICE");
                    product.setPrice(new Scanner(System.in).nextDouble());
                    System.out.println("COUNT");
                    product.setCount(scannerInt.nextInt());
                    System.out.println("DISCOUNT(%)");
                    double discount = new Scanner(System.in).nextDouble();
                    product.setPrice((100 - discount) * product.getPrice() / 100);
                    categoryService.showAllSubCategories();

                    System.out.println("CATEGORY ID");
                    product.setCategoryId(scannerInt.nextInt());
                    productService.add(product);
                }
                case 2 -> {
                    System.out.println("PRODUCT ID");
                    productService.delete(scannerInt.nextInt());
                }
                case 3 -> {
                    productService.showList();
                }
                case 0 -> {

                }
            }
        }

    }

    private static void categoryForAdmin() {
        int var4 = 10;
        while (var4 != 0) {
            System.out.println("1.ADD CATEGORY 2.DELETE CATEGORY 3.SHOW CATEGORY LIST 0.BACK");
            var4 = scannerInt.nextInt();
            switch (var4) {
                case 1 -> {
                    Category category = new Category();
                    System.out.println("CATEGORY NAME");
                    category.setName(scannerStr.nextLine());
                    System.out.println("CATEGORY PARENT ID");
                    category.setParentId(scannerInt.nextInt());
                    categoryService.add(category);
                }
                case 2 -> {
                    System.out.println("CATEGORY ID");
                    int categoryId = scannerInt.nextInt();
                    categoryService.delete(categoryId);
                }
                case 3 -> {
                    int var5 = 10;
                    categoryService.showParentCategories();
                    while (var5 != 0) {
                        System.out.println("CATEGORY ID (0.BACK)");
                        var5 = scannerInt.nextInt();
                        categoryService.showSubCategories(var5);
                        productService.showProductsByCategoryId1(var5);
                    }
                }
                case 0 -> {
                }
            }

        }
    }
}