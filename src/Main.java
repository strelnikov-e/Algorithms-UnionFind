import java.io.*;
import java.util.Random;

/*
        Execution time in ns for an array of 100 000 elements and 50 000 unions:
        Eager: 		1462825333
        Tree: 		26688250 1.82% of eager implementation or 55 times faster
        Fast Tree: 	18223792 1.25% of eager implementation or 80 times faster
*/
public class Main {

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int connections = 100000;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("array_big.txt"))) {
            bufferedWriter.write(connections + "\n");
            for (int i = 0; i < connections; i++) {
                bufferedWriter.write(random.nextInt(connections) + ",");
                bufferedWriter.write(random.nextInt(connections) + "\n");
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("array_big.txt"))) {
            int N = Integer.parseInt(reader.readLine());
            UnionFindEager unionFindEager = new UnionFindEager(N);
            String input;
            long startTime = System.nanoTime();
            while (((input = reader.readLine()) != null)) {
                String[] line = input.split(",");
                int p = Integer.parseInt(line[0]);
                int q = Integer.parseInt(line[1]);
                if (!unionFindEager.connected(p, q)) {
                    unionFindEager.union(p, q);
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Eager Tree: \t" + (endTime - startTime));

            UnionFindTree unionFindTree = new UnionFindTree(N);
            startTime = System.nanoTime();
            while (((input = reader.readLine()) != null)) {
                String[] line = input.split(",");
                int p = Integer.parseInt(line[0]);
                int q = Integer.parseInt(line[1]);
                if (!unionFindTree.connected(p, q)) {
                    unionFindTree.union(p, q);
                }
            }
            endTime = System.nanoTime();
            System.out.println("Tree: \t\t\t" + (endTime - startTime));

            UFTreeBigEl unionFindBigEl = new UFTreeBigEl(N);
            startTime = System.nanoTime();
            while (((input = reader.readLine()) != null)) {
                String[] line = input.split(",");
                int p = Integer.parseInt(line[0]);
                int q = Integer.parseInt(line[1]);
                if (!unionFindBigEl.connected(p, q)) {
                    unionFindBigEl.union(p, q);
                }
            }
            endTime = System.nanoTime();
            System.out.println("Fast Tree: \t\t" + (endTime - startTime));


        }

    }
}
