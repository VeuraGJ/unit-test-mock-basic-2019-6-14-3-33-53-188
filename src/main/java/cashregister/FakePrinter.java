package cashregister;

public class FakePrinter extends Printer{
    private boolean isMethodCalled = false;
    private String printMesage ;
    public void print(String printThis) {
        isMethodCalled = true;
        printMesage = printThis;
    }

    public String getPrintMesage() {
        return printMesage;
    }

    public boolean isMethodCalled() {
        return isMethodCalled;
    }
}
