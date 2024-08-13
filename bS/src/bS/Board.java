package bS;
import java.util.ArrayList;

public class Board {
    	private ArrayList<Holes> holesList;

        public Board(){
            holesList = new ArrayList<Holes>();
            int j = 0;

            for (int i = 0; i <= 13; i++){
                if(i < 7){
                    if ((i % 7) != 0) {
                        holesList.add(new Holes(20, i  ,"B_"+ (i % 7))) ;
                    }
                    else {
                        holesList.add(new Holes(0, i  ,"R_"+ (i % 7))) ;
                    }
                }
                
                else{
                    if ((i % 7) != 0) {
                        holesList.add(new Holes(20, i  ,"R_"+ ((i - j) % 7))) ;
                    }
                    else {
                        holesList.add(new Holes(0, i  ,"B_"+ ((i - j) % 7))) ;
                    }
                    j += 2;
                }
            }
        }

        public ArrayList<Holes> getHolesList(){
            return holesList;
        }

}
