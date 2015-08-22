package Graph;

import java.util.Arrays;

import javax.swing.plaf.metal.MetalIconFactory;

/**
 * Created by èÕ◊â§Œ•È•§•¿©` on 22/08/15.
 */
//TODO be review
public class Graph
{
  private static final int MAX_VERTEX = 20;
  private Vertex[] vertexArray;
  private boolean[][] adjMatrix;
  private int numberOfVertex;
  private StackX stack;

  public Graph() {
    vertexArray = new Vertex[MAX_VERTEX];
    adjMatrix = new boolean[MAX_VERTEX][MAX_VERTEX];
    for (int i = 0, len = adjMatrix.length; i < len; i++) {
      Arrays.fill(adjMatrix[i], false);
    }
    numberOfVertex = 0;
    stack = new StackX();
  }

  public void addVertex(char lable) {
    vertexArray[numberOfVertex++] = new Vertex(lable);
  }

  public void addAdge(int start, int end) {
    adjMatrix[start][end] = true;
    adjMatrix[end][start] = true;
  }

  public void displayVertex(int position) {
    System.out.print(vertexArray[position]);
  }

  public void depthFirstSearch() {
    vertexArray[0].wasVisited = true;
    displayVertex(0);
    stack.push(0);
    while (!stack.isEmpty()) {
      int i = getAdjUnvisitedVertex(stack.peek());
      if(i == -1) {
        stack.pop();
      } else {
        vertexArray[i].wasVisited = false;
        displayVertex(i);
        stack.push(i);
      }
    }

    for (int i = 0; i < numberOfVertex; i++) {
      vertexArray[i].wasVisited = false;
    }
  }

  public int getAdjUnvisitedVertex(int index){
    for (int i = 0; i < numberOfVertex; i++) {
      if(adjMatrix[index][i] == true &&
             vertexArray[i].wasVisited == false) {
        return i;
      }
    }
    return -1;
  }
}
