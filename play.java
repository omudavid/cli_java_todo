import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;


class Play{
public static void main(String args[]){
    String add = "-add";
    String list = "-ls";
    String delete = "-d";
    String complete = "-complete";

    //getMap();


    if(args.length>0){
        if(args[0].equals(list)){
        ls();
        }

    if(args[0].equals(add)){
        add(args);
    }

    if(args[0].equals(delete)){
        delete(args);
    }

    if(args[0].equals(complete)){
        complete(args);
    }

    }

    



}

static void print(String value){
    System.out.println( value );
}

static void add(String value[]){
    try{
        
        FileWriter fileWriter = new FileWriter("filename.txt",true);
        String toDo = "";
        for(int i =1;i<value.length;i++){
            if(i==1){
                toDo+=( value[i]);
            }else{
toDo+=(" " + value[i]);
            }
            
        }

        fileWriter.write(toDo + "\n");
        fileWriter.close();
    }catch(IOException e){
        print("File error ${e}");
    }
}


static void delete(String value[]){
    try{
        String toDos[] = getMap();
        FileWriter fileWriter = new FileWriter("filename.txt");

        String  toDo = "";

        for(int i =0;i<toDos.length;i++){
            if(!Integer.toString(i+1).equals(value[1])){
                toDo+=( toDos[i] + "\n");
            }
        }

    

        fileWriter.write(toDo);
        fileWriter.close();
    }catch(IOException e){
        print("File error ${e}");
    }
}


static void complete(String value[]){
    try{
        String toDos[] = getMap();
        FileWriter fileWriter = new FileWriter("filename.txt");

        String  toDo = "";

        for(int i =0;i<toDos.length;i++){
            if(Integer.toString(i+1).equals(value[1])){
                toDo+=("* " + toDos[i] + "\n");
            }else{
                toDo+=(toDos[i] + "\n");
            }
        }

    

        fileWriter.write(toDo);
        fileWriter.close();
    }catch(IOException e){
        print("File error ${e}");
    }
}


static void ls(){
    try{
         File toDoList = new File("filename.txt");
    Scanner reader = new Scanner(toDoList);
int count = 0;
    while(reader.hasNextLine()){
        count +=1;
        print(Integer.toString(count) +")" + " "+ reader.nextLine());
    }
    reader.close();
    }catch(FileNotFoundException e){
        print("File not found ${e}");
    }
   
}

static String[]  getMap(){
    try{
        File toDoList = new File("filename.txt");
   Scanner reader = new Scanner(toDoList);
   String data = "";
   Integer count =0;

   while(reader.hasNextLine()){
       
       if(count ==0){
        data += (reader.nextLine());
        count+=1;
       }else{
           data += ("-" + reader.nextLine());
       }
       
   }
   reader.close();
  
   var split = data.split("-");

  
   return split;

   }catch(FileNotFoundException e){
       print("File not found ${e}");
   }

   return new String[2];
}


// static void createFile(){
//     try {
//         File myObj = new  File("filename.txt");
//         if (myObj.createNewFile()) {
//           System.out.println("File created: " + myObj.getName());
//         } else {
//           System.out.println("File already exists.");
//         }
//       } catch (IOException e) {
//         System.out.println("An error occurred.");
//         e.printStackTrace();
//       }
// }



 } 
