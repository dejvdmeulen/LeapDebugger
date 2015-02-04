import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Pointable.Zone;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 * Created by Bill Gates on 17/01/14.
 */
public class DebugGUI extends JFrame {

    private JPanel LeapDebugger;

    private JTabbedPane tabbedPane1;

    /*****************************************************************************************************************
     **************************************** Basic Panel  **********************************************************
     *****************************************************************************************************************/
    private JPanel framePanel,handPanel,gesturesPanel,circlePanel,swipePanel,tapPanel,KeyTapPanel,
            basicIBBoxDimensions_Panel,basicIBBox_Panel, basicIBBoxCentre_Panel;
    private JTextField frameID_TF,timeHands_TF,frameHands_TF,
            frameFingers_TF,frameTools_TF,frameGestures_TF;
    private JTextField handFingers_TF,handTips_TF,handPalm_TF,
            handPalmIB_TF,handRadius_TF,handTouchTF,
            handPitch_TF,handYaw_TF,handRoll_TF;
    private JTextField circleID_TF,circleDir_TF,circleProgess_TF,
            circleRadius_TF,circleAngle_TF,circleState_TF;
    private JTextField swipeID_TF,swipePosn_TF,swipeDir_TF,
            swipeSpeed_TF,swipeState_TF;
    private JTextField tapID_TF,tapPosn_TF,tapDir_TF,
            tapState_TF,tapFingerID_TF;
    private JTextField keyTapID_TF,keyTapPosn_TF,keyTapDir_TF,
            keyTapState_TF,keyTapFingerID_TF;

    private JTextField basicIBBoxDimensions_W_TF, basicIBBoxDimensions_H_TF, basicIBBoxDimensions_D_TF;
    private JTextField basicIBBoxCentre_X_TF,basicIBBoxCentre_Y_TF,basicIBBoxCentre_Z_TF;
    private JCheckBox basicIBBoxValid_CB;

    private JCheckBox circle_CB,swipe_CB,tap_CB,keyTap_CB;

    /*****************************************************************************************************************
     **************************************** Finger Panel  **********************************************************
     *****************************************************************************************************************/
    private JPanel finger0Panel;
    private JTextField finger0ID_TF,finger0Length_TF,finger0Width_TF,finger0TipPos_TF,finger0StabTipPos_TF,
            finger0Dir_TF,finger0TouchDis_TF,finger0TouchZone_TF;
    private JCheckBox finger0Tool_CB,finger0Finger_CB,finger0Valid_CB;

    private JPanel finger1Panel;
    private JTextField finger1ID_TF,finger1Length_TF,finger1Width_TF,finger1TipPos_TF,finger1StabTipPos_TF,
            finger1Dir_TF,finger1TouchDis_TF,finger1TouchZone_TF;
    private JCheckBox finger1Valid_CB,finger1Tool_CB,finger1Finger_CB;

    private JPanel finger2Panel;
    private JCheckBox finger2Valid_CB,finger2Tool_CB,finger2Finger_CB;
    private JTextField finger2ID_TF,finger2Length_TF,finger2Width_TF,finger2TipPos_TF,finger2StabTipPos_TF,
            finger2Dir_TF,finger2TouchDis_TF, finger2TouchZone_TF;

    private JPanel finger3Panel;
    private JCheckBox finger3Valid_CB,finger3Tool_CB,finger3Finger_CB;
    private JTextField finger3ID_TF,finger3Length_TF,finger3Width_TF,finger3TipPos_TF,finger3StabTipPos_TF,
            finger3Dir_TF,finger3TouchDis_TF,finger3TouchZone_TF;


    private JPanel finger4Panel;
    private JCheckBox finger4Finger_CB, finger4Valid_CB, finger4Tool_CB;
    private JTextField finger4ID_TF,finger4Length_TF,finger4Width_TF,finger4TipPos_TF,finger4StabTipPos_TF,
            finger4Dir_TF,finger4TouchDis_TF, finger4TouchZone_TF;


    private JPanel finger5Panel;
    private JCheckBox finger5Finger_CB, finger5Valid_CB, finger5Tool_CB;
    private JTextField finger5ID_TF,finger5Length_TF,finger5Width_TF,finger5TipPos_TF,finger5StabTipPos_TF,
            finger5Dir_TF,finger5TouchDis_TF, finger5TouchZone_TF;


    private JPanel finger6Panel;
    private JCheckBox finger6Finger_CB, finger6Valid_CB, finger6Tool_CB;
    private JTextField finger6ID_TF,finger6Length_TF,finger6Width_TF,finger6TipPos_TF,finger6StabTipPos_TF,
            finger6Dir_TF,finger6TouchDis_TF, finger6TouchZone_TF;

    private JPanel finger7Panel;
    private JCheckBox finger7Finger_CB, finger7Valid_CB, finger7Tool_CB;
    private JTextField finger7ID_TF,finger7Length_TF,finger7Width_TF,finger7TipPos_TF,finger7StabTipPos_TF,
            finger7Dir_TF,finger7TouchDis_TF, finger7TouchZone_TF;

