/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

/**
 *
 * @author cvgs
 */
public class ClosestPoints {
    private static void cPoint(int[]x,int[]y){
     double dMin= Math.sqrt((x[0]-x[1])*(x[0]-x[1])+((y[0]-y[1])*(y[0]-y[1])));
     double jarak;
     int x1 = 0,y1 = 0,x2 = 0,y2 = 0;
     for (int i = 0; i < y.length-1; i++) {
         for (int j = i+1; j < y.length; j++) {
             jarak=Math.sqrt((x[i]-x[j])*(x[i]-x[j])+((y[i]-y[j])*(y[i]-y[j])));
             if (jarak<dMin){
                dMin=jarak;
                x1=x[i];
                x2=x[j];
                y1=y[i];
                y2=y[j];
             }
          }
      }
      System.out.println("Jarak Terpendek = "+dMin+" di titik ("+x1+","+y1+") dengan ("+x2+","+y2+")");
   }

    public static void main(String[] args) {
      int[]titikX={2,4,6,7,8};
      int[]titikY={2,4,9,5,4};
      cPoint(titikX, titikY);
   }

}
