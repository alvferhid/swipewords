package com.example.cambridgescoreconverter;

public class Calculator {

    public String convertMarks(String level, int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal) {
        String cambridgeFinalScores = "";
        switch (level) {
            case "A2":
                cambridgeFinalScores = calculateA2(readingOriginal, useOriginal, writingOriginal, listeningOriginal, speakingOriginal, level);
                break;

            case "B1":
                cambridgeFinalScores = calculateB1(readingOriginal, useOriginal, writingOriginal, listeningOriginal, speakingOriginal, level);
                break;

            case "B2":
                cambridgeFinalScores = calculateB2(readingOriginal, useOriginal, writingOriginal, listeningOriginal, speakingOriginal, level);
                break;

            case "C1":
                cambridgeFinalScores = calculateC1(readingOriginal, useOriginal, writingOriginal, listeningOriginal, speakingOriginal, level);
                break;

            case "C2":
                cambridgeFinalScores = calculateC2(readingOriginal, useOriginal, writingOriginal, listeningOriginal, speakingOriginal, level);
                break;
        }
        return cambridgeFinalScores;
    }

    public String calculateA2(int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal, String level) {

        double readingScore = 0;
        double writingScore = 0;
        double listeningScore = 0;
        double speakingScore = 0;
        double useOfEnglishScore = 0;

        String resultToSend;

        if (readingOriginal >= 7 && readingOriginal <= 12) {
            readingScore = 82 + ((readingOriginal - 7) * 3);
        } else if (readingOriginal >= 13 && readingOriginal <= 19) {
            readingScore = 100 + ((readingOriginal - 13) * 2.85);
        } else if (readingOriginal >= 20 && readingOriginal <= 27) {
            readingScore = 120 + ((readingOriginal - 20) * 2.85);
        } else if (readingOriginal >= 28 && readingOriginal <= 30) {
            readingScore = 140 + ((readingOriginal - 28) * 5);
        }
        System.out.println("A2reading: " + readingScore);

        if (useOriginal > 0) {
            useOfEnglishScore = 0;
        }


        if (writingOriginal >= 8 && writingOriginal <= 11) {
            writingScore = 82 + ((writingOriginal - 8) * 4.5);
        } else if (writingOriginal >= 12 && writingOriginal <= 17) {
            writingScore = 100 + ((writingOriginal - 12) * 3.3);
        } else if (writingOriginal >= 18 && writingOriginal <= 25) {
            writingScore = 120 + ((writingOriginal - 18) * 2.5);
        } else if (writingOriginal >= 26 && writingOriginal <= 30) {
            writingScore = 140 + ((writingOriginal - 26) * 2.5);
        }
        System.out.println("writing: " + writingScore);


        if (listeningOriginal >= 6 && listeningOriginal <= 10) {
            listeningScore = 82 + ((listeningOriginal - 6) * 3.6);
        } else if (listeningOriginal >= 11 && listeningOriginal <= 16) {
            listeningScore = 100 + ((listeningOriginal - 11) * 3.3);
        } else if (listeningOriginal >= 17 && listeningOriginal <= 22) {
            listeningScore = 120 + ((listeningOriginal - 17) * 3.3);
        } else if (listeningOriginal >= 23 && listeningOriginal <= 25) {
            listeningScore = 140 + ((listeningOriginal - 23) * 5);
        }
        System.out.println("listening: " + listeningScore);


        if (speakingOriginal >= 10 && speakingOriginal <= 17) {
            speakingScore = 82 + ((speakingOriginal - 10) * 2.5);
        } else if (speakingOriginal >= 18 && speakingOriginal <= 26) {
            speakingScore = 100 + ((speakingOriginal - 18) * 2.22);
        } else if (speakingOriginal >= 27 && speakingOriginal <= 40) {
            speakingScore = 120 + ((speakingOriginal - 27) * 2.22);
        } else if (speakingOriginal >= 41 && speakingOriginal <= 45) {
            speakingScore = 140 + ((speakingOriginal - 41) * 2.5);
        }
        System.out.println("speaking: " + speakingScore);


        int readingFinalScore = (int) Math.round(readingScore);
        int useFinalScore = (int) Math.round(useOfEnglishScore);
        int writingFinalScore = (int) Math.round(writingScore);
        int listeningFinalScore = (int) Math.round(listeningScore);
        int speakingFinalScore = (int) Math.round(speakingScore);

        resultToSend = generateResultString(readingFinalScore, useFinalScore, writingFinalScore,
                listeningFinalScore, speakingFinalScore, level, readingOriginal, useOriginal,
                writingOriginal, listeningOriginal, speakingOriginal);

        return resultToSend;
    }

