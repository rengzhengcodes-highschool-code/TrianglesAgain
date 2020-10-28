public class PointTester {

  public static void main(String[] args) {
    boolean failure = false;
    failure = distanceTo();
    failure = equalTester();
  }

  public static boolean distanceTo() {
    System.out.println("distanceTo() TEST");
    boolean failure = false;
    Point origin = new Point(0, 0);
    Point[] randomizedPoints = new Point[100];
    for (int index = 0; index < randomizedPoints.length; index++) {
      double angle = (Math.random() * 2 * Math.PI);
      randomizedPoints[index] = new Point(Math.cos(angle), Math.sin(angle));
    }

    System.out.println("RANDOMIZED UNIT CIRCLE TEST");
    for (int index = 0; index < randomizedPoints.length; index++) {
      if (Math.round(randomizedPoints[index].distanceTo(origin) * Math.pow(10, 15))/Math.pow(10, 15) == 1) {//we round here because FP errors can cause the last digit to be off a bit.
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             //if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("EXPECTED: " + 1);
        System.out.println("ACTUAL: "  + randomizedPoints[index].distanceTo(origin));
      }
    }

    System.out.println("RANDOMIZED RANDOM TEST");
    for (int index = 0; index < randomizedPoints.length; index++) {
      randomizedPoints[index] = new Point(Math.random(), Math.random());
    }
    for (int index = 0; index < randomizedPoints.length; index++) {
      double selfCalculatedDistance = Math.sqrt(Math.pow(randomizedPoints[index].getX(), 2) + Math.pow(randomizedPoints[index].getY(), 2));
      if (randomizedPoints[index].distanceTo(origin) == selfCalculatedDistance) {//we round here because FP errors can cause the last digit to be off a bit.
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             //if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("EXPECTED: " + selfCalculatedDistance);
        System.out.println("ACTUAL: "  + randomizedPoints[index].distanceTo(origin));
      }
    }

    if (failure) {
      System.out.println("AT LEAST ONE TEST FAILED!!!!");
    } else {
      System.out.println("TESTS PASSED!");
    }

    return failure;
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
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             //if you want live printouts uncomment this.
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
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             //if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("REFERENCE: " + reference.getX() + "\t" + reference.getY());
        System.out.println("ACTUAL: "  + randomizedPoints[index].getX() + "\t" + randomizedPoints[index].getY());
      }
    }

    //static barrage
    System.out.println("STATIC FIRE TEST");
    Point[][] pointsPairs = {
      {new Point(1, 1), new Point(1, 1)},
      {new Point(1, 2), new Point(2, 1)},
    };
    boolean[] pointsPairsEquality = {
      true,
      false,
    };
    for (int index = 0; index < pointsPairs.length; index++) {
      if (pointsPairs[index][0].equals(pointsPairs[index][1]) == pointsPairsEquality[index]) {
        //System.out.println("TRUTH TEST PASSED AT RUN: " + index);             //if you want live printouts uncomment this.
      } else {
        failure = true;
        System.out.println("WE HAVE FAILED");
        System.out.println("POINT 0: " + pointsPairs[index][0].getX() + "\t" + pointsPairs[index][0].getY());
        System.out.println("POINT 1: " + pointsPairs[index][1].getX() + "\t" + pointsPairs[index][1].getY());
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
