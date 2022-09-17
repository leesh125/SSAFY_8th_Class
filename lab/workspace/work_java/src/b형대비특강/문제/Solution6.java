package b형대비특강.문제;

import java.util.*;

class UserSolution {
    int lineN, eqN, curTime;
    Map<Integer, Item> task;
    Map<Integer, Integer> status;
    Deque<Integer>[] lineQ;
    boolean[] isFree;
    int[] inuse, startTime;
    Item[] working;

    static class Item {
        int reqTime, id, line, eq, time;
        Item(int a, int b, int c, int d, int e) {
            reqTime=a; id=b; line=c; eq=d; time=e;
        }
    }

    void checkDone() {
        for (int i=0; i<lineN; ++i) {
            if (isFree[i]) continue;
            int eq = working[i].eq;
            if (inuse[eq]==i && curTime == startTime[i]+working[i].time) {
//				System.out.println("line " + i + "curTime " +curTime);
                status.put(working[i].id, 3);
                inuse[eq] = -1;
                isFree[i] = true;
                working[i] = null;
            }
        }
    }

    void insertNext() {
        for (int i=0; i<lineN; ++i) {
            if (!isFree[i]) continue;
            if (lineQ[i].isEmpty()) continue;
            working[i] = task.get(lineQ[i].pop());
            isFree[i] = false;
        }
    }

    void checkStart() {
        for (int i=0; i<lineN; ++i) {
            if (isFree[i]) continue;
            int eq = working[i].eq;
            if (inuse[eq]==-1) {
                inuse[eq] = i;
                startTime[i] = curTime;
                status.put(working[i].id, 2);
            }
        }
    }

    void init(int L, int M) {
        lineN = L;
        eqN = M;

        curTime = 0;
        task = new HashMap<>();
        status = new HashMap<>();
        isFree = new boolean[lineN+1];
        inuse = new int[eqN+1];
        startTime = new int[lineN+1];
        working = new Item[lineN+1];
        Arrays.fill(isFree, true);
        Arrays.fill(inuse, -1);
        Arrays.fill(startTime, Integer.MIN_VALUE);

        lineQ = new Deque[lineN+1];
        for (int i=0; i<=lineN; ++i)
            lineQ[i] = new ArrayDeque<>();

    }

    int request(int tStamp, int pId, int mLine, int eId, int mTime) {
        Item item = new Item(tStamp, pId, mLine, eId, mTime);
        task.put(pId, item);

        while (curTime < tStamp) {
            checkDone();
            insertNext();
            checkStart();
            ++curTime;
        }

        lineQ[mLine].add(pId);
        status.put(pId, 1);

        checkDone();
        insertNext();
        checkStart();
        ++curTime;

        if (isFree[mLine]) return -1;
        int x = inuse[working[mLine].eq];
        if (x==-1 || x!=mLine) return -1;
        return working[mLine].id;
    }

    int status(int tStamp, int pId) {
        while (curTime <= tStamp) {
            checkDone();
            insertNext();
            checkStart();
            ++curTime;
        }
        Integer res = status.get(pId);
        return res==null ? 0 : res;
    }
}