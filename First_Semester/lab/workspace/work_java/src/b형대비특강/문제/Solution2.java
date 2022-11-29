package b형대비특강.문제;

import java.util.*;

class UserSolution {
    int h,w; //board size
    int y,x; //cursor
    int[][] cntArr; //alphabet count per line
    List<Character> board[];
    int charCnt = 0;

    void init(int H, int W, char mStr[]) {
//		System.out.println(String.format("INIT %d %d", H, W));
        h=H; w=W;
        y=x=0;
        board = new List[h];
        cntArr = new int[h][];
        for (int i=0; i<h; ++i) {
            board[i] = new LinkedList<>();
            cntArr[i] = new int['z'+1];
        }
        int cnt=0;
        for (int i=0; i<mStr.length; ++i) {
            if (mStr[i]==0) break;
            board[cnt/w].add(mStr[i]);
            cntArr[cnt/w][mStr[i]]++;
            ++cnt;
        }
        charCnt = cnt;
    }

    void insert(char mChar) {
//		System.out.println(String.format("INSERT %c", mChar));
//		for (int i=0; i<=charCnt/w; ++i)
//			System.out.println(board[i]);
        board[y].add(x, mChar);
        cntArr[y][mChar]++;
        int yy=y;
        while (board[yy].size()>w) {
            mChar = board[yy].get(w);
            board[yy].remove(w);
            cntArr[yy++][mChar]--;
            cntArr[yy][mChar]++;
            board[yy].add(0, mChar);
        }
        charCnt++;
        if (++x==w) {
            ++y; x=0;
        }
//		for (int i=0; i<=charCnt/w; ++i)
//			System.out.println(board[i]);
    }

    char moveCursor(int mRow, int mCol) {
        --mRow; --mCol;
//		System.out.println(String.format("MOVECUR %d %d", mRow, mCol));
        y=mRow; x=mCol;
//		System.out.println(mRow + ", " + mCol);
//		System.out.println(charCnt);
        if (mRow*w + mCol+1 > charCnt) {
            y = charCnt/w;
            x = charCnt%w;
            return '$';
        }
        return board[y].get(x);
    }

    int countCharacter(char mChar) {
//		System.out.println(String.format("countChar %c %d %d", mChar, y,x));
        int ret=0;
        for (int i=x; i<w; ++i)
            if (y*w+i+1<=charCnt && board[y].get(i)==mChar)
                ++ret;
        for (int i=y+1; i<=Math.min(h-1,charCnt/w); ++i)
            ret += cntArr[i][mChar];
        return ret;
    }

}