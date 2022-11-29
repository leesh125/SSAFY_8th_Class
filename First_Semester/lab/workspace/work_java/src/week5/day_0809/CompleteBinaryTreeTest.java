package week5.day_0809;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size = 10;
		CompleteBinaryTree tree = new CompleteBinaryTree(10);
		
		for(int i=0; i<size; i++) {
			tree.add((char)('A'+ i));
		}

//		tree.bfs();
		tree.dfs();
	}

}
