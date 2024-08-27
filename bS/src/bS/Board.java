package bS;
import java.util.ArrayList;

public class Board {
    	private ArrayList<Holes> holesList;

        protected Board(){
            holesList = new ArrayList<Holes>();
            int j = 14;

            for (int i = 0; i <= 13; i++){
                if (i < 7){
                    if ((i % 7) != 0){
                        holesList.add(new Holes(4, i ,"B_"+ (i % 7), (i + j)));
                    }
                    else {
                        holesList.add(new Holes(0, i ,"R_"+ (i % 7), (0)));
                    }
                    j -= 2;
                }
                else {
                    if ((i % 7) != 0){
                        holesList.add(new Holes(4, i ,"R_"+ ((i - j) % 7), (i - j)));
                    }
                    else {
                        holesList.add(new Holes(0, i ,"B_"+ ((i - j) % 7), (7)));
                    }
                    j += 2;
                }
            }
        }

        protected ArrayList<Holes> getHolesList(){
            return holesList;
        }

}