package org.lld.structuralPattern.flyweight.forest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeType{
    String name , color , texture;
    public TreeType (String name , String color , String texture){
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
    public void draw(int x , int y){
        System.out.println("Drawing tree [" + name + " " + color + " " + texture + "] at " + x + " " + y);
    }
}
class Tree{
    private TreeType treeType;
    int x;
    int y;
    public Tree(int x , int y, TreeType treeType){
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }
    public void draw(){
        treeType.draw(x,y);
    }
}

class TreeFactory{
    private static final Map<String,TreeType> treeTypes = new HashMap<>();
    public static TreeType getTreetypes(String name , String color , String texture){
        String key = "[" + name + "," + color + "," + texture + "]";
        if(!treeTypes.containsKey(key)){
            treeTypes.put(key , new TreeType(name,color,texture));
        }
        return treeTypes.get(key);
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();
    public void plantTree(int x, int y,String name,String color,String texture){
        TreeType type = TreeFactory.getTreetypes(name,color,texture);
        Tree tree = new Tree(x,y,type);
        trees.add(tree);
    }
    public void drawForest(){
        for(Tree tree : trees){
            tree.draw();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(0 , 0 , "Oak","Green","Rough");
        forest.plantTree(1,1,"Pine" , "Dark Green" , "Smooth");
        forest.plantTree(-1,2 , "Oak","Green","Rough");
        forest.drawForest();
    }
}
