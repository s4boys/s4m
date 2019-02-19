package selfprint;

public class SelfPrint {
    public static void main(String[] args) {
        System.out.println(getText());
    }

    // Ab hier einfuegen erlaubt
    private static String programText[] = {
            "package selfprint;",
            "",
            "public class SelfPrint {",
            "    public static void main(String[] args) {",
            "        System.out.println(getText());",
            "    }",
            "",
            "    // Ab hier einfuegen erlaubt",
            "    private static String programText[] = {",
            "    };",
            "",
            "    private static String getText() {",
            "        char quote = 34;",
            "        char newline = 10;",
            "        String sourceCode = new String();",
            "        char whitespace = 32;",
            "        String indent = new String();",
            "        for (int i = 0; i < 12; i++) {",
            "            indent += whitespace;",
            "        }",
            "        for (int i = 0; i < 9; i++) {",
            "            sourceCode = sourceCode + programText[i] + newline;",
            "        }",
            "        for (int i = 0; i < programText.length; i++) {",
            "            sourceCode = sourceCode + indent + quote + programText[i] + quote + ',' + newline;",
            "        }",
            "        for (int i = 9; i < 33; i++) {",
            "            sourceCode = sourceCode + programText[i] + newline;",
            "        }",
            "        return sourceCode;",
            "    }",
            "    // Ab hier einfuegen verboten",
            "}",
    };

    private static String getText() {
        char quote = 34;
        char newline = 10;
        String sourceCode = new String();
        char whitespace = 32;
        String indent = new String();
        for (int i = 0; i < 12; i++) {
            indent += whitespace;
        }
        for (int i = 0; i < 9; i++) {
            sourceCode = sourceCode + programText[i] + newline;
        }
        for (int i = 0; i < programText.length; i++) {
            sourceCode = sourceCode + indent + quote + programText[i] + quote + ',' + newline;
        }
        for (int i = 9; i < 33; i++) {
            sourceCode = sourceCode + programText[i] + newline;
        }
        return sourceCode;
    }
    // Ab hier einfuegen verboten
}

