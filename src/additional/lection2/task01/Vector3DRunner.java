package additional.lection2.task01;

public class Vector3DRunner {

    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);
        Vector3D i = new Vector3D(1, 0,0);
        Vector3D j = new Vector3D(0, 1, 0);

        System.out.println("v1 = " + v1 + "; v2 = " + v2 + "; i = " + i + "; j = " + j);
        System.out.println("v1 * v2 = " + v1.multiplyScalar(v2));
        System.out.println("v1 x v2 = " + v1.multiplyVector(v2));
        System.out.println("i x j = " + i.multiplyVector(j));
    }
}
