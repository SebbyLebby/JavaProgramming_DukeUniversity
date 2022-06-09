
/**
 * Write a description of Perimeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

public class Perimeter {
    public double berechnPerimeter(Shape s){
        Point lastPoint = s.getLastPoint();
        double totalPerim = 0.0;
        for(Point actualPoint : s.getPoints()){
            double distance = actualPoint.distance(lastPoint);
            totalPerim = totalPerim + distance;
            lastPoint = actualPoint;
        }
        return totalPerim;
    }
    
    public int getNumPoints(Shape s){
        int countPoints = 0;
        for(Point actualPoint : s.getPoints()){
            countPoints += 1;
        }
        return countPoints;
    }
    
    public double bekommDurschnittslänge(Shape s){
        int getPoints = getNumPoints(s);
        Point lastPoint = s.getLastPoint();
        double totalPerim = 0;
        double averageLength = 0.0;
        for(Point actualPoint : s.getPoints()){
            double distance = actualPoint.distance(lastPoint);
            totalPerim = totalPerim + distance;
            lastPoint = actualPoint;
        }
        averageLength = totalPerim/getPoints;
        return averageLength;
    }
    
    public double grösteSeite(Shape s){
        Point lastPoint = s.getLastPoint();
        double largestSide = 0.0;
        double distance = 0.0;
        for(Point actualPoint : s.getPoints()){
            if(distance > largestSide){
                largestSide = distance;
            }   
            distance = actualPoint.distance(lastPoint);
            lastPoint = actualPoint;
        }
        return largestSide;
    }
    
    public void obtenerFigura(){
        FileResource f = new FileResource();
        Shape s = new Shape(f);
        double perimeter = berechnPerimeter(s);
        double points = getNumPoints(s);
        double average_len = bekommDurschnittslänge(s);
        double largestDistance = grösteSeite(s);
        System.out.println(perimeter);
        System.out.println(points);
        System.out.println(average_len);
        System.out.println(largestDistance);
    }
    
    public void multiplesArchivos(){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = berechnPerimeter(s);
            System.out.println("Perímetro es: " + perimeter);
        }
    }
}
