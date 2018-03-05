public class Ex2 {
    public static void main(String[] args) {
        try{
            String str = null;
            if(str.equals("message")){
                System.out.println(str);
            }
        }

        catch (NullPointerException npe){
            System.out.println("NPE");
            int number = 4 / 0;
        }

        catch (ArithmeticException are){
            System.out.println("ARE");
        }

        catch (Exception ex){
            System.out.println("EX");
        }

        finally {
            System.out.println("Finally");
            return;
        }
    }
}