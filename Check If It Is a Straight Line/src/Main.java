/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 * coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] --> true
 * coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] --> false
 */
public class Main {
    public static boolean checkStraightLine(int[][] coordinates) {
        boolean flag = true;
        float temp = 0;
        for (int i = 0; i < coordinates.length - 1; i++){
            float y = (coordinates[i+1][1]-coordinates[i][1]);
            float x =(coordinates[i+1][0]-coordinates[i][0]);
            float slope = y/x;
            if (flag == true)   { temp = slope; flag = false;}
            if (slope == temp)  { temp = slope; continue;}
            else                {return false;}
        }
        return true;
    }

    public static void main(String []args){

        int [][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        System.out.println(checkStraightLine(coordinates));

    }
}
