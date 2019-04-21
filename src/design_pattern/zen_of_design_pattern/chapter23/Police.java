package design_pattern.zen_of_design_pattern.chapter23;

public class Police {
    public void checkLetter(ILetterProcess letterProcess) {
        System.out.println(letterProcess + " 信件已经检查过了...");
    }
}
