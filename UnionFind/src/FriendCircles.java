import java.util.HashSet;

//leetcode 547 friend circles
public class FriendCircles {
	public int findCircleNum(int[][] M) {
		UnionFind1 uf = new UnionFind1(M.length);
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < i; j++) {
				if (M[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < M.length; i++) {
			set.add(uf.find(i));
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		FriendCircles fc = new FriendCircles();
		int[][] M = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println("number of friend circle : " + fc.findCircleNum(M));
	}
}
