package Graph;

/**
 * Created by Í×‰¤Î¥é¥¤¥À©` on 23/08/15.
 */
public class BreathFirstSearch
{
  public static void main(String[] args) {
    int numberOfVertex = 9;
    Graph g = new Graph();
    for (int i = 0; i < numberOfVertex; i++) {
      g.addVertex((char) ('A' + i));
    }

    g.addAdge(0, 2);
    g.addAdge(5, 3);
    g.addAdge(8, 1);
    g.addAdge(4, 2);
    g.addAdge(3, 4);
    g.addAdge(1, 2);
    g.addAdge(0, 6);
    g.breathFirstSearch();
  }
}