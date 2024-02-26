public class Soil{
	private int number = 0;
	private int mature_day ;     //the change
	private int fruit_number ; 	//the change
	private int price;
	private String name;

    public Soil(String name, int number, int mature_day, int fruit_number, int price){
        this.name = name;
		this.number = number;
		this.mature_day = mature_day;
		this.fruit_number = fruit_number;
		this.price = price;
    }
        
    public void setnumber(int number){
        this.number += number;
    }
	
	public String getname(){
        return name;
    }
	
	public int getmature_day(){
        return mature_day;
    }
	
	public int getfruit_number(){
        return fruit_number;
    }
	
	public int getnumber(){
        return number;
    }
	
	public int getprice(){
        return price;
    }
    

}