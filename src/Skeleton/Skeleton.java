/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skeleton;

/**
 *
 * @author KD
 */
public class Skeleton {
    public static int[][] ZhangSuenThinning(int[][] image) {
        //Step 1
        for(int i=1; i<image.length-1; i++) {
            for(int j=1; j<image[0].length-1; j++) {
                if(image[i][j]==1 && (2<=neighbours(i, j, image) && neighbours(i, j, image)<=6) && transitions(i, j, image)==1 && image[i-1][j]*image[i][j+1]*image[i+1][j]==0 && image[i][j+1]*image[i+1][j]*image[i][j-1]==0) {
                    image[i][j] = 0;
                }
            }
        }
        
        //Step 2
        for(int i=1; i<image.length-1; i++) {
            for(int j=1; j<image[0].length-1; j++) {
                if(image[i][j]==1 && (2<=neighbours(i, j, image) && neighbours(i, j, image)<=6) && transitions(i, j, image)==1 && image[i+1][j]*image[i][j-1]*image[i-1][j]==0 && image[i][j-1]*image[i-1][j]*image[i][j+1]==0) {
                    image[i][j] = 0;
                }
            }
        }
        
        return image;
    }
    
    public static int neighbours(int i, int j, int[][] image) {
        int count = 0;
        count = image[i-1][j-1] + image[i-1][j] + image[i-1][j+1] + image[i][j-1] + image[i][j+1] + image[i+1][j-1] + image[i+1][j] + image[i+1][j+1];
        return count;
    }
    
    public static int transitions(int i, int j, int[][] image) {
        int count = 0;
        if(image[i-1][j-1]==0 && image[i-1][j]==1) count++;
        if(image[i-1][j]==0 && image[i-1][j+1]==1) count++;
        if(image[i-1][j+1]==0 && image[i][j+1]==1) count++;
        if(image[i][j+1]==0 && image[i+1][j+1]==1) count++;
        if(image[i+1][j+1]==0 && image[i+1][j]==1) count++;
        if(image[i+1][j]==0 && image[i+1][j-1]==1) count++;
        if(image[i+1][j-1]==0 && image[i][j-1]==1) count++;
        if(image[i][j-1]==0 && image[i-1][j-1]==1) count++;
        return count;
    }
    
    public static void main(String args[]) {
        int[][] image = 
            {{1,1,0,0,1,1,1},
            {1,1,0,0,1,1,1},
            {1,1,0,0,1,1,1},
            {1,1,0,0,1,1,1},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,0,0,1,1,0},
            {1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0}};
        
        int[][] skeleton = ZhangSuenThinning(image);
        
        //output
        for(int i=0; i<skeleton.length; i++) {
            for(int j=0; j<skeleton[0].length; j++) {
                System.out.print(skeleton[i][j] + ",");
            }
            System.out.println();
        }
    }
}
