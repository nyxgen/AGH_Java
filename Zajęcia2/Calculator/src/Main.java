import java.util.Scanner;

public class Main
{
        public static void main(String args[]) {
            boolean work = true;
            while (work) {
                System.out.println("1. Cone");
                System.out.println("2. Tetrahedron");
                System.out.println("3. Exit");
                Scanner typed = new Scanner(System.in);
                int choice = typed.nextInt();
                switch (choice) {
                    case 1: {
                        ExtendedConeCalculator cone = new ExtendedConeCalculator();
                        System.out.println("1. Base Area");
                        System.out.println("2. Base Perimeter");
                        System.out.println("3. Area");
                        System.out.println("4. Volume");
                        int action = typed.nextInt();
                        switch (action) {
                            case 1: {
                                System.out.println(cone.calculateBaseArea());
                                break;
                            }
                            case 2: {
                                System.out.println(cone.calculateBasePerimeter());
                                break;
                            }
                            case 3: {
                                try {
                                    cone.calculateArea();
                                } catch (Exception except) {
                                    System.out.println(except.getMessage());
                                }
                                break;
                            }
                            case 4: {

                                try {
                                    cone.calculateVolume();
                                } catch (Exception except) {
                                    System.out.println(except.getMessage());
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        ExtendedTetrahedronCalculator tetrahedron = new ExtendedTetrahedronCalculator();
                        System.out.println("1. Base Area");
                        System.out.println("2. Base Perimeter");
                        System.out.println("3. Area");
                        System.out.println("4. Volume");
                        int action = typed.nextInt();
                        switch (action) {
                            case 1: {
                                System.out.println(tetrahedron.calculateBaseArea());
                                break;
                            }
                            case 2: {
                                System.out.println(tetrahedron.calculateBasePerimeter());
                                break;
                            }
                            case 3: {
                                try {
                                    tetrahedron.calculateArea();
                                } catch (Exception except) {
                                    System.out.println(except.getMessage());
                                }
                                break;
                            }
                            case 4: {
                                try {
                                    tetrahedron.calculateVolume();
                                } catch (Exception except) {
                                    System.out.println(except.getMessage());
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case 3:
                    {
                        work = false;

                    }
                }

            }

        }
}
