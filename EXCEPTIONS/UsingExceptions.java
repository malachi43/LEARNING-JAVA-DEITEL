
public class UsingExceptions{
    public static void main(String[] args) {
        // try {
        //     throwException();
        // } catch (Exception e) {
        //     System.out.println("Exception handled in main.");
        // }
        // doesNotThrowException();
        try {
            method1();
        } catch (Exception e) {
            System.out.printf("%s%n%n", e.getMessage());
            e.printStackTrace();
            StackTraceElement[] traceElement = e.getStackTrace();

            System.out.printf("%nStack trace from get stack trace:%n");
            System.out.printf("Class\t\tFile\t\t\tLine\tMethod%n");

            for(StackTraceElement element : traceElement){
              System.out.printf("%s\t", element.getClassName());
              System.out.printf("%s\t", element.getFileName());
              System.out.printf("%s\t", element.getLineNumber());
              System.out.printf("%s%n", element.getMethodName());

            }
        }
    }

    public static void throwException() throws Exception{
        try {
            System.out.println("Method throwException");
            throw new Exception("custom exception."); // 
        } catch (Exception e) {
            System.out.println("Exception handled in throwException.");
            throw e;
        }finally{
            System.out.println("finally executed in throwException method.");
        }
    }

    public static void doesNotThrowException(){
        try {
            System.out.println("Method doesNotThrowException.");
        } catch (Exception e) {//does not execute.
            System.err.println(e);
        } finally {
            System.out.println("End of method doesNotThrowException.");
        }
    }

    public static void method3() throws Exception{
        throw new Exception();
    }

    public static void method2() throws Exception{
          method3();
    }

    public static void method1() throws Exception{
        method2();
    }
}