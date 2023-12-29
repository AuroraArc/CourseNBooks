package bomb;

import common.IntList;

public class BombMain {
    public static void main(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct passwords to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226"); // "Figure this out. I wonder where the phases are defined..."
        }
        if (phase >= 1) {
            b.phase1(IntList.of(0,9,3,0,8)); // Figure this out too
        }
        if (phase >= 2) {
            b.phase2("j j j j j j j jjj j j j j j j j j jjj j j j j j j j j j j j j jj j j j j j j j j jj j j j j j jj j j j j j j j j j j j j j j j j " +
                    "j j j j j j  j j j j j j jj j j j j j j j jj j jjj  j j j j j j jj j j jj j  jj j jjjjj j" +
                    "nnn knn k k k k k k kkk k k kk k k k k k kk k kkk k k kkk k k kkkk kkk k k kk k k k k k k k" +
                    "  k k k k k k k k k k k k k kkk k k k kkkkk k k k k k k k k k k k k k k k k k k k k k k k" +
                    " k kk k kk k kkk k  k kk k k k  j j jj  jj j jj j j jj j j j jj j jjj j  j j j j j j j j j j" +
                    "j jj j j j j j jj j j j j j j j j j j j j  jj  j j j j j jj j jj j  j j jjj j j j j j jj j j j" +
                    " j j j j j j j j j j j j j jj j j j j j j j jj j j j j jj jj jj j j j j j j j j jj j j j j  j j jj  j" +
                    " j j j j j j j j  j j j j j j j j jj j j j j j j j j j j j jj j j j j j  j jj j j j j j  jj j j  jj  jjj " +
                    " j j j  jj j j j  j j j j j  j j j j j j j j j j j j j j j j j  jj  j j j j j j j j j  j j j j j j j jj " +
                    "j j j j j j j j j  jj j  j jj j j  jj j j j j  j jj  jj  j jj j  j j j j jj jj j j j j j j j j j j j j jj" +
                    "  j j j j jj j j j j jj j j j j jj j j jj j j j j j j j j j j j j j j j j j j j j j j j jj j j j jj j j j j" +
                    " j jj  jj j j j j j jj jj j j j j j j j j j j j j jj j j j j j j j j j jj  jj j j j j j j j j j j jj j j j " +
                    "j j j j j j j j j j j jj j j j j j j j j j j j j j j jj j j j j j j j j j j jj j j j j j j j j j jj j j j j j j " +
                    " jj j j j j j j j j j jj j j j j j j jj j j j j j j j j j j j j j j j j j j j j j j j jj j j j j j j j j jj " +
                    " j j j j j j j j j j j j jj j j jj j j j j j j j j j j j j j j j j j j j j j j j j j jj j jj j j j j j j j jj " +
                    "j j j j j j j jj j j j j j j  jj j  j j j jj  jj j j j j j j j j j jj j j j j j jj j j j j j j j j j jj j j j " +
                    " j jj j j j  jj j j j j j j jj j j j j j j j j j j jj j j j  j  j j j j  j j  j j j j j j j j j j j j j j j j j" +
                    " jj j j j j j j j j j j j j jj j j jj j j j j j j j j j j j j j j j j j j j j j j j j j j j j j jj  j j jj j j " +
                    " j j j j j j j  j j j j j j jj  j j j j j j jj j j j j j j j j j j j j j j j j j jj j j j j j j j j j j j j jj j" +
                    " jj j j j j j jj j j j j j j j j jj j j j j j j j j j j j j jj j j j j j j j j jj j j j j j j j j jj j j jj j j j j" +
                    " jj j j j j j j j j j j jj j j j j j j j j j j jj j j j j j j j jj j j j j j j j j j j j j j jj j j j j jj j j j j j" +
                    " j j j j j j jj  jj j j j j j j j j j j j jj j j j j j j j j jj j j j j j j j j j j j j j j j j j j j j jj j j j j j" +
                    "jjjjjjjj j j j j j j j j j jj j j j j j j j j j j j j j j jj j j j j j j j j j j j jj j j j j j j j j j jj j j  jj j j " +
                    "j j j j j j j j j j j j j j j j j j j j j j j jj  jj j j j j j j j j j j j j j j j j j j j j j j j j jj  j j j j j j j" +
                    " " +
                    "j j j j  j j j jj j j j j j j j jj j j j j j j j j j j j jj j j j j j j j j j j j j j j j j j j j j j jjj  jj j j j j " +
                    " j j j j j j  j jj j j j j j j j j j j j j j j j j j jj j j j j j j j j j j j j j j j j j j j j jj j j j j -81201430"); // "Figure this out. I wonder where the phases are defined..."
        }
    }
}