    public String calculateB1(int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal, String level) {

        double readingScore = 0;
        double writingScore = 0;
        double listeningScore = 0;
        double speakingScore = 0;
        double useOfEnglishScore = 0;
        String resultToSend;

        if (readingOriginal >= 5 && readingOriginal <= 12) {
            readingScore = 102 + ((readingOriginal - 5) * 2.25);
        } else if (readingOriginal >= 13 && readingOriginal <= 22) {
            readingScore = 120 + ((readingOriginal - 13) * 2);
        } else if (readingOriginal >= 23 && readingOriginal <= 28) {
            readingScore = 140 + ((readingOriginal - 23) * 3.33);
        } else if (readingOriginal >= 29 && readingOriginal <= 32) {
            readingScore = 160 + ((readingOriginal - 29) * 3.3);
        }

        if (useOriginal > 0) {
            useOfEnglishScore = 0;
        }


        if (writingOriginal >= 10 && writingOriginal <= 15) {
            writingScore = 102 + ((writingOriginal - 10) * 3);
        } else if (writingOriginal >= 16 && writingOriginal <= 23) {
            writingScore = 120 + ((writingOriginal - 16) * 2.5);
        } else if (writingOriginal >= 24 && writingOriginal <= 33) {
            writingScore = 140 + ((writingOriginal - 24) * 2);
        } else if (writingOriginal >= 34 && writingOriginal <= 40) {
            writingScore = 160 + ((writingOriginal - 34) * 1.66);
        }
        System.out.println("writing: " + writingScore);


        if (listeningOriginal >= 5 && listeningOriginal <= 10) {
            listeningScore = 102 + ((listeningOriginal - 5) * 3);
        } else if (listeningOriginal >= 11 && listeningOriginal <= 17) {
            listeningScore = 120 + ((listeningOriginal - 11) * 2.85);
        } else if (listeningOriginal >= 18 && listeningOriginal <= 22) {
            listeningScore = 140 + ((listeningOriginal - 18) * 4);
        } else if (listeningOriginal >= 23 && listeningOriginal <= 25) {
            listeningScore = 160 + ((listeningOriginal - 23) * 5);
        }
        System.out.println("listening: " + listeningScore);


        if (speakingOriginal >= 7 && speakingOriginal <= 11) {
            speakingScore = 102 + ((speakingOriginal - 7) * 3.6);
        } else if (speakingOriginal >= 12 && speakingOriginal <= 17) {
            speakingScore = 120 + ((speakingOriginal - 12) * 3.33);
        } else if (speakingOriginal >= 18 && speakingOriginal <= 26) {
            speakingScore = 140 + ((speakingOriginal - 18) * 2.22);
        } else if (speakingOriginal >= 27 && speakingOriginal <= 30) {
            speakingScore = 160 + ((speakingOriginal - 27) * 3.33);
        }
        System.out.println("speaking: " + speakingScore);


        int readingFinalScore = (int) Math.round(readingScore);
        int useFinalScore = (int) Math.round(useOfEnglishScore);
        int writingFinalScore = (int) Math.round(writingScore);
        int listeningFinalScore = (int) Math.round(listeningScore);
        int speakingFinalScore = (int) Math.round(speakingScore);

        resultToSend = generateResultString(readingFinalScore, useFinalScore, writingFinalScore,
                listeningFinalScore, speakingFinalScore, level, readingOriginal, useOriginal,
                writingOriginal, listeningOriginal, speakingOriginal);

        return resultToSend;
    }

