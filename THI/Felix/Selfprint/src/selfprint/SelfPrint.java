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
"		StringBuilder sourceCode = new StringBuilder();",
"		for (int i = 0; i < 7; i++) {",
"			sourceCode.append(programText[i]);",
"			sourceCode.append(System.getProperty(\"line.seperator\"));",			
"		}",
"		for (int i = 0; i < programText.length; i++) {",
"			sourceCode.append(quote + programText[i] + quote + ',');",
"			sourceCode.append(System.getProperty(\"line.seperator\"));",		
"		}\r\n",
"		for(int i = 7; i < programText.length; i++) {",
"			sourceCode.append(programText[i]);",
"			sourceCode.append(System.getProperty(\"line.seperator\"));",		
"		}",
"		return sourceCode.toString();",
"	}",
"	// Ab hier einfuegen verboten",
"}",
	};	
	private static String getText() {
		char quote = 34;
		StringBuilder sourceCode = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sourceCode.append(programText[i]);
			sourceCode.append(System.getProperty("line.seperator"));
		}
		for (int i = 0; i < programText.length; i++) {
			sourceCode.append(quote + programText[i] + quote + ',');
			
		}
		for(int i = 7; i < programText.length; i++) {
			sourceCode.append(programText[i]);
			sourceCode.append(String.format("%n", ""));
		}
		return sourceCode.toString();
	}
	// Ab hier einfuegen verboten
}
