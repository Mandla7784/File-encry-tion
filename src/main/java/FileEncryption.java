package  main.java;

import java.util.Scanner;
import java.io.File;;
/**
 * TODO:
    * Description: Created a program that encrypts and 
    decrypts the contents of a text file using a simple
    encryption algorithm. Prompting the user to choose
    between encryption and decryption, and input the
    file name and path. Encrypt and  decrypt the file
    accordingly and save the result to a new file.

    Skills: File handling, string manipulation, basic
    input/output operations.
 */
class  FileEncryption{
    public static void main(String[] args) {
           encryptFile("instructions.txt");
    }
    static  void encryptFile(String filePath){
        try {
            File myObj  = new File(filePath);
             Scanner FileReader = new Scanner(myObj);
             while(FileReader.hasNextLine()){
                 String data = FileReader.nextLine();
                 System.out.println(data);

             }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


