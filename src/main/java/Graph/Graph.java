package Graph;

import java.util.Arrays;

import javax.swing.plaf.metal.MetalIconFactory;

/**
 * Created by èÕ◊â§Œ•È•§•¿©` on 22/08/15.
 */
//TODO how to get node?
public class Graph
{
  private static final int MAX_VERTEX = 20;
  private Vertex[] vertexArray;
  private boolean[][] adjMatrix;
  private int numberOfVertex;
  private StackX stack;
  private Queue queue;

  public Graph() {
    vertexArray = new Vertex[MAX_VERTEX];
    adjMatrix = new boolean[MAX_VERTEX][MAX_VERTEX];
    for (int i = 0, len = adjMatrix.length; i < len; i++) {
      Arrays.fill(adjMatrix[i], false);
    }
    numberOfVertex = 0;
    stack = new StackX();
    queue = new Queue();
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
    for (;!stack.isEmpty();) {
      int i = getAdjUnvisitedVertex(stack.peek());
      if(i == -1) {
        stack.pop();
      } else {
        vertexArray[i].wasVisited = true;
        displayVertex(i);
        stack.push(i);
      }
    }

    for (int i = 0; i < numberOfVertex; i++) {
      vertexArray[i].wasVisited = false;
    }
  }

  public void createMinimumSpanningTree() {
    vertexArray[0].wasVisited = true;
    stack.push(0);
    while (! stack.isEmpty()) {
      int curVertex = stack.peek();
      int v1 = getAdjUnvisitedVertex(curVertex);
      if (v1 == - 1) {
        stack.pop();
      } else {
        vertexArray[v1].wasVisited = true;
        stack.push(v1);
        displayVertex(curVertex);
        System.out.print(" -> ");
        displayVertex(v1);
        System.out.print("\n");
      }
    }
    for (int i = 0; i < numberOfVertex; i++) {
      vertexArray[i].wasVisited = false;
    }
  }
  /**
   * Method Version 1
  public void breathFirstSearch() {
    vertexArray[0].wasVisited = true;
    queue.push(0);
    for(;!queue.isEmpty();) {
      int i = getAdjUnvisitedVertex(queue.peek());
      if (i == -1) {
        queue.pop();
      } else {
        vertexArray[i].wasVisited = true;
        displayVertex(i);
        queue.push(i);
      }
    }
    for (int i = 0; i < numberOfVertex; i++) {
      vertexArray[i].wasVisited = false;
    }
  }
   */

  /**
   * method version 2
   */
  public void breathFirstSearch2() {
    vertexArray[0].wasVisited = true;
    displayVertex(0);
    queue.push(0);
    int v2;
    while (!queue.isEmpty()) {
      int v1 = queue.pop();
      while ((v2 = getAdjUnvisitedVertex(v1))!=-1) {
        vertexArray[v2].wasVisited = true;
        displayVertex(v2);
        queue.push(v2);
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
