package design_pattern.zen_of_design_pattern.chapter23;

public interface ILetterProcess {
    public void writeContext(String context);

    public void fillEnvelope(String address);

    public void letterInotoEnvelope();

    public void sendLetter();
}
