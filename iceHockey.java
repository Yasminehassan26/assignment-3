package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.Point;
import java.util.Arrays;
public class iceHockey implements IPlayersFinder
{
    private int r;
    private int c;
    private int xmax = 0;
    private int ymax = 0;
    private int xmin = 100;
    private int ymin = 100;
    private int c1;
    private int c2;
    private int size = 0;
    public char[][]conversion(String[]strings)
    {
        char[][] charArray = new char[strings.length][];
        for(int i=0; i < strings.length; i++)
        {
            charArray [i] = strings[i].toCharArray();
        }
        r=strings.length;
        c=strings[0].length();
        return charArray;
    }
    public int check(char[][] photo,int team, int x, int y)
    {
        char temp =Character.forDigit(team,10);
        int counter=0;
        if (photo[x][y]!=temp)
        {
            return 0;
        }
        else if (photo[x][y]==temp)
        {
            counter++;

            photo[x][y]='f';
            if(x>=ymax)
            {
                ymax=x;
            }
            if(x<=ymin)
            {
                ymin=x;
            }
            if (y>=xmax)
            {
                xmax=y;
            }
            if (y<=xmin)
            {
                xmin=y;
            }

            if (x == 0 && y == 0)
            {
                counter+=check(photo,team,x,y+1);
                counter+=check(photo,team,x+1,y);
            }
            if (x==0 && y ==c-1)
            {
                counter+=check(photo,team,x,y-1);
                counter+=check(photo,team,x+1,y);
            }
            if (x==r-1 && y ==0)
            {
                counter+=check(photo,team,x,y+1);
                counter+=check(photo,team,x-1,y);
            }
            if (x==r-1 && y ==c-1)
            {
                counter+=check(photo,team,x,y-1);
                counter+=check(photo,team,x-1,y);
            }
            if (x==0&&y!=c-1 && y!=0)
            {
                counter+=check(photo,team,x+1,y);
                counter+=check(photo,team,x,y-1);
                counter+=check(photo,team,x,y+1);
            }
            if (x==r-1 &&y!=c-1 && y!=0)
            {
                counter+=check(photo,team,x-1,y);
                counter+=check(photo,team,x,y-1);
                counter+=check(photo,team,x,y+1);
            }
            if (x!=0&&x!=r-1 && y==0)
            {
                counter+=check(photo,team,x+1,y);
                counter+=check(photo,team,x-1,y);
                counter+=check(photo,team,x,y+1);
            }
            if (x!=0 &&x!=r-1 && y==c-1)
            {
                counter+=check(photo,team,x+1,y);
                counter+=check(photo,team,x-1,y);
                counter+=check(photo,team,x,y-1);
            }
            if (x!=0&&x!=r-1 && y!=c-1 && y!=0)
            {
                counter+=check(photo,team,x+1,y);
                counter+=check(photo,team,x-1,y);
                counter+=check(photo,team,x,y+1);
                counter+=check(photo,team,x,y-1);
            }
        }
        return counter;

    }
    public Point points()
    {
        c1=xmin+xmax+1;
        c2=ymin+ymax+1;
        xmax = 0;
        ymax = 0;
        xmin = 100;
        ymin = 100;

        Point place = new Point(c1,c2);
        return place;
    }

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold)
    {
    	if (photo==null) {
    		System.out.println("photo is empty");
    		return null;
    		
    	}
        Point[] place1= new Point[1000000];
        char [][]p ;
        int count=0  ;

        p=conversion(photo);

        for (int i=0; i<r; i++ )
        {
            for (int j=0; j<c; j++)
            {
                count=check(p, team, i, j)	;
                if(count*4 >=threshold)
                {
                    place1[size]=points();
                    size++;
                }
                else
                {
                    xmax =0;
                    ymax=0;
                    xmin=100;
                    ymin=100;
                }
            }
        }

        if(size==0)
        {
            System.out.println("photo is empty");
            return null;
        }

        Point[] place2=new Point[size];
        Point[]temp=new Point[size];

        for (int w=0; w<size; w++)
        {
            place2[w]=place1[w];
        }
        temp= sort(place2);
        for (int w=0; w<size; w++)
        {
            System.out.println(temp[w]);
        }
        return temp;


    }
    public Point[] sort (Point[] point)
    {
        for (int j =0; j<size; j++)
        {
            for(int i =0; i<size-1; i++)
            {
                if(point[i].x>point[i+1].x)
                {
                    Point temp=point[i];
                    point[i]=point[i+1];
                    point[i+1]=temp;
                }
                else if (point[i].x==point[i+1].x)
                {
                    if(point[i].y>point[i+1].y)
                    {
                        Point temp=point[i];
                        point[i]=point[i+1];
                        point[i+1]=temp;
                    }
                }
            }
        }
        return point;
    }

    public static void main (String[] args)
    {
        iceHockey test=new iceHockey();
        String[]strings=
        {
            "8D88888J8L8E888",
            "88NKMG8N8E8JI88",
            "888NS8EU88HN8EO",
            "LUQ888A8TH8OIH8",
            "888QJ88R8SG88TY",
            "88ZQV88B88OUZ8O",
            "FQ88WF8Q8GG88B8",
            "8S888HGSB8FT8S8",
            "8MX88D88888T8K8",
            "8S8A88MGVDG8XK8",
            "M88S8B8I8M88J8N",
            "8W88X88ZT8KA8I8",
            "88SQGB8I8J88W88",
            "U88H8NI8CZB88B8",
            "8PK8H8T8888TQR8"
        };
        Point[] mainTest =test.findPlayers(strings, 8, 9);
       
    }

}
