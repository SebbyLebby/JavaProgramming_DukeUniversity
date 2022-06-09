import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        // Start counter at 0
        int counter = 0;
        //For each point numberPts in the shape
        for (Point numberPts : s.getPoints()) {
            // No need to specify variable type. It already knows which type is it.
            if (numberPts.getX() == (int)numberPts.getX()) {
                counter += 1;
            }
        }    
        // counter is the answer
        return counter;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int totalPts = getNumPoints(s);
        
        double average = length / totalPts;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point side = s.getLastPoint();
        double largestSide = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currdist = side.distance(currPt);
            side = currPt;
            if (currdist > largestSide) {
                largestSide = currdist;
            }
            else{continue;}
    }
    return largestSide;
}

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        int largestX = 0;
        int currX = 0;
        for(Point currPt : s.getPoints()){
            currX = currPt.getX();
            if (currX > largestX){
                largestX = currX;
            }
            else{continue;}
            currPt = prevPt;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerim){
                largestPerim = perimeter;
            }
            else{continue;}
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        File temp = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerim){
                largestPerim = perimeter;
                temp = f;
            }
            else{continue;}
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int totalPts = getNumPoints(s);
        double avgsidelen = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("Perimeter = " + length);
        System.out.println("Number of points = " + totalPts);
        System.out.println("Average side length = " + avgsidelen);
        System.out.println("Largest side is = " + largestSide);
        System.out.println("Largest X point is = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter between the chosen files is = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("The file name is " + file);
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter between the chosen files is = " + largestPerim);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
