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
"		String sourceCode = new String();",
"		for (int i = 0; i < 7; i++) {",
"			sourceCode = sourceCode + programtext[i] '\\n';",			
"		}",
"		for (int i = 0; i < programText.length; i++) {",
"			sourceCode = sourceCode + qoute + programText[i] + qoute + ',' + '\\n';",		
"		}",
"		for(int i = 7; i < programText.length; i++) {",
"			sourceCode = sourcecCode + programText[i] + '\\n';",		
"		}",
"		return sourceCode.toString();",
"	}",
"	// Ab hier einfuegen verboten",
"}",
	};	
	private static String getText() {
		char quote = 34;
		String sourceCode = new String();
		for (int i = 0; i < 7; i++) {
			sourceCode = sourceCode + programText[i] + '\n';
		}
		for (int i = 0; i < programText.length; i++) {
			sourceCode = sourceCode + quote + programText[i] + quote + ',' + '\n';			
		}
		for(int i = 7; i < programText.length; i++) {
			sourceCode = sourceCode + programText[i] + '\n';
		}
		return sourceCode;
	}
	// Ab hier einfuegen verboten
}
