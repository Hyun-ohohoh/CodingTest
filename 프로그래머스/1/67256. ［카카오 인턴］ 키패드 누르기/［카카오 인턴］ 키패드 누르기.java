class Solution {
    public String solution(int[] numbers, String hand) {
        int leftRow = 4;
        int leftCol = 1;
        int rightRow = 4;
        int rightCol = 3;
        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                result.append("L");
                leftCol = 1;
                if (number == 1) {
                    leftRow = 1;
                }

                if (number == 4) {
                    leftRow = 2;
                }

                if (number == 7) {
                    leftRow = 3;
                }
            }

            if (number == 3 || number == 6 || number == 9) {
                result.append("R");
                rightCol = 3;
                if (number == 3) {
                    rightRow = 1;
                }

                if (number == 6) {
                    rightRow = 2;
                }

                if (number == 9) {
                    rightRow = 3;
                }
            }


            if (number == 2 || number == 5 || number == 8 || number == 0) {
                int leftDistance = 0;
                int rightDistance = 0;
                boolean isLeft = true;
                if (number == 2) {
                    leftDistance = Math.abs(leftRow - 1) + Math.abs(leftCol - 2);
                    rightDistance = Math.abs(rightRow - 1) + Math.abs(rightCol - 2);
                    if (leftDistance < rightDistance) {
                        result.append("L");
                    } else if (leftDistance > rightDistance) {
                        result.append("R");
                        isLeft = false;
                    } else {
                        if (hand.equals("right")) {
                            result.append("R");
                            isLeft = false;
                        } else {
                            result.append("L");
                        }
                    }

                    if(isLeft) {
                        leftRow = 1;
                        leftCol = 2;
                    } else {
                        rightRow = 1;
                        rightCol = 2;
                    }
                }

                if (number == 5) {
                    leftDistance = Math.abs(leftRow - 2 )+ Math.abs(leftCol - 2);
                    rightDistance = Math.abs(rightRow - 2) + Math.abs(rightCol - 2);
                    if (leftDistance < rightDistance) {
                        result.append("L");
                    } else if (leftDistance > rightDistance) {
                        result.append("R");
                        isLeft = false;
                    } else {
                        if (hand.equals("right")) {
                            result.append("R");
                            isLeft = false;
                        } else {
                            result.append("L");
                        }
                    }

                    if(isLeft) {
                        leftRow = 2;
                        leftCol = 2;
                    } else {
                        rightRow = 2;
                        rightCol = 2;
                    }
                }

                if (number == 8) {
                    leftDistance = Math.abs(leftRow - 3) + Math.abs(leftCol - 2);
                    rightDistance = Math.abs(rightRow - 3) + Math.abs(rightCol - 2);
                    if (leftDistance < rightDistance) {
                        result.append("L");
                    } else if (leftDistance > rightDistance) {
                        result.append("R");
                        isLeft = false;
                    } else {
                        if (hand.equals("right")) {
                            result.append("R");
                            isLeft = false;
                        } else {
                            result.append("L");
                        }
                    }

                    if(isLeft) {
                        leftRow = 3;
                        leftCol = 2;
                    } else {
                        rightRow = 3;
                        rightCol = 2;
                    }
                }

                if (number == 0) {
                    leftDistance = Math.abs(leftRow - 4) + Math.abs(leftCol - 2);
                    rightDistance = Math.abs(rightRow - 4) + Math.abs(rightCol - 2);
                    if (leftDistance < rightDistance) {
                        result.append("L");
                    } else if (leftDistance > rightDistance) {
                        result.append("R");
                        isLeft = false;
                    } else {
                        if (hand.equals("right")) {
                            result.append("R");
                            isLeft = false;
                        } else {
                            result.append("L");
                        }
                    }

                    if(isLeft) {
                        leftRow = 4;
                        leftCol = 2;
                    } else {
                        rightRow = 4;
                        rightCol = 2;
                    }
                }

            }
        }

        return result.toString();
    }

}