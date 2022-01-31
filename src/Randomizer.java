import java.util.*;

public class Randomizer{
  public static Random instance = null;

  public Randomizer() {
  }

public static Random getInstance(){
  if(instance == null){
    instance = new Random();
  }
  return instance;
}

public static int nextInt(){
  return Randomizer.getInstance().nextInt();
}


}