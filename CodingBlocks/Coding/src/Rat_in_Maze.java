import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rat_in_Maze {
  static void solMaze(List<List<Character>> list,List<Character> l,int N,int M,int[][] visited,int i,int j) {
	 if(i==N && j==M) {
		 List<Character> lp=new ArrayList<>();
		 lp.addAll(l);
		 list.add(lp);
		 return;
	 }
	 visited[i-1][j-1]=1;
	 if(i+1<=N && visited[i][j-1]==0) {
	    l.add('V');
	    solMaze(list,l,N,M,visited,i+1,j);
	    l.remove(l.size()-1);
	 }
	 if(j+1<=M && visited[i-1][j]==0) {
	   l.add('H');
	   solMaze(list,l,N,M,visited,i,j+1);
	   l.remove(l.size()-1);
	 }
	 if(i+1<=N && j+1<=M && visited[i][j]==0) {
		l.add('D'); 
		solMaze(list,l,N,M,visited,i+1,j+1);
		l.remove(l.size()-1);
	 }
	 visited[i-1][j-1]=0;
  }
  public static void main(String[] args) throws IOException{
	 Scanner sc=new Scanner(System.in);
	 int N=sc.nextInt();
	 int M=sc.nextInt();
	 int[][] visited=new int[N][M];
	 for(int[] rows:visited) {
		 Arrays.fill(rows,0);
	 }
	 List<List<Character>> list=new ArrayList<>();
	 List<Character> l=new ArrayList<>();
	 solMaze(list,l,N,M,visited,1,1);
	 for(List<Character> lo:list) {
		StringBuilder sb=new StringBuilder();
		for(Character ch:lo) {
			sb.append(ch);
		}
		System.out.print(sb.toString()+" ");
	 }
	 System.out.println();
	 System.out.println(list.size());
	 sc.close();
  }
}
