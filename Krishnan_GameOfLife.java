/***************************************************************
* file: Krishnan_GameofLife.java
* author: Kimberlyn Krishnan
* class: CS 141 – Programming and Problem Solving
*
* assignment: program 6
* date last modified: 6/9/2016
*
* purpose: this program implements Conway's Game of Life.
*
****************************************************************/
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Krishnan_GameOfLife {

private static char [][] game;
private static char [] temp;
private static char [][] tempBoard;
private static String fileName;
private static int numberOfGenerations;
private static int column;
private static int row;
private static int input;
private static int generation;
private static int value;
private static int aliveCount;
private static int v = 1;

// method: constructor
// purpose: initializes a new game board
public Krishnan_GameOfLife() throws IOException {

Scanner kb = new Scanner(System.in);
System.out.print("Enter file name: ");
fileName = kb.nextLine();

File file = new File(fileName);
if (file.exists())
{
Scanner inputFile = new Scanner(file);

column = inputFile.nextInt();
row = inputFile.nextInt();
game = new char [row][column];
inputFile.nextLine();
temp = new char [row*column];
int k = 0;

while (inputFile.hasNext())
{
temp[k] = inputFile.next().charAt(0);
k++;
} // while loop

int y = 0;
for (int r = 0; r < game.length; r++)
{
  for (int c = 0; c < game[r].length; c++)
  {
    game[r][c] = temp[y];
    y++;
  }
}

} else {
System.out.println("Error file not found.");
Krishnan_GameOfLife p = new Krishnan_GameOfLife();
}

} // ends constructor

// method: getColumns
// purpose: return number of columns in the game board
public int getColumns() {
return column;
}

// method: getRows
// purpose: return number of rows in the game board
public int getRows(){
return row;
}

// method: getCell
// purpose: get the value of the cell at given column and row
public int getCell(int column, int row) {

try {

   if (game[row][column] == '0')
   {
    value = 1;
   } // if
   if (game[row][column] == 'X')
   {
     value = 2;
   } // if

} catch (ArrayIndexOutOfBoundsException whoops) {
        return 0;
}
return value;

} //ends method


// method: setCell
// purpose: set the value of the cell at given column and row
public void setCell(int column, int row, int value) {

if (value == 1)
{
  game[row][column] = '0';
}

else if (value == 2)
{
  game[row][column] = 'X';
}

} // ends method

// method: computeNextGeneration
// purpose: creates temporary 2D array to compute the next generation
public void computeNextGeneration(int generation) throws IOException {
 if (generation > 0)
{

tempBoard = new char [this.getRows()][this.getColumns()];


for (int i = 0; i < this.getRows(); i++)
  {
    for (int j = 0; j < this.getColumns(); j++)
    {
      tempBoard[i][j] = game[i][j];
    }
  }

this.print();

for (int r = 0; r < tempBoard.length; r++)
  {
// to search through the first and last row
     if (r == 0)
     {

   for (int c = 0; c < tempBoard[r].length; c++)
   {
   aliveCount=0;
   if (c == 0)
   {

    if (tempBoard[r][c+1] == 'X')
    {
    aliveCount++;
    }
    if (tempBoard[r+1][c] == 'X')
    {
    aliveCount++;
    }
    if (tempBoard[r+1][c+1] == 'X')
    {
    aliveCount++;
    }

    if (this.getCell(c,r) == 2)
    {
     if (aliveCount > 3 || aliveCount < 2)
     {
       this.setCell(c,r,0);
     }
    }

    if (this.getCell(c,r) == 1)
    {
      if (aliveCount == 3)
     {
       this.setCell(c,r,1);
     }
    }

} //ends c =0 loop

    else if (c == tempBoard[r].length - 1)
   {

   if (tempBoard[r][c-1] == 'X')
    {
    aliveCount++;
    }
    if (tempBoard[r+1][c-1] == 'X')
    {
    aliveCount++;
    }
    if (tempBoard[r+1][c] == 'X')
    {
    aliveCount++;
    }

    if (this.getCell(c,r) == 2)
    {
     if (aliveCount > 3 || aliveCount < 2)
     {
       this.setCell(c,r,0);
     }
    }

    if (this.getCell(c,r) == 1)
    {
      if (aliveCount == 3)
     {
       this.setCell(c,r,1);
     }
    }
 } // close c = temp board

       else
            {
              if(tempBoard[r][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }

          }
        }
        else if(r == tempBoard.length - 1)
        {
          for(int c = 0; c < tempBoard[r].length; c++)
          {
            aliveCount = 0;
            if(c == 0)
            {
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c+1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }
            else if(c == tempBoard[r].length - 1)
            {
              if(tempBoard[r-1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c-1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }
            else
            {
              if(tempBoard[r-1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c+1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            } // closes else
        } // closes for loop
        }
        else
        {
          for(int c = 0; c < tempBoard[r].length; c++)
          {
            aliveCount = 0;
            if(c == 0)
            {
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }
            else if(c == tempBoard[r].length - 1)
            {
              if(tempBoard[r-1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }
            else
            {
              if(tempBoard[r-1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r-1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r][c+1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c-1] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c] == 'X')
              {
                aliveCount++;
              }
              if(tempBoard[r+1][c+1] == 'X')
              {
                aliveCount++;
              }
              if(this.getCell(c,r) == 2)
              {
                if(aliveCount > 3 || aliveCount < 2)
                {
                  this.setCell(c,r,1);
                }
              }
              if(this.getCell(c,r) == 1)
              {
                if(aliveCount == 3)
                {
                  this.setCell(c,r,2);
                }
              }
            }
          }
        }
      } // closes



System.out.println("");

generation--;
computeNextGeneration(generation);

}

} //ends method

// method: print
// purpose: prints out board to console
public void print() {

System.out.println("Generation " + v);
System.out.println("");

for (int r = 0; r < game.length; r++)
{
  for (int c = 0; c < game[r].length; c++)
  {
   System.out.print(game[r][c] + " ");
  }
System.out.println("");
}

v++;

}

// method: main
// purpose: call the methods
public static void main (String[] args) throws IOException {

Scanner input = new Scanner(System.in);
Krishnan_GameOfLife x = new Krishnan_GameOfLife();
System.out.print("Enter how many generations you would like to compute: ");
numberOfGenerations = input.nextInt();

if (numberOfGenerations > 0)
 {
 System.out.println("");
 x.computeNextGeneration(numberOfGenerations);
 } else {
        System.out.println("Error. Enter valid number of generations.");
        }

} // ends main method

} // ends class

