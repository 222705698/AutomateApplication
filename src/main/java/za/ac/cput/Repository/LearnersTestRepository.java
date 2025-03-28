package za.ac.cput.Repository;

import za.ac.cput.Domain.LearnersTest;
import java.util.ArrayList;
import java.util.List;

public class LearnersTestRepository implements ILearnersTestRepository {
    private static LearnersTestRepository repository = null;
    private List<LearnersTest> learnersTestList;

    private LearnersTestRepository() {
        learnersTestList = new ArrayList<>();
    }

    public static LearnersTestRepository getRepository() {
        if (repository == null) {
            repository = new LearnersTestRepository();
        }
        return repository;
    }

    @Override
    public LearnersTest create(LearnersTest learnersTest) {
        boolean success = learnersTestList.add(learnersTest);
        if (success) {
            return learnersTest;
        }
        System.out.println("LearnersTest not successfully added");
        return null;
    }

    @Override
    public LearnersTest read(String learnersTestID) {
        for (LearnersTest learnersTest : learnersTestList) {
            if (learnersTest.getLearnersTestID().equals(learnersTestID)) {
                return learnersTest;
            }
        }
        System.out.println("LearnersTest not found");
        return null;
    }

    @Override
    public LearnersTest update(LearnersTest learnersTest) {
        for (int i = 0; i < learnersTestList.size(); i++) {
            if (learnersTestList.get(i).getLearnersTestID().equals(learnersTest.getLearnersTestID())) {
                learnersTestList.set(i, learnersTest);
                return learnersTest;
            }
        }
        System.out.println("LearnersTest not found for update");
        return null;
    }

    @Override
    public boolean delete(String learnersTestID) {
        for (LearnersTest learnersTest : learnersTestList) {
            if (learnersTest.getLearnersTestID().equals(learnersTestID)) {
                learnersTestList.remove(learnersTest);
                return true;
            }
        }
        System.out.println("LearnersTest not successfully deleted");
        return false;
    }

    @Override
    public List<LearnersTest> getAll() {
        return new ArrayList<>(learnersTestList);
    }
}
