import java.util.Scanner;
public class Main{

   public static void main(String[] args){
      //variables
      int experience = 0, enemyNum=0, encountNum=0, stageNum=0, count=0,
         forestNum=0, desertNum=0, courtNum=0, cityNum=0, godNum=0,
         playerLevel=1, userNum=0, skillNum=0, playerHP=0;
      boolean explore=false, cont=true, right=false;
      String playerName="",userInput="", 
             menu="What would you like to do: \n (1)-Go to the Shop \n  (2)-Continue with Quest \n  (3)Explore \n  (4)Quit",
             yes ="Y", no="N";
      double money=0.0, itemCost=0.0;
      Scanner input = new Scanner(System.in);
      Item[] inventory= new Item[3]; //weapon, necklace, hat
      
      //stats
      final int INT=0, SPD=1, STR=2, CHR=3, LVL_UP=1, HLT_UP=10, MAX_LEVEL=20, ENEM_MIN=2,
               FOREST=1, DESERT=2, COURT=3, CITY=4, GODS=5,
               SHOP=1, MAP=2, EXPLORE=3, QUIT=4, EXIT=999,
               FOREST_MAX=6, DESERT_MAX=10, COURT_MAX=10, CITY_MAX=8, GODS_MAX=5,
               WEAPON=0, NECKLACE=1, HAT=2;
      //weapon stats
      final int[] LEVEL1W = {0,1,1,0};
      final int[] LEVEL5W = {0,5,5,0};
      final int[] LEVEL10W = {0,10,10,0};
      final int[] LEVEL15W = {0,15,15,0};
      final int[] LEVEL20W = {0,20,20,0};
      
      //necklace stats
      final int[] LEVEL1N = {0,0,0,1};
      final int[] LEVEL5N = {0,0,0,5};
      final int[] LEVEL10N = {0,0,0,10};
      final int[] LEVEL15N = {0,0,0,15};
      final int[] LEVEL20N = {0,0,0,20};
      
      //hat stats
      final int[] LEVEL1H = {1,0,0,0};
      final int[] LEVEL5H = {5,0,0,0};
      final int[] LEVEL10H = {10,0,0,0};
      final int[] LEVEL15H = {15,0,0,0};
      final int[] LEVEL20H = {20,0,0,0};
      
      //item prices
      final double LVL1COST = 25.6, LVL5COST = 752.8, LVL10COST =1549.6 , LVL15COST =2483.1 , LVL20COST =4892.8;
      
      //create items and bosses
      //swords
      Item faith = new Item("Faithkeeper", "The sword of FateLands, used by the Hero of Old. Just seeing the sword brings faith.", LVL1COST, 1, LEVEL1W);
      Item silencer = new Item("Silencer", "For when your enemies don't know how to shut it. This sword should help bring some peace.", LVL5COST, 5, LEVEL5W);
      Item lament = new Item("Lament, Foe of Darkness", "The darkness cannot exist without light... like a warrior can't exist without a sword", LVL10COST, 10, LEVEL10W);
      Item obsidian = new Item("The Obsidian Katana", "With a blade as dark as your enemies hearts, nothing will pierce deeper.", LVL15COST, 15, LEVEL15W);
      Item destiny = new Item("Destiny's Song", "Destiny is a path that is always followed. This sword will show everyone your destiny.", LVL20COST, 20, LEVEL20W);
      
      //bows
      Item red = new Item("Redwood Straight Bow", "This bow is a basic bow for most to begin on. Nothing special about it.", LVL1COST, 1, LEVEL1W);
      Item striker = new Item("Striker's Mark", "A bow to prove the mastery of your skills.", LVL5COST, 5, LEVEL5W);
      Item phantom = new Item("Phantom Strike", "Attack as stealth as darkness in night.", LVL10COST, 10, LEVEL10W);
      Item devil = new Item("Devil's Sting", "This bow will help you to sting your enemies with the Devil's heat, a burn that will never leave.", LVL15COST, 15, LEVEL15W);
      Item calamity = new Item("Calamity", "Calamity will always change the lives of everyone around; this bow will show you are the force providing the Calamity.", LVL20COST, 20, LEVEL20W);
      
      //scythes
      Item farm = new Item("Farming Sickle", "This scythe is a great makeshift weapon if need be.", LVL1COST, 1, LEVEL1W);
      Item downfall= new Item("Downfall", "Bring your enemies to their knees with this Scythe.", LVL5COST, 5, LEVEL5W);
      Item nightfall= new Item("Nightfall, Annihilation of Mystery", "The only mystery about this scythe is was the long name truly neccessary.", LVL10COST, 10, LEVEL10W);
      Item death= new Item("Death's Scalpel", "Disect your enemies thouroughly with this Scythe.", LVL15COST, 15, LEVEL15W);
      Item expiration= new Item("Expiration", "No one can stop the end from occuring. It always ends and you can bring their end with this scythe.", LVL20COST, 20, LEVEL20W);
      
      //necklaces
      Item citrine = new Item("The Citrine Pledge", "The necklace of FateLands, worn by the Hero of Old. This devotes the Hero's pledge to the world.", LVL1COST, 1, LEVEL1W);
      Item heaven = new Item("Heavenely Petal", "No one can resist the pull of Heaven. Everyone will be more likely to listen to the wearer of this necklace.", LVL5COST, 5, LEVEL5W);
      Item wings = new Item("Sinful Wings", "Convince others to listen to you, this necklace whispers to the wearer to assist in decisions.", LVL10COST, 10, LEVEL10W);
      Item onyx= new Item("Onyx Vision", "This necklace will assist you to see into the dark.", LVL15COST, 15, LEVEL15W);
      Item dearest = new Item("Dearest Life", "Why ignore someone who is so dear to you, even when they've just met you. This necklace will make everyone believe you are the dearest person to them.", LVL20COST, 20, LEVEL20W);
      
      //hats
      Item hood = new Item("Hood of Sacred Kings", "The hat of FateLands, worn by the Hero of Old. Given to the hero by the 6 Sacred Kings.", LVL1COST, 1, LEVEL1W);
      Item cap = new Item("Champion's Cap of the World", "This hat will show everyone the champion you've become.", LVL5COST, 5, LEVEL5W);
      Item facemask = new Item("Phantom Facemask", "Blend into the night with this mask and hat combo. No one can fight the phantom.", LVL10COST, 10, LEVEL10W);
      Item wicked = new Item("Wicked Wool Hood", "Why be good when you can be wicked good? This hat will help give you that extra edge.", LVL15COST, 15, LEVEL15W);
      Item cataclysm= new Item("Curator of the Cataclysm", "Prove to everyone the force you've beome and the greater force wou can wreak. This hat reveals the all powerful you've become.", LVL20COST, 20, LEVEL20W);
      
      Item[] lvl1Items = {red, farm}; //only 2 items here because player is given the rest of the items
      Item[] lvl5Items = {silencer, striker, downfall, heaven, cap}; //level 5 items for shop
      Item[] lvl10Items = {lament, phantom, nightfall, wings, facemask}; //level 10 items for shop
      Item[] lvl15Items = {obsidian, devil, death, onyx, wicked}; //level 15 items for shop
      Item[] lvl20Items = {destiny, calamity, expiration, dearest, cataclysm}; //level 20 items for shop
      
      //introduce user to game
      System.out.println("Fatelands had once had peace. Monsters, bandits and wild animals stayed in their domains, leaving the people of Fatelands to themselves.");
      System.out.println("Fatelands had been protected by the Hero of Old, given to them by the 6 Sacred Kings. One day, wild animals began attacking, searching for food and shelter.");
      System.out.println("The people of Fatelands did not worry, knowing their hero would come back to them. Unfortunately, they did not realize how long it would be.");
      System.out.println("After several weeks, the people's hope waned. Months went by and a package arrived to the carrier who lived just outside of town.");
      System.out.println("Inside the package contained the Hero of Old's blade, hood and necklace. The carrier could only speculate what happened to the Hero of Old.");
      System.out.println("The carrier stowed away the items, saving it for a new hero. Years passed and bandits and monsters ran amock, tearing away the peace and hope from the people of Fatelands.");
      System.out.println("Who could save the people from the return of chaos?");
      System.out.println();
      System.out.println("~Hit enter to continue~");
      input.nextLine(); //userinput not required to be recorded.
      System.out.println("Your head throbbed upon waking up, surroundings unfamiliar. You were laying upon a wooden post bed, a dim light filtering into the room from the barred window.");
      System.out.println("Rising from the bed, you could see a small kitchen with a door to the left. A wardrobe, chest and a ladder leading up to a small loft, probably used for storage.");
      System.out.println("A sound outside the room catches your attention. You decide to get up and go towards the source of the sound.");
      System.out.println("Upon opening the door, you see a short, fluffy man with a leather satchel sitting on a bench sorting letters. He looks up at the door, away from the letters he was sorting.");
      System.out.println(" \"I see you've finally woken up\", the man stated, standing up and placing the letters back in the satchel. \"How are you feeling?\" he asked.");
      input.nextLine(); //userinput not required to be recorded.
      System.out.println("\"Yes, that's understandable.\", nodding his head, he looked out to the forest away from the town.");
      System.out.println("\"I found you on the edge of the forest there. There's a lot of dangerous things out there.");
      System.out.println("It's a miracle you've survived this long.\" he sadly smiled over at me. \"I didn't introduce myself. I'm the carrier of Fatelands.");
      System.out.println("Not much mail to send though. Most stick to themselves and anyone who travels doesn't send mail.\" The carrier pulled the letters back out of his satchel.");
      System.out.println("\"All of these were to someone who is no longer here. No family to deliver them to either. People lost hope and the letters stopped.");
      System.out.println("Although the people could regain hope again. We just need a hero.\" The carrier looked off to the town. \"What was your name?");

      //ask for user info & set user info
      playerName = input.nextLine();
      while (right==false){
         System.out.println("\"So your name is "+playerName+", correct?\"");
         System.out.println("~If correct, type 'Y' for yes if not type 'N' for no.~");
         userInput = input.nextLine();
         userInput.toUpperCase();
         if (userInput.equals(yes)){
            right=true;
         }
         else{
            System.out.println("What was your name?");
            playerName=input.nextLine();
         }
      }
      System.out.println("\""+playerName+", What do you believe your destiny is?\"");
      input.nextLine(); //userinput not required to be recorded.
      Character player = new Character(playerName); //creates character for player
      System.out.println("\"Would you want to restore peace to Fatelands?\"");
      System.out.println("~If you do not want to restore peace to Fatelands, type 'Quit'. Spelling will matter.~");
      userInput=input.nextLine();
      if(userInput.equals("Quit")){
         cont=false;
      }
      while(cont==true){
         playerHP=player.getHealth();
         if(userInput.equals("Quit")){
            cont=false;
         }
         if (count<1){
            System.out.println("\"Well, since you'll be assisting with bringing peace to fatelands. You should have some gear.");
            System.out.println("It's old, but it will help.\" The carrier stood up and started making his way back into the house");
            System.out.println("Following him into the house, he made his way up the ladder, pulling down a dusty, resealed package");
            System.out.println("\"Here, try this on\", he tossed the package to me.");
            System.out.println("Opening the package I found some slightly rusty, old armor, a worn blade of a sword, and a worn and torn citrine necklace.");
            System.out.println("I equipped the pieces.");
            System.out.println("~You have obtained "+faith.getName()+", "+citrine.getName()+", "+hood.getName()+"!~");
            //add beggining items to inventory (weapon, necklace, hat)
            inventory[0]=faith;
            inventory[1]=citrine;
            inventory[2]=hood;
            System.out.println("\"Those should help in the meantime. If things improve you should be able to buy better quality gear later. Or if you're lucky you can find special items exploring.");
            System.out.println("Just don't get yourself killed. You only have 1 life.\" The carrier walked outside and I followed behind him.");
            System.out.println("\"If you go to the left, you'll hit the town. To the right, you have the forest. And to get to other places, you'll need to go through the forest.");
            System.out.println("You can take this map,\" He pulled a map out of his satchel and handed it over to me. \"It's old, but it can help guide you around.\"");
            System.out.println("~You've obtained a map!~");
            System.out.println("\"Have any questions before you head out?\"");
            System.out.println("~You have some options here, you could: ");
            System.out.println(" (1)-Ask where the armor came from"); //int
            System.out.println(" (2)-Ask where he suggests to go"); //spd
            System.out.println(" (3)-Ask for some battle tips");  //str
            System.out.println(" (4)-Ask for some coins to assist on your quest"); //chr
            System.out.println(" (5)-Ask him to join you"); //fail
            System.out.println(" (6)-No, I'm good.");
            System.out.println(" Be careful "+playerName+" you may only choose one.~");
            userNum= input.nextInt();
            if(userNum==1){ //int increase
               skillNum=player.getSkLvl(INT)+1;
               player.setSkLvl(skillNum, INT);
               System.out.println("\"There used to be someone who brought peace. They wore that armor and it's seen as a symbol of peace among the people of fatelands.\"");
               System.out.println("~Intelligence Increased~");
            }
            else if(userNum==2){ //spd increase
               skillNum=player.getSkLvl(SPD)+1;
               player.setSkLvl(skillNum,SPD);
               System.out.println("\"Well, if you feel that sword isn't right for you, you can try the shop.");
               System.out.println("Or if you want to get to saving the world as quickly as possible, you can go ahead and head out."); 
               System.out.println("If you want some training before you head out, you can explore the woods.\"");
               System.out.println("~Speed Increased~");
            }
            else if(userNum==3){//str increase
               skillNum=player.getSkLvl(STR)+1;
               player.setSkLvl(skillNum, STR);
               System.out.println("\"Well, it's been a while since I did my mandatory service, but i'll teach you some tricks.\"");
               System.out.println("After several hours, the carrier smiled at you. \"That's all I got for you, but you've got a good foundation.\"");
               System.out.println("~Strength Increased~");
            }
            else if(userNum==4){//chr increase
               player.setCoins(2.5);
               skillNum=player.getSkLvl(CHR)+1;
               player.setSkLvl(skillNum,CHR);
               System.out.println("\"I don't have much, but here's some to get you started,\" the carrier handed some coins over.");
               System.out.println("~Charisma Increased~");
               System.out.println("You've gained 2.5 coins!");
            }
            else if(userNum==5){//fail
               right=checkStat(player,CHR,10);
               if(right==false){
                  System.out.println("~You have failed the Charisma check.~");
                  System.out.println("The carrier laughs, \"No, i'm too old to be going and saving the world.");
                  System.out.println("I just want to deliver letters\" the carrier stated longingly.");
               }
            }
            else{ //no stat increase
               System.out.println("\"Well it seems you're all set then.");
            }
            System.out.println("\"Good luck!\" the carrier yelled as I headed off to restore peace");
         }
         //menu
            /*
               player will have options to go to the shop, continue on with their quest, explore or quit. If a player quits, their progress will not be saved and they will need to start over.
            */
         System.out.println();
         System.out.println(menu);
         right=false;
         while (right==false){
            userNum=input.nextInt();
            if(userNum>=1&&userNum<=4){ //1-4 menu options
               right=true;
            }
         }
         if(userNum==SHOP){ //shop
            System.out.println("You enter the shop, taking a look around when the shop keeper calls out to you. \"Hero, have a look at this!\"");
            money=player.getCoins(); //will be used to compare to item prices if user can purchase item
            if(playerLevel<5){ //display level 1 items
               for (int i=0; i<lvl1Items.length;i++){
                  System.out.println("_____________________________________________________");
                  //item number will be 1 hire than array placement to make sure first item is number 1 and not 0.
                  System.out.println("Item #"+(i+1));  
                  lvl1Items[i].displayItem();
                  System.out.println("");
                  System.out.println("_____________________________________________________");
               }//for
               while (userNum < EXIT){ //until user puts in number to leave shop
                  System.out.println("\"See anything you'd like?\" The shop keeper asked happily. \"If not you can always find something next time!\"");
                  System.out.println("~Enter the item number you'd like to purchase or 999 to leave~");
                  userNum=input.nextInt();
                  if (userNum <EXIT){ //will make sure correct item is selected in array list
                     userNum--;
                     System.out.println(userNum);
                  }//if
                  if(userNum>lvl1Items.length-1){ //if number selected is not in array length
                     System.out.println("\"Hero, I dont carry that item.\" The shop keeper looks distressed and sad.");
                  }//if
                  if(userNum<lvl1Items.length){ //if number selected is in array length
                     itemCost=lvl1Items[userNum].getPrice();
                     if(money<itemCost){ //user doesn't have enough money to cover the item
                        System.out.println("Unfortunately, you don't have enough to purchase that item. ");
                     }//if
                     if(money>=itemCost){ //user has enough money to cover item
                        System.out.println("\"Congratulations, you have enough to purchase this Hero!\" The shop keeper smiles, \"Would you like to purchase it?\"");
                        right=false;
                        while (right == false){
                           System.out.println("~Type (Y) for yes and (N) for no, spelling will matter~");
                           userInput=input.nextLine();
                           if(userInput.equals(yes)){
                              money -= itemCost; //purchase item
                              player.setCoins(money); //updates player money
                              right=true; //exits out of while loop
                              System.out.println("\"The item is yours Hero!\" the shop keeper handed the item over.");
                              //array placement here doesn't matter as all items in array are weapons, future items will matter
                              inventory[WEAPON]=lvl1Items[userNum];
                              System.out.println("~The item "+inventory[WEAPON].getName()+" has been placed into your inventory~");
                           }//if
                           else if(userInput.equals(no)){
                              System.out.println("\"If you change your mind, it will be here!\" the shop keeper leaned against the counter.");
                              right=true; //exits out of while loop
                           }//else if
                           else{
                              System.out.println("The shop keeper looked a bit worried, \"My apologies Hero, but I didn't catch that. Could you repeat that?\"");
                           }//else
                        }//while - purchase item or not purchase item
                     }//if - user has money
                  }//if -item in array
               }//while - user in shop for lvl1 items
               if (userNum==EXIT){
                  System.out.println("The shop keeper waves goodbye to you as you leave. \"Until next time Hero!\"");
               }    
            }//if -lvl 1 items
            if(playerLevel>=5 && playerLevel<10){ //display level 5 items
               for (int i=0; i<lvl5Items.length;i++){
                  System.out.println("_____________________________________________________");
                  //item number will be 1 hire than array placement to make sure first item is number 1 and not 0.
                  System.out.println("Item #"+(i+1));  
                  lvl5Items[i].displayItem();
                  System.out.println("");
                  System.out.println("_____________________________________________________");
               }//for
               while (userNum < EXIT){ //until user puts in number to leave shop
                  System.out.println("\"See anything you'd like?\" The shop keeper asked happily. \"If not you can always find something next time!\"");
                  System.out.println("~Enter the item number you'd like to purchase or 999 to leave~");
                  userNum=input.nextInt();
                  if (userNum <EXIT){ //will make sure correct item is selected in array list 1=0, 2=1, etc.
                     userNum--;
                  }//if
                  if(userNum>lvl5Items.length){ //if number selected is not in array length
                     System.out.println("\"Hero, I dont carry that item.\" The shop keeper looks distressed and sad.");
                  }//if
                  if(userNum<lvl5Items.length){ //if number selected is in array length
                     itemCost=lvl5Items[userNum].getPrice();
                     if(money<itemCost){ //user doesn't have enough money to cover the item
                        System.out.println("Unfortunately, you don't have enough to purchase that item. ");
                     }//if
                     if(money>=itemCost){ //user has enough money to cover item
                        System.out.println("\"Congratulations, you have enough to purchase this Hero!\" The shop keeper smiles, \"Would you like to purchase it?\"");
                        right=false;
                        while (right == false){
                           System.out.println("~Type (Y) for yes and (N) for no, spelling will matter~");
                           userInput=input.nextLine();
                           if(userInput.equals(yes)){
                              money -= itemCost; //purchase item
                              player.setCoins(money); //updates player money
                              right=true; //exits out of while loop
                              System.out.println("\"The item is yours Hero!\" the shop keeper handed the item over.");
                              //first 3 items 0-2 are weapons, 3 are necklaces, 4 are hats
                              if(userNum<=2){
                                 inventory[WEAPON]=lvl5Items[userNum];
                              }
                              if(userNum==3){
                                 inventory[NECKLACE]=lvl5Items[userNum];
                              }
                              if(userNum==4){
                                 inventory[HAT]=lvl5Items[userNum];
                              }
                              System.out.println("~The item "+inventory[WEAPON].getName()+" has been placed into your inventory~");
                           }//if
                           else if(userInput.equals(no)){
                              System.out.println("\"If you change your mind, it will be here!\" the shop keeper leaned against the counter.");
                              right=true; //exits out of while loop
                           }//else if
                           else{
                              System.out.println("The shop keeper looked a bit worried, \"My apologies Hero, but I didn't catch that. Could you repeat that?\"");
                           }//else
                        }//while - purchase item or not purchase item
                     }//if - user has money
                  }//if -item in array
               }//while - user in shop for items
               if (userNum==EXIT){
                  System.out.println("The shop keeper waves goodbye to you as you leave. \"Until next time Hero!\"");
               } 
            }//if -lvl 5 items
            if(playerLevel>=10 && playerLevel<15){ //display level 10 items
               for (int i=0; i<lvl10Items.length;i++){
                  System.out.println("_____________________________________________________");
                  //item number will be 1 hire than array placement to make sure first item is number 1 and not 0.
                  System.out.println("Item #"+(i+1));  
                  lvl10Items[i].displayItem();
                  System.out.println("");
                  System.out.println("_____________________________________________________");
               }//for
               while (userNum < EXIT){ //until user puts in number to leave shop
                  System.out.println("\"See anything you'd like?\" The shop keeper asked happily. \"If not you can always find something next time!\"");
                  System.out.println("~Enter the item number you'd like to purchase or 999 to leave~");
                  userNum=input.nextInt();
                  if (userNum <EXIT){ //will make sure correct item is selected in array list 1=0, 2=1, etc.
                     userNum--;
                  }//if
                  if(userNum>lvl10Items.length){ //if number selected is not in array length
                     System.out.println("\"Hero, I dont carry that item.\" The shop keeper looks distressed and sad.");
                  }//if
                  if(userNum<lvl10Items.length){ //if number selected is in array length
                     itemCost=lvl10Items[userNum].getPrice();
                     if(money<itemCost){ //user doesn't have enough money to cover the item
                        System.out.println("Unfortunately, you don't have enough to purchase that item. ");
                     }//if
                     if(money>=itemCost){ //user has enough money to cover item
                        System.out.println("\"Congratulations, you have enough to purchase this Hero!\" The shop keeper smiles, \"Would you like to purchase it?\"");
                        right=false;
                        while (right == false){
                           System.out.println("~Type (Y) for yes and (N) for no, spelling will matter~");
                           userInput=input.nextLine();
                           if(userInput.equals(yes)){
                              money -= itemCost; //purchase item
                              player.setCoins(money); //updates player money
                              right=true; //exits out of while loop
                              System.out.println("\"The item is yours Hero!\" the shop keeper handed the item over.");
                              //first 3 items 0-2 are weapons, 3 are necklaces, 4 are hats
                              if(userNum<=2){
                                 inventory[WEAPON]=lvl10Items[userNum];
                              }
                              if(userNum==3){
                                 inventory[NECKLACE]=lvl10Items[userNum];
                              }
                              if(userNum==4){
                                 inventory[HAT]=lvl10Items[userNum];
                              }
                              System.out.println("~The item "+inventory[WEAPON].getName()+" has been placed into your inventory~");
                           }//if
                           else if(userInput.equals(no)){
                              System.out.println("\"If you change your mind, it will be here!\" the shop keeper leaned against the counter.");
                              right=true; //exits out of while loop
                           }//else if
                           else{
                              System.out.println("The shop keeper looked a bit worried, \"My apologies Hero, but I didn't catch that. Could you repeat that?\"");
                           }//else
                        }//while - purchase item or not purchase item
                     }//if - user has money
                  }//if -item in array
               }//while - user in shop for items 
               if (userNum==EXIT){
                  System.out.println("The shop keeper waves goodbye to you as you leave. \"Until next time Hero!\"");
               }   
            }//if -lvl 10 items
            if(playerLevel>=15 && playerLevel<20){ //display level 15 items
               for (int i=0; i<lvl15Items.length;i++){
                  System.out.println("_____________________________________________________");
                  //item number will be 1 hire than array placement to make sure first item is number 1 and not 0.
                  System.out.println("Item #"+(i+1));  
                  lvl15Items[i].displayItem();
                  System.out.println("");
                  System.out.println("_____________________________________________________");
               }//for
               while (userNum < EXIT){ //until user puts in number to leave shop
                  System.out.println("\"See anything you'd like?\" The shop keeper asked happily. \"If not you can always find something next time!\"");
                  System.out.println("~Enter the item number you'd like to purchase or 999 to leave~");
                  userNum=input.nextInt();
                  if (userNum <EXIT){ //will make sure correct item is selected in array list 1=0, 2=1, etc.
                     userNum--;
                  }//if
                  if(userNum>lvl15Items.length){ //if number selected is not in array length
                     System.out.println("\"Hero, I dont carry that item.\" The shop keeper looks distressed and sad.");
                  }//if
                  if(userNum<lvl15Items.length){ //if number selected is in array length
                     itemCost=lvl15Items[userNum].getPrice();
                     if(money<itemCost){ //user doesn't have enough money to cover the item
                        System.out.println("Unfortunately, you don't have enough to purchase that item. ");
                     }//if
                     if(money>=itemCost){ //user has enough money to cover item
                        System.out.println("\"Congratulations, you have enough to purchase this Hero!\" The shop keeper smiles, \"Would you like to purchase it?\"");
                        right=false;
                        while (right == false){
                           System.out.println("~Type (Y) for yes and (N) for no, spelling will matter~");
                           userInput=input.nextLine();
                           if(userInput.equals(yes)){
                              money -= itemCost; //purchase item
                              player.setCoins(money); //updates player money
                              right=true; //exits out of while loop
                              System.out.println("\"The item is yours Hero!\" the shop keeper handed the item over.");
                              //first 3 items 0-2 are weapons, 3 are necklaces, 4 are hats
                              if(userNum<=2){
                                 inventory[WEAPON]=lvl15Items[userNum];
                              }
                              if(userNum==3){
                                 inventory[NECKLACE]=lvl15Items[userNum];
                              }
                              if(userNum==4){
                                 inventory[HAT]=lvl15Items[userNum];
                              }
                              System.out.println("~The item "+inventory[WEAPON].getName()+" has been placed into your inventory~");
                           }//if
                           else if(userInput.equals(no)){
                              System.out.println("\"If you change your mind, it will be here!\" the shop keeper leaned against the counter.");
                              right=true; //exits out of while loop
                           }//else if
                           else{
                              System.out.println("The shop keeper looked a bit worried, \"My apologies Hero, but I didn't catch that. Could you repeat that?\"");
                           }//else
                        }//while - purchase item or not purchase item
                     }//if - user has money
                  }//if -item in array
               }//while - user in shop for items  
               if (userNum==EXIT){
                  System.out.println("The shop keeper waves goodbye to you as you leave. \"Until next time Hero!\"");
               }  
            }//if -lvl 15 items
            if(playerLevel>=20){ //display level 20 items
               for (int i=0; i<lvl20Items.length;i++){
                  System.out.println("_____________________________________________________");
                  //item number will be 1 hire than array placement to make sure first item is number 1 and not 0.
                  System.out.println("Item #"+(i+1));  
                  lvl20Items[i].displayItem();
                  System.out.println("");
                  System.out.println("_____________________________________________________");
               }//for
               while (userNum < EXIT){ //until user puts in number to leave shop
                  System.out.println("\"See anything you'd like?\" The shop keeper asked happily. \"If not you can always find something next time!\"");
                  System.out.println("~Enter the item number you'd like to purchase or 999 to exit back to the main menu~");
                  userNum=input.nextInt();
                  if (userNum <EXIT){ //will make sure correct item is selected in array list 1=0, 2=1, etc.
                     userNum--;
                  }//if
                  if(userNum>lvl20Items.length){ //if number selected is not in array length
                     System.out.println("\"Hero, I dont carry that item.\" The shop keeper looks distressed and sad.");
                  }//if
                  if(userNum<lvl20Items.length){ //if number selected is in array length
                     itemCost=lvl5Items[userNum].getPrice();
                     if(money<itemCost){ //user doesn't have enough money to cover the item
                        System.out.println("Unfortunately, you don't have enough to purchase that item. ");
                     }//if
                     if(money>=itemCost){ //user has enough money to cover item
                        System.out.println("\"Congratulations, you have enough to purchase this Hero!\" The shop keeper smiles, \"Would you like to purchase it?\"");
                        right=false;
                        while (right == false){
                           System.out.println("~Type (Y) for yes and (N) for no, spelling will matter~");
                           userInput=input.nextLine();
                           if(userInput.equals(yes)){
                              money -= itemCost; //purchase item
                              player.setCoins(money); //updates player money
                              right=true; //exits out of while loop
                              System.out.println("\"The item is yours Hero!\" the shop keeper handed the item over.");
                              //first 3 items 0-2 are weapons, 3 are necklaces, 4 are hats
                              if(userNum<=2){
                                 inventory[WEAPON]=lvl20Items[userNum];
                              }
                              if(userNum==3){
                                 inventory[NECKLACE]=lvl20Items[userNum];
                              }
                              if(userNum==4){
                                 inventory[HAT]=lvl20Items[userNum];
                              }
                              System.out.println("~The item "+inventory[WEAPON].getName()+" has been placed into your inventory~");
                           }//if
                           else if(userInput.equals(no)){
                              System.out.println("\"If you change your mind, it will be here!\" the shop keeper leaned against the counter.");
                              right=true; //exits out of while loop
                           }//else if
                           else{
                              System.out.println("The shop keeper looked a bit worried, \"My apologies Hero, but I didn't catch that. Could you repeat that?\"");
                           }//else
                        }//while - purchase item or not purchase item
                     }//if - user has money
                  }//if -item in array
               }//while - user in shop for items  
               if (userNum==EXIT){
                  System.out.println("The shop keeper waves goodbye to you as you leave. \"Until next time Hero!\"");
               }  
            }//if -lvl 20 items
         }//shop
             
         /*
            For the map, players can only go to certain stages depending on their level. This is because enemies increase in levels depending on stage level.
            Desert unlocks at level 5, Court unlocks at level 10, City unlocks at level 15, and the Lair unlocks at level 20
         */
         if(userNum==MAP){
         //display map options by level 
            System.out.println("~Here you'll continue your quest. Please select which stage you would like to fight~");
            if(playerLevel>=1){
               System.out.println("(1) Forest");
            }
            if(playerLevel>=5){
               System.out.println("(2) Desert");
            }
            if(playerLevel>=10){
               System.out.println("(3) Fairy Court");
            }
            if(playerLevel>=15){
               System.out.println("(4) Overlord's City");
            }
            if(playerLevel>=20){
               System.out.println("(5) Lair of Gods and Goddesses");
            }
            right=false; //used to determine if stage number or exit has been achieved
            while (right==false){ //select stage or back to menu
               right=false;
               boolean state=false;
               System.out.println("~Choose the stage number you would like to go to or 999 to exit back to the main menu~");
               userNum=input.nextInt();
               if (userNum >=1 && userNum<=5){ //set stageNum only numbers 1-5 will be tested
                  if(playerLevel<5){ //players under level 5 can only go to Forest
                     if(userNum == FOREST){
                        right=true;
                        stageNum=userNum;
                     }
                     else if(userNum==DESERT||userNum==COURT||userNum==CITY||userNum==GODS&&state==false){
                        System.out.println("~You can't go there yet! Level up and you'll be able to go to new places eventually~");
                        state=true;
                     }
                  }
                  else if(playerLevel<10){ //players under level 10 can only go to Forest and Desert
                     if(userNum == FOREST||userNum==DESERT){
                        right=true;
                        stageNum=userNum;
                     }
                     else if(userNum==COURT||userNum==CITY||userNum==GODS&&state==false){
                        System.out.println("~You can't go there yet! Level up and you'll be able to go to new places eventually~");
                        state=true;
                     }
                  }
                  else if(playerLevel<15){ //players under level 15 can only go to Forest and Desert and Court
                     if(userNum == FOREST||userNum==DESERT||userNum==COURT){
                        right=true;
                        stageNum=userNum;
                     }
                     else if(userNum==CITY||userNum==GODS&&state==false){
                        System.out.println("~You can't go there yet! Level up and you'll be able to go to new places eventually~");
                        state=true;
                     }
                  }
                  else if(playerLevel<20){ //players under level 20 can only go to Forest, Desert, Court and City
                     if(userNum == FOREST||userNum==DESERT||userNum==COURT||userNum==CITY){
                        right=true;
                        stageNum=userNum;
                     }
                     else if(userNum==GODS&&state==false){
                        System.out.println("~You can't go there yet! Level up and you'll be able to go to new places eventually~");
                        state=true;
                     }
                  }
                  else if(playerLevel>=20){ //players of level20+ can go anywhere. 
                     right=true;
                     stageNum=userNum;
                  }
                  else{ //user didn't select the correct option
                     System.out.println("~That is not an accepted respones.~");
                     System.out.println();
                     right=false;
                  }
                  //generate enemy numbers
                  if(stageNum==FOREST){
                     enemyNum=randomNum(FOREST_MAX,2);
                     forestNum++;
                  }
                  if(stageNum==DESERT){
                     enemyNum=randomNum(DESERT_MAX,2);
                     desertNum++;
                  }
                  if(stageNum==COURT){
                     enemyNum=randomNum(COURT_MAX,2);
                     courtNum++;
                  }
                  if(stageNum==CITY){
                     enemyNum=randomNum(CITY_MAX,2);
                     cityNum++;
                  }
                  if(stageNum==GODS){
                     enemyNum=randomNum(GODS_MAX,2);
                     godNum++;
                  }
                  //generate stage
                  if(right==true){
                     experience+=encounter(stageNum, enemyNum, playerLevel, player, inventory[WEAPON]);
                     encountNum++;
                  }
               }//stage selection
               else if(userNum==EXIT){ //return player to main menu
                  right=true;
               }
               
            }// while-select stage
         }
         
         if(userNum==EXPLORE){
            if(playerLevel<5){ //player can only go to the forest
               stageNum=FOREST;
            }
            else if(playerLevel<10){
               stageNum=randomNum(DESERT,FOREST);
            }
            else if(playerLevel<15){
               stageNum=randomNum(COURT,FOREST);
            }
            else if(playerLevel<20){
               stageNum=randomNum(CITY,FOREST);
            }
            else if(playerLevel>=20){
               stageNum=randomNum(GODS,FOREST);
            }
            //generate enemy numbers
            if(stageNum==FOREST){
               enemyNum=randomNum(FOREST_MAX,2);
               forestNum++;
            }
            if(stageNum==DESERT){
               enemyNum=randomNum(DESERT_MAX,2);
               desertNum++;
            }
            if(stageNum==COURT){
               enemyNum=randomNum(COURT_MAX,2);
               courtNum++;
            }
            if(stageNum==CITY){
               enemyNum=randomNum(CITY_MAX,2);
               cityNum++;
            }
            if(stageNum==GODS){
               enemyNum=randomNum(GODS_MAX,2);
               godNum++;
            }
            //generate stage
            experience+=encounter(stageNum, enemyNum, playerLevel, player, inventory[WEAPON]);
            encountNum++;
         }
         
         if(userNum==QUIT){ //if user wishes to quit, set quit to false so loop will no longer repeat.
            System.out.println("~Are you sure you wish to quit? Keep in mind no progress can be saved.~");
            System.out.println("~Type (Y) to quit~");
            userInput=input.nextLine();
            userInput=input.nextLine();
            if(userInput.equals(yes)){
               cont=false;
            }
         }
         
         /*
            This will be used to check player level before returning to menu options, will also show players their current status.
         */
         count=count+1; 
         //check if player leveled up, if player levels up, reset experience to 0
         if(experience>=500){
            playerLevel=playerLevel+LVL_UP;
            player.setLvl(playerLevel);
            for(int i=0;i<4;i++){ //increases user skill level
               skillNum=player.getSkLvl(i);
               skillNum+=LVL_UP;
               player.setSkLvl(skillNum,i);
            }
            experience=0;
            player.setHealth(playerHP+10);
         }
         //restore health to max
         if(player.getHealth()<playerHP){
            player.setHealth(playerHP);
         }
         /*
            display player stats 
            player name, player level, 
            health, experience
            coins, player inventory
            player skill levels
            encounter numbers
         */
         if(cont==true){
            System.out.println("~Next round~");
         }
         System.out.println("");
         System.out.println("~Player Stats~");
         System.out.println(player.getName()+" Level "+player.getLevel()+" "+player.getHealth()+"HP "+experience+" experience");
         System.out.println(player.getCoins()+" coins   inventory: "+inventory[0].getName()+", "
                              +inventory[1].getName()+", "+inventory[2].getName());
         player.displaySkills();
         System.out.println("You have had "+encountNum+" encounters:");
         System.out.println("  Forest:"+forestNum);
         if(playerLevel>=5){
            System.out.println("  Desert:"+desertNum);
         }
         if(playerLevel>=10){
            System.out.println("  Fairy Court:"+courtNum);
         }
         if(playerLevel>=15){
            System.out.println("  Overlord's City:"+cityNum);
         }
         if(playerLevel>=20){
            System.out.println("Lair of God's and Goddesses");
         }
      }
      
   }
   
