package teamproject;

//@author Cody

public class SimpleVisit implements Visitor<Vertex>
{
    
    @Override
    public void visit(Vertex obj) {
        obj.visit();
    }
}