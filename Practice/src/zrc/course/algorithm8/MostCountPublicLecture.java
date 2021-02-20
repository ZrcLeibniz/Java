package zrc.course.algorithm8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MostCountPublicLecture {
    private class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(Lecture[] issue, int timePoint) {
        Arrays.sort(issue, new LectureComparator());
        int result = 0;
        for (Lecture lecture : issue) {
            if (lecture.start >= timePoint) {
                result++;
                timePoint = lecture.end;
            }
        }
        return result;
    }

    private class LectureComparator implements Comparator<Lecture> {
        @Override
        public int compare(Lecture o1, Lecture o2) {
            return o1.end - o2.end;
        }
    }
}
