public class Triangle {
  private Point p1, p2, p3;

  public Triangle(Point a, Point b, Point c) {                                  //constructor from points
    p1 = a;
    p2 = b;
    p3 = c;
  }

  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {//constructor from coordinates
    p1 = new Point(x1, y1);
    p2 = new Point(x2, y2);
    p3 = new Point(x3, y3);
  }

  public double getPerimeter() {
    return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
  }

  public double getArea() {
    double semiPerimeter = getPerimeter()/2;
    return Math.sqrt(semiPerimeter * (semiPerimeter - p1.distanceTo(p2)) *
    (semiPerimeter - p2.distanceTo(p3)) * (semiPerimeter - p3.distanceTo(p1))); //area via heron's formula
  }

  private static double roundTenThousandths(double n) {                          //roundingTenThousandths
    return Math.round(n * 10000.) / 10000.;
  }

  public String classify() {
    //calculation for how many sides are equal
    int sidesEqual = 0;
    if (roundTenThousandths(p1.distanceTo(p2)) == roundTenThousandths(p1.distanceTo(p3))) sidesEqual++;
    if (roundTenThousandths(p1.distanceTo(p2)) == roundTenThousandths(p2.distanceTo(p3))) sidesEqual++;
    if (roundTenThousandths(p1.distanceTo(p3)) == roundTenThousandths(p2.distanceTo(p3))) sidesEqual++;
    //output depending on equal sides.
    switch (sidesEqual) {                                                       //classification based on sideLength
      case 0: return "scalene";
      case 1: return "isosceles";
      case 2: return "you should not be here; this isn't possible!";            //this result should be impossible
      case 3: return "equilateral";
      default: return "there was no classification.";                           //this result also shouldn't exist, but its there for scenario testing.
    }
  }

  public String toString() {                                                    //lists ponts of Triangle
    return "v1(" + p1.getX() + ", " + p1.getY() + ") v2(" + p2.getX() + ", " +
    p2.getY() + ") v3(" + p3.getX() + ", " + p3.getY() + ")";
  }

  public void setVertex(int index, Point newP) {                                //replaces a vertex
    switch (index) {
      case 0: p1 = newP; break;
      case 1: p2 = newP; break;
      case 2: p3 = newP; break;
    }
  }

}
