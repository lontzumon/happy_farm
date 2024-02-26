public class Starflower extends Baseplant{
	public Starflower(){
		super(0, 1, 8, 40, 30, true);
	}
	

	public String getString(int plant_grow_day){
		System.out.println("你已經種星辰花種了"+plant_grow_day+"天");
		if(mature_day-plant_grow_day>0){
		System.out.println("估計約" + (mature_day-plant_grow_day) + "天就會枯掉了");
	    }
		return "nothing";
	}
	
	public void buff(Baseplant plant,int a,int b){ //a is the location for the starflower,b is the location for the earn_money_plant
		switch(a)
		{
		    case 0:
			    if(b==1||b==3){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 1:
				if(b==0||b==2||b==4){
				    if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 2:
				if(b==1||b==5){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 3:
				if(b==0||b==4||b==6){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 4:
				if(b==1||b==3||b==5||b==7){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 5:
				if(b==2||b==4||b==8){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 6:
				if(b==3||b==7){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 7:
				if(b==4||b==6||b==8){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
			case 8:
				if(b==5||b==7){
					if(plant!=null){
						if(!plant.getmagicplant()){
							if(!plant.getstarflowerbuff()){
								plant.change_fruit_number(1);
								plant.setstarflowerbuff();
							}
						}
					}
				}
				break;
		}
	}
}