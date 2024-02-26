import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class Environment{
	private static int day =1 ;
	private static String weather;
	
	public static int getday(){
	    return day;
	}
	
    public static String Environment(){
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("environment.txt")); 
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
			int x =1;
            while ((line= br.readLine()) != null) {
            if(x==day){	
				weather = line;
            }				
			x++;
			}
			day++;
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return weather;
	}
    public static int wet_change(String weather){  //this function will change the wet
		int a=0;
		switch(weather)
		{
		    case "Sunny":
			    a= -15;
				break;
			case "Storm":
			    a= 10;
				break;
		    case "Normal":
			    a= -5;
				break;
			case "Rainy":
			    a= 5;
                break;				
		}
		return a;
	}
    public static void printing(String weather){  //print the weather
	    switch(weather)
		{
		    case "Sunny":
			    System.out.println("萬里無雲的大晴天");
				break;
			case "Storm":
			    System.out.println("暴風雨來臨，請謹慎");
				break;
		    case "Normal":
			    System.out.println("平凡的一天");
				break;
			case "Rainy":
			    System.out.println("陰雨綿綿");
                break;				
		}
	}		
}