package com.app.generateReports;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScriptRecordingTest {
	
    private static ATUTestRecorder recorder;
    private static String dirPath = System.getProperty("user.dir");

    
    public static void startRecording() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();

        //create an object of ATUTestRecorder class and pass 3 parameters explained above.
        recorder = new ATUTestRecorder(dirPath+"/videos/","Script_Video_" + dateFormat.format(date), false);

        //To start video recording.
        recorder.start();
    }

    
    
    public static void stopRecording() throws ATUTestRecorderException {
        //Stop the recording
        recorder.stop();
    }
 


}