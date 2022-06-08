package master;
import java.io.FileReader;
import java.io.IOException;
public class Main { 

	public static String checkFile(){
		String code="";
		try(FileReader reader = new FileReader("Code.txt"))
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
		System.out.println(ANSI_BLUE + "\n\nИсходный код программы:" + ANSI_WHITE);
		System.out.println(s);
		System.out.printf("\n" + ANSI_BLUE + "\nЗначения лексера:" + ANSI_WHITE);
		Lexer lexer=new Lexer(s);
		Parser parser=new Parser(lexer.analyze());
		System.out.println("\n" + ANSI_PURPLE + "[n] " + ANSI_WHITE + "- номер токена данных." + ANSI_WHITE);
		System.out.println(ANSI_BLUE + "\nВычисления интерпретатора:" + ANSI_WHITE);
		RootNode root=parser.parseTokens();
		Interpreter interpreter =new Interpreter();
		for(int i = 0; i<root.codeStr.size(); i++) {
			interpreter.run(root.codeStr.get(i));
		}
    }
}
