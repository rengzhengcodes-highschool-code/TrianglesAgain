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
    Point[] trueTest = new Point[100];
    System.out.println("RANDOMIZED TRUE TEST");
    for (int index = 0; index < trueTest.length; index++) {
      trueTest[index] = new Point(Math.random(), Math.random());
    }

    for (int index = 0; index < trueTest.length; index++) {
      Point reference = new Point(trueTest[index]);
      if (trueTest[index].equals(reference)) {
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("REFERENCE: " + reference.getX() + "\t" + reference.getY());
        System.out.println("ACTUAL: "  + trueTest[index].getX() + "\t" + trueTest[index].getY());
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