    public String calculateB2(int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal, String level) {

        double readingScore = 0;
        double writingScore = 0;
        double listeningScore = 0;
        double speakingScore = 0;
        double useOfEnglishScore = 0;
        String resultToSend;


        if (readingOriginal >= 10 && readingOriginal <= 16) {
            readingScore = 122 + ((readingOriginal - 10) * 3);
        } else if (readingOriginal >= 17 && readingOriginal <= 24) {
            readingScore = 140 + ((readingOriginal - 16) * 2.5);
        } else if (readingOriginal >= 25 && readingOriginal <= 37) {
            readingScore = 160 + ((readingOriginal - 24) * 1.53);
        } else if (readingOriginal >= 38 && readingOriginal <= 42) {
            readingScore = 180 + ((readingOriginal - 37) * 2);
        }
        System.out.println("reading: " + readingScore);


        if (useOriginal >= 7 && useOriginal <= 11) {
            useOfEnglishScore = 122 + ((useOriginal - 7) * 4.5);
        } else if (useOriginal >= 12 && useOriginal <= 18) {
            useOfEnglishScore = 140 + ((useOriginal - 11) * 2.85);
        } else if (useOriginal >= 19 && useOriginal <= 24) {
            useOfEnglishScore = 160 + ((useOriginal - 18) * 3.3);
        } else if (useOriginal >= 25 && useOriginal <= 28) {
            useOfEnglishScore = 180 + ((useOriginal - 24) * 2.5);
        }
        System.out.println("use of English: " + useOfEnglishScore);


        if (writingOriginal >= 10 && writingOriginal <= 16) {
            writingScore = 122 + ((writingOriginal - 10) * 3);
        } else if (writingOriginal >= 17 && writingOriginal <= 24) {
            writingScore = 140 + ((writingOriginal - 16) * 2.5);
        } else if (writingOriginal >= 25 && writingOriginal <= 34) {
            writingScore = 160 + ((writingOriginal - 24) * 2);
        } else if (writingOriginal >= 35 && writingOriginal <= 40) {
            writingScore = 180 + ((writingOriginal - 34) * 1.66);
        }
        System.out.println("writing: " + writingScore);


        if (listeningOriginal >= 8 && listeningOriginal <= 12) {
            listeningScore = 122 + ((listeningOriginal - 8) * 4.5);
        } else if (listeningOriginal >= 13 && listeningOriginal <= 18) {
            listeningScore = 140 + ((listeningOriginal - 12) * 3.3);
        } else if (listeningOriginal >= 19 && listeningOriginal <= 27) {
            listeningScore = 160 + ((listeningOriginal - 18) * 2.2);
        } else if (listeningOriginal >= 28 && listeningOriginal <= 30) {
            listeningScore = 180 + ((listeningOriginal - 27) * 3.33);
        }
        System.out.println("listening: " + listeningScore);


        if (speakingOriginal >= 14 && speakingOriginal <= 24) {
            speakingScore = 122 + ((speakingOriginal - 14) * 1.8);
        } else if (speakingOriginal >= 25 && speakingOriginal <= 36) {
            speakingScore = 140 + ((speakingOriginal - 24) * 1.66);
        } else if (speakingOriginal >= 37 && speakingOriginal <= 54) {
            speakingScore = 160 + ((speakingOriginal - 36) * 1.1);
        } else if (speakingOriginal >= 54 && speakingOriginal <= 60) {
            speakingScore = 180 + ((speakingOriginal - 54) * 1.66);
        }
        System.out.println("speaking: " + speakingScore);


        int readingFinalScore = (int) Math.round(readingScore);
        int useFinalScore = (int) Math.round(useOfEnglishScore);
        int writingFinalScore = (int) Math.round(writingScore);
        int listeningFinalScore = (int) Math.round(listeningScore);
        int speakingFinalScore = (int) Math.round(speakingScore);

        resultToSend = generateResultString(readingFinalScore, useFinalScore, writingFinalScore,
                listeningFinalScore, speakingFinalScore, level, readingOriginal, useOriginal,
                writingOriginal, listeningOriginal, speakingOriginal);

        return resultToSend;

    }

