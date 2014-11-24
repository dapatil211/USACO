/*
ID: darshan4
LANG: JAVA
TASK: ballet
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;



public class ballet {

	/**
	 * @param args
	 */
	
	class Cow{
		int dir = 0;
		Location[] locs = new Location[]{new Location(1,1), new Location(0,1),new Location(1,0),new Location(0,0)};
		private Location[] getLocs(){
			return locs;
		}
		private void pivot(Location pivot){
			for(int i = 0; i < 4; i++){
				Location cur = locs[i];
				int x = cur.x-pivot.x; 
				int y = cur.y-pivot.y; 
				locs[i] = new Location(y + pivot.x, pivot.y-x);
			}
			dir = (dir+1)%4;
		}
		private void move(int foot, int direction){
			Location loc = locs[foot];
			Location next;
			int turn = (direction + dir) % 4;
			if(turn == 0){
				next = new Location(loc.x, loc.y + 1);
			}
			else if(turn == 1){
				next = new Location(loc.x + 1, loc.y);
			}
			else if(turn == 2){
				next = new Location(loc.x, loc.y - 1);
			}
			else{
				next = new Location(loc.x-1, loc.y);
			}
			locs[foot] = next;
		}
		private boolean conflict(){
			for(int i = 0; i < 3; i ++){
				for(int j = i+1; j<4; j++){
					if(locs[i].equals(locs[j])){
						return true;
					}
				}
			}
			return false;
		}
	}
	class Location{
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Location loc = (Location) obj;
			return (this.x == loc.x) && (this.y == loc.y);
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Arrays.hashCode(new int[]{x,y});
		}
	}
	public static void main(String[] args) throws IOException {
		ballet b = new ballet();
		BufferedReader f = new BufferedReader(new FileReader("ballet.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ballet.out")));
		Cow c = b.new Cow();
		int n = Integer.parseInt(f.readLine());
		HashSet<Location> hs = new HashSet<Location>();
		int works = 0;
		for(int i = 0; i < n; i++){
			String move = f.readLine();
			String foot = move.substring(0, 2);
			Location l;
			int fo;
			if(foot.equals("FR")){
				l = c.locs[0];
				fo = 0;
			}
			else if(foot.equals("FR")){
				l = c.locs[1];
				fo = 1;
			}
			else if(foot.equals("RR")){
				l = c.locs[2];
				fo = 2;
			}
			else{
				l = c.locs[3];
				fo = 3;
			}
			char m = move.charAt(2);
			if(m == 'P'){
				c.pivot(b.new Location(l.x, l.y));
			}
			else if(m == 'F'){
				c.move(fo, 0);
			}
			else if(m == 'R'){
				c.move(fo, 1);
			}
			else if(m == 'B'){
				c.move(fo, 2);
			}
			else{
				c.move(fo, 3);
			}
			if(c.conflict()){
				works = -1;
				break;
			}
			else{
				hs.addAll(Arrays.asList(c.getLocs()));
			}
		}
		if(works == 0){
			int maxx = 1;
			int minx = 0;
			int maxy = 1;
			int miny = 0;
			Object[] locs = hs.toArray();
			for(int i = 0; i < locs.length; i++){
				Location l = (Location) locs[i];
				if(l.x>maxx){
					maxx = l.x;
				}
				if(l.x<minx){
					minx = l.x;
				}
				if(l.y>maxy){
					maxy = l.y;
				}
				if(l.y<miny){
					miny = l.y;
				}
			}
			int width = maxx-minx +1;
			int length = maxy-miny+1;
			out.println(width*length);
		}
		else{
			out.println(-1);
		}
		f.close();
		out.close();
		System.exit(0);
	}
	


}
