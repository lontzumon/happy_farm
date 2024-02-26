public class Baseplant{
	
	public int fruit_number, fruit_price, mature_day, total, wetmax, wetminimum;
	public boolean magicplant,sungrassbuff,starflowerbuff;
	
	public Baseplant(int fruit_price, int fruit_number, int mature_day, int wetmax, int wetminimum,boolean magicplant){
		this.fruit_price = fruit_price;
		this.fruit_number = fruit_number;
		this.mature_day = mature_day;
		this.wetmax = wetmax;
		this.wetminimum = wetminimum;
		this.magicplant = magicplant;
	}
	
	public Baseplant(int fruit_price, int fruit_number, int mature_day, int wetmax, int wetminimum,boolean magicplant,boolean sungrassbuff,boolean starflowerbuff){
		this.fruit_price = fruit_price;
		this.fruit_number = fruit_number;
		this.mature_day = mature_day;
		this.wetmax = wetmax;
		this.wetminimum = wetminimum;
		this.magicplant = magicplant;
		this.sungrassbuff = sungrassbuff;
		this.starflowerbuff = starflowerbuff;
	}
	
	public boolean getsungrassbuff(){
		return sungrassbuff;
	}
	
	public boolean getstarflowerbuff(){
		return starflowerbuff;
	}
	
	public void setsungrassbuff(){
		sungrassbuff=true;
	}
	
	public void setstarflowerbuff(){
		starflowerbuff=true;
	}
	
	public boolean getreap(int plant_grow_day){
		if(plant_grow_day >= mature_day){
		return true;
		}
		else{
		System.out.println("這水果還沒成熟");
		return false;
		}
	}
	
	public boolean uncorrect_wet(int wet){
	    boolean uncorrect_humidity;
		if(wet< wetminimum || wet>wetmax){
			uncorrect_humidity = true;
		}
		else{
		    uncorrect_humidity = false;
		}
		return uncorrect_humidity;
	}
	
	public void print_wet(int wet){
		if(wet< wetminimum || wet>wetmax){
			if(wet< wetminimum){
			    System.out.println("看起來它有點缺水");
			}
			else{
			    System.out.println("看起來它攝取過多水分了");
			}
		}
		else{
		    System.out.println("它目前處於適宜的濕度");
		}
	}
	
	public void change_mature_day(int influence1){
		mature_day+=influence1;
	}
	
	public int getmature_day(){
	    return mature_day;
	}
	
	public void change_fruit_number(int influence2){
		fruit_number+=influence2;
	}
	
	public void change_fruit_price(int influence3){
		fruit_price+=influence3;
	}
	
	public int getfruit_number(){
	    return fruit_number;
	}
	
	public boolean getmagicplant(){
	    return magicplant;
	}
	
	public String getString(int plant_grow_day){
        System.out.println("There will be replaced");	
        return "nothing";		
	}
	
	public void buff(Baseplant plant,int a,int b){
	    System.out.println("nothing");
	}
	
	public int allprice(){
		total = fruit_price * fruit_number;
		System.out.println("你賣了" + fruit_number + "顆水果，並共賣出了" + total + "元");
		return total;
	}
}