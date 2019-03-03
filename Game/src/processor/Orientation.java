
package processor;

import java.util.*;

 /**
     * enum orientation
     */

public enum Orientation {

    NORTH(0), SOUTH(1), EAST(2), WEST(3);
 
    public static Map<Integer, Orientation> map = new HashMap<Integer, Orientation>();

    static {
        for (Orientation orientationEnum : Orientation.values()) {
            map.put(orientationEnum.directionIndex, orientationEnum);
        }
    }

    private int directionIndex;

    private Orientation(int orientation) {
        this.directionIndex = orientation;
    }

    public static Orientation valueOf(int orientationNum) {
        return map.get(orientationNum);
    }
    
    /**
     * return the left rotate or right rotate
     */
    
    private Orientation rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ?
                map.size() - 1 : (this.directionIndex + step) % map.size();
        return Orientation.valueOf(newIndex);
    }
    
    /**
     * Left rotate
     */
    public Orientation leftOrientation() {
        return rotate(-1);
    }

   /**
     * Right rotate
     */
    public Orientation rightOrientation() {
        return rotate(1);
    }



}

