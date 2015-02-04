/**
 * Created by Daniel on 17/01/14.
 */
import com.leapmotion.leap.*;

public class LeapMotionListener extends Listener {

    private boolean reportedBox = false;
    private DebugGUI viewer;
    LeapMotionAnalyser analyser = new LeapMotionAnalyser();

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public LeapMotionListener(DebugGUI v)
    {
        super();
        viewer = v;
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void onInit(Controller controller)
    {  System.out.println("Initialized"); }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    // listen for all gestures
    public void onConnect(Controller controller)
        {
        System.out.println("Controller has been connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        // to and fro linear movement of a finger tip/hand in any direction

        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        // clockwise rotation of a finger tip pointing at the screen

        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        // finger tip moves forward towards the screen, then back to the original postion;
        // the finger must pause briefly before beginning the tap

        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        // finger rotates down toward the palm, then back to the original postion;
        // the finger must pause briefly before beginning the tap

        Config config = controller.config();

        // key tap parameters
        config.setFloat("Gesture.KeyTap.MinDownVelocity", 30.0f);

        System.out.println("Key Tap MinDownVelocity: " +
                config.getFloat("Gesture.KeyTap.MinDownVelocity"));
        System.out.println("Key Tap HistorySeconds: " +
                config.getFloat("Gesture.KeyTap.HistorySeconds"));
        System.out.println("Key Tap MinDistance: " +
                config.getFloat("Gesture.KeyTap.MinDistance"));
        System.out.println();

        // screen tap parameters
        config.setFloat("Gesture.ScreenTap.MinForwardVelocity", 30.0f);
        config.setFloat("Gesture.ScreenTap.MinDistance", 1.0f);

        System.out.println("Screen Tap MinDownVelocity: " +
                config.getFloat("Gesture.ScreenTap.MinForwardVelocity"));
        System.out.println("Screen Tap HistorySeconds: " +
                config.getFloat("Gesture.ScreenTap.HistorySeconds"));
        System.out.println("Screen Tap MinDistance: " +
                config.getFloat("Gesture.ScreenTap.MinDistance"));
        System.out.println();
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void onDisconnect(Controller controller)
    {  System.out.println("Disconnected");  }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void onExit(Controller controller)
    {  System.out.println("Exited");  }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    // fired when a frame is received from the Leap controller
    public void onFrame(Controller controller)
    {
        viewer.clear();    // reset the GUI window

        // get the most recent frame
        Frame frame = controller.frame();
        Frame prevFrame = controller.frame(1);
        Hand hand0 = frame.hands().get(0);
        Hand hand1 = frame.hands().get(1);

        // report frame info to the GUI
        viewer.setFrameInfo(frame.id(), frame.timestamp(), frame.hands().count(),
                frame.fingers().count(), frame.tools().count(),
                frame.gestures().count());
        //System.out.println("Rotation Matrix:"+ frame.rotationMatrix(controller.frame(1)));
        //System.out.println("Rotation  Angle:" + frame.rotationAngle(controller.frame(1)));


        viewer.setDetailedFrameInfo(frame, prevFrame);
        viewer.setIBBoxInfo(frame);
        viewer.setHandsInfo(hand0, hand1, prevFrame);
        viewer.setGesturesInfo(frame.gestures());
        InteractionBox ib = frame.interactionBox();
        if (!reportedBox) {
            System.out.println("Interaction Box Info");
            System.out.println("  center: " + analyser.round1dp(ib.center()));
            System.out.println("  (x,y,z) dimensions: (" + analyser.round1dp(ib.width()) + ", " +
                    analyser.round1dp(ib.height()) + ", " + analyser.round1dp(ib.depth()) +")");
            reportedBox = true;
        }

        if (!frame.hands().isEmpty())
        {
            analyser.examineHand(viewer, frame.hands().get(0), ib);     // only examine the first hand
            analyser.examineFingers(viewer, frame.fingers());
        }
        analyser.examineGestures(viewer, frame.gestures(), controller);
    }
}
