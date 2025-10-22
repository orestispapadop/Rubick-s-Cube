import java.util.ArrayList;
import java.util.HashMap;
public class State implements Comparable<State> {
    private State father = null;
    static int SIZE = 3;
    private char sideA[][]; // side a is the main side 
    private char sideB[][];
    private char sideC[][];
    private char sideD[][];
    private char sideUp[][];
    private char sideDown[][];
    HashMap<String,char[][]> sides;
        
        
    
    State(){
        this.sideA = new char[3][3];
        this.sideB = new char[3][3];
        this.sideC = new char[3][3];
        this.sideD = new char[3][3];
        this.sideUp = new char[3][3];
        this.sideDown = new char[3][3];
        this.SetColors();
        this.sides = new HashMap<String,char[][]>() ;
        this.sides.put("A", sideA);
        this.sides.put("B", sideB);
        this.sides.put("C", sideC);
        this.sides.put("D", sideD);
        this.sides.put("Up", sideUp);
        this.sides.put("Down", sideDown);
    }
    public void PrintSides(){
        for(String key : sides.keySet()){
            char[][] side = sides.get(key);
            System.out.println("Side : " + key);
            for(int i = 0 ; i <3; i++){
                
                for(int j = 0 ; j <3; j++){
                    System.out.print(side[i][j]);

                
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public char[] reversearray(char[] col){
        char[] temp;
        temp = new char[3];
        int j = 3;
        for(int i = 0 ; i < 3 ; i++){
            temp[j-1 ] = col[i];
            j = j-1;
        }
        return temp;
    }

    public void reverse2darray(char side[][]){
        char[][] temp;
        temp = new char[3][3];
        char[] temp2 = new char[3];
        for(int i = 0 ; i<3 ; i++){
            for (int j = 0 ; j<3 ; j++ ){
                temp[i][j] = side[i][j];
            }
        }
        for(int i = 0; i < 3; i++){
            temp2 = getCol(2-i, temp); // getting the colum i want to reverse 

            setCol(i, side, reversearray(temp2)); //putting the collum in the  side reversed
        }
    }

    public char[] getRow(int row , char side[][]){
        char[] Row;
        Row = new char[3];
        for (int i = 0; i<3 ; i++){
            Row[i] = side[row][i];
        }
        return Row;
    }

    public char[] getCol(int col , char side[][]){
        char[] Col;
        Col = new char[3];
        for (int i = 0; i<3 ; i++){
            Col[i] = side[i][col];
        }
        return Col;
    }
    
    public void  setRow(int row, char side[][], char newValues[]){
        for (int i = 0; i <3 ; i++){
            side[row][i] = newValues[i];
        }
    }
    public void setCol( int col, char side[][], char newValues[]){
        for(int i = 0 ; i<3 ; i++){
            side[i][col] = newValues[i];
        }
    }

    void SetColors(){
        for (int i = 0 ; i < 3; i++){ // side A main side
            for (int j = 0 ; j < 3; j++){
                sideA[i][j] = 'W';
            }
        }
        for (int i = 0 ; i < 3; i++){ // side B
            for (int j = 0 ; j < 3; j++){
                sideB[i][j] = 'O';
            }
        }
        for (int i = 0 ; i < 3; i++){ // side C
            for (int j = 0 ; j < 3; j++){
                sideC[i][j] = 'Y';
            }
        }
        for (int i = 0 ; i < 3; i++){ // side D
            for (int j = 0 ; j < 3; j++){
                sideD[i][j] = 'R';
            }
        }
        for (int i = 0 ; i < 3; i++){ // side Up
            for (int j = 0 ; j < 3; j++){
                sideUp[i][j] = 'G';
            }
        }
        for (int i = 0 ; i < 3; i++){ // side Down
            for (int j = 0 ; j < 3; j++){
                sideDown[i][j] = 'B';
            }
        }
    }

    public void RotateLeft(int row){ 
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];
            
        temp = getRow(row, sideA);
        temp2 = getRow(row, sideD);
        for(int i =0 ; i<3 ; i ++){
            sideA[row][i] = temp2[i];
        }
        temp2 = getRow(row, sideB);
        for(int i =0 ; i<3 ; i ++){
            sideB[row][i] = temp[i];
        }
        temp =getRow(row, sideC);
        for(int i =0 ; i<3 ; i ++){
            sideC[row][i] = temp2[i];
        }
        for(int i =0 ; i<3 ; i ++){
            sideD[row][i] = temp[i];
        }
        if( row == 0){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideUp[i][j];
                }
            }
            setRow(0, sideUp,getCol(2, temp3));
            setRow(1, sideUp,getCol(1, temp3));
            setRow(2, sideUp,getCol(0, temp3));
            
            
            

        }else if( row == 2){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideDown[i][j];
                }
            }
            setCol(2, sideDown, getRow(0, temp3));
            setCol(1, sideDown, getRow(1, temp3));
            setCol(0, sideDown, getRow(2, temp3));

        }
    }

    public void rotateRight(int row){
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];
            
        temp = getRow(row, sideD);
        temp2 = getRow(row, sideA);
        for(int i =0 ; i<3 ; i ++){
            sideD[row][i] = temp2[i];
        }
        temp2 = getRow(row, sideC);
        for(int i =0 ; i<3 ; i ++){
            sideC[row][i] = temp[i];
        }
        temp =getRow(row, sideB);
        for(int i =0 ; i<3 ; i ++){
            sideB[row][i] = temp2[i];
        }
        for(int i =0 ; i<3 ; i ++){
            sideA[row][i] = temp[i];
        }
        if( row == 0){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideUp[i][j];
                }
            }
            setCol(0, sideUp, getRow(2, temp3));
            setCol(1, sideUp, getRow(1, temp3));
            setCol(2, sideUp, getRow(0, temp3));
            
            
            

        }else if( row == 2){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideDown[i][j];
                }
            }
            setRow(0, sideDown,getCol(2, temp3));
            setRow(1, sideDown,getCol(1, temp3));
            setRow(2, sideDown,getCol(0, temp3));
            
            

        }
    }

    public void rotateDown(int col){
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];
            
        temp = getCol(col, sideA);
        temp2 = getCol(col, sideUp);
        reverse2darray(sideC);//reverse side c(back side)
        for(int i =0 ; i<3 ; i ++){
            sideA[i][col] = temp2[i];
        }
        temp2 = getCol(col, sideDown);
        for(int i =0 ; i<3 ; i ++){
            sideDown[i][col] = temp[i];
        }
        temp =getCol(col, sideC);
        for(int i =0 ; i<3 ; i ++){
            sideC[i][col] = temp2[i];
        }
        for(int i =0 ; i<3 ; i ++){
            sideUp[i][col] = temp[i];
        }
        if( col == 0){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideD[i][j];
                }
            }
            setCol(0, sideD, getRow(2, temp3));
            setCol(1, sideD, getRow(1, temp3));
            setCol(2, sideD, getRow(0, temp3));
            
            
            

        }else if( col == 2){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideB[i][j];
                }
            }
            setRow(0, sideB, getCol(2, temp3));
            setRow(1, sideB, getCol(1, temp3));
            setRow(2, sideB, getCol(0, temp3));

            
            

        }
        reverse2darray(sideC);
    }

    public void rotateUp(int col){
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];
            
        temp = getCol(col, sideUp);
        temp2 = getCol(col, sideA);
        reverse2darray(sideC);//reverse side c(back side)
        for(int i =0 ; i<3 ; i ++){
            sideUp[i][col] = temp2[i];
        }
        temp2 = getCol(col, sideC);
        for(int i =0 ; i<3 ; i ++){
            sideC[i][col] = temp[i];
        }
        temp =getCol(col, sideDown);
        for(int i =0 ; i<3 ; i ++){
            sideDown[i][col] = temp2[i];
        }
        for(int i =0 ; i<3 ; i ++){
            sideA[i][col] = temp[i];
        }
        if( col == 0){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideD[i][j];
                }
            }
            setRow(0, sideD,getCol(2, temp3));
            setRow(1, sideD,getCol(1, temp3));
            setRow(2, sideD,getCol(0, temp3));
            
            
            

        }else if( col == 2){
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideB[i][j];
                }
            }
            setCol(0, sideB, getRow(2, temp3));
            setCol(1, sideB, getRow(1, temp3));
            setCol(2, sideB, getRow(0, temp3));
            
        }
        reverse2darray(sideC);
    }

    public void layerRight(int layer){
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];

        if(layer == 0){
            
            temp = getRow(2, sideUp);
            setRow(2, sideUp, reversearray(getCol(2, sideD)));
            temp2 = getCol(0, sideB);
            setCol(0, sideB, temp);
            temp = getRow(0, sideDown);
            setRow(0, sideDown,reversearray(temp2));
            setCol(2, sideD, temp);
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideA[i][j];
                }
            }
            setCol(0, sideA, getRow(2, temp3));
            setCol(1, sideA, getRow(1, temp3));
            setCol(2, sideA, getRow(0, temp3));

        }else if (layer == 1){
            temp = getRow(1, sideUp);
            setRow(1, sideUp, reversearray(getCol(1, sideD)));
            temp2 = getCol(1, sideB);
            setCol(1, sideB, temp);
            temp = getRow(1, sideDown);
            setRow(1, sideDown,reversearray(temp2));
            setCol(1, sideD, temp);
        }else{
            temp = getRow(0, sideUp);
            setRow(0, sideUp, reversearray(getCol(0, sideD)));
            temp2 = getCol(2, sideB);
            setCol(2, sideB, temp);
            temp = getRow(2, sideDown);
            setRow(2, sideDown,reversearray(temp2));
            setCol(0, sideD, temp);

            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideC[i][j];
                }
            }
            setRow(0, sideC,getCol(2, temp3));
            setRow(1, sideC,getCol(1, temp3));
            setRow(2, sideC,getCol(0, temp3));

        }
    }
    public void layerLeft(int layer){
        char[] temp;
        char[] temp2;
        char[][] temp3;
        temp = new char[3];
        temp2 = new char[3];
        temp3 = new char[3][3];

        if(layer == 0){
            
            temp = getRow(2, sideUp);
            setRow(2, sideUp, getCol(0, sideB));
            temp2 = getCol(2, sideD);
            setCol(2, sideD, reversearray(temp));
            temp = getRow(0, sideDown);
            setRow(0, sideDown,temp2);
            setCol(0, sideB, reversearray(temp));
            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideA[i][j];
                }
            }
            setRow(0, sideA,getCol(2, temp3));
            setRow(1, sideA,getCol(1, temp3));
            setRow(2, sideA,getCol(0, temp3));
            

        }else if (layer == 1){
            temp = getRow(1, sideUp);
            setRow(1, sideUp, getCol(1, sideB));
            temp2 = getCol(1, sideD);
            setCol(1, sideD, reversearray(temp));
            temp = getRow(1, sideDown);
            setRow(1, sideDown,temp2);
            setCol(1, sideB, reversearray(temp));
        }else{
            temp = getRow(0, sideUp);
            setRow(0, sideUp, getCol(2, sideB));
            temp2 = getCol(0, sideD);
            setCol(0, sideD, reversearray(temp));
            temp = getRow(2, sideDown);
            setRow(2, sideDown,temp2);
            setCol(2, sideB, reversearray(temp));

            for(int i = 0 ; i<3 ; i++){
                for (int j = 0 ; j<3 ; j++ ){
                    temp3[i][j] = sideC[i][j];
                }
            }
            setCol(0, sideC, getRow(2, temp3));
            setCol(1, sideC, getRow(1, temp3));
            setCol(2, sideC, getRow(0, temp3));

        }




    }

    ArrayList<String> moveList=new ArrayList<String>();
    moveList.add("U");
    moveList.add("U'");
    moveList.add("D");
    moveList.add("D'");
    moveList.add("F");
    moveList.add("F'");
    moveList.add("B");
    moveList.add("B'");
    moveList.add("R");
    moveList.add("R'");
    moveList.add("L");
    moveList.add("L'");
    moveList.add("M");
    moveList.add("M'");
    moveList.add("S");
    moveList.add("S'");
    moveList.add("E");
    moveList.add("E'");

    public Void Random(){
        //10 repeats in order to shuffle the cube 
        for (int j=0; j<10; j++)
        {
            // loop to print elements at randonm
            for (int i = 0; i < movelist.size(); i++) 
            {
                // generating the index using Math.random()
                int index = (int)(Math.random() * movelist.size());
                String move = moveList.get(index); 
                System.out.println("Random Element is :" + movelist.get(index));
                Move(move);
            }
        }
    }  
    
    public void Move(String move){
        switch (move){
            case "U":
                rotateRight(0);
                break;
            case "U'":
                RotateLeft(0);
                break;
            case "D":
                RotateLeft(2);
                break;  
            case "D'":
                rotateRight(2);
                break;
            case "F":
                layerRight(0);
                break;
            case "F'":
                layerLeft(0);
                break;
            case "B":
                layerLeft(2);
                break;
            case "B'":
                layerRight(2);
                break;
            case "R":
                rotateUp(2);
                break;
            case "R'":
                rotateDown(2);
                break;
            case "L":
                rotateDown(0);
                break;
            case "L'":
                rotateUp(0);
                break;
            case "M":
                rotateUp(1);
                break;
            case "M'":
                rotateDown(1);
                break;
            case "S":
                layerRight(1);
                break;
            case "S'":
                layerLeft(1);
                break;
            case "E":
                rotateRight(1);
                break;
            case "E'":
                RotateLeft(1);
                break;
            

        }

    }
        
       
    
    public boolean isFinal(char[][] side){
        char first = side[0][0];
        for(int i = 0 ; i <3; i++){
                    
            for(int j = 0 ; j <3; j++){
                 if (side[i][j] != first){
                    return false;
                }
            }
                    
        }
        return true;    
    }

    void print() {
        System.out.println();           //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    State getFather() {
        return this.father;
    }

    void setFather(State father) {
        this.father = father;
    }

    ArrayList<State> getChildren(int heuristic) {
        return null;
    }

    // public boolean isFinal() {
    //     return true;                        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // }

    @Override
    public int compareTo(State o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
