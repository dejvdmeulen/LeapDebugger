/**
 * Created by Bill Gates on 17/01/14.
 */

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class LeapMotionAnalyser {
    //True for debugging
    boolean DEBUG = false;

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     * @param  url  an absolute URL giving the base location of the image
     * @param  name the location of the image, relative to the url argument
     * @return      the image at the specified URL
     * @see
     */
    /**
    public void examineFrame(DebugGUI viewer, Frame frame, Frame prevFrame)
    {
        viewer.setDetailedFrameInfo(frame, prevFrame );

    } **/

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
      */
    public void examineHand(DebugGUI viewer, Hand hand, InteractionBox ib)
    {
        int fCount = 0;
        Vector avgPos = Vector.zero();

        // check if the hand has any fingers
        FingerList fingers = hand.fingers();
        if(DEBUG){
            if(fingers.isEmpty()){System.out.println("No fingers present");}
        }

        if (!fingers.isEmpty()) {
            // Calculate the hand's average finger tip position
            fCount = fingers.count();
            if(DEBUG ){System.out.println("Number of fingers: "+ fCount);}
            for (Finger finger : fingers)
            {
                if(DEBUG){System.out.println(finger.toString());}
                avgPos = avgPos.plus(finger.tipPosition());
            }
            avgPos = avgPos.divide(fingers.count());
        }

    /* check if finger is deep within the touch zone, which
       ranges from 1 to -1 (-1 being nearer the screen) */
        boolean isTouched = false;
        Finger frontFinger = hand.fingers().frontmost();
        float touchDist = frontFinger.touchDistance();
        if (touchDist< -0.8f) {
            // System.out.println("Pressed: touch distance: " + touchDist);
            isTouched = true;
        }

        // get the hand's normal vector and direction
        Vector normal = hand.palmNormal();
        // a unit vector pointing orthogonally downwards relative to the palm
        Vector direction = hand.direction();
        // a unit vector pointing from the palm position to the fingers

        // calculate the hand's pitch, roll, and yaw angles
        int pitch = (int) Math.round( Math.toDegrees(direction.pitch()));
        int roll = (int) Math.round( Math.toDegrees(normal.roll()));
        int yaw = (int) Math.round( Math.toDegrees(direction.yaw()));

        // convert the palm to interaction box coordinates
        Vector palmIB = ib.normalizePoint(hand.palmPosition());

        // report hand info to the GUI
        viewer.setHandInfo(fCount, round1dp(avgPos), round1dp( hand.sphereRadius()),
                round1dp(hand.palmPosition()), round1dp(palmIB),
                pitch, roll, yaw, isTouched);

    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void examineFingers(DebugGUI viewer, FingerList fingers )
    {
        Finger finger0 = fingers.get(0);
        Finger finger1 = fingers.get(1);
        Finger finger2 = fingers.get(2);
        Finger finger3 = fingers.get(3);
        Finger finger4 = fingers.get(4);
        Finger finger5 = fingers.get(5);
        Finger finger6 = fingers.get(6);
        Finger finger7 = fingers.get(7);
        Finger finger8 = fingers.get(8);
        Finger finger9 = fingers.get(9);

        viewer.setFinger0Info(finger0.id(), round1dp(finger0.length()), round1dp(finger0.width()),round1dp(finger0.tipPosition()),
                round1dp(finger0.stabilizedTipPosition()),round1dp(finger0.direction()),finger0.isFinger(), finger0.isTool(),
                finger0.isValid(), round1dp(finger0.touchDistance()), finger0.touchZone() );

        viewer.setFinger1Info(finger1.id(), round1dp(finger1.length()), round1dp(finger1.width()),round1dp(finger1.tipPosition()),
                round1dp(finger1.stabilizedTipPosition()),round1dp(finger1.direction()),finger1.isFinger(), finger1.isTool(),
                finger1.isValid(), round1dp(finger1.touchDistance()), finger1.touchZone() );

        viewer.setFinger2Info(finger2.id(), round1dp(finger2.length()), round1dp(finger2.width()),round1dp(finger2.tipPosition()),
                round1dp(finger2.stabilizedTipPosition()),round1dp(finger2.direction()),finger2.isFinger(), finger2.isTool(),
                finger2.isValid(), round1dp(finger2.touchDistance()), finger2.touchZone() );

        viewer.setFinger3Info(finger3.id(), round1dp(finger3.length()), round1dp(finger3.width()),round1dp(finger3.tipPosition()),
                round1dp(finger3.stabilizedTipPosition()),round1dp(finger3.direction()),finger3.isFinger(), finger3.isTool(),
                finger3.isValid(), round1dp(finger3.touchDistance()), finger3.touchZone() );

        viewer.setFinger4Info(finger4.id(), round1dp(finger4.length()), round1dp(finger4.width()),round1dp(finger4.tipPosition()),
            round1dp(finger4.stabilizedTipPosition()),round1dp(finger4.direction()),finger4.isFinger(), finger4.isTool(),
            finger4.isValid(), round1dp(finger4.touchDistance()), finger4.touchZone() );

        viewer.setFinger5Info(finger5.id(), round1dp(finger5.length()), round1dp(finger5.width()),round1dp(finger5.tipPosition()),
                round1dp(finger5.stabilizedTipPosition()),round1dp(finger5.direction()),finger5.isFinger(), finger5.isTool(),
                finger5.isValid(), round1dp(finger5.touchDistance()), finger5.touchZone() );

        viewer.setFinger6Info(finger6.id(), round1dp(finger6.length()), round1dp(finger6.width()),round1dp(finger6.tipPosition()),
                round1dp(finger6.stabilizedTipPosition()),round1dp(finger6.direction()),finger6.isFinger(), finger6.isTool(),
                finger6.isValid(), round1dp(finger6.touchDistance()), finger6.touchZone() );

        viewer.setFinger7Info(finger7.id(), round1dp(finger7.length()), round1dp(finger7.width()),round1dp(finger7.tipPosition()),
                round1dp(finger7.stabilizedTipPosition()),round1dp(finger7.direction()),finger7.isFinger(), finger7.isTool(),
                finger7.isValid(), round1dp(finger7.touchDistance()), finger7.touchZone() );

        viewer.setFinger8Info(finger8.id(), round1dp(finger8.length()), round1dp(finger8.width()),round1dp(finger8.tipPosition()),
                round1dp(finger8.stabilizedTipPosition()),round1dp(finger8.direction()),finger8.isFinger(), finger8.isTool(),
                finger8.isValid(), round1dp(finger8.touchDistance()), finger8.touchZone() );

        viewer.setFinger9Info(finger9.id(), round1dp(finger9.length()), round1dp(finger9.width()),round1dp(finger9.tipPosition()),
                round1dp(finger9.stabilizedTipPosition()),round1dp(finger9.direction()),finger9.isFinger(), finger9.isTool(),
                finger9.isValid(), round1dp(finger9.touchDistance()), finger9.touchZone() );
    }
    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    // look through all the gestures, sending info to the GUI
    public void examineGestures(DebugGUI viewer, GestureList gestures, Controller controller)
    {
        int fID;
        for (Gesture gesture : gestures) {
            switch (gesture.type()) {
                case TYPE_CIRCLE:
                    CircleGesture circle = new CircleGesture(gesture);
                    // calculate clock direction using the angle between circle normal and pointable
                    boolean isClockwise =
                            (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/4);

                    // calculate angle swept since last frame
                    double sweptAngle = 0;
                    if (circle.state() != State.STATE_START) {
                        CircleGesture previousUpdate = new CircleGesture(controller.frame(1).gesture(circle.id()));
                        sweptAngle = (circle.progress() - previousUpdate.progress()) * 2 * Math.PI;
                    }

                    int angle = (int) Math.round(Math.toDegrees(sweptAngle));

                    viewer.setCircleInfo(circle.id(), circle.state(), isClockwise,
                            round1dp(circle.progress()), round1dp(circle.radius()), angle);

                    break;

                case TYPE_SWIPE:
                    SwipeGesture swipe = new SwipeGesture(gesture);

                    viewer.setSwipeInfo(swipe.id(), swipe.state(), round1dp(swipe.position()),
                            round1dp(swipe.direction()), round1dp(swipe.speed()));
                    break;

                case TYPE_SCREEN_TAP:
                    ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                    fID = screenTap.pointable().id();   // finger ID will stay the same across frames

                    viewer.setTapInfo(screenTap.id(), screenTap.state(), round1dp(screenTap.position()),
                            round1dp(screenTap.direction()), fID);
                    break;

                case TYPE_KEY_TAP:
                    KeyTapGesture keyTap = new KeyTapGesture(gesture);
                    fID = keyTap.pointable().id();   // finger ID will stay the same across frames
                    viewer.setKeyTapInfo(keyTap.id(), keyTap.state(), round1dp(keyTap.position()),
                     round1dp(keyTap.direction()), fID);
                    break;

                default:
                    System.out.println("Unknown gesture type.");
                    break;
            }
        }
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    // round the x,y,z values in a vector to 1 dp
    public Vector round1dp(Vector v)
    {
        v.setX( (float)Math.round(v.getX()*10)/10 );
        v.setY( (float)Math.round(v.getY()*10)/10 );
        v.setZ( (float)Math.round(v.getZ()*10)/10 );
        return v;
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public float round1dp(float f){
        return (float)Math.round(f*10)/10;
    }
}
