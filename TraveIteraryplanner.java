import java.util.*;

public class TraveIteraryplanner {
    Map<String,travelPlanner> hmap; 
    TraveIteraryplanner(){
        hmap = new HashMap<>();
        travelPlanner tplanner = new travelPlanner("08/01/2024",80000.0);
        hmap.put("Maldives",tplanner);
        tplanner = new travelPlanner("08/02/2024",120000.0);
        hmap.put("Paris",tplanner);
        tplanner = new travelPlanner("08/03/2024",1100000.0);
        hmap.put("Barcelona",tplanner);
        tplanner = new travelPlanner("08/04.2024",80000.0);
        hmap.put("Bali",tplanner);
        tplanner = new travelPlanner("08/05/2024",100000.0);
        hmap.put("Bangkok",tplanner);
        tplanner = new travelPlanner("08/06/2024",1200000.0);
        hmap.put("Singapore",tplanner);
    }
    public static class travelPlanner{
        String avdate;
        double total_budget;
        travelPlanner(String avdate,double d){
            this.avdate = avdate;
            this.total_budget = d;
        }
    }
    public static boolean checkDate(String d1,String d2){
        String yr1 = "";
        yr1 += d1.charAt(d1.length()-2);
        yr1 += d1.charAt(d1.length()-1);
        int y1 = Integer.parseInt(yr1);
        String yr2 = "";
        yr2 += d2.charAt(d1.length()-2);
        yr2 += d2.charAt(d1.length()-1);
        int y2 = Integer.parseInt(yr2);
        if(y2<y1)  return true;
        else if(y2>y1) return false;
        String mn1 = "";
        mn1 +=  d1.charAt(d1.length()-7);
        mn1 += d1.charAt(d1.length()-6);
        int m1 = Integer.parseInt(mn1);
        String mn2 = "";
        mn2 += d2.charAt(d2.length()-7);
        mn2 += d2.charAt(d2.length()-6);
        int m2 = Integer.parseInt(mn2);
        if(m2<m1) return true;
        else if(m2>m1) return false;
        String dy1 = "";
        dy1 += d1.charAt(d1.length()-10);
        dy1 += d1.charAt(d2.length()-9);
        int b1 = Integer.parseInt(dy1);
        String dy2 = "";
        dy2 += d2.charAt(d2.length()-10);
        dy2 += d2.charAt(d2.length()-9);
        int b2 = Integer.parseInt(dy2);
        if(b2<b1) return true;
        else if(b1>b2) return false;
        return true;
    }
    public static void main(String[] args){
        TraveIteraryplanner planner = new TraveIteraryplanner();
        Scanner scn = new Scanner(System.in);
        System.out.println("WELCOME TO THE TRAVEL PLANNER AGENCY : ");
        System.out.print("Enter your available date for travel start (DD/MM/YYYY) : ");
        String date = scn.next();
        if(date.length()!=10){
            System.out.print("Your input format is not correct.");
            return;
        }
        System.out.print("Enter your budget : ");
        int total_budget = scn.nextInt();
        travelPlanner newtravel = new travelPlanner(date,total_budget);
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,travelPlanner> mp : planner.hmap.entrySet()){
            String key = mp.getKey();
            travelPlanner tplanner = mp.getValue();
            boolean check = checkDate(tplanner.avdate,newtravel.avdate);
            if(check==true && newtravel.total_budget>=tplanner.total_budget){
                list.add(key);
            }
        }
        if(list.size()==0){
        System.out.print("Your budget is not sufficient.");
        }
        System.out.print("For the given budget you can visit the following places : ");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.print("Enter your prefered location : ");
        String location = scn.next();
        if(list.contains(location)==false) {
            System.out.print("You don't have enough budget.");
            return;
        }
        System.out.print("You can visit "+location+" from "+planner.hmap.get(location).avdate+
        " and you need minimum " + planner.hmap.get(location).total_budget);
    }
}
