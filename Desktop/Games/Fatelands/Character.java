public class Character{
/*
   Character is a class to create player and nonplayer characters. At no time should the skills be returned, but instead to display only alonside the skill levels.
   Character will be used throughout the Main program. Levels will increase at certain preset incriments. Coins will be used to purchase items from shop. Skill levels will be used to pass checkpoints.
   Name will be used to identify the characters for the program and player. Health will be used to determine when a Character dies.
   Skills is a set list that doesn't need to be changed. If skills are added in the future, more skill levels will need to be added. 
*/
   String name;
   int level, health;
   double coins;
   final String[] SKILL = {"Intelligence","Speed","Strength","Charisma"};
   int[] skillLevel = {1,1,1,1};
   
   //create player character
   public Character(String n){
      name = n;
      level = 1;
      health= 100;
      coins = 0.0;
   }
   //create nonplayer character
   public Character(String n, int lvl, int h, double c, int[] sLvl){
      name = n;
      level = lvl;
      health = h;
      coins = c;
      skillLevel = sLvl;
   }
   
   //set/change variables
   public void setName(String n){
      name = n;
   }
   public void setLvl(int lvl){
      level = lvl;
   }
   public void setHealth(int h){
      health = h;
   }
   public void setCoins(double c){
      coins = c;
   }
   public void setSkLvl(int value, int place){
      skillLevel[place] = value;
   }
   
   //get values
   public String getName(){
      return name;
   }
   public int getLevel(){
      return level;
   }
   public int getHealth(){
      return health;
   }
   public double getCoins(){
      return coins;
   }
   public int getSkLvl(int place){
      return skillLevel[place];
   }
   
   // displaying skill level base stats
   public void displaySkills(){
      for (int i=0; i<SKILL.length; i++){
         System.out.println(SKILL[i]+" level "+skillLevel[i]);
      }
   }
}