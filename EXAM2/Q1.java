public class Q1 extends Handicap{

    private int NumPractice;
    private int NumNonPractice;

    public Q1(Player p){
        super(p);
        this.NumPractice = 0;
        this.NumNonPractice = 0;
    }

    @Override public void add(Game g){
        if(g.isPractice()){
            this.NumPractice++;
        }
        else{
            this.NumNonPractice++;
            super.add(g)
        }
    }

    public int getNumPracticeGames(){
        return NumPractice;
    }

    public int getNumNonPracticeGames(){
        return NumNonPractice;
    }

    @Override public int getHandicap(){
        return super.getHandicap();
    }

}