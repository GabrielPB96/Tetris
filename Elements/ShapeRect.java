package Elements;
import java.awt.Color;

public class ShapeRect extends Wall{
    public ShapeRect(int row_center, int column_center, Color color){
        super(4, row_center, column_center, color);
        createWall(row_center, column_center);
    }
    
    public ShapeRect(Position center, Color color){
        super(4, center, color);
        createWall(center.getRow(), center.getColumn());
    }
    
    public void createWall(int row_center, int column_center){
        blocks.add(new Block(row_center-2, column_center, color));
        blocks.add(new Block(row_center-1, column_center, color));
        blocks.add(new Block(row_center, column_center, color));
        blocks.add(new Block(row_center+1, column_center , color));
    }
    
    public Wall clone(){
        ShapeRect clone = new ShapeRect(center_position, color);
        clone.setBlocks(this.cloneBlocks());
        return clone;
    }
}
