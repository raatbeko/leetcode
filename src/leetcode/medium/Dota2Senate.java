package leetcode.medium;

import java.util.LinkedList;

public class Dota2Senate {

//    public static String predictPartyVictory(String senate) {
//        char[] charArray = senate.toCharArray();
//        int radiant = 0, rSkip = 0;
//        int dire = 0, dSkip = 0;
//        for (char c : charArray) {
//            if (c == 'R') {
//                if (rSkip > 0) {
//                    rSkip--;
//                    continue;
//                }
//                radiant++;
//                dSkip++;
//            } else {
//                if (dSkip > 0) {
//                    dSkip--;
//                    continue;
//                }
//                dire++;
//                rSkip++;
//            }
//        }
//
//        return (radiant - rSkip) > (dire - dSkip) ? "Radiant" : "Dire";
//    }

//    public static String predictPartyVictory(String senate) {
//        char[] charArray = senate.toCharArray();
//        int radiant = 0;
//        int dire = 0;
//        for (char c : charArray) {
//            if (c == 'R') {
//                if (radiant < 0) {
//                    radiant++;
//                    continue;
//                }
//                dire--;
//                radiant++;
//                if (dire > 0) {
//                    radiant--;
//                }
//            } else {
//                if (dire < 0) {
//                    dire++;
//                    continue;
//                }
//                radiant--;
//                dire++;
//                if (radiant > 0) {
//                    dire--;
//                }
//            }
//        }
//
//        return radiant > dire ? "Radiant" : "Dire";
//    }

    public static String predictPartyVictory(String senate) {
        LinkedList<Integer> r = new LinkedList<>();
        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                r.add(i);
            else d.add(i);
        }
        while (!d.isEmpty() && !r.isEmpty()) {
            Integer pollD = d.poll();
            Integer pollR = r.poll();
            if (pollD > pollR) {
                r.add(pollR + senate.length());
            } else {
                d.add(pollR + senate.length());
            }
        }

        return d.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDDR"));
    }
}
