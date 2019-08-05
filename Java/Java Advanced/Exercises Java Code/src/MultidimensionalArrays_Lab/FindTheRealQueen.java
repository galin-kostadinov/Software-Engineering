package MultidimensionalArrays_Lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        for (int row = 0; row < chessBoard.length; row++) {
            String[] input = sc.nextLine().split("\\s+");

            for (int col = 0; col < chessBoard[row].length; col++) {
                chessBoard[row][col] = input[col].charAt(0);
            }
        }

        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                if (chessBoard[row][col] == 'q') {
                    boolean isRealQueen = checkIsRealQueen(chessBoard, row, col);

                    if (isRealQueen) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean checkIsRealQueen(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean colUp = checkColUp(chessBoard, rowIndex, colIndex);
        boolean colDown = checkColDown(chessBoard, rowIndex, colIndex);
        boolean rowLeft = checkRowLeft(chessBoard, rowIndex, colIndex);
        boolean rowRight = checkRowRight(chessBoard, rowIndex, colIndex);
        boolean firstDiagonalUp = checkFirstDiagonalUp(chessBoard, rowIndex, colIndex);
        boolean firstDiagonalDown = checkFirstDiagonalDown(chessBoard, rowIndex, colIndex);
        boolean secondDiagonalUp = checkSecondDiagonalUp(chessBoard, rowIndex, colIndex);
        boolean secondDiagonalDown = checkSecondDiagonalDown(chessBoard, rowIndex, colIndex);

        return colUp && colDown && rowLeft && rowRight && firstDiagonalUp
                && firstDiagonalDown && secondDiagonalUp && secondDiagonalDown;
    }

    private static boolean checkSecondDiagonalDown(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;
        int col = colIndex - 1;

        for (int row = rowIndex + 1; row < chessBoard.length; row++) {
            if (col >= 0) {
                if (chessBoard[row][col--] == 'q') {
                    return isTrue = false;
                }
            } else {
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkSecondDiagonalUp(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;
        int col = colIndex + 1;

        for (int row = rowIndex - 1; row >= 0; row--) {
            if (col < chessBoard[row].length) {
                if (chessBoard[row][col++] == 'q') {
                    return isTrue = false;
                }
            } else {
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkFirstDiagonalDown(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;
        int col = colIndex + 1;

        for (int row = rowIndex + 1; row < chessBoard.length; row++) {
            if (col < chessBoard[row].length) {
                if (chessBoard[row][col++] == 'q') {
                    return isTrue = false;
                }
            } else {
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkFirstDiagonalUp(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;
        int col = colIndex - 1;

        for (int row = rowIndex - 1; row >= 0; row--) {
            if (col >= 0) {
                if (chessBoard[row][col--] == 'q') {
                    return isTrue = false;
                }
            } else {
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkRowRight(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;

        for (int col = colIndex + 1; col < chessBoard[rowIndex].length; col++) {
            if (chessBoard[rowIndex][col] == 'q') {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkRowLeft(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;

        for (int col = 0; col < colIndex; col++) {
            if (chessBoard[rowIndex][col] == 'q') {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkColUp(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;

        for (int row = 0; row < rowIndex; row++) {
            if (chessBoard[row][colIndex] == 'q') {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }

    private static boolean checkColDown(char[][] chessBoard, int rowIndex, int colIndex) {
        boolean isTrue = true;

        for (int row = rowIndex + 1; row < chessBoard.length; row++) {
            if (chessBoard[row][colIndex] == 'q') {
                isTrue = false;
                break;
            }
        }

        return isTrue;
    }
}
