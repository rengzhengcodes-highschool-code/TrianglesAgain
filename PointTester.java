public class PointTester {

  public static void main(String[] args) {
    boolean failure = false;
    failure = equalTester();
  }

  public static void errorHorn() {
    System.out.println("ERROR\nERROR\nERROR\n");
  }

  public static boolean equalTester() {
    System.out.println("POINT CLASS equal() TESTER");
    boolean failure = false;
    Point[] randomizedPoints = new Point[100];
    for (int index = 0; index < randomizedPoints.length; index++) {
      randomizedPoints[index] = new Point(Math.random(), Math.random());
    }

    System.out.println("RANDOMIZED TRUE TEST");
    for (int index = 0; index < randomizedPoints.length; index++) {
      Point reference = new Point(randomizedPoints[index]);
      if (randomizedPoints[index].equals(reference)) {
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("REFERENCE: " + reference.getX() + "\t" + reference.getY());
        System.out.println("ACTUAL: "  + randomizedPoints[index].getX() + "\t" + randomizedPoints[index].getY());
      }
    }

    //Math.random is exclusive of 1. Therefore it should never equal point (1,1)
    System.out.println("RANDOMIZED FALSE TEST");
    for (int index = 0; index < randomizedPoints.length; index++) {
      Point reference = new Point(1, 1);
      if (!randomizedPoints[index].equals(reference)) {
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("REFERENCE: " + reference.getX() + "\t" + reference.getY());
        System.out.println("ACTUAL: "  + randomizedPoints[index].getX() + "\t" + randomizedPoints[index].getY());
      }
    }

    if (failure) {
      System.out.println("AT LEAST ONE TEST FAILED!!!!");
    } else {
      System.out.println("TESTS PASSED!");
    }

    return failure;
  }

}
