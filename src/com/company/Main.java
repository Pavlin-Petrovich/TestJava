package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] digitals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrSplit = str.split("");
        String result = "";
        String result2 = "";
        String[] array;
        String str2 = "";
        for (int open = 0; open < str.length(); open++) {

            if (strArrSplit[open].equals("[")) {

                for (int close = open + 1; close < str.length(); close++) {

                    if (strArrSplit[close - 1].equals("/") && strArrSplit[close].equals("]")) {
                        String number = "";
                        strArrSplit[open] = "/";
                        strArrSplit[close] = "/";

                        for (int j = open - 1; j > -1; j--) {
                            if (strArrSplit[j].equals("]") || strArrSplit[j].equals("[")) break;
                            number += strArrSplit[j];
                        }
                        array = number.split("");
                        number = "";
                        for (int j = array.length - 1; j > -1; j--) {
                            number += array[j];
                        }
                        int h = Integer.parseInt(number);
                        result2 = result;
                        for (int j = 0; j < h - 1; j++) {
                            result2 += result;
                        }


                        boolean yh = true;
                        if (close != strArrSplit.length - 1) {
                            for (int j = close + 1; j < str.length(); j++) {
                                for (String u : digitals)
                                    if (strArrSplit[j].equals(u)) {
                                        yh = false;
                                        break;
                                    }

                                if (strArrSplit[j].equals("]")) {
                                    strArrSplit[j - 1] = "/";
                                    break;
                                }

                                if (yh) {
                                    result2 += strArrSplit[j];
                                    strArrSplit[j] = " ";
                                    strArrSplit[close] = "/";
                                }
                                if (!yh) break;
                                if (strArrSplit[close - 1].equals("/") && strArrSplit[close].equals("]")) break;
                            }
                        } else {
                            strArrSplit[close] = "/";
                        }
                        result = result2;
                    }

                    if (strArrSplit[close].equals("]") && !strArrSplit[close - 1].equals("]") && !strArrSplit[close - 1].equals("/")) {
                        strArrSplit[open] = "/";

                        for (int j = close - 1; j > -1; j--) {

                            if (strArrSplit[j].equals("]")) {
                                strArrSplit[j] = "/";
                                break;
                            }
                            if (strArrSplit[j].equals("[")) break;
                            if (!strArrSplit[j].equals(" ")) {
                                str2 += strArrSplit[j];
                            }


                        }

                        array = str2.split("");
                        str2 = "";
                        for (int j = array.length - 1; j > -1; j--) {
                            str2 += array[j];
                        }
                        array = str2.split("/");

                        int g = Integer.parseInt(array[0]);
                        for (int j = 0; j < g; j++) {
                            result += array[1];
                        }
                        str2 = "";
                        boolean uu = true;
                        if (close != str.length() - 1)
                            for (int j = close + 1; j < str.length(); j++) {
                                for (String u : digitals)
                                    if (strArrSplit[j].equals(u)) {
                                        uu = false;
                                        break;
                                    }

                                if (strArrSplit[j].equals("]")) {
                                    strArrSplit[j - 1] = "/";
                                    strArrSplit[close] = "/";
                                    break;
                                }

                                if (uu) {
                                    result += strArrSplit[j];
                                    strArrSplit[j] = " ";
                                }
                                if (!uu) break;

                            }
                        if (strArrSplit[close].equals("]") && !strArrSplit[close - 1].equals("]") && !strArrSplit[close - 1].equals("/"))
                            break;
                        if (strArrSplit[close].equals("/")) break;
                    } else if (strArrSplit[close].equals("[")) {
                        strArrSplit[open] = "[";
                        break;
                    }
                }

            } else if (strArrSplit[open].equals("]") && strArrSplit[open - 1].equals("/")) {
                open = -1;

            }
        }

        if (!result2.equals("")) {
            System.out.println(result2);
        } else {
            System.out.println(result);
        }
    }
}


