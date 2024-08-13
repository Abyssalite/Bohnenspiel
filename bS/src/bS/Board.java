package bS;
import java.util.ArrayList;

public class Board {
    	private ArrayList<Holes> holesList;

        public Board(){
            holesList = new ArrayList<Holes>();
            int j = 2;

            for (int i = 1; i <= 14; i++){
                if(i < 8){
                    if ((i % 7) != 0) {
                        holesList.add(new Holes(4, i - 1 ,"A_"+ (i % 7))) ;
                    }
                    else {
                        holesList.add(new Holes(0, i - 1 ,"A_"+ (i % 7))) ;
                    }
                }
                
                else{
                    if ((i % 7) != 0) {
                        holesList.add(new Holes(4, i - 1 ,"B_"+ ((i - j) % 7))) ;
                    }
                    else {
                        holesList.add(new Holes(0, i - 1 ,"B_"+ ((i - j) % 7))) ;
                    }
                    j += 2;
                }
            }
        }

        public ArrayList<Holes> getHolesList(){
            return holesList;
        }

}
