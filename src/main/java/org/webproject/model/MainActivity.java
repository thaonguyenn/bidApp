package org.webproject.model;

public class MainActivity {
	 String tv_result1 = "",tv_result2 = "";
	 String str_from,str_to;
	 int dist = 0;
public MainActivity(String str_from,String str_to) {
	this.str_from = str_from;
	this.str_to = str_to;
}
	 public int start() {
		 String apikey = "ABQIAAAA7j_Q-rshuWkc8HyFI4V2HxQYPm-xtd00hTQOC0OXpAMO40FHAxT29dNBGfxqMPq5zwdeiDSHEPL89A";
         String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + str_from + "&destinations=" + str_to + "&mode=driving&language=en-EN&avoid=tolls&key="+apikey;
         String result = new Task(MainActivity.this).doInBackground(url);
         setDouble(result);
         return dist;
     }
	 public void setDouble(String result) {
	        String res[]=result.split(",");
	        Double min=Double.parseDouble(res[0])/60;
	        int dist=Integer.parseInt(res[1])/1000;
	        this.dist = dist;
	        tv_result1= ("Duration= " + (int) (min / 60) + " hr " + (int) (min % 60) + " mins");
	        tv_result2= ("Distance= " + dist + " kilometers");
//	        System.out.println(tv_result1);
//	        System.out.println(tv_result2);
	    }
	 public static void main(String[] args) {
		System.out.println(new MainActivity("56+đường+31+phường+Bình+Trưng+Tây+Quận+2+TPHCM+Việt+Nam", "10+Phổ+Quang+Tân+Bình+TPHCM+Việt+Nam").start());
		
	}
	 
}
