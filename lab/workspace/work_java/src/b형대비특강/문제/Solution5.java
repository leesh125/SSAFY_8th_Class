package b형대비특강.문제;

class UserSolution {
    final int MAX_N = 10000;
    final int MAX_M = 10;

    int imgCnt, imgSize;
    int[][] imgList;
    char[][][] imgimg;

    int[] convImg(char[][] img) {
        int[] ret = new int[imgSize];
        for (int i=0; i<imgSize; ++i) {
            for (int j=0; j<imgSize; ++j) {
                ret[i] |= img[i][j]<<j;
            }
        }
        return ret;
    }

    int imgDiff(int[] img1, int[] img2) {
        int ret = 0;
        for (int i=0; i<imgSize; ++i) {
            ret += Integer.bitCount(img1[i]^img2[i]);
        }
        return ret;
    }

    void init(int N, int M, char mImageList[][][]) {
        imgCnt=N; imgSize=M;
        imgList = new int[imgCnt][];
        imgimg = mImageList;

        for (int i=0; i<imgCnt; ++i) {
            imgList[i] = convImg(mImageList[i]);
        }

    }

    int findImage(char mImage[][]) {
        int minDiff=10001, minId=0;

        int[] given = convImg(mImage);
        for (int i=0; i<imgCnt; ++i) {
            int diff = imgDiff(imgList[i], given);
            if (diff < minDiff) {
                minDiff = diff;
                minId = i+1;
            }
        }

        return minId;
    }
}