    private JPanel finger8Panel;
    private JCheckBox finger8Finger_CB, finger8Valid_CB, finger8Tool_CB;
    private JTextField finger8ID_TF,finger8Length_TF,finger8Width_TF,finger8TipPos_TF,finger8StabTipPos_TF,
            finger8Dir_TF,finger8TouchDis_TF, finger8TouchZone_TF;

    private JPanel finger9Panel;
    private JCheckBox finger9Finger_CB, finger9Valid_CB, finger9Tool_CB;
    private JTextField finger9ID_TF,finger9Length_TF,finger9Width_TF,finger9TipPos_TF,finger9StabTipPos_TF,
            finger9Dir_TF,finger9TouchDis_TF, finger9TouchZone_TF;


    /*****************************************************************************************************************
     **************************************** Frame Panel  **********************************************************
     *****************************************************************************************************************/

    private JPanel detailedFrameInfo;
    private JCheckBox frameIBBox_Valid_CB;
    private JTextField detailedFrameInfo_ID_TF,detailedFrameInfo_TimeStamp_TF,detailedFrameInfo_NoHands_TF,
            detailedFrameInfo_NoFIngers,detailedFrameInfo_NoTools_TF,detailedFrameInfo_NoGestures_TF,
            detailedFrameInfo_FPS_TF;

    private JPanel frameScaling_Panel;
    private JTextField frameScaling_Prob_TF,frameScaling_Factor_TF;


    private JPanel frameTranslation_Panel;
    private JTextField frameTranslation_X_TF,frameTranslation_Y_TF,frameTranslation_Z_TF,frameTranslation_Prob_TF;


    private JPanel frameRotation_Panel;

    private JPanel frameRotationAxis_Panel;
    private JTextField frameRotationAxis_X_TF,frameRotationAxis_Y_TF,frameRotationAxis_Z_TF;

    private JPanel frameRotationAngleDeg_Panel;
    private JTextField frameRotationAngleDeg_X_TF,frameRotationAngleDeg_Y_TF,frameRotationAngleDeg_Z_TF,
            frameRotationAngleDeg_Prob_TF;

    private JPanel frameRotationAngleRad_Panel;
    private JTextField frameRotationAngleRad_X_TF;
    private JTextField frameRotationAngleRad_Y_TF;
    private JTextField frameRotationAngleRad_Z_TF;
    private JTextField frameRotationAngleRad_Prob_TF;

    private JPanel frameIBBox_Panel;
    private JPanel frameIBBoxDimensions_Panel;
    private JTextField frameIBBox_H_TF,frameIBBox_W_TF,frameIBBox_D_TF;
    private JPanel frameIBBoxCentre_Panel;
    private JTextField frameIBBox_X_TF,frameIBBox_Y_TF,frameIBBox_Z_TF;

    /*****************************************************************************************************************
     **************************************** Hand Panel  **********************************************************
     *****************************************************************************************************************/

    private JPanel hand0_Panel;
    private JPanel hand0Basic_Panel;
    private JTextField hand0Basic_NoFingers_TF,hand0Basic_Touching_TF,hand0Basic_Pitch_TF,hand0Basic_Yaw_TF,
            hand0Basic_Roll_TF;
    private JPanel hand0Rotation_Panel;
    private JPanel hand0RotationAxis_Panel;
    private JTextField hand0RotationAxis_X_TF,hand0RotationAxis_Y_TF,hand0RotationAxis_Z_TF;
    private JPanel hand0RotationAngleRad_Panel;
    private JTextField hand0RotationAngleRad_X_TF,hand0RotationAngleRad_Y_TF,hand0RotationAngleRad_Z_TF,
            hand0RotationAngleRad_Prob_TF;
    private JPanel hand0RotationAngleDeg_Panel;
    private JTextField hand0RotationAngleDeg_X_TF,hand0RotationAngleDeg_Y_TF,hand0RotationAngleDeg_Z_TF,
            hand0RotationAngleDeg_Prob_TF;
    private JPanel hand0Translation_Panel;
    private JTextField hand0Translation_X_TF,hand0Translation_Y_TF,hand0Translation_Z_TF,hand0Translation_Prob_TF;
    private JPanel hand0Sphere_Panel;
    private JTextField hand0Sphere_X_TF,hand0Sphere_Y_TF,hand0Sphere_Z_TF,hand0Sphere_Radius_TF;

