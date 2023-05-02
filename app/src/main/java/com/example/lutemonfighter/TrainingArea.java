package com.example.lutemonfighter;


public class TrainingArea {
    private StringBuilder sb;

    public String train() {

        // StringBuilder for handling a multiline textview
        sb = new StringBuilder();
        sb.setLength(0);

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()) {

            // Creating the training program
            sb.append(lutemon.getName()).append(" juoksee juoksumatolla!\n");
            sb.append(lutemon.getName()).append(" tekee punnerruksia\n");
            sb.append(lutemon.getName()).append(" rutistaa vatsalihaksia\n");
            sb.append(lutemon.getName()).append(" vetää leukoja\n");
            sb.append(lutemon.getName()).append(" tekee kyykkyjä\n");
            sb.append(lutemon.getName()).append(" suoritti treenin ja sai 2 kokemuspistettä!\n\n");

            // After training, lutemon gains 2 xp, +2 attack and one completed training session
            lutemon.setExperience(lutemon.getExperience() + 2);
            lutemon.setAttack(lutemon.getAttack() + 2);
            lutemon.setTrainingSessions(lutemon.getTrainingSessions() + 1);
        }
        String trainingProgram = sb.toString();

        return trainingProgram;
    }

}
