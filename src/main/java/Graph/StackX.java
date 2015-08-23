package Graph;

/**
 * Created by Í×‰¤Î¥é¥¤¥À©` on 22/08/15.
 */
public class StackX
{
  private static final int SIZE = 20;
  private int st[];
  private int top;

  public StackX() {
    st = new int[SIZE];
    top = -1;
  }

  public boolean push(int value) {
    if(top + 1 > SIZE - 1) {
      throw new IndexOutOfBoundsException("top > size");
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
  public boolean isEmpty() {
    if (top == -1)
      return true;
    return false;
  }
}
