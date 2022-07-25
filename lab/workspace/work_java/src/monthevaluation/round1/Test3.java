package monthevaluation.round1;

public class Test3 {

	public static void main(String[] args) {
		int start = 1000,money = 7470,temp = 0;
		int[] nums = {1000, 500, 100, 50, 10};
		int[] c_nums = new int[5];
		int i = 0;
		
		while(i < nums.length) {
			temp = money / nums[i];
			if(temp > 0) {
				c_nums[i] = temp;
			}
			money = money % nums[i];
			i++;
		}
		
		System.out.println("투입급액 : 10000원");
		System.out.println("상품급액 : 2530원");
		System.out.println("거스름돈 : 7470원");
		System.out.println("---------------------");
		System.out.println("1000원 : " + c_nums[0] + "장");
		System.out.println("500원 : " + c_nums[1] + "장");
		System.out.println("100원 : " + c_nums[2] + "장");
		System.out.println("50원 : " + c_nums[3] + "장");
		System.out.println("10원 : " + c_nums[4] + "장");
	}

}