    //create encounters
      public static int encounter(int stage, int numOfEnemy, int playerLevel, Character user, Item playerItem){
      /* 
         Encounters will be determined by user level, number of enemies, and map or explore condition. If following map, character will go through full path of area. If going through explore, enemy count will be randomized, areas included will be determined by player level.
      */
            //enemy stats
         final int[] LVL2B={2,3,2,2}; //forest
         final int[] LVL6B={11,11,14,11}; //desert
         final int[] LVL11B={23,22,21,24}; //court
         final int[] LVL16B={32,36,34,34}; //city
         final int[] LVL21B={46,55,46,60}; //gods
         final int[] LVL1G={2,2,2,2};
         final int[] LVL2G={4,4,4,4};
         final int[] LVL3G={6,6,6,6};
         final int[] LVL4G={8,8,8,8};
         final int[] LVL5G={10,10,10,10};
         final int[] LVL6G={12,12,12,12};
         final int[] LVL7G={14,14,14,14};
         final int[] LVL8G={16,16,16,16};
         final int[] LVL9G={18,18,18,18};
         final int[] LVL10G={20,20,20,20};
         final int[] LVL11G={22,22,22,22};
         final int[] LVL12G={24,24,24,24};
         final int[] LVL13G={26,26,26,26};
         final int[] LVL14G={28,28,28,28};
         final int[] LVL15G={30,30,30,30};
         final int[] LVL16G={33,33,33,33};
         final int[] LVL17G={36,36,36,36};
         final int[] LVL18G={39,39,39,39};
         final int[] LVL19G={42,42,42,42};
         final int[] LVL20G={45,45,45,45};
      //bosses & pawns (may want to make encounters first)
         Character forestBoss = new Character("Crogon, Forest Dweller", 2,68,4.8,LVL2B);
         Character forestGrunt1 = new Character("Mutated Deer", 1, 25, 0.3, LVL1G);
         Character forestGrunt2 = new Character("Grizzly Bear", 1, 34, 0.0, LVL1G);
         Character forestGrunt3 = new Character("Easter Bunny",1,20,1.5,LVL1G);
         Character forestGrunt4 = new Character("Rabbid Squirrels", 2, 42, 0.9, LVL2G);
         Character forestGrunt5 = new Character("Changeling",2,34,0.2,LVL2G);
         Character forestGrunt6 = new Character("Leprechaun", 2, 55, 3.2, LVL2G);
         Character[] forestGrunts = {forestGrunt1, forestGrunt2, forestGrunt3, forestGrunt4, forestGrunt5, forestGrunt6};
         
         Character desertBoss = new Character("Niselphos, Nagaraja",6,120,16.7,LVL6B);
         Character desertGrunt1 = new Character("Desert Bandit",3,48,1.2,LVL3G);
         Character desertGrunt2 = new Character("Giant Worm",3,52,0.9,LVL3G);
         Character desertGrunt3 = new Character("Rattlesnakes",3,50,1.1,LVL3G);
         Character desertGrunt4 = new Character("Geenie",4,72,2.4,LVL4G);
         Character desertGrunt5 = new Character("Cactus mutant",4,69,1.9,LVL4G);
         Character desertGrunt6 = new Character("Sand Crab",4,76,1.2,LVL4G);
         Character desertGrunt7 = new Character("Oasis",5,88,4.6,LVL5G);
         Character desertGrunt8 = new Character("Giant Scorpion",5,80,2.5,LVL5G);
         Character desertGrunt9 = new Character("Camel Spiders",6,92,3.2,LVL6G);
         Character desertGrunt10 = new Character("Scarab Storms",6,116,4.9,LVL6G);
         Character[] desertGrunts = {desertGrunt1, desertGrunt2, desertGrunt2, desertGrunt3, desertGrunt4, desertGrunt5,
                                       desertGrunt6, desertGrunt7, desertGrunt8, desertGrunt9, desertGrunt10};
                                       
         Character courtBoss = new Character("Amaltheia, Queen of the Twilight Throne",11, 173, 32.4, LVL11B);
         Character courtGrunt1 = new Character("Yasmine Silverbird", 7, 124, 21.2, LVL7G);
         Character courtGrunt2 = new Character("Flix Figwood", 7, 111, 19.3, LVL7G);
         Character courtGrunt3 = new Character("Hydrangea Mistyweb", 8, 133, 23.9, LVL8G);
         Character courtGrunt4 = new Character("Ash Palmgem", 8, 126, 21.8, LVL8G);
         Character courtGrunt5 = new Character("Maple Cedarstone", 9, 142, 26.3, LVL9G);
         Character courtGrunt6 = new Character("Thistle Cricketmuddle", 9, 134, 24.7, LVL9G);
         Character courtGrunt7 = new Character("Jade Pinegust", 10, 156, 29.5, LVL10G);
         Character courtGrunt8 = new Character("Nyx Meadowshine", 10, 142, 28.6, LVL10G);
         Character courtGrunt9 = new Character("Celestia Lightning Petal", 10, 153, 29.1, LVL10G);
         Character courtGrunt10 = new Character("Cirrus Coppergrass", 10, 146, 28.1, LVL10G);
         Character[] courtGrunts= {courtGrunt1, courtGrunt2, courtGrunt3, courtGrunt4, courtGrunt4, courtGrunt5,
                                 courtGrunt6, courtGrunt7, courtGrunt8, courtGrunt9, courtGrunt10};
                                 
         Character cityBoss = new Character("Desmond, Overlord", 16, 238,53.7,LVL16B);
         Character cityGrunt1 = new Character("Vampire Soldier", 11, 152, 32.6 ,LVL11G);
         Character cityGrunt2 = new Character("Vampire Mercenary",12, 164, 36.2, LVL12G);
         Character cityGrunt3 = new Character("Count Vernon", 13, 178, 40.1, LVL13G);
         Character cityGrunt4 = new Character("Master Karpov", 14, 191, 42.7, LVL14G);
         Character cityGrunt5 = new Character("Mistress Kynthia", 14, 187, 41.3, LVL14G);
         Character cityGrunt6 = new Character("Prince Reyes", 15, 198, 45.4, LVL15G);
         Character cityGrunt7 = new Character("Princcess Izora", 15, 202, 43.8, LVL15G);
         Character cityGrunt8 = new Character("Queen Zephirah", 16, 226, 51.4, LVL16G);
         Character[] cityGrunts= {cityGrunt1, cityGrunt2, cityGrunt3, cityGrunt4, cityGrunt4, cityGrunt5,
                                    cityGrunt6, cityGrunt7, cityGrunt8};
                                    
         Character boss = new Character("Qhytris, Goddess of Endings",21, 320, 82.9, LVL21B);
         Character grunt1 = new Character("Izotz, God of Storms",16,218, 62.5, LVL16G);
         Character grunt2 = new Character("Dhether, God of Freedom", 17, 231, 63.9, LVL17G);
         Character grunt3 = new Character("Kades, God of Music", 18, 246, 64.1, LVL18G);
         Character grunt4 = new Character("Uasis, Goddess of Vengence", 19, 259, 70.2, LVL19G);
         Character grunt5 = new Character("Druris, Goddess of Earth", 20, 264, 73.4, LVL20G);
         Character[] gods = {grunt1, grunt2, grunt3, grunt4, grunt5};
      
         final int FOREST_MAX=6, DESERT_MAX=10, COURT_MAX=10, CITY_MAX=8, GODS_MAX=5,
                     GRUNT_KILL=10, BOSS_KILL=50;
         int enemy=0, maxHP=user.getHealth(), hpU=user.getHealth(), hpE=0,
             count=0, experience=0, userNum=0, stat=0,
             forestNum=0, desertNum=0, courtNum=0, cityNum=0, godNum=0;
         Scanner input = new Scanner(System.in);
      
         if(stage==1){
         //forest
            forestNum++;
            while(count<numOfEnemy+1 && hpU>0){ //num of enemies and boss
               if (count<numOfEnemy && hpU>0){ //while player is still alive
                  enemy= randomNum(FOREST_MAX,0);
                  System.out.println("Ahead of you, you spot "+forestGrunts[enemy].getName()+".");
                  hpE=combat(user, playerItem, forestGrunts[enemy]);
                  hpU=user.getHealth();
                  if(hpE<=0){
                     experience= experience+GRUNT_KILL;
                  }
               }
               else if(hpU>0){//when enemy number is 1 more than array, it will be the boss.
                  System.out.println("Ahead, you see a chest. Upon opening you see several potions.");
                  System.out.println("~You're health has gone back to "+maxHP+"~");
                  hpU=maxHP;
                  hpE=combat(user, playerItem, forestBoss);
                  hpU=user.getHealth();
                  if(hpE<=0 && hpU>0){
                     experience= experience+BOSS_KILL;
                  }
               }
                  count++;
            }
            
            if(hpU<=0){
                  System.out.println("You begin to feel week, your vision fades.");
                  System.out.println("~Oh no! Your health fell below 0. Let's return to the menu.~");
               }
         
         }
         
         if(stage==2){
            while(count<numOfEnemy+1 && hpU>0){
               if (count<numOfEnemy){
                  enemy= randomNum(DESERT_MAX,0);
                  System.out.println("Ahead of you, you spot "+desertGrunts[enemy].getName()+".");
                  hpE=combat(user, playerItem, desertGrunts[enemy]);
                  hpU=user.getHealth();
                  if(hpE<=0){
                     experience= experience+GRUNT_KILL;
                  }
               }
               else if(hpU>0){
                  System.out.println("Ahead, you see a chest. Upon opening you see several potions.");
                  System.out.println("~You're health has gone back to "+maxHP+"~");
                  hpU=maxHP;
                  hpE=combat(user, playerItem, desertBoss);
                  hpU=user.getHealth();
                  if(hpE<=0 && hpU>0){
                     experience= experience+BOSS_KILL;
                  }
               }
                  count++;
            }
            
            if(hpU<=0){
                  System.out.println("You begin to feel week, your vision fades.");
                  System.out.println("~Oh no! Your health fell below 0. Let's return to the menu.~");
               }
         
         }         
         
         if(stage==3){
         //court
            while(count<numOfEnemy+1 && hpU>0){
                  if (count<numOfEnemy){
                     enemy= randomNum(COURT_MAX,0);
                     System.out.println("Ahead of you, you spot "+courtGrunts[enemy].getName()+".");
                     hpE=combat(user, playerItem, courtGrunts[enemy]);
                     hpU=user.getHealth();
                     if(hpE<=0){
                        experience= experience+GRUNT_KILL;
                     }
                  }
                  else if (hpU>0){
                     System.out.println("Ahead, you see a chest. Upon opening you see several potions.");
                     System.out.println("~You're health has gone back to "+maxHP+"~");
                     hpU=maxHP;
                     hpE=combat(user, playerItem, courtBoss);
                     hpU=user.getHealth();
                     if(hpE<=0 && hpU>0){
                        experience= experience+BOSS_KILL;
                     }
               }
                  count++;
            }
            
            if(hpU<=0){
                  System.out.println("You begin to feel week, your vision fades.");
                  System.out.println("~Oh no! Your health fell below 0. Let's return to the menu.~");
               }
         
         }         
         
         if(stage==4){
         //city
            while(count<numOfEnemy+1 && hpU>0){
                  if (count<numOfEnemy){
                     enemy= randomNum(CITY_MAX,0);
                     System.out.println("Ahead of you, you spot "+cityGrunts[enemy].getName()+".");
                     hpE=combat(user, playerItem, cityGrunts[enemy]);
                     hpU=user.getHealth();
                     if(hpE<=0){
                        experience= experience+GRUNT_KILL;
                     }
                  }
                  else if (hpU>0){
                     System.out.println("Ahead, you see a chest. Upon opening you see several potions.");
                     System.out.println("~You're health has gone back to "+maxHP+"~");
                     hpU=maxHP;
                     hpE=combat(user, playerItem, cityBoss);
                     hpU=user.getHealth();
                     if(hpE<=0 && hpU>0){
                        experience= experience+BOSS_KILL;
                     }
               }
                  count++;
            }
            
            if(hpU<=0){
                  System.out.println("You begin to feel week, your vision fades.");
                  System.out.println("~Oh no! Your health fell below 0. Let's return to the menu.~");
               }
         
         }         
         
         if(stage==5){
         //gods
            while(count<numOfEnemy+1 && hpU>0){
                  if (count<numOfEnemy){
                     enemy= randomNum(GODS_MAX,0);
                     System.out.println("Ahead of you, you spot "+gods[enemy].getName()+".");
                     hpE=combat(user, playerItem, gods[enemy]);
                     hpU=user.getHealth();
                     if(hpE<=0){
                        experience= experience+GRUNT_KILL;
                        System.out.println("You've defeated "+gods[enemy].getName()+".");
                     }
                  }
                  else if (hpU>0){
                     System.out.println("Ahead, you see a chest. Upon opening you see several potions.");
                     System.out.println("~You're health has gone back to "+maxHP+"~");
                     hpU=maxHP;
                     hpE=combat(user, playerItem, boss);
                     hpU=user.getHealth();
                     if(hpE<=0 && hpU>0){
                        experience= experience+BOSS_KILL;
                     }
               }
                  count++;
            }
            
            if(hpU<=0){
                  System.out.println("You begin to feel week, your vision fades.");
                  System.out.println("~Oh no! Your health fell below 0. Let's return to the menu.~");
               }
         
         }         
         return experience;
      }
      
