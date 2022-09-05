package week9.day_0905;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class SEOUL09_LEESEOKHYUN {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "SEOUL09_LEESEOKHYUN";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    
    static final double diameter = 5.2;
    static final double realdiameter = 5.73; // 지름
    static final double[][] HOLES = {{ 0 + diameter / 2, 0 + diameter / 2 }, { 127, 0 }, // 목표 위치 수정
            						 { 254 - diameter / 2, 0 + diameter / 2 }, 
            						 { 0 + diameter / 2, 127 - diameter / 2 }, { 127, 127 },
            						 { 254 - diameter / 2, 127 - diameter / 2 }};
    static int intercept = 35;// 중간 홀에 들어갈 수 있는 최대 절편값
    static double[][] upIntercept = new double[][] { { 0, intercept }, // 상단홀 도달 절편
    												 { TABLE_WIDTH / 2, TABLE_HEIGHT },
    												 { TABLE_WIDTH, intercept } };
    static double[][] downIntercept = new double[][] { { 0, TABLE_HEIGHT - intercept },  // 하단홀 도달 절편
    												   { TABLE_WIDTH / 2, 0 },
    												   { TABLE_WIDTH, TABLE_HEIGHT - intercept } };

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //
                // 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
                // - order: 1인 경우 선공, 2인 경우 후공을 의미
                // - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                // 예) balls[0][0]: 흰 공의 X좌표
                // balls[0][1]: 흰 공의 Y좌표
                // balls[1][0]: 1번 공의 X좌표
                // balls[4][0]: 4번 공의 X좌표
                // balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
                	
                boolean[] myTurnBalls = new boolean[6]; // 공들
                if(order == 1) {
                	// 다이위에 있는 공들 인덱스별로 true 하기
                	if (balls[1][0] != -1 && balls[3][0] == -1) { 
                		myTurnBalls[1] = true;
                	} else if (balls[1][0] == -1 && balls[3][0] != -1) {
                		myTurnBalls[3] = true;
                	} else if (balls[1][0] == -1 && balls[3][0] == -1) {
                		myTurnBalls[5] = true;
                	} else {
                		myTurnBalls[1] = true;
                		myTurnBalls[3] = true;
                	}
                }else {
                	if (balls[2][0] != -1 && balls[4][0] == -1) { 
                		myTurnBalls[2] = true;
                	} else if (balls[2][0] == -1 && balls[4][0] != -1) {
                		myTurnBalls[4] = true;
                	} else if (balls[2][0] == -1 && balls[4][0] == -1) {
                		myTurnBalls[5] = true;
                	} else {
                		myTurnBalls[2] = true;
                		myTurnBalls[4] = true;
                	}
                }
                
                double[] bestAngleNPower = getBest(balls, myTurnBalls); // 쳐야될 각도와 power
                angle = (float) bestAngleNPower[0];
                power = (float) bestAngleNPower[1];

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 다른 공과의 충돌 여부 판단 함수
    static boolean crashCheck(float[] start, double[] end, float[] otherball){
        double a = (start[1] - end[1]) / (start[0] - end[0]);
        double b = -1;
        double c = start[1] - a * start[0]; // 출발지와 목적지 사이의 일차 방정식 계수
        // 거리 구하기
        double res = Math.abs(a * otherball[0] + b * otherball[1] + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        if (res < realdiameter && (end[0] - otherball[0]) * (start[0] - otherball[0]) < 0) { //중간에 다른 공이 있거나, 지름이 작을 때 
            return true; // 충돌
        } else {
            double dx = otherball[0] - end[0];
            double dy = otherball[1] - end[1];
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));// 경로 상의 공이 아닌 치고 난 후, 마주치는 공이 있는지
            if (distance <= diameter) { // 공의 지름보다 작거나 같을 때 비교
                return true; // 충돌
            }
            return false;
        }
    }

    // 두 공 사이 거리 구하기
    static double getDistance(float[] pos1, double[] pos2) {
        return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
    }
    
    // 중단 홀 도달 각 여부를 판단하기 위한 메서드
    static boolean areaCheck(double[][] intercept, float[] ballPos){ 
        double a1 = (intercept[0][1] - intercept[1][1]) / (intercept[0][0] - intercept[1][0]);
        double b = -1;
        double c1 = intercept[0][1] - a1 * intercept[0][0];
        double a2 = (intercept[2][1] - intercept[1][1]) / (intercept[2][0] - intercept[1][0]);
        double c2 = intercept[2][1] - a2 * intercept[2][0];
        double res = (a1 * ballPos[0] + b * ballPos[1] + c1) * (a2 * ballPos[0] + b * ballPos[1] + c2);

        if (res >= 0) { // 도달 가능한 곳에 있을 경우 true
            return true;
        }
        return false;
    }

    // 칠 수 있는 공들의 후보 리스트를 리턴하는 함수(다른 공과의 충돌여부 판단, 굴절 가능 판단 
    static ArrayList<Double[]> getCandidate(float[] myPos, float[] ballPos, int ballIdx, float[][] balls) {
        ArrayList<Double[]> candidate = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (i == 1) {// 하단 득점 가능 여부
                if (!areaCheck(downIntercept, ballPos)) { 
                    continue; // 도달 X
                }
            }
            if (i == 4) {// 상단 득점 가능 여부
                if (!areaCheck(upIntercept, ballPos)) {
                    continue; // 도달 X
                }
            }
            double ballToholeRad = Math.atan2(HOLES[i][1] - ballPos[1], HOLES[i][0] - ballPos[0]);// 목적구에서 홀까지의 라디안
            double[] target = new double[] { ballPos[0] - diameter * Math.cos(ballToholeRad),
                    ballPos[1] - diameter * Math.sin(ballToholeRad) };// 타격 위치
            double radian = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);// 수구에서 타격 위치까지의 라디안
            double reflect = 90 - Math.toDegrees(radian) + Math.toDegrees(ballToholeRad); // 수구의 타격 후 굴절 각도
            boolean crash = false; // 다른 공과 충돌 여부 판단
            boolean possible = true; // 굴절이 가능 여부 판단
            
            if (80 < Math.abs(90 - reflect)) { // 굴절 불가능 시
                possible = false;
            } else { // 굴절 가능 시
                for (int j = 1; j < 6; j++) { // 다른 모든 공에 대해 충돌여부 판단
                    if (j == ballIdx || balls[j][0] == -1) // 타겟 공이거나 다이 위에 없는 공이면
                        continue; // pass
                    if (crashCheck(myPos, target, balls[j]) || crashCheck(ballPos, HOLES[i], balls[j])) { // 충돌 시
                        crash = true;
                    }
                }
            }
            if (!crash && possible) { // 충돌이 없고 굴절 가능 시 
                double angle = 90 - Math.toDegrees(radian);
                double refract = Math.abs(90 - reflect);
                double targetDist = getDistance(myPos, target);
                double holeDist = getDistance(ballPos, HOLES[i]);
                candidate.add(new Double[] { refract, angle, targetDist, holeDist });// 후보에 추가
            }
        }
        return candidate;// 후보리스트 리턴
    }

    // 	power 구하기
    static double getPower(double ballToHole, double reflect, double my2target) { 
        double m = 3.1; // 마찰계수
        double angle = Math.toRadians(reflect);// 굴절각
        double velocity1 = Math.sqrt(2 * m * ballToHole);// 초기 속도
        double velocity2 = 0;
        
        if (reflect == 0) {// 굴절각이 0일 때, 도착속도 = 목적구의 출발 속도
            velocity2 = velocity1;
        } else {// 굴절각이 있을 때, 수구 도착속도 계산
            velocity2 = velocity1 / Math.cos(angle);
        }
        
        double power = Math.sqrt(Math.pow(velocity2, 2) + 2 * m * my2target);// 타격지점에 velocity2의 속도로 도달위한 초기 속도
        
        return power;
    }
    
    // 타겟 공의 각도와 파워를 리턴하는 함수
    public static double[] getBest(float[][] inputballs, boolean[] myTurnBalls) { 
        float[][] balls = inputballs;
        double[] degreeNPower = new double[] { 90, 50 };
        float[] myPos = balls[0];
        ArrayList<Double[]> candidate = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (myTurnBalls[i]) {// 타겟 공 추출
            	ArrayList<Double[]> temp = getCandidate(myPos, balls[i], i, balls);
                for (Double[] a : temp) {
                    candidate.add(a);
                }
            }
        }
        
        // 칠 수 있는 공들을 굴절각 기준으로 정렬
        Collections.sort(candidate, new Comparator<Double[]>() {
			@Override
			public int compare(Double[] o1, Double[] o2) {
				return (int) (o1[0] - o2[0]);
			}
        });

        if (candidate.size() != 0) {
        	// 각도,힘 가져오기
        	degreeNPower = new double[] { candidate.get(0)[1], getPower(candidate.get(0)[3], candidate.get(0)[0], candidate.get(0)[2]) };
        } else { // 칠 수 있는 공이 1도 없을 경우
            for (int i = 1; i < 6; i++) {
                if (myTurnBalls[i]) { // 다이 위에 있는 아무 공을 침
                    double[] target = new double[] { inputballs[i][0], inputballs[i][1] }; // 해당 공의 좌표
                    double radian = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]); // 라디안 구하기 
                    double reflect = 90 - Math.toDegrees(radian); // 각도로 변형
                    degreeNPower = new double[] { reflect, 50 };
                    break;
                }
            }
        }
        return degreeNPower;
    }
}