package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.init.ConferenceInitializer;
import com.example.conferencemanagmentapp.model.Conference;
import com.example.conferencemanagmentapp.model.Lecture;
import com.example.conferencemanagmentapp.model.LectureRoot;
import com.example.conferencemanagmentapp.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ConferencesServiceImpl {
    public Conference getConference(){
        return ConferenceInitializer.CONFERENCE;
    }

    public Lecture getLectureById(int lectureId){
        return getConference().getLectures().get(lectureId - 1);
    }

    public LectureRoot getLectureRootByIdAndKey(int lectureId, int lectureRootKey){
        return getLectureById(lectureId).getLectureRoots().get(lectureRootKey);
    }

    public boolean isSpaceAvailable(LectureRoot lectureRoot){
        return lectureRoot.getFreeSpace() >= 1;
    }

    private void decreaseFreeSpace(LectureRoot lectureRoot) {
        if (isSpaceAvailable(lectureRoot)) {
            lectureRoot.setFreeSpace(lectureRoot.getFreeSpace() - 1);
        }
    }


    public void saveReservation(User user, int lectureId, int lectureRootKey) {
         getLectureRootByIdAndKey(lectureId, lectureRootKey).getUsers().add(user);
    }
}
