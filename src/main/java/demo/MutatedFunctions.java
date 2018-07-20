package demo;

class MutatedFunctions {

    private MutatedFunctions() {
    }

    static String foo(boolean b) {
        if (b) {
            performVitallyImportantBusinessFunction();
            return "OK";
        }

        return "FAIL";
    }

    static String foo(int i) {
        if (i >= 0) {
            return "foo";
        } else {
            return "bar";
        }
    }

    private static void performVitallyImportantBusinessFunction() {
        // causes some important side effect
    }

}
