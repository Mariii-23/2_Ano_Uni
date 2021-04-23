package Fichas.src.Semana7.casainteligente;

import java.util.Objects;

public class SmartSpeaker extends SmartDevice {
  public static final int MAX =20;
  public static final int MIN =0;

  private String channel;
  private int volume;

  public SmartSpeaker(String ID, String channel, int volume) {
    super(ID,false);
    this.channel = channel;
    if(volume>MAX) volume = MAX;
    else if(volume <MIN) volume = MIN;
    this.volume = volume;
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
    if(volume>MAX) volume = MAX;
    else if(volume <MIN) volume = MIN;
    this.volume = volume;
  }

  public void volumeUp(){
    if( this.volume++>= MAX) this.volume= MAX ;
  }
  public void volumeDown(){
    if( this.volume--<= MIN) this.volume= MIN ;
  }

  public SmartSpeaker clone(){
    return new SmartSpeaker(this.getID(),this.channel,this.volume);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    SmartSpeaker that = (SmartSpeaker) o;
    return volume == that.volume && Objects.equals(channel, that.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), channel, volume);
  }
}
