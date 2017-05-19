import java.io.*;
import java.util.*;

/**
 * Created by denis__larin on 19.05.17.
 */
public class Pr {
    int summ;
    int[] note = {1, 2, 5, 10, 50, 100, 500, 1000, 5000};
    int numberStep = 1;
    ArrayList arrayList = new ArrayList();
    Writer writer = new FileWriter("temp");

    public Pr(int summ) throws IOException {
        this.summ = summ;
        startProg();
    }

    private void startProg() throws IOException {
        //пример 6
        int tempSumm = summ;
        while (tempSumm!=0) {
            arrayList.add(maxNumber(tempSumm, false));
            tempSumm-=(int)arrayList.get(arrayList.size()-1);
        }
        System.out.println("самый рациональный способ "+ arrayList +  "\n");
        split(arrayList);
    }

    private void split(ArrayList arrayList) throws IOException {
        int numberSplit = 0;
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            int splitsumm = (int) arrayList.get(i);
            while (isSplit(splitsumm) && splitsumm!=0){
                numberSplit++;
                arrayList.add(i+numberSplit,maxNumber(splitsumm,true));

                if(inNote(splitsumm-(int)arrayList.get(i+numberSplit))){
                    arrayList.add(i+numberSplit+1,splitsumm-(int)arrayList.get(i+numberSplit));
                    splitsumm-=(int)arrayList.get(i+numberSplit);
                    splitsumm-=(int)arrayList.get(i+numberSplit+1);
                }
                else {
                    splitsumm-=(int)arrayList.get(i+numberSplit);
                }
            }
            if (splitsumm == 1 && numberSplit>0){
                arrayList.add(i+numberSplit,1);
                numberSplit++;
                arrayList.remove(i);
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                System.out.println(arrayList + "\n");
                numberStep++;
               /* writer.append(arrayList.toString() + "\n");
                writer.flush();*/
                numberSplit = 0;
                i = -1;
            }
            else if(splitsumm == 0 && numberSplit>0){
                arrayList.remove(i);
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                System.out.println(arrayList + "\n");
                numberStep++;
                /*writer.append(arrayList.toString() + "\n");
                writer.flush();*/
                numberSplit = 0;
                i = -1;
            }
        }
    }

    private boolean inNote(int o) {
        for (int i = 0; i < note.length; i++) {
            if (o == note[i])
                return true;
        }
        return false;
    }

    private boolean isSplit(int num) {
       return num>1;
    }

    private int maxNumber(int tempSumm, boolean b) {
        if (b){
            tempSumm--;
        }
        if(tempSumm>=5000){
            return 5000;
        }
        if(tempSumm>=1000){
            return 1000;
        }
        if(tempSumm>=500){
            return 500;
        }
        if(tempSumm >= 100) {
            return 100;
        }

       if(tempSumm>=50){
           return 50;
       }
       if (tempSumm>=10){
           return 10;
       }
       if (tempSumm>=5){
           return 5;
       }
       if (tempSumm>= 2){
           return 2;
       }
       else{
           return 1;
       }
    }
}
