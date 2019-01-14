package pl.sdacademy.PaniOdHRVERII.builder;

public class Person {
    private final String firstname;
    private final String lastname;
    private final String sex;
    private final AdditionalInformations additionalInformations;

    private Person(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.sex = builder.sex;
        this.additionalInformations = builder.additionalInformations;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public AdditionalInformations getAdditionalInformations() {
        return additionalInformations;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String sex;
        private AdditionalInformations additionalInformations;


        public Builder(String firstname, String lastname, String sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.sex = sex;
        }

        public Builder additionalInformations(final AdditionalInformations additionalInformations) {
            this.additionalInformations = additionalInformations;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String toString() {
        String personPrint = "";
        int maxlength = this.firstname.length() + this.lastname.length() + 10;

        maxlength = max(maxlength, this.sex.length() + 7);
        maxlength = max(maxlength, additionalInformations.maxLenghtAddInfo());

        for (int i = 0; i < maxlength; i++) {
            personPrint += "-";
        }
        personPrint += System.lineSeparator();
        personPrint += "|Name: " + this.firstname + ", " + this.lastname;

        for (int i = 0; i < (maxlength - (this.firstname.length() + this.lastname.length() + 10)); i++) {
            personPrint += " ";
        }
        personPrint += "|" + System.lineSeparator();

        personPrint += "|Sex: " + this.sex;

        for (int i = 0; i < (maxlength - (this.sex.length() + 7)); i++) {
            personPrint += " ";
        }
        personPrint += "|";

        personPrint += this.additionalInformations.toString() + System.lineSeparator();

        for (int i = 0; i < maxlength; i++) {
            personPrint += "-";
        }
        return personPrint;


    }

    public int max(int maxlength, int length) {

        if (maxlength < length) {
            return length;
        } else {
            return maxlength;
        }

    }
}

