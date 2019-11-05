package com.company;

import java.util.Scanner;

public class TreeCompression {

    public static int check(int[] deg) {                        //ham kiem tra dieu kien dung
        int count = 0;
        int check = 1;
        for (int i = 1; i < deg.length; i++) {
            if (deg[i] > 1) {                                   //dinh bac > 1 -> CONTINUE
                break;
            }
            if (deg[i] == 1) {
                count++;
            }
        }
        if (count == 1 && deg[0] == 1) {                        //con 1 dinh noi voi 0 -> STOP
            check = 0;
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("So canh: ");
        int links = sc.nextInt();
        int point = links + 1;
        int[] deg = new int[point];                        //array chua degree cua moi dinh
        for (int i = 0; i < point; i++) {                  //khoi tao cac dinh deu bac 0
            deg[i] = 0;
        }
        int[][] link = new int[links][2];                  //array cac canh
        for (int i = 0; i < links; i++) {                  //nhap cac canh
            System.out.println("Canh thu " + (i + 1) + ": ");
            link[i][0] = sc.nextInt();
            link[i][1] = sc.nextInt();
            deg[link[i][0]]++;                             //dem so bac moi dinh them vao
            deg[link[i][1]]++;
        }

        System.out.println("Prufer Code: ");
        for (int i = 1; i < point; i++) {
            if (check(deg) == 1) {
                int min = point + 1;
                for (int j = 1; j < point; j++) {
                    if (deg[j] == 1 && j < min) {
                        min = j;
                    }
                }
                deg[min]--;                                          //xoa dinh min
                for (int j = 0; j < links; j++) {                    //xoa canh noi voi dinh min
                    if (link[j][0] == min && deg[link[j][1]] > 0) {
                        deg[link[j][1]]--;
                        System.out.print(link[j][1] + " ");
                    }
                    if (link[j][1] == min && deg[link[j][0]] > 0) {
                        deg[link[j][0]]--;
                        System.out.print(link[j][0] + " ");
                    }
                }
            }
        }
    }
}
