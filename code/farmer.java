public class farmer{
	//this class is used to create the player(pitcher and hitter) and calculate the pitcher's energe
	private int energy ;
	private int money ;
	private String name;
	private int maxenergy;

    public farmer(String name, int energy, int money, int maxenergy){
        this.name = name;
		this.energy = energy;
		this.money = money;
		this.maxenergy = maxenergy;
    }
	
    public boolean setenergy(int work){
		if(energy+work>maxenergy || energy+work<0){
			if(energy+work>maxenergy){
			energy=maxenergy;
			return true;
			}
			else{
			System.out.println("你的體力不足，你可以去睡覺以補充體力");
			return false;
			}
		}
		else{
			energy += work;
			return true;
		}	
    }

    public boolean setmoney(int item_price){
        if(money+item_price<0){
		    System.out.println("你買不起它");
			return false;
		}
		else{
			money += item_price;
		    return true;
		}
		
    }
	
	public int getenergy(){
        return energy;
    }
	
	public String getname(){
	    return name;
	}
	
    public int getmoney(){
        return money;
    }
	
	public void getenergy_and_money(){
	    System.out.println("目前體力:"+energy +"  金錢:"+money);
	}
}