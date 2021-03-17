package Ficha4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class Stack {
  private ArrayList<String> stack;

  public Stack() {
    stack = new ArrayList<String>();
  }

  public Stack(int size) {
    stack = new ArrayList<String>(size);
  }

  public Stack(@NotNull Stack o) {
    this.stack = o.getStack();
  }

  public ArrayList<String> getStack() {
    //ArrayList<String> ret = new ArrayList<>(stack); // faz shallow clone
    ArrayList<String> ret = new ArrayList<>();
    for (String s : stack)
      ret.add(s); // ret.add(s.clone(); Deep clone em vez de shallow clone
    return ret;
  }

  public void setStack(ArrayList<String> stack) {
    for (String s : stack)
      this.stack.add(s);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if ((o == null) || this.getClass() != o.getClass()) return false;
    Stack stack1 = (Stack) o;
    return stack1.getStack().equals(this.stack);
  }

  @Override
  public String toString() {
    return "Stack{" +
        this.stack.toString() +
        '}';
  }

  public Stack clone() {
    return new Stack(this);
  }

  public int length() {
    return this.stack.size();
  }

  public boolean empty() {
    return this.stack.isEmpty();
  }

  public String top() {
    return this.stack.get(this.stack.size() - 1);
  }

  public void push(String s) {
    this.stack.add(s);
  }

  public void pop() {
    if (!this.empty()) {
      this.stack.remove(this.stack.size() - 1);
    }
  }
}
