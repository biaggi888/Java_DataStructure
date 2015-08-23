package Graph;

/**
 * Created by èÕ◊â§Œ•È•§•¿©` on 23/08/15.
 */
public class Queue
{
  private static final int SIZE = 20;
  private int font;
  private int rear;
  private int queue[];

  public Queue() {
    queue = new int[SIZE];
    font = 0;
    rear = -1;
  }

  public int pop() {
    int tmp = queue[font ++];
    if (font == SIZE)
      font = 0;
    return tmp;
  }

  public void push(int value) {
    if (rear == SIZE -1)
      rear = -1;
    queue [++rear] = value;
  }

  public int peek() {
    return queue[font];
  }

  public boolean isEmpty() {
    return (rear + 1 == font
                || font + SIZE -1 == rear);
  }

}
