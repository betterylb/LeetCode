package HeaderFirst.Strategy;

public class DuckCall {
    QuackBehavior quackBehavior;
    public DuckCall(){
        quackBehavior = new Quack();
    }

}
