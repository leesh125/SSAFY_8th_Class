package b형대비특강.문제;

import java.util.*;

class UserSolution {
    final int MAXN=50010;
    int[] y,x;
    boolean[] del, cannot;

    final int maxSize = 10000;

    List<Integer> row[];
    List<Integer> col[];
    List<Integer> diag1[]; // /
    List<Integer> diag2[]; // \

    List<Integer> visitedPlace[];

    void init() {
        y = new int[MAXN];
        x = new int[MAXN];
        del = new boolean[MAXN];
        cannot = new boolean[MAXN];

        row = new List[maxSize];
        col = new List[maxSize];
        diag1 = new List[2*maxSize];
        diag2 = new List[2*maxSize];

        for (int i=0; i<maxSize; ++i) {
            row[i] = new ArrayList<>();
            col[i] = new ArrayList<>();
        }
        for (int i=0; i<2*maxSize; ++i) {
            diag1[i] = new ArrayList<>();
            diag2[i] = new ArrayList<>();
        }

        visitedPlace = new List[maxSize];
        for (int i=0; i<maxSize; ++i)
            visitedPlace[i] = new ArrayList<>();
    }

    void addPlace(int pID, int r, int c) {
        y[pID] = r;
        x[pID] = c;

        int idx = 0;
        for (idx=0; idx<row[r].size(); ++idx) {
            if (c<x[row[r].get(idx)]) {
                break;
            }
        }
        row[r].add(idx, pID);

        for (idx=0; idx<col[c].size(); ++idx) {
            if (r<y[col[c].get(idx)]) {
                break;
            }
        }
        col[c].add(idx, pID);

        for (idx=0; idx<diag1[r+c].size(); ++idx) {
            if (c<x[diag1[r+c].get(idx)]) {
                break;
            }
        }
        diag1[(r+c)].add(idx, pID);

        for (idx=0; idx<diag2[(r-c+2*maxSize)%(2*maxSize)].size(); ++idx) {
            if (c<x[diag2[(r-c+2*maxSize)%(2*maxSize)].get(idx)]) {
                break;
            }
        }
        diag2[(r-c+2*maxSize)%(2*maxSize)].add(idx, pID);
    }

    void removePlace(int pID) {
        del[pID]=true;
    }

    int getPlace(int dir, int id) {
        int yy=y[id], xx=x[id];

        if (dir==0) {
            // up
            int idx = 0;
            for (int i=0; i<col[xx].size(); ++i)
                if (col[xx].get(i)==id) {
                    idx = i;
                    break;
                }

            while (true) {
                --idx;
                int next = col[xx].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==4) {
            // down
            int idx = 0;
            for (int i=0; i<col[xx].size(); ++i)
                if (col[xx].get(i)==id) {
                    idx = i;
                    break;
                }

            while (true) {
                ++idx;
                int next = col[xx].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }


        } else if (dir==2) {
            // right
            int idx = 0;
            for (int i=0; i<row[yy].size(); ++i)
                if (row[yy].get(i)==id) {
                    idx = i;
                    break;
                }

            while (true) {
                ++idx;
                int next = row[yy].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==6) {
            // left
            int idx = 0;
            for (int i=0; i<row[yy].size(); ++i)
                if (row[yy].get(i)==id) {
                    idx = i;
                    break;
                }
            while (true) {
                --idx;
                int next = row[yy].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==1) {
            // right up
            int idx = 0;
            for (int i=0; i<diag1[xx+yy].size(); ++i)
                if (diag1[xx+yy].get(i)==id) {
                    idx = i;
                    break;
                }
            while (true) {
                ++idx;
                int next = diag1[xx+yy].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==5) {
            // left down
            int idx = 0;
            for (int i=0; i<diag1[xx+yy].size(); ++i)
                if (diag1[xx+yy].get(i)==id) {
                    idx = i;
                    break;
                }
            while (true) {
                --idx;
                int next = diag1[xx+yy].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==7) {
            // left up
            int idx = 0;
            for (int i=0; i<diag2[(yy-xx+2*maxSize)%(2*maxSize)].size(); ++i)
                if (diag2[(yy-xx+2*maxSize)%(2*maxSize)].get(i)==id) {
                    idx = i;
                    break;
                }
            while (true) {
                --idx;
                int next = diag2[(yy-xx+2*maxSize)%(2*maxSize)].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        } else if (dir==3) {
            // right down
            int idx = 0;
            for (int i=0; i<diag2[(yy-xx+2*maxSize)%(2*maxSize)].size(); ++i)
                if (diag2[(yy-xx+2*maxSize)%(2*maxSize)].get(i)==id) {
                    idx = i;
                    break;
                }
            while (true) {
                ++idx;
                int next = diag2[(yy-xx+2*maxSize)%(2*maxSize)].get(idx);
                if (del[next] || cannot[next])
                    continue;
                return next;
            }

        }

        return 0;
    }

    void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {
        int cnt=0;
        int id = moveInfo[0];
        visitList[cnt++] = id;
        visitedPlace[uID].add(id);
        for (int i=1; i<visitNum; ++i) {
            int dir = moveInfo[i];
            id = getPlace(dir, id);
            visitList[cnt++] = id;
            visitedPlace[uID].add(id);
        }

        for (int i=0; i<visitNum; ++i) {
            cannot[visitList[i]] = true;
        }

    }

    void disinfectPlaces(int uID) {
        for (int id: visitedPlace[uID]) {
            cannot[id] = false;
        }
        visitedPlace[uID].clear();
    }
}
