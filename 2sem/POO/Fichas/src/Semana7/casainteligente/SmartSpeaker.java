package Fichas.src.Semana7.casainteligente;

public class SmartSpeaker extends SmartDevice {
  public static final int MAX =100;
  public static final int MIN =0;

  private String channel;
  private int volume;

  public SmartSpeaker(String ID, String channel, int volume) {
    super(ID,false);
    this.channel = channel;
    this.volume = volume;
  }

  public SmartSpeaker() {
    super();
    this.channel = "";
    this.volume =MIN;
  }

  public SmartSpeaker(String ID) {
    super(ID);
    this.channel = "";
    this.volume =MIN;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public void volumeUp(){
    this.volume = this.volume++ % (MAX+1);
  }
  public void volumeDown(){
    this.volume = this.volume-- % (MAX+1);
  }
}
