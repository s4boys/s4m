package selfprint;

public class SelfPrint {
	public static void main(String[] args) {
		System.out.println(getText());
	}
	
	// Ab hier einfügen erlaubt
	private static String programText [] = {
				"package selfprint;\r\n",
				"",
				"public class SelfPrint {\r\n",
				"	public static void main(String[] args) {\r\n",
				"		System.out.println(getText());\r\n",
				"	}\r\n",
				"	// Ab hier einfügen erlaubt\r\n",
				"	private static String programText [] = {\r\n",
				"	};\r\n",
				"",
				"	private static String getText() {\r\n",
				"		char quote = 34;\r\n",
				"		StringBuilder sourceCode = new StringBuilder();\r\n",
				"		for (int i = 0; i < 9; i++) {\r\n",
				"			sourceCode.append(programText[i]);\r\n",
				"		}\r\n",
				"		for (int i = 0; i < programText.length; i++) {\r\n",
				"			sourceCode.append(quote + programText[i] + quote + ',');\r\n",
				"		}\r\n",
				"		for(int i = 4; i < programText.length; i++) {\r\n",
				"			sourceCode.append(programText[i]);\r\n",
				"		}\r\n",
				"		return sourceCode.toString();\r\n",
				"	}\r\n",
				"	// Ab hier einfügen verboten\r\n",
				"}\r\n",
				""
	};
	
	private static String getText() {
		char quote = 34;
		StringBuilder sourceCode = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sourceCode.append(programText[i]);
		}
		for (int i = 0; i < programText.length; i++) {
			sourceCode.append(quote + programText[i] + quote + ',');
		}
		for(int i =10; i < programText.length; i++) {
			sourceCode.append(programText[i]);
		}
		return sourceCode.toString();
	}
	// Ab hier einfügen verboten
}
