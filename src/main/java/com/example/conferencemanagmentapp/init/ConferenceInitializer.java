package com.example.conferencemanagmentapp.init;

import com.example.conferencemanagmentapp.model.Conference;
import com.example.conferencemanagmentapp.model.ConferenceBreak;
import com.example.conferencemanagmentapp.model.Lecture;
import com.example.conferencemanagmentapp.model.LectureRoot;
import lombok.Data;
import lombok.Getter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
@Getter
public class ConferenceInitializer {
    public static final Conference CONFERENCE = generateConference();
    public static final List<Lecture> LECTURES = generateLectures();

    private static Conference generateConference(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");

        return new Conference(
                1L,
                LocalDateTime.parse("2021-01-06 10:00:00", dateTimeFormatter),
                LocalDateTime.parse("2021-01-06 15:45:00", dateTimeFormatter),
                generateLectures(),
                generateConferenceBreaks()
        );
    }

    private static List<Lecture> generateLectures(){
        List<Lecture> lectures = new ArrayList<>();

        lectures.add(
                new Lecture(
                        1,
                        LocalTime.of(10, 0),
                        LocalTime.of(11, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        lectures.add(
                new Lecture(
                        2,
                        LocalTime.of(12, 0),
                        LocalTime.of(13, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        lectures.add(
                new Lecture(
                        3,
                        LocalTime.of(14, 0),
                        LocalTime.of(15, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        return lectures;
    }

    private static Map<Integer, LectureRoot> generateThreeExampleLectureRoots(){
        Map<Integer, LectureRoot> lectureRoots = new TreeMap<>();

        lectureRoots.put(1, new LectureRoot("Backend Development"));
        lectureRoots.put(2, new LectureRoot("Frontend Development"));
        lectureRoots.put(3, new LectureRoot("Web Development"));

        return lectureRoots;
    }

    private static List<ConferenceBreak> generateConferenceBreaks(){
        List<ConferenceBreak> conferenceBreaks = new ArrayList<>();

        conferenceBreaks.add(
                new ConferenceBreak(
                        LocalTime.of(11, 45),
                        LocalTime.of(12, 0)
                )
        );

        conferenceBreaks.add(
                new ConferenceBreak(
                        LocalTime.of(13, 45),
                        LocalTime.of(14, 0)
                )
        );

        return conferenceBreaks;
    }
}
