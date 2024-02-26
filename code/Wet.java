public class Wet{
    private int wet;
	public Wet(){
	wet=20;
	}
    public void setwet(int humidity){
        if((wet + humidity)> 100){
		    wet=100;
		}
		else{
		    if((wet + humidity)< 0){
			    wet=0;
			}
			else{
			wet += humidity;
			}
        }
    }
	public void reset_wet(){
        wet=20;
    }
	public int getwet(){
        return wet;
    }
}