
```java
interface Room {
   public static final Player player = new Player(1,"test")  ;
}

class Player{
    private String name;
    private int id;
    
    public Player(int id, String name){
    this.name = name;
    this.id = id;    
}

}
```

Association  Room---->Player

