package demo;

class MutationTest {

    private MutationTest() {
    }

    public String foo(int i) {
        if ( i >= 0 ) {
            return "foo";
        } else {
            return "bar";
        }
    }

}
