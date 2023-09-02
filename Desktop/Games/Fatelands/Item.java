public class Item{
/*
   Item is used for Armors, Accesories, Weapons that player Characters can equip to increase their stats. 
   After an item is created, there will be no need to change because there will not be an upgrade or smithing system at this time. 
*/
   String name, info;
   double price;
   int level;
   final String[] SKILL = {"Intelligence","Speed","Strength","Charisma"};
   int[] skillLevel = new int[4];
   
   //create item with necessary info
   public Item(String n, String i, double p, int lvl, int[] slvl){
      name = n;
      info = i;
      price = p;
      level = lvl;
      skillLevel = slvl;
   }
   
   //get info, no set items will need to be used because there is no reason to change item after it is created
   public String getName(){
      return name;
   }
   public String getInfo(){
      return info;
   }
   public double getPrice(){
      return price;
   }
   public int getLevel(){
      return level;
   }
   public int getSkillLevel(int place){
      return skillLevel[place];
   }
   
   //used to display items in the shop
   public void displayItem(){
      System.out.println(name+" item level "+level+" price:"+price);
      System.out.println(info);
      for (int i=0; i<SKILL.length; i++){
         System.out.print(SKILL[i]+" level "+skillLevel[i]+"  ");
      }
      System.out.println();
   }
}