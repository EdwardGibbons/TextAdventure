package textAdventure;

import java.util.*;

public class TextAdventureRunner {
	private static final int TEXT_SPEED = 4; 
	
	public static void displayMessage(String msg) throws InterruptedException {		
		for (int i = 0; i < msg.length(); i++) {
			System.out.print(msg.charAt(i));
			Thread.sleep(TEXT_SPEED);
		}
	} // end of displayMessage method
	
	public static void displayMessageln(String msg) throws InterruptedException {
		// identical to displayMessage but prints a line afterwards
		displayMessage(msg);
		System.out.println();
	}
	
	public static String getNextScenario(String[] choices,String[] scenarios, Scanner in) throws InterruptedException {
		
		int input;
		while (true) {
			for (int i = 1; i <= choices.length; i++) {
				displayMessage("	" + i + ") " + choices[i-1]);
				System.out.println();
			} // display choices
			
			if (!in.hasNextInt()) {
				displayMessage("INVALID! Must type integer");
				System.out.println();
				in.nextLine(); // clear line
				continue;
			} // makes sure we are dealing with integers
			
			input = in.nextInt();
			in.nextLine(); // clear line
			if (  !(1<= input && input <= choices.length)  ) {
				displayMessage("INVALID! Must type value between 1 and " + choices.length);
				System.out.println();
				continue;
			} // makes sure we are dealing with numbers in a valid range
			return scenarios[input-1];
			
		} // end of while loop
		
	} // end of getNextScenarioMethod
	
	
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		ArrayList<String> choiceHistory = new ArrayList<>();
		boolean end = false;
		String scenario = "start";
		int scenarioNumber = 0;
		
				System.out.println("________                          __    ___________      ____________________________________ _____________  _______    \r\n"
				+ "\\_____  \\  __ __   ____   _______/  |_  \\__    ___/___   \\______   \\_   _____/\\__    ___/    |   \\______   \\ \\      \\   \r\n"
				+ " /  / \\  \\|  |  \\_/ __ \\ /  ___/\\   __\\   |    | /  _ \\   |       _/|    __)_   |    |  |    |   /|       _/ /   |   \\  \r\n"
				+ "/   \\_/.  \\  |  /\\  ___/ \\___ \\  |  |     |    |(  <_> )  |    |   \\|        \\  |    |  |    |  / |    |   \\/    |    \\ \r\n"
				+ "\\_____\\ \\_/____/  \\___  >____  > |__|     |____| \\____/   |____|_  /_______  /  |____|  |______/  |____|_  /\\____|__  / \r\n"
				+ "       \\__>           \\/     \\/                                  \\/        \\/                            \\/         \\/  \r\n"
				+ "___________.__              __      __        .__  .__          __                                                      \r\n"
				+ "\\__    ___/|  |__   ____   /  \\    /  \\_____  |  | |  |   _____/  |_                                                    \r\n"
				+ "  |    |   |  |  \\_/ __ \\  \\   \\/\\/   /\\__  \\ |  | |  | _/ __ \\   __\\                                                   \r\n"
				+ "  |    |   |   Y  \\  ___/   \\        /  / __ \\|  |_|  |_\\  ___/|  |                                                     \r\n"
				+ "  |____|   |___|  /\\___  >   \\__/\\  /  (____  /____/____/\\___  >__|                                                     \r\n"
				+ "                \\/     \\/         \\/        \\/               \\/                                                         \r\n"
				+ "                                                                                                                        \r\n"
				+ "                                                                                                                        \r\n"
				+ "                                                                                                                        \r\n"
				+ "                                                                                                                        \r\n"
				+ "                                                                                                                        \r\n"
				+ "                                                                                                                       ");
		
