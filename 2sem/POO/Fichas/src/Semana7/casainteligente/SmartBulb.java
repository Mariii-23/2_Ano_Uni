package Fichas.src.Semana7.casainteligente;

public class SmartBulb extends SmartDevice{
  public static final int WARM = 0;
  public static final int NEUTRAL= 10;
  public static final int COLD = -10;

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
    this.tone = tone;
  }
}
