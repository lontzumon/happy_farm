public class Mulberry extends Baseplant{
	public Mulberry(){
		super(10, 8, 16, 35, 25, false, false, false);
	}
	

	public String getString(int plant_grow_day){
		System.out.println("你已經種桑樹種了"+plant_grow_day+"天");
		System.out.println("預估會結"+fruit_number+"顆果實");
		if(mature_day-plant_grow_day>0){
		System.out.println("估計約" + (mature_day-plant_grow_day) + "天就可以成熟了");
	    }
		else{
		System.out.println("桑樹已經成熟了");
		}
		return "nothing";
	}
}