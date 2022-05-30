import java.io.IOException;
import java.util.Scanner;

public class Sudoku {
  static boolean correct(int[][] board,int n,int i,int j,int index) {
	  for(int l=0;l<n;l++) {
		  if(board[l][j]==index) {
			  return false;
		  }
	  }
	  for(int l=0;l<n;l++) {
		  if(board[i][l]==index) {
			  return false;
		  }
	  }
	  int h=(int)Math.sqrt(n);
	  int boxRowStart=i-i%h;
	  int boxColStart=j-j%h;
	  for(int l=boxRowStart;l<boxRowStart+h;l++) {
		  for(int m=boxColStart;m<boxColStart+h;m++) {
			 if(board[l][m]==index) {
				return false; 
			 }
		  }
	  }
	  return true;
  }
  static boolean Solve(int[][] board,int n) {
	 int row=-1;
	 int col=-1;
	 boolean isEmpty=true;
	 for(int i=0;i<n;i++) {
		 for(int j=0;j<n;j++) {
			 if(board[i][j]==0) {
				 row=i;
				 col=j;
				 isEmpty=false;
				 break;
			 }
		 }
		 if(!isEmpty) {
			break; 
		 }
	 }
	 if(isEmpty) {
		 return true;
	 }
	 for(int k=1;k<=9;k++) {
		 if(correct(board,n,row,col,k)) {
			 board[row][col]=k;
			 if(Solve(board,n)) {
				 return true;
			 }
			 else {
				 board[row][col]=0;
			 }
		 }
	 }
	 return false;
  }
  public static void main(String[] args)throws IOException {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[][] board=new int[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			board[i][j]=sc.nextInt();
		}
	}
	if(Solve(board,n)) {
	  for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			System.out.print(board[i][j]+" ");
		}
		System.out.println();
	  }
	}
  }
}
