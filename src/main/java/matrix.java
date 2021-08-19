import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        int[][] a = generateMatrix(4, 4, 0, 5);
        printMatrix(a);
        System.out.format("SUM = %d", sumMatric(a));
        System.out.println();

        if (isContainX(a, 3)) {
            System.out.println("Ma trận có chứa x");
        } else System.out.println("Ma trận không chứa x");

        if (isPrimeMatrix(a)) {
            System.out.println("Ma trận toàn số nguyên tố");
        } else System.out.println("Không phải ma trận toàn số nguyên tố");


        System.out.println("Tổng đường chéo chính" + sumDuongCheoChinh(a));
        System.out.println("tổng đường chéo phụ" + sumDuongCheoPhu(a));
        System.out.println(" tổng các phần tử trên dòng " + sumPhanTuDong(a, 2));
        System.out.println(" tổng các phần tử trên cột " + sumPhanTuCot(a, 2));
        System.out.println("tổng các phần tử trên đường chéo chính " + sumPhanTuNuaTrenDuongCheoChinh(a));
        System.out.println("tổng các phần tử trên đường chéo chính " + sumPhanTuNuaDuoiDuongCheoChinh(a));

        int maxValue=maxValueMatrix(a);
        if(maxValue>0){
            System.out.println("Gía trị lớn nhất trong mảng " + maxValue);
        }
    }

    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Mời nhập số dòng");
        int r = sc.nextInt();
        System.out.println("Mời nhập số cột");
        int c = sc.nextInt();

        int[][] ret = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("a[%d][%d]", i, j);
                ret[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        return ret;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                System.out.format("%5d ", a[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int r, int c, int min, int max) {
        int[][] req = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                req[i][j] = (int) Math.floor(Math.random() * (max - min) + min);
            }
        }
        return req;
    }

    public static int sumMatric(int[][] a) {
        int s = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                s += a[i][j];
            }
        }
        return s;
    }

    public static boolean isContainX(int[][] a, int x) {

        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == x) {
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean isPrimeNumber(int n) {
        boolean ret = true;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static boolean isPrimeMatrix(int[][] a) {
        for (int i = 2, r = a.length; i < r; i++) {
            for (int j = 2, c = a[0].length; j < c; j++) {
                if (!isPrimeNumber(a[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int maxValueMatrix(int[][] a) {
        int req = a[0][0];
        for (int i = 2, r = a.length; i < r; i++) {
            for (int j = 2, c = a[0].length; j < c; j++) {
                if (a[i][j] > req) {
                    req = a[i][j];
                }
            }
        }
        return req;
    }

    public static int sumDuongCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i == j) {
                    sum += a[i][j];

                }
            }
        }
        return sum;
    }

    public static int sumDuongCheoPhu(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i + j == r - 1)
                    sum += a[i][j];

            }

        }
        return sum;
    }

    public static int sumPhanTuDong(int[][] a, int x) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i == x) {
                    sum += a[x][j];
                }
            }

        }
        return sum;
    }

    public static int sumPhanTuCot(int[][] a, int x) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (j == x) {
                    sum += a[i][x];
                }
            }

        }
        return sum;
    }

    public static int sumPhanTuNuaTrenDuongCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i < j) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumPhanTuNuaDuoiDuongCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i > j) {
                    sum += a[i][j];
                }
            }


        }
        return sum;
    }
}