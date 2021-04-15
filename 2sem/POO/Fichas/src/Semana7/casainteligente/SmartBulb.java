package Fichas.src.Semana7.casainteligente;

import java.util.Objects;

public class SmartBulb extends SmartDevice{
  public static final int WARM = 2;
  public static final int NEUTRAL= 1;
  public static final int COLD = 0;

  private int tone;

  public SmartBulb(String ID, int tone) {
    super(ID,false);
    this.tone = tone;
  }

  public SmartBulb(String ID) {
    super(ID,false);
    this.tone = NEUTRAL;
  }

  public SmartBulb() {
    super("",false);
    this.tone = NEUTRAL;
  }
  public int getTone() {
    return tone;
  }

  public void setTone(int tone) {
    if(tone>0)
      this.tone = 2;
    else if ( tone<0 )
      this.tone = 0;
  }

  public SmartBulb clone() {
    return new SmartBulb(this.getID(),this.getTone());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SmartBulb smartBulb = (SmartBulb) o;
    return tone == smartBulb.tone;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tone);
  }
}