    /***********************************/
    private JPanel hand1_Panel;
    private JPanel hand1Basic_Panel;
    private JTextField hand1Basic_NoFingers_TF,hand1Basic_Touching_TF,hand1Basic_Pitch_TF,hand1Basic_Yaw_TF,
            hand1Basic_Roll_TF;
    private JPanel hand1Rotation_Panel;
    private JPanel hand1RotationAxis_Panel;
    private JTextField hand1RotationAxis_X_TF,hand1RotationAxis_Y_TF,hand1RotationAxis_Z_TF;
    private JPanel hand1RotationAngleRad_Panel;
    private JTextField hand1RotationAngleRad_X_TF,hand1RotationAngleRad_Y_TF,hand1RotationAngleRad_Z_TF,
            hand1RotationAngleRad_Prob_TF;
    private JPanel hand1RotationAngleDeg_Panel;
    private JTextField hand1RotationAngleDeg_X_TF,hand1RotationAngleDeg_Y_TF,hand1RotationAngleDeg_Z_TF,
            hand1RotationAngleDeg_Prob_TF;
    private JPanel hand1Translation_Panel;
    private JTextField hand1Translation_X_TF,hand1Translation_Y_TF,hand1Translation_Z_TF,hand1Translation_Prob_TF;
    private JPanel hand1Sphere_Panel;
    private JTextField hand1Sphere_X_TF,hand1Sphere_Y_TF,hand1Sphere_Z_TF,hand1Sphere_Radius_TF;




    /*****************************************************************************************************************
     **************************************** Gestures Panel  **********************************************************
     *****************************************************************************************************************/
    private JPanel gesturesCircle_Panel;
    private JCheckBox gesturesCircle_Valid_CB;
    private JTextField gesturesCircle_ID_TF,gesturesCircle_FingerID_TF,gesturesCircle_NoCircuits_TF,
            gesturesCircle_Radius_TF,gesturesCircle_Angle_TF,gesturesCircle_State_TF;
    private JPanel gesturesCircleDirection_Panel;
    private JTextField gesturesCircleDirection_X_TF,gesturesCircleDirection_Y_TF,gesturesCircleDirection_Z_TF;
    private JPanel gesturesCircleNormal_Panel;
    private JTextField gesturesCircleNormal_X_TF,gesturesCircleNormal_Y_TF,gesturesCircleNormal_Z_TF;
    private JPanel gesturesCircleDuration_Panel;
    private JTextField gesturesCircleDuration_US_TF;
    private JTextField gesturesCircleDuration_S_TF;

    private JPanel gesturesSwipe_Panel;
    private JCheckBox gesturesSwipe_Valid_CB;
    private JTextField gesturesSwipe_ID_TF,gesturesSwipe_FingerID_TF,gesturesSwipe_Speed_TF,gesturesSwipe_State_TF;
    private JPanel gesturesSwipeDirection_Panel;
    private JTextField gesturesSwipeDirection_X_TF,gesturesSwipeDirection_Y_TF,gesturesSwipeDirection_Z_TF;
    private JPanel gesturesSwipeNormal_Panel;
    private JTextField gesturesSwipeNormal_X_TF,gesturesSwipeNormal_Y_TF,gesturesSwipeNormal_Z_TF;
    private JPanel gesturesSwipeDuration_Panel;
    private JTextField gesturesSwipeDuration_US_TF,gesturesSwipeDuration_S_TF;

    private JPanel gesturesScreenTap_Panel;
    private JCheckBox gesturesScreenTap_Valid_CB;
    private JTextField gesturesScreenTap_ID_TF,gesturesScreenTap_FingerID_TF,gesturesScreenTap_State_TF;
    private JPanel gesturesScreenTapDirection_Panel;
    private JTextField gesturesScreenTapDirection_X_TF,gesturesScreenTapDirection_Y_TF,gesturesScreenTapDirection_Z_TF;
    private JPanel gesturesScreenTapNormal_Panel;
    private JTextField gesturesScreenTapNormal_X_TF,gesturesScreenTapNormal_Y_TF,gesturesScreenTapNormal_Z_TF;
    private JPanel gesturesScreenTapDuration_Panel;
    private JTextField gesturesScreenTapDuration_US_TF,gesturesScreenTapDuration_S_TF;

    private JPanel gesturesKeyTap_Panel;
    private JCheckBox gesturesKeyTap_Valid_CB;
    private JTextField gesturesKeyTap_ID_TF,gesturesKeyTap_FingerID_TF,gesturesKeyTap_State_TF;
    private JPanel gesturesKeyTapDirection_Panel;
    private JTextField gesturesKeyTapDirection_X_TF,gesturesKeyTapDirection_Y_TF,gesturesKeyTapDirection_Z_TF;
    private JPanel gesturesKeyTapNormal_Panel;
    private JTextField gesturesKeyTapNormal_X_TF,gesturesKeyTapNormal_Y_TF,gesturesKeyTapNormal_Z_TF;
    private JPanel gesturesKeyTapDuration_Panel;
    private JTextField gesturesKeyTapDuration_US_TF,gesturesKeyTapDuration_S_TF;


