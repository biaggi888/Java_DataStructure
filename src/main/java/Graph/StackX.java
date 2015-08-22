package Graph;

/**
 * Created by Leo on 22/08/15.
 */
public class StackX
{
  private static final int SIZE = 20;
  private int top = -1;
  private int st[];

  public StackX() {
    st = new int[SIZE];

  }

  public boolean push(int value) {
    if(st == null) {
      throw new NullPointerException("Stack == null");
    }
    st[++top] = value;
    return true;
  }
  public int pop() {
    return st[top--];
  }
  public int peek() {
    return st[top];
  }
}