    public String calculateC1(int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal, String level) {

        double readingScore = 0;
        double writingScore = 0;
        double listeningScore = 0;
        double speakingScore = 0;
        double useOfEnglishScore = 0;
        String resultToSend;


        if (readingOriginal >= 17 && readingOriginal <= 22) {
            readingScore = 142 + ((readingOriginal - 17) * 3);
        } else if (readingOriginal >= 23 && readingOriginal <= 31) {
            readingScore = 160 + ((readingOriginal - 23) * 2.22);
        } else if (readingOriginal >= 32 && readingOriginal <= 42) {
            readingScore = 180 + ((readingOriginal - 32) * 1.81);
        } else if (readingOriginal >= 43 && readingOriginal <= 50) {
            readingScore = 200 + ((readingOriginal - 43) * 1.42);
        }
        System.out.println("reading: " + readingScore);


        if (useOriginal >= 8 && useOriginal <= 10) {
            useOfEnglishScore = 142 + ((useOriginal - 8) * 3);
        } else if (useOriginal >= 11 && useOriginal <= 15) {
            useOfEnglishScore = 160 + ((useOriginal - 11) * 2.22);
        } else if (useOriginal >= 16 && useOriginal <= 22) {
            useOfEnglishScore = 180 + ((useOriginal - 16) * 2.85);
        } else if (useOriginal >= 23 && useOriginal <= 28) {
            useOfEnglishScore = 200 + ((useOriginal - 23) * 2);
        }
        System.out.println("use of English: " + useOfEnglishScore);


        if (writingOriginal >= 10 && writingOriginal <= 15) {
            writingScore = 142 + ((writingOriginal - 10) * 3);
        } else if (writingOriginal >= 16 && writingOriginal <= 23) {
            writingScore = 160 + ((writingOriginal - 16) * 2.5);
        } else if (writingOriginal >= 24 && writingOriginal <= 33) {
            writingScore = 180 + ((writingOriginal - 24) * 2);
        } else if (writingOriginal >= 34 && writingOriginal <= 40) {
            writingScore = 200 + ((writingOriginal - 34) * 1.66);
        }
        System.out.println("writing: " + writingScore);


        if (listeningOriginal >= 11 && listeningOriginal <= 12) {
            listeningScore = 142 + ((listeningOriginal - 11) * 9);
        } else if (listeningOriginal >= 13 && listeningOriginal <= 17) {
            listeningScore = 160 + ((listeningOriginal - 13) * 4);
        } else if (listeningOriginal >= 18 && listeningOriginal <= 25) {
            listeningScore = 180 + ((listeningOriginal - 18) * 2.5);
        } else if (listeningOriginal >= 26 && listeningOriginal <= 30) {
            listeningScore = 200 + ((listeningOriginal - 26) * 2.5);
        }
        System.out.println("listening: " + listeningScore);


        if (speakingOriginal >= 17 && speakingOriginal <= 29) {
            speakingScore = 142 + ((speakingOriginal - 17) * 1.38);
        } else if (speakingOriginal >= 30 && speakingOriginal <= 44) {
            speakingScore = 160 + ((speakingOriginal - 30) * 1.33);
        } else if (speakingOriginal >= 45 && speakingOriginal <= 65) {
            speakingScore = 180 + ((speakingOriginal - 45) * 0.95);
        } else if (speakingOriginal >= 66 && speakingOriginal <= 75) {
            speakingScore = 200 + ((speakingOriginal - 66) * 1.11);
        }
        System.out.println("speaking: " + speakingScore);


        int readingFinalScore = (int) Math.round(readingScore);
        int useFinalScore = (int) Math.round(useOfEnglishScore);
        int writingFinalScore = (int) Math.round(writingScore);
        int listeningFinalScore = (int) Math.round(listeningScore);
        int speakingFinalScore = (int) Math.round(speakingScore);

        resultToSend = generateResultString(readingFinalScore, useFinalScore, writingFinalScore,
                listeningFinalScore, speakingFinalScore, level, readingOriginal, useOriginal,
                writingOriginal, listeningOriginal, speakingOriginal);

        return resultToSend;

    }

