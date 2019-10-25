package level4_refactor;

public class Level4Refactor {
    public static void main(String[] args) {
        String[] aA = {"A","B","C"},bB = {"a","b","c"},cC;

        GoGoGo running = new GoGoGo();

        cC = running.add(aA,bB);//{"A","B","C","a","b","c"}

        running.create(cC);//{"A","B","C","a","b","c"}

        running.add("D",3);//{"A","B","C","D","a","b","c"}

        running.add("d");//{"A","B","C","D","a","b","c","d"}

        running.add(aA);//{"A","B","C","D","a","b","c","d","A","B","C"}

        running.delete(3);//{"A","B","C","a","b","c","d","A","B","C"}

        running.delete(7);//{"A","B","C","a","b","c","A","B","C"}

        running.delete();//{"A","B","C","a","b","c","A","B"}

        running.delete();//{"A","B","C","a","b","c","A"}

        running.delete();//{"A","B","C","a","b","c"}

        running.changeString("E",2);//{"A","B","E","a","b","c"}

        System.out.println(running.contains("E"));//print true

        System.out.println(running.contains("C"));//print false

        System.out.println(running.getLength());//print 6

        System.out.println(running.get(2));//print E

        running.clear();//{}

        running.createNew();//{}
    }
}
