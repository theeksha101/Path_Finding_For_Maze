package com;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Maze extends JFrame {

    List<Integer> path ;
    int[][] maze =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 14, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 0, 2, 3, 3, 3, 3, 0},
                    {0, 7, 0, 0, 2, 2, 0, 0, 0, 3, 0},
                    {0, 7, 7, 7, 7, 0, 0, 0, 0, 3, 0},
                    {0, 8, 0, 0, 6, 0, 0, 0, 0, 3, 0},
                    {0, 8, 0, 0, 6, 5, 5, 0, 0, 3, 0},
                    {0, 8, 0, 0, 0, 0, 5, 0, 0, 3, 0},
                    {0, 8, 8, 8, 8, 8, 5, 4, 4, 24, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };

    public Maze(List<Integer> p) {
        path = p;
        path.remove(0);
        setTitle("Maze Solving with Dijkstra");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color color;
        g.translate(50, 50);


        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {

                switch (maze[row][col]) {
                    case 0:
                        color = Color.BLACK;
                        break;
                    case 14:
                        color = Color.RED;
                        break;
                    case 24:
                        color = Color.BLUE;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }

                for (int i = 0; i < path.size(); i++){
                    if (maze[row][col] == path.get(i)){
                        color = Color.GREEN;
                        break;
                    }
                }

                g.setColor(color);
                g.fillRect(40 * col, 40 * row, 40, 40);
                g.setColor(Color.BLACK);
                g.drawRect(40 * col, 40 * row, 40, 40);
            }
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int[][] adjacencyMatrix = {
                        {0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 0, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 0, 10, 0, 2, 0, 0},
                        {0, 0, 0, 14, 0, 2, 0, 1, 6},
                        {8, 0, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 6, 7, 0}
                };

                List<Integer> path = DijkstraAlgo.dijkstra(adjacencyMatrix, 0);
                Maze maze = new Maze(path);
                maze.setVisible(true);

            }
        });


    }

}