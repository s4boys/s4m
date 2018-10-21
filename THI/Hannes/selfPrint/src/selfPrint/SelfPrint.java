package selfPrint;

public class SelfPrint {
    public static void main(String[] args) {
        System.out.print(getText());
    }

    // Ab hier einfügen erlaubt
    private static String programText[] = {
            "package selfPrint;",
            "",
            "public class SelfPrint {",
            "    public static void main(String[] args) {",
            "        System.out.print(getText());",
            "    }",
            "",
            "    // Ab hier einfügen erlaubt",
            "    private static String programText[] = {",
            "    };",
            "    private static String getText() {",
            "        String result = new String();",
            "        char quote = (char) 34;",
            "        char comma = (char) 44;",
            "        char newline = (char) 10;",
            "        char whitespace = (char) 32;",
            "        char backslash = (char) 92;",
            "        String indent = new String();",
            "        for (int i = 0; i < 12; i++) {",
            "            indent += whitespace;",
            "        }",
            "        for (int i = 0; i < 9; i++) {",
            "            result += programText[i] + newline;",
            "        }",
            "        for (String s : programText) {",
            "            result += indent + quote + s + quote + comma + newline;",
            "        }",
            "        for (int i = 9; i < 34; i++) {",
            "            result += programText[i] + newline;",
            "        }",
            "        return result;",
            "    }",
            "    // Ab hier einfügen verboten",
            "}",
    };
    private static String getText() {
        String result = new String();
        char quote = (char) 34;
        char comma = (char) 44;
        char newline = (char) 10;
        char whitespace = (char) 32;
        char backslash = (char) 92;
        String indent = new String();
        for (int i = 0; i < 12; i++) {
            indent += whitespace;
        }
        for (int i = 0; i < 9; i++) {
            result += programText[i] + newline;
        }
        for (String s : programText) {
            result += indent + quote + s + quote + comma + newline;
        }
        for (int i = 9; i < 34; i++) {
            result += programText[i] + newline;
        }
        return result;
    }
    // Ab hier einfügen verboten
}
