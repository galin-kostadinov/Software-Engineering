package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int StartIndexFileName = text.lastIndexOf('\\')+1;
        int StartIndexExtension = text.lastIndexOf('.')+1;
        String fileName = text.substring(StartIndexFileName, StartIndexExtension-1);
        String extension = text.substring(StartIndexExtension);

        System.out.println(String.format("File name: %s", fileName));
        System.out.println(String.format("File extension: %s", extension));

    }
}
