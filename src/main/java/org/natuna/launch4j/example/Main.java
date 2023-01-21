package org.natuna.launch4j.example;

/**
 * The main class for the launch4j demonstration.
 */
public class Main {

  /**
   * Default constructor.
   */
  public Main() {
  }

  private void run() {
    System.out.println("Hello world!");
  }

  /**
   * THe main routine.
   *
   * @param args any command line arguments
   */
  public static void main(final String... args) {

    Main c = new Main();
    c.run();
    System.exit(0);
  }
}
