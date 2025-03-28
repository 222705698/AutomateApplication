package za.ac.cput.Factory;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.LearnersTest;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Util.Helper;

public class LearnersTestFactory {
    public static LearnersTest createLearnersTestFactory(String testScore, TestAppointment test) {
        String learnersTestID = Helper.gernerateId();
        if (Helper.isNullOrEmpty(learnersTestID))
            return null;

        return new LearnersTest.Builder()
                .setLearnersTestID(learnersTestID)
                .settestScore(testScore)
                .setTest(test)
                .build();


    }
}
