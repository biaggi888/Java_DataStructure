package minium_spanning_tree;

import Utils.StackOverFlowException;

/**
 * Created by П═╫Йд╬ещеде└й` on 24/08/15.
 */
public class CreateMinimumSpanningTree
{
  public static void main(String[] args) {
    GraphY<City> g = new GraphY<>();
    for (int i = 0; i < 11; i++) {
      g.addVertex(new City("\"" + ((char) ('A' + i)) + "-city\""));
      for (int j = 0; j < 11; j++) {
        if ((j + 10) % 2 == 0)
          g.addAdge(i , j);
        else
          g.addAdge(j, i);
      }
      g.displayVertex(i);
      System.out.print("\n");
    }
    try {
      g.createMinimumSpanningTree(0);
    } catch (StackOverFlowException e) {
      e.printStackTrace();
    }
  }
}

class City
{

  public City(String cityName) {
    this.cityName = cityName;
  }

  @Override
  public String toString() {
    return "City = " + cityName + " ";
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  private String cityName;
}
