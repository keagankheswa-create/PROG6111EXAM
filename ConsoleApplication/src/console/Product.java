/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package console;
/**
 *
 * @author keaga
 */
public class Product implements IProduct {
    
    private String[]productNameS;
    private int[][] salesData;
    private final String[] productNames;

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }
    @Override
    public int GetTotalProductsSold() {
        int total = 0;

        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total = total + salesData[i][j];
            }
        }
        
        return total;

}
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int months = salesData[0].length;
        int products = salesData.length;
        
        double average = (double) total / (products * months);

        return Math.round(average);
    }
    @Override
    public String GetMostPopularProduct() {
        int highest = 0;
        int index = 0;

        for (int i = 0; i < salesData.length; i++) {
            int total = 0;

            for (int j = 0; j < salesData[i].length; j++) {
                total = total + salesData[i][j];
    
}
            if(total > highest) {
                highest = total;
                index = i;
            }
        }
       
        return productNames[index] + "(" + highest + ")";
    }

   
    }
