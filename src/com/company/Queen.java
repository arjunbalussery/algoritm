package com.company;

import java.util.Stack;

public class Queen {
    public static void queen (int n) {
        Stack<Point> stack = new Stack<>();
        queen(0,stack);
    }

    private static boolean queen(int col, Stack<Point> stack) {
        if (col==8) {
            print(stack);
            return true;
        } else {
            for (int row=0;row<8;row++) {
                Point p =  new Point(row,col);
                if(safe (stack,p)) {
                    //chose
                    stack.push(p);
                    //explore
                    if(queen(col+1,stack)) {
                        return true;
                    }
                    //unchose
                    stack.pop();
                }

            }

        }
        return false;
    }

    private static boolean safe(Stack<Point> stack, Point p) {
        for (Point pt : stack) {
            if (pt.x==p.x || pt.y == p.y ||
                    Math.abs(p.x-pt.x) == Math.abs(p.y-pt.y)) {
                return false;
            }
        }
        return true;
    }

    private static void print(Stack<Point> stack) {
        for (Point p : stack) {
            System.out.println("row: "+p.x+" col: "+p.y);
        }
        System.out.println();
    }

    public static void knightTour(int n) {
        Stack<Point> stack = new Stack<>();
        knightTour(0,0,stack,1);
    }

    public static void knightTourFast(int n) {
        int [][] board = new int[8][8];
        knightTour(0,0,board,1);
    }

    private static boolean knightTour(int row, int col, Stack<Point> stack,int count) {
        if(count >64) {
            printKnight(stack);
            return true;
        } else {
            Point p = new Point(row,col,count);
            if (safeKnight(p,stack)) {
                //chose
                stack.add(p);
                count=count+1;
                //explore
                 //move 1 down right
                if (isvalidMove(row+2,col+1) && knightTour(row+2,col+1,stack,count)) {
                    return true;
                }


                //move 6 right down
                if (isvalidMove(row+1,col+2) && knightTour(row+1,col+2,stack,count)) {
                    return true;
                }

                //move 5 right top
                if (isvalidMove(row-1,col+2) && knightTour(row-1,col+2,stack,count)) {
                    return true;
                }

                //move 3 top right
                if (isvalidMove(row-2,col+1) && knightTour(row-2,col+1,stack,count)) {
                    return true;
                }

                //move 4 top left
                if (isvalidMove(row-2,col-1) && knightTour(row-2,col-1,stack,count)) {
                    return true;
                }

                //move 7 left top
                if (isvalidMove(row-1,col-2) && knightTour(row-1,col-2,stack,count)) {
                    return true;
                }


                //move 6 left down
                if (isvalidMove(row+1,col-2) && knightTour(row+1,col-2,stack,count)) {
                    return true;
                }


                //move 2 down left
                if (isvalidMove(row+2,col-1) && knightTour(row+2,col-1,stack,count)) {
                    return true;
                }
                //unchose
                count=count-1;
                stack.pop();
            }
        }
        return false;
    }

    private static boolean knightTour(int row, int col, int[][]board,int count) {
        if(count >64) {
            printKnight(board);
            return true;
        } else {
            if (safeKnight(row,col,board)) {
                //chose
                board[row][col]=count;
                count=count+1;
                //explore
                //move 1 down right
                if (isvalidMove(row+2,col+1,board) && knightTour(row+2,col+1,board,count)) {
                    return true;
                }


                //move 6 right down
                if (isvalidMove(row+1,col+2,board) && knightTour(row+1,col+2,board,count)) {
                    return true;
                }

                //move 5 right top
                if (isvalidMove(row-1,col+2,board) && knightTour(row-1,col+2,board,count)) {
                    return true;
                }

                //move 3 top right
                if (isvalidMove(row-2,col+1,board) && knightTour(row-2,col+1,board,count)) {
                    return true;
                }

                //move 4 top left
                if (isvalidMove(row-2,col-1,board) && knightTour(row-2,col-1,board,count)) {
                    return true;
                }

                //move 7 left top
                if (isvalidMove(row-1,col-2,board) && knightTour(row-1,col-2,board,count)) {
                    return true;
                }


                //move 6 left down
                if (isvalidMove(row+1,col-2,board) && knightTour(row+1,col-2,board,count)) {
                    return true;
                }


                //move 2 down left
                if (isvalidMove(row+2,col-1,board) && knightTour(row+2,col-1,board,count)) {
                    return true;
                }
                //unchose
                count=count-1;
                board[row][col]=0;
            }
        }
        return false;
    }

    private static boolean isvalidMove(int row, int col, int[][] board) {
        if(row >=0 && col>=0 && row <8 && col < 8 && safeKnight(row,col,board))return true;
        return false;
    }

    private static boolean safeKnight(int row, int col, int[][] board) {
        if(board[row][col] > 0) return false;
        return true;
    }

    private static void printKnight(int[][] board) {
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printKnight(Stack<Point> stack) {
        int [][] board = new int[8][8];
        for (Point p : stack) {
            board[p.x][p.y]=p.count;
        }
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static boolean isvalidMove(int row, int col) {
        if(row >=0 && col>=0 && row <8 && col < 8)return true;
        return false;
    }

    private static boolean safeKnight(Point p, Stack<Point> stack) {
        for (Point pt :  stack) {
            if(p.x==pt.x && p.y == pt.y) {
                return false;
            }
        }
        return true;
    }
}
class Point {
    int x,y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
