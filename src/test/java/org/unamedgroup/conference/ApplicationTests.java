package org.unamedgroup.conference;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.unamedgroup.conference.dao.ConferenceRepository;
import org.unamedgroup.conference.dao.ParticipantsRepository;
import org.unamedgroup.conference.feature.service.IDetectFaceService;

import java.io.FileNotFoundException;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    IDetectFaceService detectFaceService;
    @Autowired
    ParticipantsRepository participantsRepository;

    @Test
    public void contextLoads() throws ParseException {

    }
    @Test
    public void faceDetecture() throws FileNotFoundException {
//        File file = new File("E:\\IDEA\\zhoutao3.jpg");
//        //IDetectFaceService detectFaceService= new DetectFaceServiceImpl();
//        detectFaceService.addFaceFeature(file, 1);
//        double result = detectFaceService.compareFace(file,1);
//        System.out.println(result);
    }

    @Test
    public void test() {
//        Message.sendMessage("1");
    }
}
