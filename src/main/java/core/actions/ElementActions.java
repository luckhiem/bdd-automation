package core.actions;

public interface ElementActions {
    WaitActions waitAction = new WaitActions();
    ClickActions clickAction = new ClickActions();
    InputActions inputAction = new InputActions();
    KeyboardActions keyboardAction = new KeyboardActions();
    AssertionActions assertAction = new AssertionActions();
    NavigationActions navigationAction = new NavigationActions();
}
