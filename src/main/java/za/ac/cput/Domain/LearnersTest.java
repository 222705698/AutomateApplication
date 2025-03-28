package za.ac.cput.Domain;
//Sinokholo Singazi 222705698
public class LearnersTest extends TestAppointment {
    private String learnersTestID;
    private String testScore;
    private TestAppointment test;

    public LearnersTest() {
    }
    private LearnersTest(Builder builder) {
        this.learnersTestID = builder.learnersTestID;
        this.testScore = builder.testScore;
        this.test = builder.test;
    }

    public String getLearnersTestID() {
        return learnersTestID;
    }

    public String gettestScore() {
        return testScore;
    }

    public TestAppointment getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "LearnersTest{" +
                "learnersTestID='" + learnersTestID + '\'' +
                ", testScore=" + testScore +
                ", test=" + test +
                '}';
    }

    public static class Builder {
        private String learnersTestID;
        private String testScore;
        private TestAppointment test;

        public Builder setLearnersTestID(String learnersTestID) {
            this.learnersTestID = learnersTestID;
            return this;
        }

        public Builder settestScore(String testScore) {
            this.testScore = testScore;
            return this;
        }

        public Builder setTest(TestAppointment test) {
            this.test = test;
            return this;
        }
        public LearnersTest.Builder copy(Builder builder) {
            this.learnersTestID = builder.learnersTestID;
            this.testScore = builder.testScore;
            this.test = builder.test;
            return this;
        }

        public LearnersTest build() {
            return new LearnersTest(this);
        }
    }
}