		while (!end) {
			choiceHistory.add(scenario);
			scenarioNumber++;
			displayMessage("(" + scenarioNumber + ") ");
			switch (scenario) {
				case "start":
					displayMessageln("You are walking in downtown New York on a crowded sidewalk.");
					displayMessageln("You are walking behind a man, and his wallet falls from his pocket");
					String[] c1 = {"Go and pick up the wallet", "Ignore it"}; 	// c(#) represents the choices for the specific scenario
					String[] s1 = {"walletgrab", "ignore"};						// s(#) represents the outcome scenarios from choosing specific choices
					scenario = getNextScenario(c1, s1, in);						// this displays the choices the user has and returns the specific scenario output
					break;
				case "ignore":
					displayMessageln("You went along and ignored it. How boring!");
					displayMessageln("You go along to live an incredibly boring life where");
					displayMessageln("nothing ever happens, because you never do anything exciting. :(");
					end = true;
					break;
				case "walletgrab":
	                displayMessageln("You pick up the wallet. The man has gotten quite far now however and is only barely in sight");
	                String[] c2 = {"Swiftly follow the man to RETURN the wallet", "Steal the wallet"};
	                String[] s2 = {"return", "steal"};
	                scenario = getNextScenario(c2, s2, in);
	                break;
	                	// beginning of RETURN route
	            case "return":
	                displayMessageln("You try to run after the man. The man gets through a stoplight and your stuck on the other side.");
	                displayMessageln("The chase continues.");
	                String[] rc1 = {"Jaywalk", "Wait for the stoplight to let you pass"};
	                String[] rs1 = {"jaywalkInjury", "loseGuy"};
	                scenario = getNextScenario(rc1,rs1, in);
	                break;
	            case "jaywalkInjury":
	                displayMessageln("You try to run through the street, but you get hit by a car. While getting hit by the car the wallet falls out of your hand.");
	                displayMessageln("You were delivered to a hospital shortly after getting by the car, but shortly died. Lesson: Don't jaywalk.");
	                end = true;
	                break;
				case "loseGuy":
					displayMessageln("By the time you are let through, the man has dissapeared. You decide to check through his wallet, to look for anything useful");
	                String[] rc2 = {"Call his phone number listed in wallet", "Give up and steal money at this point", "Go to his listed address"};
	                String[] rs2 = {"phoneCall", "laterSteal", "goToAddress"};
					scenario = getNextScenario(rc2,rs2,in);
					break;
				case "phoneCall":
					displayMessageln("You decide to call the man, but his accent too strong to understand. You do hear some subway sounds though.");
					String[] rc3 = {"Go to the subway", "Go to the grocery store"};
					String[] rs3 = {"subway", "groceryStore"};
					scenario = getNextScenario(rc3,rs3,in);
					if(scenario.equals("groceryStore")) {
						displayMessageln("While walking to the grocery store you trip on a rock and caused you to roll down a hill and end up at the subway, almost \n"
								+ "like some divine being doesn't want to code a grocery store path. Weird.");
						scenario = "subway";
					}
					break;
				case "subway":
					displayMessageln("When you get to the subway, you can't find him. There is way too many people. While in the subway, someone");
					displayMessageln("pickpockets you without you even noticing, and you lose the wallet.");
					String[] rc5 = {"Go home and cry", "Dedicate your life to punish the person responsible for pickpocketing you", "Get a job at the subway for some reason"};
					String[] rs5 = {"cry", "punisher", "subwayJob"};
					scenario = getNextScenario(rc5,rs5,in);
					break;
				case "cry":
					displayMessageln("You go home and cry.");
					end = true;
					break;
				case "punisher":
					displayMessageln("You dedicate your life to find the man who pick pocketed you. After 3 years of searching for the pickpocketer \n"
							+ "you eventually find the man, but find that his mother has the same name as yours, and become lifelong friends. You grow old\n"
							+ "together and live happily ever after and nothing bad ever happens. THE END");
					end = true;
					break;
				case "subwayJob":
					displayMessageln("For whatever reason, you decided to get a job at the subway. The interview went well. A week later you hear back from them \n"
							+ "and they tell you that you're hired! Now you can finally get out of the house do something with your life, you lazy bafoon. ");
					end = true;
					break;
				case "laterSteal":
					displayMessageln("You feel somewhat bad, but continue on.");
					String[] rc4 = {"Steal the money", "Steal the credit card", "Steal both"};
					String[] rs4 = {"laterStealMoney", "laterStealCard", "laterStealBoth"};
					scenario = getNextScenario(rc4,rs4,in);
					if (scenario.equals("laterStealCard") || scenario.equals("laterStealBoth")) {
						displayMessageln("You decide to steal it. Unfortunately for you, the authorities were quickly able to track you down and bring you to\n"
								+ "justice. When you get put on trial, the judge unfairly sentences you to life in prison because they had dementia.");
						scenario = "jail";
					}
					break;
					
				case "laterStealMoney":
					displayMessageln("You succesfully steal the man's money and get away with it. You do very feel very bad about it.\n"
							+ "Ultimately you have doomed the world, because the man who dropped his wallet would have cured cancer, but\n"
							+ "never had the funds to start his research because he lost his wallet.");
					end = true;
					break;
				case "goToAddress":
					displayMessageln("You go try to go to his listed address. Unfortunately the neighborhood is gated, and is fenced all around.");
					String[] rc6 = {"Climb the fence", "Head to the main entrance and politely ask if you can RETURN the wallet to the address", "Give up"};
					String[] rs6 = {"climbFence", "politeAsk", "giveUpatBreakIn"};
					scenario = getNextScenario(rc6,rs6,in);
					if(scenario.equals("politeAsk")) {
						displayMessageln("You decide to go to the entrance and politely ask if you can RETURN the wallet. They tell you no because the worker"
								+ "is lazy and does not get paid enough to care. You go back and decide to climb the fence");
						scenario = "climbFence";
					}
					break;
				case "giveUpatBreakIn":
					displayMessageln("You decide at this point, despite how far you've come. The man never gets his wallet and you are a failure.");
					end = true;
					break;
				case "climbFence":
					displayMessageln("You climb the fence even though it is pretty high and fortunately you don't get hurt. You make it in the neighborhood.\n"
							+ "Now that you are in the neighborhood, you search for the house. You find the house and put the wallet in the mailbox.\n"
							+ "You climb the fence again to leave and succesfully RETURNED the wallet. Congratualtions! You win.");
					end = true;
					break;
				// end of RETURN route
	                    
				case "steal":
	                displayMessageln("You grab and wallet and head the opposite direction. This would work out 99% of the time, but there are police officer nearby eating shawarma \nwho saw you steal the wallet. You go ahead and start running away. ");
	                String[] c4 = {"Run", "Turn yourself in"};
					String[] s4 = {"runFromPolice", "jail"};
					scenario = getNextScenario(c4,s4,in);
	                    		break;
				case "runFromPolice":
					displayMessageln("You run from the police as they chase you through the street; however, you struggle running through the big crowd also walking about. You see \na ladder which provides an easy way to make it to the rooftops.");
					String[] c5 = {"Climb to the rooftops","Keep pushing through the crowd."};
					String[] s5 = {"rooftops", "crowd"};
					scenario = getNextScenario(c5,s5,in);
					break;
				case "rooftops":
					displayMessageln("You eagerly climb the ladder and successfully make it to the rooftops. You go jumping from rooftop to rooftop and cheer for joy as you have \nescaped the police. All of a sudden, a pigeon flies right in front of your face causing you to fall and 213 bones in your body.");
					end = true;
					break;
				case "crowd":
					displayMessageln("You push your way through the crowd and try to blend in to not get spotted. it ended up working, but as you celebrate, you trip on a rock on \nthe sidewalk and the police catch up.");
					String[] c6 = {"Through the rock at the police officer","Do nothing","Play dead"};
					String[] s6 = {"KO","jail","ambulance"};
					scenario = getNextScenario(c6,s6,in);
					break;
				case "KO":
					displayMessageln("You knock out one of the police officers. As you celebrate, the three other police officers arrest you. I'm not sure how you thought that /nwould help. You notice that something is off after the officers put a bag over your head after you get into the car");
					String[] c7 = {"Peek through the bag","Be patent"};
					String[] s7 = {"death","lab"};
					scenario = getNextScenario(c7,s7,in);
					break;
				case "death":
					displayMessageln("You lift the bag up just enough to see that you are in a moving car. You seem to be out of town, but the moment you start to recognize where \nyou are, you realize the person to your left noticed you peeking and shot you. RIP");
					end = true;
					break;
				case "lab":
					displayMessageln("When they finally take the bag off your head, you seem to be in some kind of lab. The officers in front of you explain the they liked your \nyour confidence and they wanted to turn you into something greater that can protect the city, the almighty, all powerful, superhero, drumroll please...          Rock-Man!");
					String[] c8 = {"Accept the responsibilities as the greatest superhero of all time.","Decline"};
					String[] s8 = {"superhero","youKnowTooMuch"};
					scenario = getNextScenario(c8,s8,in);
					break;
				case "youKnowTooMuch":
					displayMessageln("You politely decline. The officers let you know that you know too much about there secret project and now they need to \u2620 you.");
					end = true;
					break;
				case "superhero":
					displayMessageln("You become the greatest superhero known to man for years to come.");
					end = true;
					break;
				case "ambulance":
					displayMessageln("The police officers stop as they realize that you might have gotten hurt from the fall. They call in an ambulance to try and help you. They \n"
							+ "put you on the ambulance and leave you alone breifly. This is you're chance to get away.");
					String[] c9 = {"Charge at the wall to break out.","Walk out the door","Hide"};
					String[] s9 = {"injured","sneak","hidden"};
					scenario = getNextScenario(c9,s9,in);
					break;
				case "injured":
					displayMessageln("You charge against the wall of the ambulance to break free. As you charge, you crash into the strong, heavy, sturdy, very supported wall and \n"
							+ "relize that everything in your body hurts. I don't know what you thought would happen. At least you're in an ambulance. Also, now you have a huge medical \n"
							+ "bill. Was it worth it?");
					end = true;
					break;
				case "hide":
					displayMessageln("You hide in the ambulance. When the police see you missing from the ambulance, they \n"
							+ "conduct a search party and never find you. Now you are living in the shadows forever.");
					end = true;
					break;
				case "sneak":
					displayMessageln("You sneek out the ambulance and see that outside, all the officers are there and see you escape. This is akward.");
					String[] c10 = {"Run for it","Give up"};
					String[] s10 = {"run","jail"};
					scenario = getNextScenario(c10,s10,in);
					if(scenario.equals("jail")) {
						displayMessageln("The officers imedietly arest you. You are now charged with more than you were initialy and have a longer sentance. ");
					}
					break;
				case "run":
					displayMessageln("You make a run for it. As you bolt away, the officers chase you down. ");
					String[] c11 = {"Hide in a dumpster.","Keep running", "Disguise yourself"};
					String[] s11 = {"escape","keepRunning", "disguise"};
					scenario = getNextScenario(c11,s11,in);
					break;
				case "escape":
					displayMessageln("You turn a corner and see a dumbster. Without hesatation, you instantly dive striaght in. When the police turn the corner, they keep running \n"
							+ "without seeing you at all. Congradulations, you escaped with the wallet, but at what cost?");
					end = true;
					break;
				case "keepRunning":
					displayMessageln("You keep running as fast as you can. You look behind you to see that the police officers have stoped following you. You then look forward and see \n"
							+ "why as you run straight of the dock and ito the ocean. You should pay better attention to where you're going.");
					end = true;
					break;
				case "disguise":
					displayMessageln("You turn a corner and choose to take off your glasses, and through them in a nearby dupster. You also style your hair a little differently and hope \n"
							+ "that Supermans disguise actualy works as you just sit there and wait. The officers get to the corner and all run past you. The disguise worked, but now your \n"
							+ "wanted in 29 states and forever on the run from the cops. At least you still have the wallet. ");
					end = true;
					break;
				case "jail":
					displayMessageln("Soooo... You're in jail. You even have a roomate named Tod. You are stuck here... Forever.");
					String[] jc1 = {"Serve your life sentence", "Plan an escape"};
					String[] js1 = {"acceptance", "escapePlan"};
					scenario = getNextScenario(jc1,js1,in);
					break;
				
				
				case "escapePlan":
					displayMessageln("You decide that you want to break out.");
					String[] jc2 = {"Search the room", "Socialize with Tod."};
					String[] js2 = {"searchRoom", "socialize"};
					scenario = getNextScenario(jc2,js2,in);
					break;
					
				case "acceptance":

					displayMessageln("You decide to serve your sentance and live the rest of your life in jail. Not much intresting things happen, your in jail, and thats about it. You end \n"

							+ "up dieing at the age of 74 from pnemonia. ");
					end = true;
					break;

				case "socialize":

					displayMessageln("You start talking to your roommate, Tod. You quickly became freinds as you realize that both of your judges had dementia. While in the cafateria, you \n"

							+ "admit to Tod that you desire to escape. He admits that his old roomate wanted to escape as well. He tried to dig a hole through the wall and got about 3 inches \n"

							+ "deep. Fortunatly, noone was able to hear your conversation due to a loud fight in the background.");

					String[] c12 = {"Ask about how to escape","Ask what happened to Tod's previous roomate."};

					String[] s12 = {"escapeRoute","informationRoute"};

					scenario = getNextScenario(c12,s12,in);

					break;

				case "escapeRoute":
					displayMessageln("Tod tells you that the old roomate was planning an escape for a while and you could check around the room for some useful tools. You go back to the cell.");
					String[] co12 = {"Change your mind and serve you sentance with Tod.","Look around the room."};
					String[] so12 = {"acceptance","searchRoom"};

					scenario = getNextScenario(co12,so12,in);

					break;
				case "informationRoute":

					displayMessageln("He ended up escaping through a crawl space in the sewers. He used a map to know that it was there. Unfortunatly, there were police waiting on the other \n"

							+ "side and he got moved to a more secure cell.");

					String[] c13 = {"Try to escape through the sewers.","Find another way."};

					String[] s13 = {"sewer","alternateEscape"};

					scenario = getNextScenario(c13,s13,in);

					break;

				case "alternateEscape":

					displayMessageln("When you get back to the room, Tod shows you the map and you find that there is a closet not to far away that you are able to sneak into it. As you go to execute \n"

							+ "the paln, a gaurd imediatly catches you.");

					String[] c14 = {"Bribe the gaurd.","Make a pinkie promise."};

					String[] s14 = {"bribe","promise"};

					scenario = getNextScenario(c14,s14,in);

					break;

				case "bribe":

					displayMessageln("You reach to your pocket to try and bribe the gaurd but you realize that they confiscated your wallet and you don't have money. You imeadeatly get moved to a \n"

							+ "more secure prison cell where escape is impossible.");

					end = true;

					break;

				case "promise":

					displayMessageln("You make a pinkie promise to the gaurd that you won't try to escape. The gaurd believes this and lets you through. When you get in, you take a uniform and it fits \njust right.");

					String[] c15 = {"Walk out and escape","Bring Tod with you."};

					String[] s15 = {"caught","WooHoo"};

					scenario = getNextScenario(c15,s15,in);

					break;

				case "WooHoo":

					displayMessageln("You go to the cell and get Tod, as your walking out with Tod, a suspitious gaurd stops you and asks where your going. You say some vague things about transfering an \n"

							+ "inmate and he lets you go. \nCongradulations! You escaped with Tod and now you have a new best friend and live happily ever after in Mexico.");

					end = true;

					break;

				case "caught":

					displayMessage("As you're making your way out, a suspitious gaurd stops you and asks you where your going. You struggle to make up a good excuse and the gaurd catches on to what \nyou've done and locks you in a more secure cell where escape is impossible.");

					end = true;

					break;


				
				case "searchRoom":
					displayMessageln("You search the room. Near your bed you find a small crack in the wall and a small rock hammer.\n"
							+ "It looks like the last inmate was trying to mine his way out. You also notice that under your bed \n"
							+ "is a map of the entire prison layout with handwriting describing the sewer layout. Looks like whoever \n"
							+ "was there last was planning an escape for a while. Anyway you see a entrance to the sewer in the kitchen \n"
							+ "from the cafateria.");
					String[] jec1 = {"Mine your way out of the prison from your cell.", "Attempt to break out thru the sewer somehow"};
					String[] jes1 = {"mining", "sewers"};
					scenario = getNextScenario(jec1,jes1,in);
					break;
				case "mining":
					displayMessageln("You decide to continue mining to make the small crack in the wall bigger and bigger. This of course takes \n"
							+ "very long to do. This takes roughly 30 years to mine a hole big enough to fit yourself thru. After you finally \n"
							+ "escape after the long mining expedition, you break free. You go on to live the rest of your life in Mexico \n"
							+ "feeling ashamed knowing you put yourself through all of this just for a wallet");
					end = true;
					break;
				case "sewers":
					displayMessageln("You decide to try to get into the cafateria kitchen to get into the sewer.");
					String[] jec2 = {"Play the long game and attempt to get a job in the kitchen after serving some time", "Break into the kitchen as soon as it is possible"};
					String[] jes2 = {"longGame", "breakInCafeteria"};
					scenario = getNextScenario(jec2,jes2,in);
					break;
				case "longGame":
					displayMessageln("Eventually you get the kitchen job. You work your first day. According to the map you go off of there should \n"
							+ "be a crawl space underneath some of the kitchen equipment. You check underneath and you find a crawlspace directly \n"
							+ "leading to a sewage pipe which leads to the exit.");
					String[] jec3 = {"Immediately climb thru the crawlspace and through the sewer to escape", "Wait for the right opportunity to climb through"};
					String[] jes3 = {"earlyEscape","extraLongGame"};
					scenario = getNextScenario(jec3,jes3,in);
					break;
				case "breakInCafeteria":
					displayMessageln("While the guards are looking away for a second you decide try to go thru the kitchen doors and break in. \n"
							+ "Of course this does not work. It is a prison and they get to you immediately when you go into the kitchen unathorized. \n"
							+ "You get put in a more secure cell and never make it out.");
					end = true;
					break;
				case "earlyEscape":
					displayMessageln("You decide to crawl thru the sewage pipe immediately. The security quickly notices you are missing and realizes \n"
							+ "that you are climbing thru and are now waiting on the other side of the pipe to bring you to a more secure cell. You never \n"
							+ "escape.");
					end = true;
					break;
				case "extraLongGame":
					displayMessageln("You decide to work in the kitchen and wait until the perfect moment to plan your escape. One day a fight breaks \n"
							+ "out in the cafateria and you decide that this is the perfect moment and you go into the crawl space and leave thru the \n"
							+ "sewer and crawl your way to freedom. By the time they realize you're gone you are far enough away such that they \n"
							+ "cannot find you. You go to Mexico to live a new life and live happily ever after, but the man never got his wallet RETURNED.");
					end = true;
					break;
			}
            
           	 // This displays 
        		if (end) {
            			displayMessageln("\nDo you wish to go to a previous option?");
            	
            			String[] ce = {"yes","no"};
            	
		            	String selection = getNextScenario(ce, ce, in);
		            	
		            	if(selection.equals("yes")) {
		            		end = false;
		            		while (true) {
		            			displayMessage("Choose a number between 1 and " + (choiceHistory.size()-1) + ": ");
		            			if (!in.hasNextInt()) {
		            				displayMessageln("INVALID! Must type integer");
		            				in.nextLine();
		            				continue;
		            			}
		            			int goTo = in.nextInt() - 1;
		            			in.nextLine();
		            			
		            			if (! (0<=goTo && goTo < choiceHistory.size()) ) {
		            				displayMessageln("INVALID! Must type value within the given range");
		            				continue;
		            			}
		            			scenario = choiceHistory.get(goTo);
		            			choiceHistory.subList(goTo,choiceHistory.size()).clear();
		            			scenarioNumber = goTo;
		            			break;
		            		}
		            	}
		            	else {
		            		displayMessageln("Thank you playing!");
		            	}
            		}
            
		} // end of while loop

		in.close();
		System.exit(0);
	} // end of main method
} // end of class
