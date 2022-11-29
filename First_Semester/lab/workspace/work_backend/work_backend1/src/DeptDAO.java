import java.sql.*;
import java.util.*;

// DAO : Data Access Object
// MVC 패턴에서 Model에 해당한다.
// 데이터를 핸들링하는 로직을 담은 객체?
// 테이블 단위로 많이 만든다.

public class DeptDAO {

    static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";
    static final String DB_USER = "ssafy";
    static final String DB_PASS = "ssafy";

    // step1. Driver Class 로딩, 등록
    static {
        try {
            Class.forName(DRIVER_CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 부서 하나 등록 (필요한 정보 : 부서번호, 부서이름, 위치)
    public int insertDept(Dept dept) {

        Connection conn = null;
        PreparedStatement pstmt= null;
        String sql = "insert into dept(deptno, dname, loc) values(?,?,?)"; // 데이터만 ? 줄 수 있음
        try {
            // step2
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // step3. 통로 만들기
            pstmt = conn.prepareStatement(sql);

            // step4. 실행
            pstmt.setInt(1, dept.getDeptNo()); // ? 채우기
            pstmt.setString(2, dept.getDname());
            pstmt.setString(3, dept.getLoc());
            int rowCnt = pstmt.executeUpdate();

            System.out.println(rowCnt + "행이 처리되었습니다.");

            return rowCnt;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // step5 (항상 실행되어야 함)
            if (pstmt!= null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return 0;
    }

    // 부서 전체 조회
    public List<Dept> selectDepts() {
        Connection conn = null;
        PreparedStatement pstmt= null;
        ResultSet rs = null;
        ArrayList<Dept> list = new ArrayList<Dept>();
        String sql = "select deptno, dname, loc from dept"; 
        try {
            // step2
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // step3. 통로 만들기
            pstmt = conn.prepareStatement(sql);

            // step4. 실행
            rs = pstmt.executeQuery();

            // step5. 
            while(rs.next()) {
                list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // step5 (항상 실행되어야 함)
            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (pstmt!= null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}