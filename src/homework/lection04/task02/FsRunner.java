package homework.lection04.task02;

public class FsRunner {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory d1 = new Directory("dir1",
                new File("f1",10),
                new File("f2",20)
        );
        Directory d2 = new Directory("dir2",
                new Directory("dir3", new File("f3",30)),
                new File("f4",40)
        );
        root.add(d1).add(d2).add(new File("f5",50));

        System.out.println("Tree of file system directories: \n");
        System.out.println(root);

        System.out.println("Trying to add directory d2 to itself:");
        d2.add(d2);
        System.out.println("\nTrying to add directory root to directory d1:");
        d1.add(root);
        System.out.println("\nSize of the root directory is " + root.getSize() + ".");
    }
}
