public class happy_farm{
	public static boolean right_number(String soil_number){
		boolean a = true;
	   try{
			Integer.parseInt(soil_number);
			int soil_select =Integer.parseInt(soil_number);
						if(soil_select<1||soil_select>9){
						    System.out.println("沒有這種田地編號");
							a=false;
						}
		}catch(java.lang.NumberFormatException e){
			System.out.println("請輸入正確的田地編號");
			a=false;
		}
		return a;
	}		
    public static void main(String args[]){
		//already used money energy day watering_can hoe sickle plant  soil melon berry soil_now command command_split i fruit plant_grow_day name person weather soil_select
		int money = 2000;
		int energy = 100;
		int sleep = 70; 
		int[] minusenergy={-5,-15}; // the energy cost in fill and loosen ,plant
		int[] plant_grow_day ={0,0,0,0,0,0,0,0,0};
		int[] constant_day = {0,0,0,0,0,0,0,0,0};
		int[] watering_can={0,50,100};  //number,price,energy
		int[] hoe={0,420,100};
		int[] sickle={0,210,100};
		int soil_select=0;
		String[] fruit= {"watermelon","mulberry","sungrass","starflower"};
		String weather =" ";
		int[] fruit_num={0,10,0,5,0,15,0,20};  // (watermelon number, price,mulberry number, price,and so on)
		Wet[] wet=new Wet[9];
		for(int i=0;i<wet.length;i++){
		    wet[i] = new Wet();
		}
		
		Soil[] soil=new Soil[4];
		soil[0] = new Soil("sand",0,0,0,15);    //(name,number,the change in mature day,the change in the fruit_number,price)
		soil[1] = new Soil("clay",0,-3,-1,20);  
		soil[2] = new Soil("loam",0,3,1,20);
        soil[3] = new Soil("magicdust",0,0,0,30);		
		String[] seed_now ={"no","no","no","no","no","no","no","no","no"};
		int[] soil_now ={9,9,9,9,9,9,9,9,9};  // 9 means it isn't fill and loosen the soil yet
		Baseplant[] plant = new Baseplant[9];
		System.out.println("歡迎來到[開心]農場");
		System.out.println("您總共有9塊田地，為田字型，分別由左而右再由上到下編號為1到9");
		System.out.println("請創造你自己的農場吧");
		System.out.println("請輸入你的名字:");
		String name = ConsoleIn.readLine();
		System.out.println("請選擇角色(可輸入illustrate先看職業能力): 植物學家(botanist)商人(merchant)力士(hercules)");
		String profession ="";
		while(true){
			profession = ConsoleIn.readLine();
			if(profession.equals("botanist") || profession.equals("merchant") || profession.equals("hercules")){
				if(profession.equals("botanist")){
				energy=90;
				System.out.println("你選擇了植物學家");
				break;
				}
				if(profession.equals("merchant")){
				watering_can[1]-=10;
				hoe[1]-=10;
				sickle[1]-=10;
				minusenergy[0]-=5;
				minusenergy[1]-=5;
				System.out.println("你選擇了商人");
				break;
				}
				if(profession.equals("hercules")){
				sleep=100;
				minusenergy[0]+=5;
				minusenergy[1]+=5;
				System.out.println("你選擇了力士");
				break;
				}
			}
			else{
				if(profession.equals("illustrate")){
					System.out.println("植物學家(botanist): 賺錢型植物果實產量+1，功能型植物存活天數+1");
					System.out.println("                    體力上限從100降到90");
					System.out.println("商人(merchant):     商店販賣工具-10元(鋤頭、鐮刀和澆花器)，每顆果實價格+1元");
					System.out.println("                    種植和填土動作耗費體力+5");
					System.out.println("力士(hercules):     睡覺能恢復所有體力，種植和填土動作耗費體力-5");
					System.out.println("-----------------------------------------------------------------------------");
				}
				else{
					System.out.println("沒有這種職業，請重新輸入");
					}
			}
		}
		System.out.println("遊戲開始");
		farmer person = new farmer(name,energy,money,energy);
		System.out.println("第"+Environment.getday()+ "天");
		weather = Environment.Environment();
		Environment.printing(weather);
		person.getenergy_and_money();
		System.out.println("請輸入指令");
		while(true){
		String command = ConsoleIn.readLine();
		String[] command_split = command.split(" ");
		if(command_split.length==2){
		    if(command_split[0].equals("water")){
				if(right_number(command_split[1])){
				    soil_select =Integer.parseInt(command_split[1]);
				    if(seed_now[soil_select-1]=="no"){
				        System.out.println("你需要先在這塊地播種");
				    }
				    else{
					    if(soil_now[soil_select-1]==9){
				        System.out.println("你需要先在第"+soil_select+"塊田地填土並鬆土");
				        }
				        else{
					
			                switch(watering_can[0])
			                {
				                case 0:
				                    System.out.println("你需要先買澆水器");
				                    break;
				                case 1:
							        if(person.setenergy(-10)){
								        System.out.println("你對第"+soil_select+"塊田地的植物澆水");
									    wet[soil_select-1].setwet(5);
									    watering_can[2]-=5;
									    person.getenergy_and_money();
								    }
					                break;
			                }
			                if(watering_can[2]==0){
			                    System.out.println("你的澆水器已損壞，請記得再買一把");
				                watering_can[0]-=1;
			                }
				        }
				    }
				}
				
		    }
		}
		if(command_split.length==5){
	        if(command_split[0].equals("fill")&&command_split[1].equals("and")&&command_split[2].equals("loosen")){
			    if(command_split[3].equals("sand")||command_split[3].equals("clay")||command_split[3].equals("loam")||command_split[3].equals("magicdust")){
				    if(right_number(command_split[4])){
				    soil_select =Integer.parseInt(command_split[4]);
					if(soil_now[soil_select-1]!=9){
				    System.out.println("你已經在第"+soil_select+"塊田地填土了");
				    }
				    else{
				        for(int i=0;i<4;i++){
				            if(soil[i].getname().equals(command_split[3])){
					            if(soil[i].getnumber()!=0){   //if the user want to fill and loosen,he needs to buy the soil first
							        switch(hoe[0])
			                        {
				                        case 0:
				                            System.out.println("你需要先買鋤頭");
				                            break;
				                        case 1:
									        if(person.setenergy(minusenergy[0])){
										        System.out.println("你在第"+soil_select+"塊田地填土");
										        hoe[2]-=5;
									            soil_now[soil_select-1]=i;
												wet[soil_select-1].reset_wet();
												wet[soil_select-1].setwet(Environment.wet_change(weather));
												soil[i].setnumber(-1);
												constant_day[soil_select-1]=0;
											    person.getenergy_and_money();
										    }
					                        break;
			                        }
			                        if(hoe[2]==0){
			                            System.out.println("你的鋤頭已損壞，請記得再買一把");
				                        hoe[0]-=1;
			                        }
						
						        }
						        else{
						        System.out.println("你沒有這種土壤，請先去買");
						        }
					        }
				        }
				    }
					}

				}
				else{
				System.out.println("沒有這種土壤，請重新輸入指令");
				}
			}
		}
	    if(command_split.length==3){
		    if(command_split[0].equals("plant")){
				if(command_split[1].equals("watermelon") ||command_split[1].equals("mulberry") ||command_split[1].equals("sungrass") ||command_split[1].equals("starflower")){
					if(right_number(command_split[2])){
				    soil_select =Integer.parseInt(command_split[2]);
					if(!seed_now[soil_select-1].equals("no")){
				    System.out.println("這塊地已經種下種子了");
				    }
				    else{
				        for(int i=0;i<4;i++){
				            if(command_split[1].equals(fruit[i])){
					            if(fruit_num[2*i]!=0){
								    if(soil_now[soil_select-1]!=9){
										if(soil_now[soil_select-1]==3){ //3 means there are magicdust here 
										    if(command_split[1].equals("sungrass") ||command_split[1].equals("starflower")){
												if(person.setenergy(minusenergy[1])){
													seed_now[soil_select-1] = command_split[1];
													System.out.println("你在第"+soil_select+"塊田地種了"+command_split[1]);	
													fruit_num[2*i]-=1;
													person.getenergy_and_money();
													if(i==2){                     // create the plant 
														plant[soil_select-1] = new Sungrass();
													}
													else{
														plant[soil_select-1] = new Starflower();
													}
													if(profession.equals("botanist")){
													    plant[soil_select-1].change_mature_day(1);
													}
													for(int a=0;a<9;a++){    //the buff for the magicplant
														if(a!=soil_select-1){
															if(plant[a]!=null){
																plant[soil_select-1].buff(plant[a],(soil_select-1),a);
															}
														}
													}
												}
											}
											else{
											    System.out.println("這是魔法土，只能種特殊植物");
											}
										}
										else{
											if(command_split[1].equals("watermelon") ||command_split[1].equals("mulberry")){
												if(person.setenergy(minusenergy[1])){
													seed_now[soil_select-1] = command_split[1];
													System.out.println("你在第"+soil_select+"塊田地種了"+command_split[1]);	
													fruit_num[2*i]-=1;
													person.getenergy_and_money();
													if(i==0){                     // create the plant 
														plant[soil_select-1] = new Watermelon();
													}
													else{
														plant[soil_select-1] = new Mulberry();
													}
													if(profession.equals("botanist")){
													    plant[soil_select-1].change_fruit_number(1);
													}
													if(profession.equals("merchant")){
													    plant[soil_select-1].change_fruit_price(1);
													}
													for(int j=0;j<2;j++){
														if(j==soil_now[soil_select-1]){
															plant[soil_select-1].change_mature_day(soil[j].getmature_day());     //the fruit's mature_day and fruit_number may change (depends on soil)
															plant[soil_select-1].change_fruit_number(soil[j].getfruit_number());
														}
													}
													for(int a=0;a<9;a++){
														if(plant[a]!=null){   //the buff for the magicplant
															if(plant[a].getmagicplant()){
																plant[a].buff(plant[soil_select-1],a,soil_select-1);
															}
														}
													}
												}
											}
											else{
											    System.out.println("這是正常的土，只能種植一般植物");
											}
										}
									}
								    else{
								        System.out.println("你需要先在第"+soil_select+"塊田地填土並鬆土");
								    }
							    }
							    else{
							        System.out.println("你需要先買種子");
							    }
					        }
				        }
			        }
					}
					
				    	
				}
				else{
				    System.out.println("沒有這種種子，請重新輸入指令");
				}
			}
		}
	    if(command_split.length==5){
		    if(command_split[0].equals("reap") && command_split[1].equals("and") && command_split[2].equals("sell")){
				if(right_number(command_split[4])){
				    soil_select =Integer.parseInt(command_split[4]);
                        if(command_split[3].equals(seed_now[soil_select-1]) &&(!command_split[3].equals("no"))){
					        if(plant[soil_select-1].getreap(plant_grow_day[soil_select-1])){
					            if(person.setenergy(-5)){
					                person.setmoney(plant[soil_select-1].allprice());	
					                plant_grow_day[soil_select-1] =0;
					                soil_now[soil_select-1]= 9 ;
					                seed_now[soil_select-1]="no";
							        person.getenergy_and_money();
						        }
					        }
				        }
				else{
				    System.out.println("你沒有種植這種植物");
				}
		    }
			    
			}
		}
	    if(command_split.length==2 || command_split.length==3){
		    if(command_split[0].equals("buy")){
				if(command.equals("buy watering can")){
				    switch(watering_can[0])
					{
						case 0:
						    if(person.setmoney(-1*watering_can[1])){
								System.out.println("你買了澆水器");
						        watering_can[0]+=1;
								person.getenergy_and_money();
							}
							break;
						case 1:
						    System.out.println("你只能擁有一個");
							break;
					}	
                }    				
			    if(command.equals("buy hoe")){
			        switch(hoe[0])
					{
						case 0:
						    if(person.setmoney(-1*hoe[1])){
								System.out.println("你買了鋤頭");
						        hoe[0]+=1;
								person.getenergy_and_money();
							}
							break;
						case 1:
						    System.out.println("你只能擁有一個");
							break;
					}
			    }
				if(command.equals("buy sickle")){
			        switch(sickle[0])
					{
						case 0:
						    if(person.setmoney(-1*sickle[1])){
							System.out.println("你買了鐮刀");
						    sickle[0]+=1;
							person.getenergy_and_money();
							}
							break;
						case 1:
						    System.out.println("你只能擁有一個");
							break;
					}	
			    }
				if(command.equals("buy watermelon")){
					if(person.setmoney(-1*fruit_num[1])){
						System.out.println("你買了西瓜種子");
					    fruit_num[0]+=1;
						person.getenergy_and_money();
					}         	
			    }
				if(command.equals("buy mulberry")){
					if(person.setmoney(-1*fruit_num[3])){
						System.out.println("你買了桑樹種子");
					    fruit_num[2]+=1;
						person.getenergy_and_money();
					}
			    }
				if(command.equals("buy sungrass")){
					if(person.setmoney(-1*fruit_num[5])){
						System.out.println("你買了太陽草種子");
					    fruit_num[4]+=1;
						person.getenergy_and_money();
					}         	
			    }
				if(command.equals("buy starflower")){
					if(person.setmoney(-1*fruit_num[7])){
						System.out.println("你買了星辰花種子");
					    fruit_num[6]+=1;
						person.getenergy_and_money();
					}         	
			    }
				if(command.equals("buy sand")){
					if(person.setmoney(-1*soil[0].getprice())){
						System.out.println("你買了砂土");
					    soil[0].setnumber(1);
						person.getenergy_and_money();
					}
			    }
				if(command.equals("buy clay")){
					if(person.setmoney(-1*soil[1].getprice())){
						System.out.println("你買了黏土");
					    soil[1].setnumber(1);
						person.getenergy_and_money();
					}
			    }
				if(command.equals("buy loam")){
					if(person.setmoney(-1*soil[2].getprice())){
						System.out.println("你買了壤土");
					    soil[2].setnumber(1);
						person.getenergy_and_money();
					}
			    }
				if(command.equals("buy magicdust")){
					if(person.setmoney(-1*soil[3].getprice())){
						System.out.println("你買了魔法土");
					    soil[3].setnumber(1);
						person.getenergy_and_money();
					}
			    }
				if(!(command.equals("buy watering can") || command.equals("buy hoe") || command.equals("buy sickle") || command.equals("buy watermelon") || command.equals("buy mulberry") || command.equals("buy sand") || command.equals("buy clay") || command.equals("buy loam"))){
				    if(!(command.equals("buy sungrass") ||command.equals("buy starflower") ||command.equals("buy magicdust"))){
						System.out.println("商店裡沒這東西，你可以輸入store看商店裡有甚麼東西");
					}
				}
			}
		}
		if(command.equals("store")){
			System.out.println("        雜貨店");
		    System.out.println("澆水器: "+watering_can[1]+"元(watering can)");
			System.out.println("鋤頭: "+hoe[1]+"元(hoe)");
			System.out.println("鐮刀: "+sickle[1]+"元(sickle)");
			System.out.println("西瓜種子: 10元/個(watermelon)");
			System.out.println("桑樹種子: 5元/個(mulberry)");
			System.out.println("太陽草種子: 15元/個(sungrass)");
			System.out.println("星辰花種子: 20元/個(starflower)");
			System.out.println("砂土: 15元(sand)");
			System.out.println("黏土: 20元(clay)");
			System.out.println("壤土: 20元(loam)");
			System.out.println("魔法土: 30元(magicdust)");
			
			System.out.println("-------------------------------------------------------");
		}
	    if(command_split.length==2){
		        if(command_split[0].equals("check")){
					if(right_number(command_split[1])){
						soil_select =Integer.parseInt(command_split[1]);
						person.setenergy(-5);
						if(soil_now[soil_select-1]==9){
							System.out.println("田地編號:"+soil_select);
							System.out.println("目前未填土，想當然也未種植植物");
						}
						else{
							if(seed_now[soil_select-1].equals("no")){
								System.out.println("田地編號:"+soil_select);
								System.out.println("目前的土壤是"+soil[soil_now[soil_select-1]].getname());
								System.out.println("濕度:"+wet[soil_select-1].getwet());
								System.out.println("'尚未種植植物'");
							}
							else{
								System.out.println("田地編號:"+soil_select);
								System.out.println("目前的土壤是"+soil[soil_now[soil_select-1]].getname());
								System.out.println("濕度:"+wet[soil_select-1].getwet());
								plant[soil_select-1].getString(plant_grow_day[soil_select-1]);
								plant[soil_select-1].print_wet(wet[soil_select-1].getwet());
							}
						}
			        person.getenergy_and_money();
		        }
			}    
		}
		
		if(command.equals("bag")){  //print the thing user have
		    System.out.println("錢: "+person.getmoney()+"體力: "+person.getenergy());
			System.out.println("澆水器: "+watering_can[0]);
			System.out.println("鋤頭: "+hoe[0]);
			System.out.println("鐮刀: "+sickle[0]);
			System.out.println("西瓜種子: "+fruit_num[0]);
			System.out.println("桑樹種子: "+fruit_num[2]);
			System.out.println("太陽草種子: "+fruit_num[4]);
			System.out.println("星辰花種子: "+fruit_num[6]);
			System.out.println("砂土: "+soil[0].getnumber());
			System.out.println("黏土: "+soil[1].getnumber());
			System.out.println("壤土: "+soil[2].getnumber());
			System.out.println("魔法土: "+soil[3].getnumber());
		}
		if(command.equals("help")){
		    System.out.println("你可以輸入:(記得輸入英文喔)");
			System.out.println("    store (看商店有哪些物品販賣)");
			System.out.println("    buy [商店販賣物品] (買商店裡的物品)");
			System.out.println("    fill and loosen [土壤名稱] [田地編號] (放入土壤並使其鬆軟)");
			System.out.println("    plant [植物名稱] [田地編號] (種下植物)");
			System.out.println("    reap and sell [植物名稱] [田地編號] (收成植物，並販售)");
			System.out.println("    check (檢查田地的各種狀態)");
			System.out.println("    water [田地編號] (幫植物澆水)");
			System.out.println("    bag (目前身上的所有物和狀態)");
			System.out.println("    sleep (結束這一天，進入下一天)");
			System.out.println("    help (提供玩家幫助)");
			System.out.println("-------------------------------------------------------");
		}
		if(command.equals("sleep")|| person.getenergy()==0){
		    System.out.println("你很累，所以你去睡覺了");
			person.setenergy(sleep);
			for(int i=0;i<9;i++){
			    if(soil_now[i]!=9){  //if the user has planted the plant, the plant will grow
					if(plant[i] != null){
						plant_grow_day[i]++;
						if(plant[i].uncorrect_wet(wet[i].getwet())){  // if the plant in the uncorrect wet,it may grow worse
							if(plant[i].getmagicplant()){
							    plant[i].change_mature_day(-1);
							}
							else{
								if(plant_grow_day[i]>plant[i].getmature_day()){
									constant_day[i]=0;
								}
								constant_day[i]++;
							}
						}
						else{
							constant_day[i]=0;
						}
						if(constant_day[i]>3){
							plant[i].change_fruit_number(-1);
						}
						if(constant_day[i]>5 || plant[i].getfruit_number()==0){
							System.out.println("因為一時的疏忽，第"+(i+1)+"塊田地的植物死掉了");
							plant_grow_day[i] =0;
							soil_now[i]= 9 ;
							seed_now[i]="no";
							constant_day[i]=0;
						}
					}
			    }
				
			}
			
			System.out.println("第"+Environment.getday()+ "天");
			weather = Environment.Environment();
			Environment.printing(weather);
			for(int i=0;i<9;i++){
			    wet[i].setwet(Environment.wet_change(weather));
				if(plant[i] != null){
					if(plant[i].getmagicplant()){
						if(plant_grow_day[i]>=plant[i].getmature_day()){
							System.out.println("第"+(i+1)+"塊田地的功能型植物已消失");
							plant_grow_day[i] =0;
							soil_now[i]= 9 ;
							seed_now[i]="no";
							constant_day[i]=0;
						}
					}
				}
			}
			person.getenergy_and_money();
		}
	    if(!(command_split.length==2 && (command_split[0].equals("water") || command_split[0].equals("check"))) ){//if user write wrong order
		    if(!(command_split.length==5 && ((command_split[0].equals("fill")&&command_split[1].equals("and")&&command_split[2].equals("loosen")) || (command_split[0].equals("reap") && command_split[1].equals("and") && command_split[2].equals("sell"))))){
			    if(!(((command_split.length==2 || command_split.length==3) && command_split[0].equals("buy")) || command.equals("store") || command.equals("bag"))){
				    if(!(command.equals("sleep")|| command.equals("help"))){
						if(!(command_split.length==3 && command_split[0].equals("plant"))){
					        System.out.println("沒有這種指令，你可以輸入help以得到幫助");
					    }
					}
				}
			}
		}
		if(person.getmoney()==0){
			int a=0;
			for(int i=0;i<8;i++){
				if(seed_now[i].equals("no")){
				a++;
				}
			}
			if(a==9){
			    System.out.println("你無法再從事種植，所以你破產了");
			    System.out.println("遊戲結束 GAME OVER");
				System.out.println("存活了"+Environment.getday()+ "天" + "，身上沒任何錢");
			    break;
			}
		}
		if(weather==null){
		    System.out.println("你共生存了"+Environment.getday()+"天");
			System.out.println("你擁有了"+person.getmoney()+"元");
			System.out.println("遊戲被你破關了，Congratulation~");
			break;
		    }
		}
	}
}