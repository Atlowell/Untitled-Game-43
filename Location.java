import java.util.Scanner;

/**
 * [Untitled Game]
 * [Description of game goes here, including objectives, backstory, etc.]
 * @author Wesley LaFleur, wlafleur@purdue.edu
 * @author Austin Lowell, N/A
 * @author David Burgos, N/A
 * @version October 10, 2015
 */
public class Location {

    //GLOBAL VARIABLES
    String s;
    Scanner in = new Scanner(System.in);

    public Location square1() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square2();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("\033[31;1mWhat?\033[0m");
            square1();
        }
        return null;
    }

    public Location square2() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
            System.out.println("Which way would you like to go?");
            s = in.nextLine();
            if (s.equalsIgnoreCase("d")) {
                System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
                square3();
            } else if (s.equalsIgnoreCase("s")) {
                System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
                square6();
            } else if (s.equalsIgnoreCase("a")) {
                System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
                square1();
            } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
                System.out.println("\033[31;1mThanks for playing!\033[0m");
            }
            else {
                System.out.println("What?");
                square2();
            }
        return null;
    }

    public Location square3() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square4();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square7();
        } else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square2();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square3();
        }
        return null;
    }

    public Location square4() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square3();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square8();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square4();
        }
        return null;
    }

    public Location square5() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square1();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square6();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square9();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square5();
        }
        return null;
    }

    public Location square6() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        System.out.println("'a' for west.)");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square2();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square7();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square10();
        } else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square6();
        }
        return null;
    }

    public Location square7() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square3();
        } else if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square8();
        } else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square11();
        } else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square6();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square5();
        }
        return null;
    }

    public Location square8() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square4();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square12();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square7();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square8();
        }
        return null;
    }

    public Location square9() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square10();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square13();
        }
        else if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square5();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square9();
        }
        return null;
    }

    public Location square10() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square11();
        }
        else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square14();
        }
        else if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square6();
        }
        else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square9();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square10();
        }
        return null;
    }

    public Location square11() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if (s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square12();
        }
        else if (s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square15();
        }
        else if (s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square7();
        }
        else if (s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square10();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square11();
        }
        return null;
    }

    public Location square12() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square8();
        }
        else if(s.equalsIgnoreCase("s")) {
            System.out.println("\033[31;1mYou have chosen to go south.\033[0m");
            square16();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square11();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square12();
        }
        return null;
    }

    public Location square13() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*   x   *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square9();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square14();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square13();
        }
        return null;
    }

    public Location square14() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *   x   *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square10();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square15();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square13();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square14();
        }
        return null;
    }

    public Location square15() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *   x   *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square11();
        }
        else if(s.equalsIgnoreCase("d")) {
            System.out.println("\033[31;1mYou have chosen to go east.\033[0m");
            square16();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square14();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("What?");
            square15();
        }
        return null;
    }

    public Location square16() {
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("*       *       *       *       *");
        System.out.println("*       *       *       *   x   *");
        System.out.println("*       *       *       *       *");
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("Which way would you like to go?");
        s = in.nextLine();
        if(s.equalsIgnoreCase("w")) {
            System.out.println("\033[31;1mYou have chosen to go north.\033[0m");
            square12();
        }
        else if(s.equalsIgnoreCase("a")) {
            System.out.println("\033[31;1mYou have chosen to go west.\033[0m");
            square15();
        } else if (s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")) {
            System.out.println("\033[31;1mThanks for playing!\033[0m");
        }
        else {
            System.out.println("\033[31;1mWhat?\033[0m");
            square16();
        }
        return null;
    }
}
