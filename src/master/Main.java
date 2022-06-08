package master;
import java.io.FileReader;
import java.io.IOException;
public class Main { 

	public static String checkFile(){
		String code="";
		try(FileReader reader = new FileReader("/Users/kiryxa/Downloads/DSL-main/src/Code.txt"))
		{
			int c;
			while((c=reader.read())!=-1){

				code=code.concat(String.valueOf((char)c));
			}
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		return code;
	}

    public static void main(String[] args) {
		String s=checkFile();
		System.out.println("\n\nИсходный код программы:");
		System.out.println(s);
		System.out.printf("\n" + "\nЗначения лексера:");
		Lexer lexer=new Lexer(s);
		Parser parser=new Parser(lexer.analyze());
		System.out.println("\n" + "[n] " + "- номер токена данных.");
		System.out.println("\nВычисления интерпретатора:");
		RootNode root=parser.parseTokens();
		Interpreter interpreter =new Interpreter();
		for(int i = 0; i<root.codeStr.size(); i++) {
			interpreter.run(root.codeStr.get(i));
		}
    }
}
