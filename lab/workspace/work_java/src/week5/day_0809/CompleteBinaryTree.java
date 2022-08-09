package week5.day_0809;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 완전 이진트리
public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex; // size
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[SIZE+1]; // SIZE 개수의 노드를 저장(1인덱스부터 사용)
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public void add(char e) {
		if(isFull()) {
			System.out.println("노드를 추가할 공간이 없습니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	// 트리 전체 노드를 너비우선탐색으로 순회(탐색)
	public void bfs() {
		
		// 큐에는 노드를 탐색하는데 필요한 정보(상황에 따라 다르다) 담는다.
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 루트 노드 넣고 시작
		
		while(!queue.isEmpty()) { // 방문할 노드가 있을때까지 반복
			int current = queue.poll();
			System.out.println(nodes[current]);
			
			if(current*2<=lastIndex) queue.offer(current*2);
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void dfs() {
		
		Stack<Integer> queue = new Stack<>();
		queue.push(1); // 루트 노드 넣고 시작
		
		while(!queue.isEmpty()) { // 방문할 노드가 있을때까지 반복
			int current = queue.pop();
			System.out.println(nodes[current]);
			
			if(current*2<=lastIndex) queue.push(current*2);
			if(current*2+1<=lastIndex) queue.push(current*2+1);
		}
	}
}
