package Telephone;

public abstract class TelephoneDefinition implements TelephoneInterface{

	@Override
	public void pressButton(char btnValue)
	{
		System.out.println(btnValue + " has been pressed.");
	}
	@Override
	public void startRecordVoice()
	{
		System.out.println("Voice recording has been started.");
	}
	
	@Override
	public void endRecordVoice()
	{
		System.out.println("Voice recording has been stopped.");
	}
}
