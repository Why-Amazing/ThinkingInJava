package com.chapter_10_inner_class.Eg_10_4;

/**
 * 内部类与向上转型
 * Created by lazyo on 2018/2/4.
 */
class Parcel4 {
    /*
    private内部类给类的设计者提供了一种途径,通过这种方式可以完全阻止任何依赖于类型的编码,
    并且完全隐藏了实现的细节
     */
    private class PContents implements Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;

        public PDestination(String whereTo) {
            this.label = whereTo;
        }

        public String readLabel(){
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }
}

public class TestParcel{
    public static void main(String[] args){
        Parcel4 p4 = new Parcel4();
        Contents c = p4.contents();
        Destination d = p4.destination("Tasmania");
        Parcel4.PDestination pd = p4.new PDestination("whereTo");
        //Illegal  -- can't access private class
//        Parcel4.PContents pc = p4.new PContents();
    }
}
