public class Watermelon extends Baseplant{
	public Watermelon(){
		super(35, 4, 12, 25, 15, false, false, false);
	}

	public String getString(int plant_grow_day){
		System.out.println("你已經種西瓜種了"+plant_grow_day+"天");
		System.out.println("預估會結"+fruit_number+"顆果實");
		if(mature_day-plant_grow_day>0){
		System.out.println("估計約" + (mature_day-plant_grow_day) + "天就可以成熟了");
	    }
		else{
		System.out.println("西瓜已經成熟了");
		}
		return "nothing";
	}
	
}