    private LeapMotionListener listener;
    private Controller controller;

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public DebugGUI() {
        super("Leap Motion Controller Debugger");
        this.add(LeapDebugger);
        //setContentPane(LeapDebugger);
        // Create listener and controller
        listener = new LeapMotionListener(this);
        controller = new Controller();
        controller.addListener(listener);

        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            { controller.removeListener(listener);    // Remove the sample listener when done
                System.exit(0);
            }
        });
        pack();

        setVisible(true);

        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e) {}

        if (!controller.isConnected()) {
            System.out.println("Cannot connect to Leap");
            System.exit(1);
        }

    }


    /**
 * Setters
 * Clear()
 * setFrameDAta
 * setHandInfo
 * setCircleInfo
 * setSwipeInfo
 * setTapInfo
 * setKeyTapInfi
 */


    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.

     */
    public void clear()
    {
        //Clear all the frame data fields
        frameID_TF.setText("");
        timeHands_TF.setText("");
        frameHands_TF.setText("");
        frameFingers_TF.setText("");
        frameTools_TF.setText("");
        frameGestures_TF.setText("");

        //Clear all the Hand data Fields
        handFingers_TF.setText("");
        handTips_TF.setText("");
        handRadius_TF.setText("");
        handPalm_TF.setText("");
        handPalmIB_TF.setText("");
        handPitch_TF.setText("");
        handRoll_TF.setText("");
        handYaw_TF.setText("");
        handTouchTF.setText("");

        //Clear all the Circle gesture data fields
        circle_CB.setSelected(false);
        circleDir_TF.setText("");
        circleID_TF.setText("");
        circleProgess_TF.setText("");
        circleRadius_TF.setText("");
        circleAngle_TF.setText("");
        circleState_TF.setText("");

        //Clear all the swipe gesture data Fields
        swipe_CB.setSelected(false);
        swipeID_TF.setText("");
        swipePosn_TF.setText("");
        swipeDir_TF.setText("");
        swipeState_TF.setText("");
        swipeSpeed_TF.setText("");

        //Clear all the Tap gesture data fields
        tap_CB.setSelected(false);
        tapID_TF.setText("");
        tapPosn_TF.setText("");
        tapDir_TF.setText("");
        tapState_TF.setText("");
        tapFingerID_TF.setText("");

        //CLear all the Key Tap Gesture Data fields
        keyTap_CB.setSelected(false);
        keyTapID_TF.setText("");
        keyTapPosn_TF.setText("");
        keyTapDir_TF.setText("");
        keyTapState_TF.setText("");
        keyTapFingerID_TF.setText("");
    }


    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
      */
    public void setFrameInfo(long id, long timestamp, int hCount, int fCount,
                             int tCount, int gCount)
    {
        frameID_TF.setText(""+id);
        timeHands_TF.setText(""+timestamp);
        frameHands_TF.setText(""+hCount);
        frameFingers_TF.setText(""+fCount);
        frameTools_TF.setText(""+tCount);
        frameGestures_TF.setText(""+gCount);
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void setHandInfo(int fCount, Vector tipsPos, float sphRadius,
                            Vector palmPos, Vector palmPosIB,
                            int pitch, int roll, int yaw, boolean isTouching)
    {
        handFingers_TF.setText(""+fCount);
        handTips_TF.setText(""+tipsPos);
        handRadius_TF.setText(""+sphRadius);
        handPalm_TF.setText(""+palmPos);
        handPalmIB_TF.setText(""+palmPosIB);
        handPitch_TF.setText(""+pitch);
        handRoll_TF.setText(""+roll);
        handYaw_TF.setText(""+yaw);
        String touching = (isTouching) ? "yes" : "";
        handTouchTF.setText(touching);
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void setCircleInfo(long id, State state, boolean isClockwise, float progress,
                              float radius, int angle)
    {
        circle_CB.setSelected(true);
        circleID_TF.setText(""+id);
        String dir = (isClockwise) ? "CW" : "CCW";
        circleDir_TF.setText(dir);
        circleProgess_TF.setText(""+progress);
        circleRadius_TF.setText(""+radius);
        circleAngle_TF.setText(""+angle);
        circleState_TF.setText(""+state);
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
       */
    public void setSwipeInfo(long id, State state, Vector posn, Vector dir, float speed)
    {
        swipe_CB.setSelected(true);
        swipeID_TF.setText(""+id);
        swipePosn_TF.setText(""+posn);
        swipeDir_TF.setText(""+dir);
        swipeState_TF.setText(""+state);
        swipeSpeed_TF.setText(""+speed);
    }

    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
      */
    public void setTapInfo(long id, State state, Vector posn, Vector dir, int fID)
    {
        tap_CB.setSelected(true);
        tapID_TF.setText(""+id);
        tapPosn_TF.setText(""+posn);
        tapDir_TF.setText(""+dir);
        tapState_TF.setText(""+state);
        tapFingerID_TF.setText(""+fID);
        //System.out.println("Screen tap(" + fID + "): " + dir + " / " + state);
     }


    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
       */
    public void setKeyTapInfo(long id, State state, Vector posn, Vector dir, int fID)
    {
        keyTap_CB.setSelected(true);
        keyTapID_TF.setText(""+id);
        keyTapPosn_TF.setText(""+posn);
        keyTapDir_TF.setText(""+dir);
        keyTapState_TF.setText(""+state);
        keyTapFingerID_TF.setText(""+fID);
        //System.out.println("Key tap(" + fID + "): " + dir + " / " + state);

    }


    public void setIBBoxInfo(Frame frame){
        basicIBBoxDimensions_W_TF.setText(""+frame.interactionBox().width());
        basicIBBoxDimensions_H_TF.setText(""+frame.interactionBox().height());
        basicIBBoxDimensions_D_TF.setText(""+frame.interactionBox().depth());
        basicIBBoxCentre_X_TF.setText(""+frame.interactionBox().center().getX());
        basicIBBoxCentre_Y_TF.setText(""+frame.interactionBox().center().getY());
        basicIBBoxCentre_Z_TF.setText(""+frame.interactionBox().center().getZ());
        basicIBBoxValid_CB.setText(""+frame.interactionBox().isValid());


    }
    private static final double PI = 3.14159265359;
    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
    */
    public void setDetailedFrameInfo( Frame frame, Frame previousFrame)
    {
        frameIBBox_Valid_CB.setSelected(frame.interactionBox().isValid());
        detailedFrameInfo_ID_TF.setText("" + frame.id());
        detailedFrameInfo_TimeStamp_TF.setText("" + frame.timestamp());
        detailedFrameInfo_NoHands_TF.setText(""+frame.hands().count());
        detailedFrameInfo_NoFIngers.setText(""+frame.fingers().count());
        detailedFrameInfo_NoTools_TF.setText(""+frame.tools().count());
        detailedFrameInfo_NoGestures_TF.setText(""+frame.gestures().count());
        detailedFrameInfo_FPS_TF.setText(""+frame.currentFramesPerSecond());
        frameScaling_Prob_TF.setText(""+frame.scaleProbability(previousFrame));
        frameScaling_Factor_TF.setText(""+frame.scaleFactor(previousFrame));
        frameTranslation_X_TF.setText(""+frame.translation(previousFrame).getX());
        frameTranslation_Y_TF.setText(""+frame.translation(previousFrame).getY());
        frameTranslation_Z_TF.setText(""+frame.translation(previousFrame).getZ());
        frameTranslation_Prob_TF.setText(""+frame.translationProbability(previousFrame));
        frameRotationAxis_X_TF.setText(""+frame.rotationAxis(previousFrame).getX());
        frameRotationAxis_Y_TF.setText(""+frame.rotationAxis(previousFrame).getY());
        frameRotationAxis_Z_TF.setText(""+frame.rotationAxis(previousFrame).getZ());
        frameRotationAngleDeg_X_TF.setText("" + frame.rotationAngle(previousFrame )*(180/PI));
        frameRotationAngleDeg_Y_TF.setText("" + frame.rotationAngle(previousFrame )*(180/PI));
        frameRotationAngleDeg_Z_TF.setText("" + frame.rotationAngle(previousFrame )*(180/PI));
        frameRotationAngleDeg_Prob_TF.setText("" + frame.rotationProbability(previousFrame));
        frameRotationAngleRad_X_TF.setText("" + frame.rotationAngle(previousFrame ));
        frameRotationAngleRad_Y_TF.setText("" + frame.rotationAngle(previousFrame ));
        frameRotationAngleRad_Z_TF.setText("" + frame.rotationAngle(previousFrame ));
        frameRotationAngleRad_Prob_TF.setText("" + frame.rotationProbability(previousFrame));
        frameIBBox_H_TF.setText(""+frame.interactionBox().height());
        frameIBBox_W_TF.setText(""+frame.interactionBox().width());
        frameIBBox_D_TF.setText(""+frame.interactionBox().depth());
        frameIBBox_X_TF.setText(""+frame.interactionBox().center().getX());
        frameIBBox_Y_TF.setText(""+frame.interactionBox().center().getY());
        frameIBBox_Z_TF.setText(""+frame.interactionBox().center().getZ());

    }

    public void setHandsInfo(Hand hand0, Hand hand1, Frame prevFrame){

        hand0Basic_NoFingers_TF.setText(""+hand0.fingers().count());
        hand0Basic_Touching_TF.setText("");
        hand0Basic_Pitch_TF.setText(""+hand0.direction().getX());
        hand0Basic_Yaw_TF.setText("" + hand0.direction().getY());
        hand0Basic_Roll_TF.setText(""+hand0.direction().getZ());

        hand0RotationAxis_X_TF.setText(""+hand0.rotationAxis(prevFrame).getX());
        hand0RotationAxis_Y_TF.setText(""+hand0.rotationAxis(prevFrame).getY());
        hand0RotationAxis_Z_TF.setText(""+hand0.rotationAxis(prevFrame).getZ());

       hand0RotationAngleRad_X_TF.setText(""+hand0.rotationAngle(prevFrame));
       hand0RotationAngleRad_Y_TF.setText(""+hand0.rotationAngle(prevFrame));
       hand0RotationAngleRad_Z_TF.setText(""+hand0.rotationAngle(prevFrame));
       hand0RotationAngleRad_Prob_TF.setText(""+hand0.rotationProbability(prevFrame));

        hand0RotationAngleDeg_X_TF.setText(""+hand0.rotationAngle(prevFrame)*(180/PI));
        hand0RotationAngleDeg_Y_TF.setText(""+hand0.rotationAngle(prevFrame)*(180/PI));
        hand0RotationAngleDeg_Z_TF.setText(""+hand0.rotationAngle(prevFrame)*(180/PI));
        hand0RotationAngleDeg_Prob_TF.setText(""+hand0.rotationProbability(prevFrame));

        hand0Translation_X_TF.setText(""+hand0.translation(prevFrame).getX());
        hand0Translation_Y_TF.setText(""+hand0.translation(prevFrame).getY());
        hand0Translation_Z_TF.setText(""+hand0.translation(prevFrame).getZ());
        hand0Translation_Prob_TF.setText(""+hand0.translationProbability(prevFrame));
        hand0Sphere_X_TF.setText(""+hand0.sphereCenter().getX());
        hand0Sphere_Y_TF.setText(""+hand0.sphereCenter().getY());
        hand0Sphere_Z_TF.setText(""+hand0.sphereCenter().getZ());
        hand0Sphere_Radius_TF.setText(""+hand0.sphereRadius());


        hand1Basic_NoFingers_TF.setText(""+hand1.fingers().count());
        hand1Basic_Touching_TF.setText("");
        hand1Basic_Pitch_TF.setText(""+hand1.direction().getX());
        hand1Basic_Yaw_TF.setText(""+hand1.direction().getY());
        hand1Basic_Roll_TF.setText(""+hand1.direction().getZ());

        hand1RotationAxis_X_TF.setText(""+hand1.rotationAxis(prevFrame).getX());
        hand1RotationAxis_Y_TF.setText(""+hand1.rotationAxis(prevFrame).getY());
        hand1RotationAxis_Z_TF.setText(""+hand1.rotationAxis(prevFrame).getZ());

        hand1RotationAngleRad_X_TF.setText(""+hand1.rotationAngle(prevFrame));
        hand1RotationAngleRad_Y_TF.setText(""+hand1.rotationAngle(prevFrame));
        hand1RotationAngleRad_Z_TF.setText(""+hand1.rotationAngle(prevFrame));
        hand1RotationAngleRad_Prob_TF.setText(""+hand1.rotationProbability(prevFrame));

        hand1RotationAngleDeg_X_TF.setText(""+hand1.rotationAngle(prevFrame)*(181/PI));
        hand1RotationAngleDeg_Y_TF.setText(""+hand1.rotationAngle(prevFrame)*(181/PI));
        hand1RotationAngleDeg_Z_TF.setText(""+hand1.rotationAngle(prevFrame)*(181/PI));
        hand1RotationAngleDeg_Prob_TF.setText(""+hand1.rotationProbability(prevFrame));

        hand1Translation_X_TF.setText(""+hand1.translation(prevFrame).getX());
        hand1Translation_Y_TF.setText(""+hand1.translation(prevFrame).getY());
        hand1Translation_Z_TF.setText(""+hand1.translation(prevFrame).getZ());
        hand1Translation_Prob_TF.setText(""+hand1.translationProbability(prevFrame));

        hand1Sphere_X_TF.setText(""+hand1.sphereCenter().getX());
        hand1Sphere_Y_TF.setText(""+hand1.sphereCenter().getY());
        hand1Sphere_Z_TF.setText(""+hand1.sphereCenter().getZ());
        hand1Sphere_Radius_TF.setText(""+hand1.sphereRadius());
    }
    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
      */
    public void setFinger0Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                              boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger0ID_TF.setText(""+ id);
        finger0Length_TF.setText(""+ lenght);
        finger0Width_TF.setText(""+ width);
        finger0TipPos_TF.setText(""+ tipPos);
        finger0StabTipPos_TF.setText(""+ stabTipPos);
        finger0Dir_TF.setText(""+ dir);
        finger0TouchDis_TF.setText(""+tDis);
        finger0TouchZone_TF.setText(""+tZone);
        finger0Tool_CB.setSelected(tool);
        finger0Finger_CB.setSelected(finger);
        finger0Valid_CB.setSelected(valid);
    }

    public void setFinger1Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger1ID_TF.setText(""+ id);
        finger1Length_TF.setText(""+ lenght);
        finger1Width_TF.setText(""+ width);
        finger1TipPos_TF.setText(""+ tipPos);
        finger1StabTipPos_TF.setText(""+ stabTipPos);
        finger1Dir_TF.setText(""+ dir);
        finger1TouchDis_TF.setText(""+tDis);
        finger1TouchZone_TF.setText(""+tZone);
        finger1Tool_CB.setSelected(tool);
        finger1Finger_CB.setSelected(finger);
        finger1Valid_CB.setSelected(valid);
    }


    public void setFinger2Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger2ID_TF.setText(""+ id);
        finger2Length_TF.setText(""+ lenght);
        finger2Width_TF.setText(""+ width);
        finger2TipPos_TF.setText(""+ tipPos);
        finger2StabTipPos_TF.setText(""+ stabTipPos);
        finger2Dir_TF.setText(""+ dir);
        finger2TouchDis_TF.setText(""+tDis);
        finger2TouchZone_TF.setText(""+tZone);
        finger2Tool_CB.setSelected(tool);
        finger2Finger_CB.setSelected(finger);
        finger2Valid_CB.setSelected(valid);
    }


    public void setFinger3Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger3ID_TF.setText(""+ id);
        finger3Length_TF.setText(""+ lenght);
        finger3Width_TF.setText(""+ width);
        finger3TipPos_TF.setText(""+ tipPos);
        finger3StabTipPos_TF.setText(""+ stabTipPos);
        finger3Dir_TF.setText(""+ dir);
        finger3TouchDis_TF.setText(""+tDis);
        finger3TouchZone_TF.setText(""+tZone);
        finger3Tool_CB.setSelected(tool);
        finger3Finger_CB.setSelected(finger);
        finger3Valid_CB.setSelected(valid);
    }


    public void setFinger4Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                                boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger4ID_TF.setText(""+ id);
        finger4Length_TF.setText(""+ lenght);
        finger4Width_TF.setText(""+ width);
        finger4TipPos_TF.setText(""+ tipPos);
        finger4StabTipPos_TF.setText(""+ stabTipPos);
        finger4Dir_TF.setText(""+ dir);
        finger4TouchDis_TF.setText(""+tDis);
        finger4TouchZone_TF.setText(""+tZone);
        finger4Tool_CB.setSelected(tool);
        finger4Finger_CB.setSelected(finger);
        finger4Valid_CB.setSelected(valid);
    }

    public void setFinger5Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger5ID_TF.setText(""+ id);
        finger5Length_TF.setText(""+ lenght);
        finger5Width_TF.setText(""+ width);
        finger5TipPos_TF.setText(""+ tipPos);
        finger5StabTipPos_TF.setText(""+ stabTipPos);
        finger5Dir_TF.setText(""+ dir);
        finger5TouchDis_TF.setText(""+tDis);
        finger5TouchZone_TF.setText(""+tZone);
        finger5Tool_CB.setSelected(tool);
        finger5Finger_CB.setSelected(finger);
        finger5Valid_CB.setSelected(valid);
    }

    public void setFinger6Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger6ID_TF.setText(""+ id);
        finger6Length_TF.setText(""+ lenght);
        finger6Width_TF.setText(""+ width);
        finger6TipPos_TF.setText(""+ tipPos);
        finger6StabTipPos_TF.setText(""+ stabTipPos);
        finger6Dir_TF.setText(""+ dir);
        finger6TouchDis_TF.setText(""+tDis);
        finger6TouchZone_TF.setText(""+tZone);
        finger6Tool_CB.setSelected(tool);
        finger6Finger_CB.setSelected(finger);
        finger6Valid_CB.setSelected(valid);
    }

    public void setFinger7Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger7ID_TF.setText(""+ id);
        finger7Length_TF.setText(""+ lenght);
        finger7Width_TF.setText(""+ width);
        finger7TipPos_TF.setText(""+ tipPos);
        finger7StabTipPos_TF.setText(""+ stabTipPos);
        finger7Dir_TF.setText(""+ dir);
        finger7TouchDis_TF.setText(""+tDis);
        finger7TouchZone_TF.setText(""+tZone);
        finger7Tool_CB.setSelected(tool);
        finger7Finger_CB.setSelected(finger);
        finger7Valid_CB.setSelected(valid);
    }

    public void setFinger8Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger8ID_TF.setText(""+ id);
        finger8Length_TF.setText(""+ lenght);
        finger8Width_TF.setText(""+ width);
        finger8TipPos_TF.setText(""+ tipPos);
        finger8StabTipPos_TF.setText(""+ stabTipPos);
        finger8Dir_TF.setText(""+ dir);
        finger8TouchDis_TF.setText(""+tDis);
        finger8TouchZone_TF.setText(""+tZone);
        finger8Tool_CB.setSelected(tool);
        finger8Finger_CB.setSelected(finger);
        finger8Valid_CB.setSelected(valid);
    }

    public void setFinger9Info(int id,  float lenght, float width,  Vector tipPos, Vector stabTipPos, Vector dir,
                               boolean finger, boolean tool, boolean valid, float tDis, Zone tZone)
    {
        finger9ID_TF.setText(""+ id);
        finger9Length_TF.setText(""+ lenght);
        finger9Width_TF.setText(""+ width);
        finger9TipPos_TF.setText(""+ tipPos);
        finger9StabTipPos_TF.setText(""+ stabTipPos);
        finger9Dir_TF.setText(""+ dir);
        finger9TouchDis_TF.setText(""+tDis);
        finger9TouchZone_TF.setText(""+tZone);
        finger9Tool_CB.setSelected(tool);
        finger9Finger_CB.setSelected(finger);
        finger9Valid_CB.setSelected(valid);
    }


    public void setGesturesInfo(GestureList gestures){
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

                    gesturesCircle_Valid_CB.setSelected(circle.isValid());
                    gesturesCircle_ID_TF.setText(""+circle.id());
                    gesturesCircle_FingerID_TF.setText(""+circle.pointable().id());
                    gesturesCircle_NoCircuits_TF.setText(""+circle.progress());
                    gesturesCircle_Radius_TF.setText(""+circle.radius());
                    gesturesCircle_Angle_TF.setText(""+angle);
                    gesturesCircle_State_TF.setText(""+circle.state());

                    gesturesCircleDirection_X_TF.setText("");
                    gesturesCircleDirection_Y_TF.setText("");
                    gesturesCircleDirection_Z_TF.setText("");

                    gesturesCircleNormal_X_TF.setText(""+circle.normal().getX());
                    gesturesCircleNormal_Y_TF.setText(""+circle.normal().getY());
                    gesturesCircleNormal_Z_TF.setText(""+circle.normal().getZ());

                   gesturesCircleDuration_US_TF.setText(""+circle.duration());
                   gesturesCircleDuration_S_TF.setText(""+circle.durationSeconds());



                    break;

                case TYPE_SWIPE:
                    SwipeGesture swipe = new SwipeGesture(gesture);

                    gesturesSwipe_Valid_CB.setSelected(swipe.isValid());
                    gesturesSwipe_ID_TF.setText(""+swipe.id());
                    gesturesSwipe_FingerID_TF.setText(""+swipe.pointable().id());
                    gesturesSwipe_Speed_TF.setText(""+swipe.speed());
                    gesturesSwipe_State_TF.setText(""+swipe.state());

                    gesturesSwipeDirection_X_TF.setText(""+swipe.direction().getX());
                    gesturesSwipeDirection_Y_TF.setText(""+swipe.direction().getY());
                    gesturesSwipeDirection_Z_TF.setText(""+swipe.direction().getZ());

                    gesturesSwipeNormal_X_TF.setText(""+swipe.position().getX());
                    gesturesSwipeNormal_Y_TF.setText(""+swipe.position().getY());
                    gesturesSwipeNormal_Z_TF.setText(""+swipe.position().getZ());

                    gesturesSwipeDuration_US_TF.setText(""+swipe.duration());
                    gesturesSwipeDuration_S_TF.setText(""+swipe.durationSeconds());

                    break;

                case TYPE_SCREEN_TAP:
                    ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                    gesturesScreenTap_Valid_CB.setSelected(screenTap.isValid());
                    gesturesScreenTap_ID_TF.setText(""+screenTap.id());
                    gesturesScreenTap_FingerID_TF.setText(""+screenTap.pointable().id());
                    gesturesScreenTap_State_TF.setText(""+screenTap.state());

                    gesturesScreenTapDirection_X_TF.setText(""+screenTap.direction().getX());
                    gesturesScreenTapDirection_Y_TF.setText(""+screenTap.direction().getY());
                    gesturesScreenTapDirection_Z_TF.setText(""+screenTap.direction().getZ());

                    gesturesScreenTapNormal_X_TF.setText(""+screenTap.position().getX());
                    gesturesScreenTapNormal_Y_TF.setText(""+screenTap.position().getY());
                    gesturesScreenTapNormal_Z_TF.setText(""+screenTap.position().getZ());

                    gesturesScreenTapDuration_US_TF.setText(""+screenTap.duration());
                    gesturesScreenTapDuration_S_TF.setText(""+screenTap.durationSeconds());

                    break;

                case TYPE_KEY_TAP:
                    KeyTapGesture keyTap = new KeyTapGesture(gesture);

                    gesturesKeyTap_Valid_CB.setSelected(keyTap.isValid());
                    gesturesKeyTap_ID_TF.setText(""+keyTap.id());
                    gesturesKeyTap_FingerID_TF.setText(""+keyTap.pointable().id());
                    gesturesKeyTap_State_TF.setText(""+keyTap.state());

                    gesturesKeyTapDirection_X_TF.setText(""+keyTap.direction().getX());
                    gesturesKeyTapDirection_Y_TF.setText(""+keyTap.direction().getY());
                    gesturesKeyTapDirection_Z_TF.setText(""+keyTap.direction().getZ());

                    gesturesKeyTapNormal_X_TF.setText(""+keyTap.position().getX());
                    gesturesKeyTapNormal_Y_TF.setText(""+keyTap.position().getY());
                    gesturesKeyTapNormal_Z_TF.setText(""+keyTap.position().getZ());

                    gesturesKeyTapDuration_US_TF.setText(""+keyTap.duration());
                    gesturesKeyTapDuration_S_TF.setText(""+keyTap.durationSeconds());
                    break;
            }
            }
    }
    }

