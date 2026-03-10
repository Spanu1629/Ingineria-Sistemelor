void main() {
    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    List<Integer> xPlusY = new ArrayList(); //a
    Set<Integer> zSet = new TreeSet(); //b
    List<Integer> xMinusY = new ArrayList();//c
    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList(); //d
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
        x.add(random.nextInt(11));
    }

    for (int i = 0; i < 7; i++) {
        y.add(random.nextInt(11));
    }

    Collections.sort(x);
    Collections.sort(y);

    System.out.println("x = " + x);
    System.out.println("y = " + y);

    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("x + y = " + xPlusY);
    for (Integer nr : x) {
        if (y.contains(nr)) {
            zSet.add(nr);
        }
    }
    System.out.println("zSet = " + zSet);
    for (Integer nr : x) {
        if (!y.contains(nr)) {
            xMinusY.add(nr);
        }
    }
    System.out.println("x - y = " + xMinusY);
    for (Integer nr : x) {
        if (nr <= p) {
            xPlusYLimitedByP.add(nr);
        }
    }

    for (Integer nr : y) {
        if (nr <= p) {
            xPlusYLimitedByP.add(nr);
        }
    }
    Collections.sort(xPlusYLimitedByP);
    System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);
}

