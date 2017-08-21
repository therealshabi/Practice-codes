import java.util.*;

public class automata
{
   static final int no_of_chars = 256; 
   static int n;
   static int m;
   static int TF[][];
	public static void main(String args[])
	{
      String txt="aaababaabaababaab";
      String patt="aabab";
      n=txt.length();
      m=patt.length();
      int lps=0;
      TF=new int[m+1][no_of_chars];
      for(int i=0;i<no_of_chars;i++)
      TF[0][i]=0;
      TF[0][patt.charAt(0)]=1;
      for(int i=1;i<=m;i++)
      {
        for(int j=0;j<no_of_chars;j++)
        TF[i][j]=TF[lps][j];

        if(i!=m)
        TF[i][patt.charAt(i)]=i+1;   //When pattern comes we jump to next state
 
        if(i<m)
        lps=TF[lps][patt.charAt(i)];
      }
       int j=0;
      for(int i=0;i<n;i++)
      {
         j=TF[j][txt.charAt(i)];
         if(j==m)
         {
           System.out.println("Pattern Found Successfully at index : "+(i-m+1));
           
         }
      }
	}
}