    public String calculateC2(int readingOriginal, int useOriginal, int writingOriginal, int listeningOriginal, int speakingOriginal, String level) {

        double readingScore = 0;
        double writingScore = 0;
        double listeningScore = 0;
        double speakingScore = 0;
        double useOfEnglishScore = 0;
        String resultToSend;


        if (readingOriginal >= 14 && readingOriginal <= 21) {
            readingScore = 162 + ((readingOriginal - 14) * 2.25);
        } else if (readingOriginal >= 22 && readingOriginal <= 27) {
            readingScore = 180 + ((readingOriginal - 22) * 3.33);
        } else if (readingOriginal >= 28 && readingOriginal <= 35) {
            readingScore = 200 + ((readingOriginal - 28) * 2.5);
        } else if (readingOriginal >= 36 && readingOriginal <= 44) {
            readingScore = 220 + ((readingOriginal - 36) * 1.25);
        }
        System.out.println("reading: " + readingScore);


        if (useOriginal >= 9 && useOriginal <= 12) {
            useOfEnglishScore = 162 + ((useOriginal - 9) * 4.5);
        } else if (useOriginal >= 13 && useOriginal <= 16) {
            useOfEnglishScore = 180 + ((useOriginal - 13) * 5);
        } else if (useOriginal >= 17 && useOriginal <= 21) {
            useOfEnglishScore = 200 + ((useOriginal - 17) * 4);
        } else if (useOriginal >= 22 && useOriginal <= 28) {
            useOfEnglishScore = 220 + ((useOriginal - 22) * 1.66);
        }
        System.out.println("use of English: " + useOfEnglishScore);


        if (writingOriginal >= 10 && writingOriginal <= 15) {
            writingScore = 162 + ((writingOriginal - 10) * 3);
        } else if (writingOriginal >= 16 && writingOriginal <= 23) {
            writingScore = 180 + ((writingOriginal - 16) * 2.5);
        } else if (writingOriginal >= 24 && writingOriginal <= 33) {
            writingScore = 200 + ((writingOriginal - 24) * 2);
        } else if (writingOriginal >= 34 && writingOriginal <= 40) {
            writingScore = 220 + ((writingOriginal - 34) * 1.66);
        }
        System.out.println("writing: " + writingScore);


        if (listeningOriginal >= 10 && listeningOriginal <= 13) {
            listeningScore = 162 + ((listeningOriginal - 10) * 4.5);
        } else if (listeningOriginal >= 14 && listeningOriginal <= 17) {
            listeningScore = 180 + ((listeningOriginal - 14) * 5);
        } else if (listeningOriginal >= 18 && listeningOriginal <= 23) {
            listeningScore = 200 + ((listeningOriginal - 18) * 3.33);
        } else if (listeningOriginal >= 24 && listeningOriginal <= 30) {
            listeningScore = 220 + ((listeningOriginal - 24) * 1.66);
        }
        System.out.println("listening: " + listeningScore);


        if (speakingOriginal >= 17 && speakingOriginal <= 29) {
            speakingScore = 162 + ((speakingOriginal - 17) * 1.38);
        } else if (speakingOriginal >= 30 && speakingOriginal <= 44) {
            speakingScore = 180 + ((speakingOriginal - 30) * 1.33);
        } else if (speakingOriginal >= 45 && speakingOriginal <= 65) {
            speakingScore = 200 + ((speakingOriginal - 45) * 0.95);
        } else if (speakingOriginal >= 66 && speakingOriginal <= 75) {
            speakingScore = 220 + ((speakingOriginal - 66) * 1.11);
        }
        System.out.println("speaking: " + speakingScore);


        int readingFinalScore = (int) Math.round(readingScore);
        int useFinalScore = (int) Math.round(useOfEnglishScore);
        int writingFinalScore = (int) Math.round(writingScore);
        int listeningFinalScore = (int) Math.round(listeningScore);
        int speakingFinalScore = (int) Math.round(speakingScore);

        resultToSend = generateResultString(readingFinalScore, useFinalScore, writingFinalScore,
                listeningFinalScore, speakingFinalScore, level, readingOriginal, useOriginal,
                writingOriginal, listeningOriginal, speakingOriginal);

        return resultToSend;

    }

