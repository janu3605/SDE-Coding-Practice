package StacksUsage;

/*
  MODEL: Stack / Simulation  
  PROBLEM: The Multi-Level Undo Manager You are
  building a simplified text editor engine. The editor supports two types of
  operations: 1. Typing: Represented by a string (e.g., "hello"). 2. Undo:
  Represented by the special command "(undo)".  Each time the engine
  encounters a word, it adds it to the document. Each time it encounters
  "(undo)", it must remove the most recently added word that hasn't already
  been undone.  Your task is to process a sequence of commands and return the
  final state of the document as a single string.   INPUT: - commands (an
  array of strings)  OUTPUT: - A single String representing the final
  document, with words separated by single spaces.  
  EXAMPLE 1: Input: commands
  = ["The", "cat", "sat", "(undo)", "on", "the", "mat"] 
  Output: "The cat on the
  mat" Explanation: "sat" was typed, then undone.  
  EXAMPLE 2: Input: commands = ["A", "B", "(undo)", "(undo)", "C"] 
  Output: "C" Explanation: "A" and "B" were both undone.
 */
import java.util.*;

public class UndoManager {

    public static String processCommands(String[] commands) {
        Stack<String> stack = new Stack<>();

        for (String str : commands) {
            if (!str.contains("undo")) {
                stack.add(str);
            } else {
                stack.pop();
            }
        }

        return String.join(" ", stack);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inpt = sc.nextLine().split(" ");
        String output = processCommands(inpt);
        System.out.println(output);
    }

}
