
/**
 * Write a description of peg_solitaire_game here.
 * 
 * @author VARDAAN KAPOOR
 * @version 15TH JULY 2022
 */
import java.util.Scanner;//import scanner class

public class peg_solitaire_game {
public static int readValidInt(Scanner in,String prompt,int min,int max)
{
    int our_val=in.nextInt();
    
    while (true)//keep running the loop until valid value is returned
    {
        if(our_val>=1 && our_val<=4)
        {
            return our_val;
        }
        else{
            System.out.println(prompt+" "+min+"and "+max);
            in=new Scanner(System.in);
            our_val=in.nextInt();
        }}
    
}
public static char[][] createBoard(int BoardType)
{
    char [][] localarray=null;//initially make array variable point to "nowhere"
     switch(BoardType)// used switch statement for each type of board
    {
        case 1:
        localarray=new char[7][9];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<9;j++)
            {
                
                if((i==0 || i==1 || i==5 || i==6) && (j!=3 && j!=4 && j!=5))
                {
                    localarray[i][j]='#';
                }
                else{
                    localarray[i][j]='@';
                }
                 if(i==3 && j==4)
                {
                    localarray[i][j]='-';
                }
               }}
               
               break;
                
        case 2:
        localarray=new char[6][6];
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(((i==0 || i==5) && (j==1 || j==4)) || ((i==1 || i==4) && (j==0 || j==5)))
                {
                    localarray[i][j]='-';
                }
                else if((i==0 || i==5)&&(j==0 || j==5))
                {
                    localarray[i][j]='#';
                }
                else{
                    localarray[i][j]='@';
                }}}
                
                break;
                
        case 3:
        localarray=new char[4][9];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(i<3 &&(j<(4-(i+1)) || j>(4+(i+1))))
                {
                    localarray[i][j]='#';
                }
                else if(j==(4-(i+1)) || j==(4+(i+1)))
                {
                    localarray[i][j]='-';
                }
                else{
                    localarray[i][j]='@';
                }
                if(i==2 && j==4)
                {
                    localarray[i][j]='-';
                }
            }}
            /*for(int i=0;i<4;i++)
                {
                    for(int j=0;j<9;j++)
                    {
                        System.out.print(localarray[i][j]);
                    }
                    System.out.println();
                }*/
            break;
            
        case 4:
        localarray=new char[5][5];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(i==1 && (j==1 || j==2 || j==3))
                {
                    localarray[i][j]='@';
                }
                else if((i==2 || i==3) && j==2)
                {
                    localarray[i][j]='@';
                }
                else{
                    localarray[i][j]='-';
                }}}
                
                break;
                
            }
            // didn't use default statement as it wasn't needed because we have checked the validity of user's input by another method
       return localarray;
        }        
  public static void displayBoard(char[][] Board)
  {
     int row_l=Board.length;
     int column_l=Board[0].length;
     System.out.print("  ");
     for(int k=1;k<=column_l;k++)//print column numbers
     {
         System.out.print(k);
        }
        System.out.println();
        for(int i=0;i<row_l;i++)
        {
            System.out.print((i+1)+" ");//print row numbers
            for(int j=0;j<column_l;j++)
            {
                System.out.print(Board[i][j]);
            }
            System.out.println();
        }}
 public static int[] readValidMove(Scanner in,char[][] Board)
 {
    int row_l=Board.length;
    int col_l=Board[0].length;
    int row_n=in.nextInt();
    while(true)//keep running loop until valid row value is given
    {
        
    if(row_n<1 || row_n>row_l)
    {
        System.out.println("PLease enter an integer between 1 and "+row_l);
        in=new Scanner(System.in);
        row_n=in.nextInt();
    }
    else{
        break;}}
    System.out.println("Enter column number of peg you want to move");
    in=new Scanner(System.in);
    int col_n=in.nextInt();
    while(true)
    {
        if(col_n<1 || col_n>col_l)
        {
            System.out.println("PLease enter an integer between 1 and "+col_l);
            in=new Scanner(System.in);
            col_n=in.nextInt();
        }
        else{
            break;}}
            System.out.println("Please give direction of movement");
            System.out.println("1)UP\n2)DOWN\n3)LEFT\n4)RIGHT");
            in=new Scanner(System.in);
            int dir=in.nextInt();
            while(true)
            {
                if(dir<1 || dir>4)
                {
                    System.out.println("Enter direction number between 1 and 4");
                    in=new Scanner(System.in);
                    dir=in.nextInt();
                }
                else{
                    break;}}
            int[] collectarray={row_n,col_n,dir};
            return collectarray;
        }
  public static boolean isValidMove(char[][] Board,int row,int column,int direction)
  {
      
      if(Board[row][column]=='@')
      {
         switch(direction)//used switch case for each direction movement
         {
             case 1:
              if(row>1 && Board[row-1][column]=='@' && Board[row-2][column]=='-')//atleast 2 spaces above our peg
              {
                  return true;}
                  else{
                      return false;}
             case 2:
             int maxpossrow=Board.length-2;
             if(row<maxpossrow && Board[row+1][column]=='@' && Board[row+2][column]=='-')
             {
                 return true;}
                 else{
                     return false;}
             case 3:
             if(column>1 && Board[row][column-1]=='@' && Board[row][column-2]=='-')
             {
                 return true;}
                 else{
                     return false;}
             case 4:
             if(column<Board[0].length-2 && Board[row][column+1]=='@' && Board[row][column+2]=='-')
             {
                 return true;}
                 else{
                     return false;}
                    
                    default:
                    return false;}
                }
                else{
                    return false;}}
                    // no default needed as direction given by user was verified by another methood
