package Graph;

/**
 * Created by ��׉�Υ饤���` on 22/08/15.
 */
public class Vertex
{
  public char label;
  public boolean wasVisited;

  public Vertex(char label) {
    this.label = label;
    wasVisited = false;
  }

  @Override
  public String toString() {
    return "Vertex = " + label + " WasVisuted = " + wasVisited + "\n" ;
  }
}
