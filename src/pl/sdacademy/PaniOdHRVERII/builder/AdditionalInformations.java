package pl.sdacademy.PaniOdHRVERII.builder;

public class AdditionalInformations {
    private final int height;
    private final String birthDate;
    private final String[] interests;

    private AdditionalInformations(Builder builder) {

        this.height = builder.height;
        this.birthDate = builder.birthDate;
        this.interests = builder.interests;
    }

    public int getHeight() {
        return height;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String[] getInterests() {
        return interests;
    }

    public static class Builder {
        private int height;
        private String birthDate;
        private String[] interests;

        public Builder height(final int height) {
            this.height = height;
            return this;
        }

        public Builder birthDate(final String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder intrests(final String... intrests) {
            this.interests = intrests;
            return this;
        }

        public AdditionalInformations build() {
            return new AdditionalInformations(this);
        }
    }

    public String toString() {
        String addInfoPrint = "";
        String birthDateCheck;
        String heightCheck;
        String interestsAll = "";
        int maxAddInf;

        if (this.height == 0) {
            heightCheck = "No data";
        } else {
            heightCheck = this.height + "cm";
        }
        if (this.birthDate == null) {
            birthDateCheck = "No data";
        } else {
            birthDateCheck = this.birthDate;
        }

        if (this.interests == null) {
            interestsAll = "No data";
        } else {
            if (this.interests.length == 1) {
                interestsAll += interests[0];
            } else {
                for (int i = 0; i < 1; i++) {
                    interestsAll += interests[i] + ",";
                }
                for (int i = 1; i < interests.length - 1; i++) {
                    interestsAll += " " + interests[i] + ",";
                }
                for (int i = interests.length - 1; i < interests.length; i++) {
                    interestsAll += " " + interests[i];
                }

            }
        }
        maxAddInf = maxLenghtAddInfo();


        addInfoPrint += System.lineSeparator();
        addInfoPrint += "|Height: " + heightCheck;
        for (int i = 0; i < (maxAddInf - (heightCheck.length() + 10)); i++) {
            addInfoPrint += " ";
        }
        addInfoPrint += "|" + System.lineSeparator();
        addInfoPrint += "|Birthdate: " + birthDateCheck;
        for (int i = 0; i < (maxAddInf - (birthDateCheck.length() + 13)); i++) {
            addInfoPrint += " ";
        }
        addInfoPrint += "|" + System.lineSeparator();
        addInfoPrint += "|Interests: " + interestsAll;
        for (int i = 0; i < (maxAddInf - (interestsAll.length() + 13)); i++) {
            addInfoPrint += " ";
        }
        addInfoPrint += "|";

        return addInfoPrint;
    }

    public int maxLenghtAddInfo() {
        String birthDateCheck;
        String heightCheck;
        String interestsAll = "";

        if (this.height == 0) {
            heightCheck = "No data";
        } else {
            heightCheck = this.height + "cm";
        }
        if (this.birthDate == null) {
            birthDateCheck = "No data";
        } else {
            birthDateCheck = this.birthDate;
        }

        if (this.interests == null) {
            interestsAll = "No data";
        } else {
            if (this.interests.length == 1) {
                interestsAll += interests[0];
            } else {
                for (int i = 0; i < 1; i++) {
                    interestsAll += interests[i] + ",";
                }
                for (int i = 1; i < interests.length - 1; i++) {
                    interestsAll += " " + interests[i] + ",";
                }
                for (int i = interests.length - 1; i < interests.length; i++) {
                    interestsAll += " " + interests[i];
                }

            }
        }
        if (birthDateCheck.length() + 13 > heightCheck.length() + 10) {
            if (birthDateCheck.length() + 13 > interestsAll.length() + 13) {
                return birthDateCheck.length() + 13;
            } else {
                return interestsAll.length() + 13;
            }
        } else {
            if (heightCheck.length() + 10 > interestsAll.length() + 13) {
                return heightCheck.length() + 10;
            } else {
                return interestsAll.length() + 13;
            }
        }

    }
}
