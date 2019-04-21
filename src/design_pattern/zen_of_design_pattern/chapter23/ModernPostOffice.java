package design_pattern.zen_of_design_pattern.chapter23;

public class ModernPostOffice {
    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police letterPolice = new Police();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        letterPolice.checkLetter(letterProcess);
        letterProcess.letterInotoEnvelope();
        letterProcess.sendLetter();
    }
}
