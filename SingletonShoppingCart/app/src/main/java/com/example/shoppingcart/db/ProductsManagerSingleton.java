package com.example.shoppingcart.db;

import com.example.shoppingcart.models.Product;

import java.util.ArrayList;

public class ProductsManagerSingleton {

    //boilerplate code
    private ProductsManagerSingleton(){
        loadProductsDataSet();
    }

    //instance
    private static ProductsManagerSingleton instance = null;
    public static ProductsManagerSingleton getInstance(){
        if(instance == null){
            instance = new ProductsManagerSingleton();
        }
        return instance;
    }

    private ArrayList<Product> productList = new ArrayList<Product>();

    private void loadProductsDataSet(){
        this.productList.add(new Product(1,"Peach Pie","A Dessert",5.00,25));
        this.productList.add(new Product(2,"Carrot Cake","A piece of Carrot Cake",3.75,15));
        this.productList.add(new Product(3,"Apple Cider","A refreshing Drink",3.50,3));
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public ArrayList<String> getProductNames(){
        ArrayList<String> productNames = new ArrayList<String>();
        for(int i = 0;i<this.productList.size();i++){
            productNames.add(this.productList.get(i).getName());
        }
        return productNames;
    }

    public int getQuantityByProductId(int id){
        for(int i = 0;i<this.productList.size();i++){
            Product curr = this.productList.get(i);
            if(curr.getId() == id){
                return curr.getQuantityRemaining();
            }
        }
        return -1;
    }

    public Product getProductbyId(int id){
        for(int i = 0;i<this.productList.size();i++){
            Product curr = this.productList.get(i);
            if(curr.getId() == id){
                return curr;
            }
        }
        return null;
    }
}
