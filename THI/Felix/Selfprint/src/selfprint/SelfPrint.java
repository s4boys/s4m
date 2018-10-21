package selfprint;
public class SelfPrint {
	public static void main(String[] args) {
		System.out.println(getText());
	}	
	// Ab hier einfuegen erlaubt
	private static String programText [] = {
"package selfprint;",
"public class SelfPrint {",
"	public static void main(String[] args) {",
"		System.out.println(getText());",
"	}",
"	// Ab hier einfuegen erlaubt",
"	private static String programText [] = {",
"	};",
"	private static String getText() {",
"		char quote = 34;",
"		char newline = 10;",		
"		String sourceCode = new String();",
"		for (int i = 0; i < 7; i++) {",
"			sourceCode = sourceCode + programtext[i] + newline;",			
"		}",
"		for (int i = 0; i < programText.length; i++) {",
"			sourceCode = sourceCode + qoute + programText[i] + qoute + ',' + newline;",		
"		}",
"		for(int i = 7; i < programText.length; i++) {",
"			sourceCode = sourcecCode + programText[i] + newline;",		
"		}",
"		return sourceCode.toString();",
"	}",
"	// Ab hier einfuegen verboten",
"}",
	};	
	private static String getText() {
		char quote = 34;
		char newline = 10;
		String sourceCode = new String();
		for (int i = 0; i < 7; i++) {
			sourceCode = sourceCode + programText[i] + newline;
		}
		for (int i = 0; i < programText.length; i++) {
			sourceCode = sourceCode + quote + programText[i] + quote + ',' + newline;			
		}
		for(int i = 7; i < programText.length; i++) {
			sourceCode = sourceCode + programText[i] + newline;
		}
		return sourceCode;
	}
	// Ab hier einfuegen verboten
}
