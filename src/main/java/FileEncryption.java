package  main.java;

import java.io.File;
import java.io.FileWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Scanner;
import javax.crypto.Cipher;


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
    public static void main(String[] args) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        File file = new File("instructions.txt");
        FileWriter fw =new FileWriter(file);

         // Creating KeyPair generator object
         KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
          keyPairGen.initialize(2048); // init

          KeyPair pair = keyPairGen.generateKeyPair();

          // creating cypher object 
          Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

       //Initializing a Cipher object
       cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        
          // enctrypting the data 
          byte[] cipherText = cipher.doFinal();
          System.out.println(new String(cipherText , "utf-8"));
          System.out.println();
          System.out.println("Data encrypted successfully");
          fw.append(new String(cipherText , "utf-8"));
          fw.close();
           Scanner userAnswer = new Scanner(System.in);
           System.out.println("Would you like to decrypt ?");
           System.out.println(userAnswer);
           if(userAnswer.equals("yes")){
            // decrypt the ciphertext 
          cipher.init(Cipher.DECRYPT_MODE, pair.getPublic());
           byte[] newPlainText = cipher.doFinal(cipherText);
             System.out.println( "Finish decryption: " );
             System.out.println( new String(newPlainText, "UTF8") );
           }
      


     

    }
    static  String  encryptFile(String filePath){

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
        return filePath;
  

    }
}