      //create combat system
      public static int combat(Character user, Item userItem, Character enemy){
         /*
            Attacks will be based of strength and power of hit (miss to crit), calculated as: health-(strength*attack). Character dies when health reaches 0. If able to find a way to make a save file, will have the player reset from last area (1,5,10,15,20)
         */
         final int INT=0, SPD=1, STR=2, CHR=3, CRIT=5, MISS=0;
         int userAttack=0, enemyAttack=0, hpU= user.getHealth(), hpE = enemy.getHealth();
         double userCoins, eCoins;
         while(hpU>0 && hpE>0){
            userAttack= (user.getSkLvl(STR)+userItem.getSkillLevel(STR))*((int)(Math.random()*100)% CRIT+MISS);
            hpE-=userAttack;
            if (hpE>0){
               enemyAttack =(enemy.getSkLvl(STR))*((int)(Math.random()*100)% CRIT+MISS);
               hpU-=enemyAttack;
               eCoins=enemy.getCoins();
               userCoins=user.getCoins()+eCoins;
               user.setCoins(userCoins);
               
            }
         }
         user.setHealth(hpU);
         return hpE;

      }
   
      //create check systems
      public static boolean checkStat(Character user, int stat, int pass){
      /*
         Check system will be used to to check stats to get bonus conversation, info and unlock secret areas to obtain more gold.
      */
         int userSkill= user.getSkLvl(stat);
         if (userSkill>=pass){
            return true;
         }
         else{
            return false;
         }
      }
      
      //generate random numbers, used for explore to decide random stage and number of enemies
      public static int randomNum(int high, int low){
         int random = ((int)(Math.random()*100)%high+low);
         return random;
      }
}