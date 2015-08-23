package Graph;

import java.util.Arrays;

import javax.swing.plaf.metal.MetalIconFactory;

/**
 * Created by ��׉�Υ饤���` on 22/08/15.
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
