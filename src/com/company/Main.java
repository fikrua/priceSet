package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        double price1=0 ;  //price of each item
        double totalPrice;  // totalprice will save price*quantity
        int counter =0 ; // will count total item purchase
        double total_Purchase_Amount = 0; // will sum every purchase
        boolean done = false;    // will check the loop will continue or not
        String item = "";    // will save the item customer add
        HashMap<String,Double> priceSet = new HashMap<String, Double>(); // this key is  item and the value is it's price
        ArrayList <String> itemList = new ArrayList<String>(); // will save the array of items the customer want to purchase
        priceSet.put("banana",2.5); //this will add keys and values to the HashMap
        priceSet.put("oringe",2.4);
        priceSet.put("grap",1.25);
        priceSet.put("milk",3.45);
        priceSet.put("egg",4.65);
        priceSet.put("water",4.90);

        while(!done){ //this loop check if the  customer wants more item and item
            System.out.println("enter the item you want ");
            item = scan.nextLine();
            itemList.add(item);
            System.out.println("do you want continue Y/n");
            String yes = scan.nextLine();
            if(yes.equalsIgnoreCase("y"))
                done =false;
            else if  (yes.equalsIgnoreCase("n")){
                System.out.printf( "%-10s %-10s %-10s %-10s\n",
                        "Item Name", "price", "Quantity" ,"cost");
                done = true;
            }
            else System.out.println("invialed input");
        }
        for(String list: itemList){ // this loop calculate each total price
            if(!priceSet.containsKey(list))
                System.out.println("sorry! we are out off this pariticular " + list);
            else
                price1 = priceSet.get(list);
            int quantity =1+ rand.nextInt(3); // will genrate form 1 up to 4 random quantity
            totalPrice = quantity*price1;
            System.out.printf( "%-10s $%-10s %-10s $%-5s\n",
                    list,price1,quantity ,totalPrice);
            total_Purchase_Amount+=totalPrice;
            counter++;

        }
        System.out.println("\n");
        System.out.printf("Total Purchase Amount = $%5s\n",total_Purchase_Amount);
        System.out.println("Total Items Purchased: "+counter);
        if(total_Purchase_Amount>20)
            System.out.println("You spent too much today..");
        else
            System.out.println("Thank you for shopping at my market!");

    }

}