public static char[][] performMove(char[][] Board,int row,int column,int direction)
{
     Board[row][column]='-';//remove original peg-common for all directions
    switch(direction)
    {
        case 1:
        Board[row-2][column]='@';
        Board[row-1][column]='-';
        break;
       
        case 2:
        Board[row+2][column]='@';
        Board[row+1][column]='-';
        break;
        case 3:
        Board[row][column-2]='@';
        Board[row][column-1]='-';
        break;
        case 4:
        Board[row][column+2]='@';
        Board[row][column+1]='-';
        break;
    }
    return Board;}
    public static int countPegsRemaining(char[][] Board)
    {
        int c=0;
        for(int i=0;i<Board.length;i++)
        {
            for(int j=0;j<Board[0].length;j++)
            {
                if(Board[i][j]=='@')
                {
                    c+=1;
                }}}
                return c;}
 public static int countMovesAvailable(char[][] Board)
 
 {
     // we take each peg and find possibility of its movements in all 4 directions-we do this for all pegs available
     int c=0;
     for(int i=0;i<Board.length;i++)
     {
         for(int j=0;j<Board[0].length;j++)
         {
             if(Board[i][j]=='@')
             {
                 if(isValidMove(Board,i,j,1))
                 {
                     c+=1;}
                     if(isValidMove(Board,i,j,2))
                 {
                     c+=1;}
                     if(isValidMove(Board,i,j,3))
                 {
                     c+=1;}
                     if(isValidMove(Board,i,j,4))
                 {
                     c+=1;}
                    }}}
       return c;  
    }
public static void main()
{
    
    System.out.println("Board Style Menu\n1)Cross\n2)Circle\n3)Triangle\n4)Simple T");
    System.out.println("Choose a board style");
    Scanner sc=new Scanner(System.in);
    String pr="Please enter an integer between";
    int correctval=readValidInt(sc,pr,1,4);
    char[][] b;
    b=createBoard(correctval);
    displayBoard(b);
    Boolean check=false;
    int chances=1;
    //until and unless a valid move remains we play the game
    while(chances>0)
    {
        check=false;
    while (check==false)
     {   
    System.out.println("Please enter row of peg you want to move");
    sc=new Scanner(System.in);
    int [] validmove=new int[3];
    validmove=readValidMove(sc,b);
    /*for(int i=0;i<3;i++)
    {
        System.out.println(validmove[i]);
    }*/

    check=isValidMove(b,validmove[0]-1,validmove[1]-1,validmove[2]);
    if(check==false)
    {
        System.out.println("you inputted a wrong or invalid move-please try again with a valid move");}

else{
    b=performMove(b,validmove[0]-1,validmove[1]-1,validmove[2]);
displayBoard(b);
int count=countPegsRemaining(b);

System.out.println(count);
if(count==1)// when only 1 peg remains we win
{
    System.out.println("you won");
}

 chances=countMovesAvailable(b);
 if(count>1)// if count of pegs available<1 and chances<1 then person loses
 {
if( chances>0)

{
System.out.println("come on player-you have "+chances+" different paths at this stage to win the game"); 
}
else {
    System.out.println("sorry you lost");

}
}
}

}
}
}
}