    public String generateResultString(int readingCambridge, int useCambridge, int writingCambridge,
                                       int listeningCambridge, int speakingCambridge, String level, int readingMark,
                                       int useMark, int writingMark, int listeningMark, int speakingMark) {

        String finalGrades = "";
        int finalScore;

        if (level.equals("A2")) {

            finalScore = (readingCambridge + writingCambridge + listeningCambridge + speakingCambridge) / 4;

            finalGrades = "Reading: " + readingMark + "/30" + "\n" + "Cambridge Score: " + readingCambridge + "-" + cambridgeScalePosition(readingCambridge) + "\n" +
                    "\n" + "Writing: " + writingMark + "/30" + "\n" + "Cambridge Score: " + writingCambridge + "-" + cambridgeScalePosition(writingCambridge) + "\n" +
                    "\n" + "Listening: " + listeningMark + "/25" + "\n" + "Cambridge Score: " + listeningCambridge + "-" + cambridgeScalePosition(listeningCambridge) + "\n" +
                    "\n" + "Speaking: " + speakingMark + "/45" + "\n" + "Cambridge Score: " + speakingCambridge + "-" + cambridgeScalePosition(speakingCambridge) + "\n" +
                    "\n" + "Final score: " + finalScore + "-" + cambridgeScalePosition(finalScore);

        } else if (level.equals("B1")) {

            finalScore = (readingCambridge + writingCambridge + listeningCambridge + speakingCambridge) / 4;

            finalGrades = "Reading: " + readingMark + "/32" + "\n" + "Cambridge Score: " + readingCambridge + "-" + cambridgeScalePosition(readingCambridge) + "\n" +
                    "\n" + "Writing: " + writingMark + "/40" + "\n" + "Cambridge Score: " + writingCambridge + "-" + cambridgeScalePosition(writingCambridge) + "\n" +
                    "\n" + "Listening: " + listeningMark + "/25" + "\n" + "Cambridge Score: " + listeningCambridge + "-" + cambridgeScalePosition(listeningCambridge) + "\n" +
                    "\n" + "Speaking: " + speakingMark + "/30" + "\n" + "Cambridge Score: " + speakingCambridge + "-" + cambridgeScalePosition(speakingCambridge) + "\n" +
                    "\n" + "Final score: " + finalScore + "-" + cambridgeScalePosition(finalScore);

        } else if (level.equals("B2")) {

            finalScore = (readingCambridge + useCambridge + writingCambridge + listeningCambridge + speakingCambridge) / 5;

            finalGrades = "Reading: " + readingMark + "/42" + "\n" + "Cambridge Score: " + readingCambridge + "-" + cambridgeScalePosition(readingCambridge) + "\n" +
                    "\n" + "Use of English: " + useMark + "/28" + "\n" + "Cambridge score: " + useCambridge + "-" + cambridgeScalePosition(useCambridge) + "\n" +
                    "\n" + "Writing: " + writingMark + "/40" + "\n" + "Cambridge Score: " + writingCambridge + "-" + cambridgeScalePosition(writingCambridge) + "\n" +
                    "\n" + "Listening: " + listeningMark + "/30" + "\n" + "Cambridge Score: " + listeningCambridge + "-" + cambridgeScalePosition(listeningCambridge) + "\n" +
                    "\n" + "Speaking: " + speakingMark + "/60" + "\n" + "Cambridge Score: " + speakingCambridge + "-" + cambridgeScalePosition(speakingCambridge) + "\n" +
                    "\n" + "Final score: " + finalScore + "-" + cambridgeScalePosition(finalScore);

        } else if (level.equals("C1")) {

            finalScore = (readingCambridge + useCambridge + writingCambridge + listeningCambridge + speakingCambridge) / 5;

            finalGrades = "Reading: " + readingMark + "/50" + "\n" + "Cambridge Score: " + readingCambridge + "-" + cambridgeScalePosition(readingCambridge) + "\n" +
                    "\n" + "Use of English: " + useMark + "/28" + "\n" + "Cambridge score: " + useCambridge + "-" + cambridgeScalePosition(useCambridge) + "\n" +
                    "\n" + "Writing: " + writingMark + "/40" + "\n" + "Cambridge Score: " + writingCambridge + "-" + cambridgeScalePosition(writingCambridge) + "\n" +
                    "\n" + "Listening: " + listeningMark + "/30" + "\n" + "Cambridge Score: " + listeningCambridge + "-" + cambridgeScalePosition(listeningCambridge) + "\n" +
                    "\n" + "Speaking: " + speakingMark + "/75" + "\n" + "Cambridge Score: " + speakingCambridge + "-" + cambridgeScalePosition(speakingCambridge) + "\n" +
                    "\n" + "Final score: " + finalScore + "-" + cambridgeScalePosition(finalScore);

        } else if (level.equals("C2")) {

            finalScore = (readingCambridge + useCambridge + writingCambridge + listeningCambridge + speakingCambridge) / 5;

            finalGrades = "Reading: " + readingMark + "/44" + "\n" + "Cambridge Score: " + readingCambridge + "-" + cambridgeScalePosition(readingCambridge) + "\n" +
                    "\n" + "Use of English: " + useMark + "/28" + "\n" + "Cambridge score: " + useCambridge + "-" + cambridgeScalePosition(useCambridge) + "\n" +
                    "\n" + "Writing: " + writingMark + "/40" + "\n" + "Cambridge Score: " + writingCambridge + "-" + cambridgeScalePosition(writingCambridge) + "\n" +
                    "\n" + "Listening: " + listeningMark + "/30" + "\n" + "Cambridge Score: " + listeningCambridge + "-" + cambridgeScalePosition(listeningCambridge) + "\n" +
                    "\n" + "Speaking: " + speakingMark + "/75" + "\n" + "Cambridge Score: " + speakingCambridge + "-" + cambridgeScalePosition(speakingCambridge) + "\n" +
                    "\n" + "Final score: " + finalScore + "-" + cambridgeScalePosition(finalScore);

        }
        return finalGrades;
    }

    public String cambridgeScalePosition(int mark) {

        String cambridgeScore = "";

        if (mark < 120) {
            cambridgeScore = "A1";
        }
        if (mark >= 120 && mark < 140) {
            cambridgeScore = "A2";
        }
        if (mark >= 140 && mark < 160) {
            cambridgeScore = "B1";
        }
        if (mark >= 160 && mark < 180) {
            cambridgeScore = "B2";
        }
        if (mark >= 180 && mark < 200) {
            cambridgeScore = "C1";
        }
        if (mark >= 200) {
            cambridgeScore = "C2";
        }

        return cambridgeScore;
    }
}