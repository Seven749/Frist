package level4;

class GoGoGo{

    String[] create(String[] inPut){
        String[] strArrays = inPut;
        return strArrays;
    }

    String [] delete(String[] inPut,int index) {
        String[] strArrays = new String[inPut.length-1];
        for (int subscriptCopy = index;subscriptCopy < strArrays.length;subscriptCopy++) {
            strArrays[subscriptCopy] = inPut[subscriptCopy+1];
        }
        for (int subscriptCopy = 0;subscriptCopy < index;subscriptCopy++) {
            strArrays[subscriptCopy] = inPut[subscriptCopy];
        }
        return strArrays;
    }

    String[] deleteLast(String[] inPut) {
        String[] strArrays = new String[inPut.length-1];
        for (int i = 0;i < strArrays.length;i++)
            strArrays[i] = inPut[i];
        return strArrays;
    }

    String[] add(String[] inPut,String systemIn ,int index) {
        String[] strArrays = new String[inPut.length+1];
        for (int indexCopy = inPut.length;indexCopy > index;indexCopy--) {
            strArrays[indexCopy] = inPut[indexCopy-1];
        }
        strArrays[index] = systemIn;
        for (int indexCopy = 0;indexCopy<index;indexCopy++){
            strArrays[indexCopy] = inPut[indexCopy];
        }
        return strArrays;
    }

    String[] add(String[] inPut ,String systemIn) {
        String[] strArrays = new String[inPut.length+1];
        for (int index =0;index <= inPut.length;index++) {
            strArrays[index] = inPut[index];
        }
        strArrays[inPut.length+1] = systemIn;
        return strArrays;
    }

    String[] add(String[] frontArrays,String[] behindArrays) {
        String[] strArrays = new String[frontArrays.length+behindArrays.length];
        for (int i = 0;i < strArrays.length;i++) {
            if (i < frontArrays.length)
                strArrays[i] = frontArrays[i];
            if (i > frontArrays.length - 1)
                strArrays[i] = behindArrays[i - frontArrays.length];
        }
        return strArrays;
    }
    String[] clear(String[] inPut) {
        System.out.println("Clear is OK.");
        return new String[0];
    }

    String get(String[] inPut,int index) {
        return inPut[index];
    }

    String[] changeString(String[] inPut,String newStr,int index) {
        String[] strArrays = inPut;
        strArrays[index] = newStr;
        return strArrays;
    }

    Integer getLenth(String[] inPut) {
        return inPut.length;
    }

    boolean contains(String[] inPut,String object) {
        for (String a:inPut) {
            if (a.equals(object)) {
                return true;
            }
        }
        return false;
    }
}
public class level4 {
    public static void main(String[] args) {
        //例如
        String[] aA = {"A","B","C"},bB = {"a","b","c"},cC;
        GoGoGo running = new GoGoGo();
        cC = running.add(aA,bB);//{"A","B","C","a","b","c"}
        cC = running.changeString(cC,"D",1);//{"A","D","C","a","b","c"}
        cC = running.deleteLast(cC);//{"A","D","C","a","b"}
        aA = running.create(aA);//return {"A","B","C"}
        aA = running.add(aA, "D", 1);//return {"A","B","C","D"}
        aA = running.delete(aA,2);//{"A","D","B"}
        System.out.println(running.get(aA,1));//return "D"
        System.out.println(running.getLenth(aA));//return 3(aA.length)
        System.out.println(running.contains(aA,"B"));//return true;
        System.out.println(running.contains(aA,"C"));//return false;
        running.clear(aA);//return new String[0]
    }

}
