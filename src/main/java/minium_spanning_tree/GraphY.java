package minium_spanning_tree;

import org.misc.Person;

import Graph.StackX;
import Graph.Vertex;
import Utils.StackOverFlowException;

/**
 * Created by èÕ◊â§Œ•È•§•¿©` on 24/08/15.
 */
public class GraphY<T>
{
  private VertexY<T>[] vertex;
  private StackX stack;
  private final int MAX_VERTEX = 30;
  private boolean[][] adjMatrix;
  private int currentVertex = 0;

  public GraphY() {
    vertex = new VertexY[MAX_VERTEX];
    adjMatrix = new boolean[MAX_VERTEX][MAX_VERTEX];
    stack = new StackX();
  }

  public void addVertex(T v) {
    vertex[currentVertex++] = new VertexY<>(v);
  }

  public void addAdge(int start, int end) {
    adjMatrix[start][end] = true;
  }

  public void displayVertex(int position) {
    System.out.print(vertex[position]);
  }

  public void createMinimumSpanningTree(int v) throws StackOverFlowException {
    vertex[v].wasVisited = true;
    stack.push(v);
    while (! stack.isEmpty()) {
      int curVertex = stack.peek();
      int v1 = getUnVisitedVertex(curVertex);
      if (v1 == - 1) {
        stack.pop();
      } else {
        vertex[v1].wasVisited = true;
        stack.push(v1);
        displayVertex(curVertex);
        System.out.print(" -> ");
        displayVertex(v1);
        System.out.print("\n");
      }
    }


    for (int i = 0; i < currentVertex; i++) {
      vertex[i].wasVisited = false;
    }
  }

  public int getUnVisitedVertex(int index) {
    for (int i = 0; i < currentVertex; i++) {
      if (adjMatrix[index][i] == true && vertex[i].wasVisited == false) {
        return i;
      }
    }
    return - 1;
  }
}
