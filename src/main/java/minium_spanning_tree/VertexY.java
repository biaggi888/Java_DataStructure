package minium_spanning_tree;

/**
 * Created by Í×‰¤Î¥é¥¤¥À©` on 24/08/15.
 */
public class VertexY<T>
{
  public boolean wasVisited;
  public T lable;

  public VertexY(T lable) {
    this.lable = lable;
    wasVisited = false;
  }

  @Override
  public String toString() {
    return "Vertex{"
               + lable + ",Visited=" + wasVisited + '}';
  }
}

