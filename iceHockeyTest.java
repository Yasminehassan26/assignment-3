package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class iceHockeyTest
{   @Test
    void test()
    {
        iceHockey test=new iceHockey();
        String[]strings= { "33JUBU33",
                           "3U3O4433",
                           "O33P44NB",
                           "PO3NSDP3",
                           "VNDSD333",
                           "OINFD33X"
                         };
        Point[] expectedResult =test.findPlayers(strings, 3, 16);
        Point[] result = new Point[3];
        result[0]=new Point(4,5);
        result[1]=new Point(13,9);
        result[2]=new Point(14,2);
        Assert.assertArrayEquals(result,expectedResult);
    }
    @Test
    void test1()
    {
        iceHockey test=new iceHockey();
        String[]strings=
        {
            "44444H44S4",
            "K444K4L444",
            "4LJ44T44XH",
            "444O4VIF44",
            "44C4D4U444",
            "4V4Y4KB4M4",
            "G4W4HP4O4W",
            "4444ZDQ4S4",
            "4BR4Y4A444",
            "4G4V4T4444"
        };
        Point[] expectedResult =test.findPlayers(strings, 4, 16);
        Point[] result = new Point[6];
        result[0]=new Point(3,8);
        result[1]=new Point(4,16);
        result[2]=new Point(5,4);
        result[3]=new Point(16,3);
        result[4]=new Point(16,17);
        result[5]=new Point(17,9);
        Assert.assertArrayEquals(result,expectedResult);
    }
    @Test
    void test2()
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
        Point[] expectedResult =test.findPlayers(strings, 8, 9);
        Point[] result = new Point[19];
        result[0]=new Point(1, 17);
        result[1]=new Point (3, 3);
        result[2]=new Point (3, 10);
        result[3]=new Point(3, 25);
        result[4]=new Point (5, 21);
        result[5]=new Point(8, 17);
        result[6]=new Point(9, 2);
        result[7]=new Point (10,9);
        result[8]=new Point (12,23);
        result[9]=new Point(17,16);
        result[10]=new Point(18,3);
        result[11]=new Point(18,11);
        result[12]=new Point(18,28);
        result[13]=new Point(22,20);
        result[14]=new Point(23,26);
        result[15]=new Point(24,15);
        result[16]=new Point(27,2);
        result[17]=new Point(28,26);
        result[18]=new Point(29,16);
        Assert.assertArrayEquals(result,expectedResult);
    }
    @Test
    void test3()
    {
        iceHockey test=new iceHockey();
        String[]strings= { "11111",
                           "1AAA1",
                           "1A1A1",
                           "1AAA1",
                           "11111"
                         };
        Point[] expectedResult =test.findPlayers(strings, 1, 3);
        Point[] result = new Point[2];
        result[0]=new Point(5,5);
        result[1]=new Point(5,5);
        Assert.assertArrayEquals(result,expectedResult);
    }
    @Test
    void test4()
    {
        iceHockey test=new iceHockey();
        String[]strings=
        {
            "44444H44S4",
            "K444K4L444",
            "4LJ44T44XH",
            "444O4VIF44",
            "44C4D4U444",
            "4V4Y4KB4M4",
            "G4W4HP4O4W",
            "4444ZDQ4S4",
            "4BR4Y4A444",
            "4G4V4T4444"
        };
        Point[] expectedResult =test.findPlayers(strings, 3, 16);
        Assert.assertArrayEquals(null,expectedResult);
    }
    @Test
    void test5()
    {
        iceHockey test=new iceHockey();
        String[]strings=null;
        
        Point[] expectedResult =test.findPlayers(strings, 3, 16);
        Assert.assertArrayEquals(null,expectedResult);
    }
}
